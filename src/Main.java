import graphics.*;
import graphics.Frame;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import queries.QueryMaker;
import javax.persistence.Tuple;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
        QueryMaker queryMaker = interfaceInitiator.getQueryMaker();
        interfaceInitiator.initiateInterface();
        Frame frame = interfaceInitiator.getFrame();
        ResultsDisplayer resultsDisplayer = new ResultsDisplayer();
        resultsDisplayer.setInterface(frame, queryMaker);
//        System.out.println("Write integer to end session");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        session.close();
    }
}