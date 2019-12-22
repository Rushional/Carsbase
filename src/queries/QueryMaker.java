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

public class QueryMaker {
    private Session session;
    private SimpleDateFormat dateFormat;

    public QueryMaker(Session session) {
        this.session = session;
        String pattern = "yyyy-MM-dd";
        this.dateFormat = new SimpleDateFormat(pattern);
    }

    private List<Tuple> queryGetTuples(String sqlQuery) {
        Query nativeQuery = session.createNativeQuery(sqlQuery, Tuple.class);
        List<Tuple> nativeQueryResults = nativeQuery.getResultList();
        return nativeQueryResults;
    }

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
    public List<Tuple> workerProblemsByDate(Date left, Date right) {
        String leftDate = dateFormat.format(left);
        String rightDate = dateFormat.format(right);
        return queryGetTuples(
                "SELECT car_name, client_name, work_type_name, delivery_date " +
                "FROM problem " +
                "INNER JOIN car ON car_id=pk_car_id " +
                "INNER JOIN client ON fk_client_id=pk_client_id " +
                "INNER JOIN work_type ON work_type_id=pk_work_type_id " +
                "WHERE worker_id=1 AND delivery_date BETWEEN DATE '" + leftDate + "' AND DATE '" + rightDate + "';"
        );
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
}