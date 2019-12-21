package graphics;

import org.hibernate.Session;
import queries.QueryMaker;
import queries.QueryManager;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class InterfaceInitiator {
    private Frame frame;
    private QueryManager queryManager;
    private QueryMaker queryMaker; //TO DO delete this! Make Manager create Maker. Also don't do this, because time

    public InterfaceInitiator(Session session) {
        queryMaker = new QueryMaker(session);
        queryManager = new QueryManager(queryMaker);
    }

    public void initiateInterface() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    frame = new Frame(queryManager);
                    frame.pack();
                    frame.setVisible(true);
                }
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
    }

    public Frame getFrame() {
        return frame;
    }

    public QueryMaker getQueryMaker() {
        return queryMaker;
    }

    public QueryManager getQueryManager() {
        return queryManager;
    }
}
