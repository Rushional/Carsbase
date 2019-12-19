import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Tuple;
import java.util.List;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            System.out.println("Started");
            Configuration configuration = new Configuration();
            System.out.println("Created a configuration");
            configuration.configure();

            System.out.println("configured");
            ourSessionFactory = configuration.buildSessionFactory();
            System.out.println("built a session factory");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) {
        final Session session = getSession();
        try {
            System.out.println();
            System.out.println("Executing task 1:");
            Query query1workTypes = session.createNativeQuery(
                    "SELECT work_type_name, price FROM work_type",
                    Tuple.class);
            System.out.println("executing: " + query1workTypes.getQueryString());
            List<Tuple> query1workTypesResults = query1workTypes.getResultList();
            for (Tuple workTypesTuple : query1workTypesResults) {
                System.out.print("Work type: " + workTypesTuple.get("work_type_name") + ", ");
                System.out.println("Price: " + workTypesTuple.get("price"));
            }

            System.out.println();
            System.out.println("Executing task 2:");
            Query query2carsClients = session.createNativeQuery(
                    "SELECT car_name, client_name " +
                    "FROM car INNER JOIN client " +
                    "ON fk_client_id=pk_client_id",
                    Tuple.class);
            System.out.println("executing: " + query2carsClients.getQueryString());
            List<Tuple> query2carsClientsResults = query2carsClients.getResultList();
            for (Tuple workTypesTuple : query2carsClientsResults) {
                System.out.print("Car name: " + workTypesTuple.get("car_name") + ", ");
                System.out.println("Client name: " + workTypesTuple.get("client_name"));
            }

            System.out.println();
            System.out.println("Executing task 3:");
            Query query3carWorks = session.createNativeQuery(
                    "SELECT work_type_name " +
                    "FROM problem " +
                    "INNER JOIN work_type ON work_type_id=pk_work_type_id " +
                    "WHERE car_id=3;",
                    Tuple.class);
            System.out.println("executing: " + query3carWorks.getQueryString());
            List<Tuple> query3carWorksResults = query3carWorks.getResultList();
            for (Tuple workTypesTuple : query3carWorksResults) {
                System.out.println("Work type: " + workTypesTuple.get("work_type_name"));
            }

            System.out.println();
            System.out.println("Executing task 4:");
            Query query4workerProblemsByDate = session.createNativeQuery(
                    "SELECT car_name, client_name, work_type_name, delivery_date " +
                    "FROM problem " +
                    "INNER JOIN car ON car_id=pk_car_id " +
                    "INNER JOIN client ON fk_client_id=pk_client_id " +
                    "INNER JOIN work_type ON work_type_id=pk_work_type_id " +
                    "WHERE worker_id=1 AND delivery_date BETWEEN DATE '2019-12-12' AND DATE '2019-12-17'",
                    Tuple.class);
            System.out.println("executing: " + query4workerProblemsByDate.getQueryString());
            List<Tuple> query4workerProblemsByDateResults = query4workerProblemsByDate.getResultList();
            for (Tuple workTypesTuple : query4workerProblemsByDateResults) {
                System.out.print("Car name: " + workTypesTuple.get("car_name") + ", ");
                System.out.print("Client name: " + workTypesTuple.get("client_name") + ", ");
                System.out.print("Work type: " + workTypesTuple.get("work_type_name") + ", ");
                System.out.println("Delivery date: " + workTypesTuple.get("delivery_date"));
            }

            System.out.println();
            System.out.println("Executing task 5:");
            final Query query5clientCost = session.createSQLQuery(
                    "SELECT " +
                    "SUM (price) AS total_cost " +
                    "FROM client " +
                    "INNER JOIN car ON pk_client_id=fk_client_id " +
                    "INNER JOIN problem ON pk_car_id=car_id " +
                    "INNER JOIN work_type ON work_type_id=pk_work_type_id " +
                    "WHERE pk_client_id=1"
            );
            System.out.println("executing: " + query5clientCost.getQueryString());
            for (Object o : query5clientCost.list()) {
                double totalCost = (double)o;
                System.out.println("Total cost: " + totalCost);
            }
        } finally {
            session.close();
        }
    }
}