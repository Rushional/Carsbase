import graphics.*;
import graphics.Frame;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import queries.QueryManager;

import java.util.Scanner;

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
        InterfaceInitiator interfaceInitiator = new InterfaceInitiator(session);
        QueryManager queryManager = interfaceInitiator.getQueryManager();
        queryManager.createQueryOptions();
        interfaceInitiator.initiateInterface();
        Frame frame = interfaceInitiator.getFrame();
        ResultsDisplayer resultsDisplayer = new ResultsDisplayer();
        resultsDisplayer.setInterface(frame, queryManager);
//        System.out.println("Write integer to end session");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        session.close();
    }
}