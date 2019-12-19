import database.ClientEntity;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Tuple;
import javax.persistence.metamodel.EntityType;

import java.util.List;
import java.util.Map;

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
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }

            System.out.println();
            System.out.println("Executing task 1:");
//            final Query query1workTypes = session.createSQLQuery("SELECT work_type_name, price FROM work_type").addEntity(WorkTypesQuery.class);
//            System.out.println("executing: " + query1workTypes.getQueryString());
//            List<WorkTypesQuery> workTypesList = query1workTypes.list();
//            //display the data
//            workTypesList.forEach(row->{
//                System.out.println("\t"+row.getWorkTypeName()+"\t"+row.getPrice());
//            });

            Query query1workTypes = session.createNativeQuery(
                    "SELECT work_type_name, price FROM work_type",
                    Tuple.class);
            List<Tuple> query1workTypesResults = query1workTypes.getResultList();
            for (Tuple workTypesTuple : query1workTypesResults) {
                System.out.print("Work type: " + workTypesTuple.get("work_type_name") + ", ");
                System.out.println("Price: " + workTypesTuple.get("price"));
            }

            System.out.println();
            System.out.println("Executing task 2:");
            final Query query2carsClients = session.createSQLQuery(
                    "SELECT car_name, client_name " +
                    "FROM car INNER JOIN client " +
                    "ON fk_client_id=pk_client_id"
            );
            System.out.println("executing: " + query2carsClients.getQueryString());
            for (Object o : query2carsClients.list()) {
                System.out.println("  " + o);
            }

            System.out.println();
            System.out.println("Executing task 3:");
            final Query query3carWorks = session.createSQLQuery(
                    "SELECT work_type_name\n" +
                    "FROM problem\n" +
                    "INNER JOIN work_type ON work_type_id=pk_work_type_id\n" +
                    "WHERE car_id=3;"
            );
            System.out.println("executing: " + query3carWorks.getQueryString());
            for (Object o : query3carWorks.list()) {
                System.out.println("  " + o);
            }

            System.out.println();
            System.out.println("Executing task 4:");
            final Query query4workerProblemsByDate = session.createSQLQuery(
                    "SELECT car_name, client_name, work_type_name, delivery_date\n" +
                    "FROM problem\n" +
                    "INNER JOIN car ON car_id=pk_car_id\n" +
                    "INNER JOIN client ON fk_client_id=pk_client_id\n" +
                    "INNER JOIN work_type ON work_type_id=pk_work_type_id\n" +
                    "WHERE worker_id=1 AND delivery_date BETWEEN DATE '2019-12-12' AND DATE '2019-12-17'"
            );
            System.out.println("executing: " + query4workerProblemsByDate.getQueryString());
            for (Object o : query4workerProblemsByDate.list()) {
                System.out.println("  " + o);
            }

            System.out.println();
            System.out.println("Executing task 5:");
            final Query query5clientCost = session.createSQLQuery(
                    "SELECT\n" +
                    "SUM (price) AS total_cost\n" +
                    "FROM client\n" +
                    "INNER JOIN car ON pk_client_id=fk_client_id\n" +
                    "INNER JOIN problem ON pk_car_id=car_id\n" +
                    "INNER JOIN work_type ON work_type_id=pk_work_type_id\n" +
                    "WHERE pk_client_id=1"
            );
            System.out.println("executing: " + query5clientCost.getQueryString());
            for (Object o : query5clientCost.list()) {
                System.out.println("  " + o);
            }
        } finally {
            session.close();
        }
    }
}