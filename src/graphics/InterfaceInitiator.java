package graphics;

import org.hibernate.Session;
import queries.QueryManager;
import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class InterfaceInitiator {
    private QueryManager queryManager;
    private ResultsDisplayer resultsDisplayer;
    private Frame frame;


    public InterfaceInitiator(Session session) {
        queryManager = new QueryManager(session);
        resultsDisplayer = new ResultsDisplayer();
    }

    public void initiateInterface() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    frame = new Frame(queryManager, resultsDisplayer);
                    frame.pack();
                    frame.setVisible(true);
                }
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
        resultsDisplayer.setInterface(frame, queryManager);
    }

    public Frame getFrame() {
        return frame;
    }

    public QueryManager getQueryManager() {
        return queryManager;
    }
}
