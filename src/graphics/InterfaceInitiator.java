package graphics;

import org.hibernate.Session;
import queries.QueryMaker;
import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class InterfaceInitiator {
    private QueryMaker queryMaker;
    private ResultsDisplayer resultsDisplayer;
    private Frame frame;


    public InterfaceInitiator(Session session) {
        queryMaker = new QueryMaker(session);
        resultsDisplayer = new ResultsDisplayer();
    }

    public void initiateInterface() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    frame = new Frame(queryMaker, resultsDisplayer);
                    frame.pack();
                    frame.setVisible(true);
                }
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
        resultsDisplayer.setInterface(frame, queryMaker);
    }

    public Frame getFrame() {
        return frame;
    }

    public QueryMaker getQueryMaker() {
        return queryMaker;
    }
}
