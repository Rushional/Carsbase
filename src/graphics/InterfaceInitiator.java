package graphics;

import org.hibernate.Session;
import queries.QueryMaker;
import queries.QueryManager;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class InterfaceInitiator {
    private QueryMaker queryMaker; //TO DO delete this! Make Manager create Maker. Also don't do this, because time
    private QueryManager queryManager;
    private TableDisplayer tableDisplayer;
    private Frame frame;


    public InterfaceInitiator(Session session) {
        queryMaker = new QueryMaker(session);
        queryManager = new QueryManager(queryMaker);
        tableDisplayer = new TableDisplayer();
    }

    public void initiateInterface() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    frame = new Frame(queryManager, tableDisplayer);
                    frame.pack();
                    frame.setVisible(true);
                }
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
        tableDisplayer.setInterface(frame, queryManager);
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
