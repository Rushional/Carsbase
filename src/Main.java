import database.WorkTypeEntity;
import graphics.Frame;
import graphics.InterfaceInitiator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import queries.QueryManager;
import javax.persistence.Tuple;
import java.util.Calendar;
import java.util.Date;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) {
        final Session session = getSession();
        QueryManager queryManager = new QueryManager(session);
        try {
//            System.out.println();
//            System.out.println("Executing task 1:");
//            for (Tuple workTypesTuple : queryManager.workTypes()) {
//                System.out.print("Work type: " + workTypesTuple.get("work_type_name") + ", ");
//                System.out.println("Price: " + workTypesTuple.get("price"));
//            }
//
//            System.out.println();
//            System.out.println("Executing task 2:");
//            for (Tuple carsClientsTuples : queryManager.carsClients()) {
//                System.out.print("Car name: " + carsClientsTuples.get("car_name") + ", ");
//                System.out.println("Client name: " + carsClientsTuples.get("client_name"));
//            }
//
//            System.out.println();
//            System.out.println("Executing task 3:");
//            for (Tuple carWorksTuples : queryManager.carWorks(6)) {
//                System.out.println("Work type: " + carWorksTuples.get("work_type_name"));
//            }
//
//            System.out.println();
//            System.out.println("Executing task 4:");
//            for (Tuple workerProblemsByDateTuples : queryManager.workerProblemsByDate(new Date(119, Calendar.DECEMBER, 20), new Date(119, Calendar.DECEMBER, 30))) {
//                System.out.print("Car name: " + workerProblemsByDateTuples.get("car_name") + ", ");
//                System.out.print("Client name: " + workerProblemsByDateTuples.get("client_name") + ", ");
//                System.out.print("Work type: " + workerProblemsByDateTuples.get("work_type_name") + ", ");
//                System.out.println("Delivery date: " + workerProblemsByDateTuples.get("delivery_date"));
//            }
//
//            System.out.println();
//            System.out.println("Executing task 5:");
//            System.out.println("Total cost: " + queryManager.clientCost(7));
            int foo = 10;
//            WorkTypeEntity workType = new WorkTypeEntity();
//            workType.setWorkTypeName("Test work type");
//            workType.setPrice((double)54);
//            session.beginTransaction();
//            session.save(workType);
//            System.out.println("Inserted Successfully");
//            session.getTransaction().commit();
//
//            session.beginTransaction();
//            WorkTypeEntity workType = (WorkTypeEntity)session.get(WorkTypeEntity.class, 8);
//            workType.setWorkTypeName("Testing update");
//            System.out.println("Updated Successfully");
//            session.getTransaction().commit();
            InterfaceInitiator interfaceInitiator = new InterfaceInitiator();
            Frame frame = interfaceInitiator.initiateInterface();
        } finally {
            session.close();
        }
    }
}