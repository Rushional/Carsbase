package user_interaction;

import graphics.ResultsDisplayer;
import queries.QueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerProblemsByDateButtonListener implements ActionListener {
    private QueryManager queryManager;
    private ResultsDisplayer resultsDisplayer;

    public WorkerProblemsByDateButtonListener(QueryManager queryManager, ResultsDisplayer resultsDisplayer) {
        this.queryManager = queryManager;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        if (queryManager.getQueryTimePeriod() != null && queryManager.getWorkerId() != -1) {
            resultsDisplayer.displayWorkerProblemsByDate(queryManager.workerProblemsByDate());
        }
    }
}
