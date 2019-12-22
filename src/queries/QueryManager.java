package queries;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.Tuple;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//TO DO: Make this one abstract. Instead of immediately querying create extending [type]QueryMakers and send them to
//the manager
//Also probably shouldn't be done - wasting time

public class QueryManager {
    private Session session;
//    private SimpleDateFormat dateFormat;
//    private static String pattern = "yyyy-MM-dd";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String queryTimePeriod = null;
    private int workerId = -1;
    private List<Tuple> carNames;
    private List<Tuple> workerNames;
    private List<Tuple> clientNames;

    public QueryManager(Session session) {
        this.session = session;
//        this.dateFormat = new SimpleDateFormat(pattern);
    }

    private List<Tuple> queryGetTuples(String sqlQuery) {
        Query nativeQuery = session.createNativeQuery(sqlQuery, Tuple.class);
        List<Tuple> nativeQueryResults = nativeQuery.getResultList();
        return nativeQueryResults;
    }

    public void createQueryOptions() {
        carNames = getCarNames();
        workerNames = getWorkerNames();
        clientNames = getClientNames();
    }

    private List<Tuple> getCarNames() { return queryGetTuples("SELECT car_name FROM car"); }
    private List<Tuple> getWorkerNames() { return queryGetTuples("SELECT worker_name FROM worker"); }
    private List<Tuple> getClientNames() { return queryGetTuples("SELECT client_name FROM client"); }

    //task 1
    public List<Tuple> workTypes() {
            return queryGetTuples("SELECT work_type_name, price FROM work_type;");
    }

    //task 2
    public List<Tuple> carsClients() {
        return queryGetTuples(
                "SELECT car_name, client_name " +
                "FROM car INNER JOIN client " +
                "ON fk_client_id=pk_client_id;"
        );
    }

    //task 3
    public List<Tuple> carWorks(int carID) {
        return queryGetTuples(
                "SELECT work_type_name " +
                "FROM problem " +
                "INNER JOIN work_type ON work_type_id=pk_work_type_id " +
                "WHERE car_id="+carID+";"
        );
    }

    //task 4
    public List<Tuple> workerProblemsByDate() {
        if (queryTimePeriod != null && workerId != -1) {
            Date right = new Date(); //today date
            String rightDate = dateFormat.format(right);
            String leftDate = computeDate(right);
            return queryGetTuples(
                    "SELECT car_name, client_name, work_type_name, delivery_date " +
                            "FROM problem " +
                            "INNER JOIN car ON car_id=pk_car_id " +
                            "INNER JOIN client ON fk_client_id=pk_client_id " +
                            "INNER JOIN work_type ON work_type_id=pk_work_type_id " +
                            "WHERE worker_id=" + workerId + " AND delivery_date BETWEEN DATE '" + leftDate + "' AND DATE '" + rightDate + "';"
            );
        }
        else return null;
    }

    //task 5
    public double clientCost(int clientID) {
        final Query query5clientCost = session.createSQLQuery(
                "SELECT " +
                "SUM (price) AS total_cost " +
                "FROM client " +
                "INNER JOIN car ON pk_client_id=fk_client_id " +
                "INNER JOIN problem ON pk_car_id=car_id " +
                "INNER JOIN work_type ON work_type_id=pk_work_type_id " +
                "WHERE pk_client_id=" + clientID + ";"
        );
        double totalCost = 0;
        for (Object o : query5clientCost.list()) {
            totalCost = (double)o;
        }
        return totalCost;
    }

    private String computeDate(Date right) {
        if (right != null) {
            switch (queryTimePeriod) {
                case "Past day":
                    return "2019-12-22";
                case "Past week":
                    return "2019-12-16";
                case "Past month":
                    return "2019-11-23";
                case "Past quarter of a year":
                    return "2019-09-23";
                case "Past year":
                    return "2018-12-23";
                default:
                    return null;
            }
        }
        else return null;
    }

    public void setQueryTimePeriod(String queryTimePeriod) {
        this.queryTimePeriod = queryTimePeriod;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getQueryTimePeriod() {
        return queryTimePeriod;
    }

    public int getWorkerId() {
        return workerId;
    }
}
