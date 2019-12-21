import graphics.Frame;
import graphics.InterfaceInitiator;
import graphics.ResultsPanel;
import graphics.TableDisplayer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import queries.QueryManager;
import javax.persistence.Tuple;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        InterfaceInitiator interfaceInitiator = new InterfaceInitiator();
        Frame frame = interfaceInitiator.initiateInterface();
        TableDisplayer tableDisplayer = new TableDisplayer(frame);
        List<Tuple> workTypesTuple;
        List<Tuple> carsClientsTuple;
        List<Tuple> carWorksTuple;
        List<Tuple> workerProblemsByDateTuple;
        double totalCost;
        try {
            //task1
            workTypesTuple = queryManager.workTypes();
            //task2
            carsClientsTuple = queryManager.carsClients();
            //task3
            carWorksTuple = queryManager.carWorks(6);
            //task4
            workerProblemsByDateTuple = queryManager.workerProblemsByDate
                    (new Date(119, Calendar.DECEMBER, 20), new Date(119, Calendar.DECEMBER, 30));
            //task5
            totalCost =  queryManager.clientCost(7);
        } finally {
            session.close();
        }
        tableDisplayer.displayWorkTypes(workTypesTuple);
    }
}