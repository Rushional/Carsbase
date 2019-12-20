package queries;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.Tuple;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class QueryManager {
    private Session session;
    private SimpleDateFormat dateFormat;

    public QueryManager(Session session) {
        this.session = session;
        String pattern = "yyyy-MM-dd";
        this.dateFormat = new SimpleDateFormat(pattern);
    }

    private List<Tuple> queryGetTuples(String sqlQuery) {
        Query nativeQuery = session.createNativeQuery(sqlQuery, Tuple.class);
//        System.out.println("executing: " + nativeQuery.getQueryString());
        List<Tuple> nativeQueryResults = nativeQuery.getResultList();
//            for (Tuple workTypesTuple : nativeQueryResults) {
//                System.out.print("Work type: " + workTypesTuple.get("work_type_name") + ", ");
//                System.out.println("Price: " + workTypesTuple.get("price"));
//            }
        return nativeQueryResults;
    }

    //TO DO create adminQuery that checks if admin and then queryGetTuples

    //should be admin
    //task 1
    public List<Tuple> workTypes() {
            return queryGetTuples("SELECT work_type_name, price FROM work_type;");
    }


    //should be admin
    //task 2
    public List<Tuple> carsClients() {
        return queryGetTuples(
                "SELECT car_name, client_name " +
                "FROM car INNER JOIN client " +
                "ON fk_client_id=pk_client_id;"
        );
    }

    //should check if user_id (pl_client_id) == car's client fk_client_id
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
