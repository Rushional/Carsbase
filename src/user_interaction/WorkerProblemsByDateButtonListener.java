package user_interaction;

import graphics.ResultsDisplayer;
import queries.QueryMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerProblemsByDateButtonListener implements ActionListener {
    private QueryMaker queryMaker;
    private ResultsDisplayer resultsDisplayer;

    public WorkerProblemsByDateButtonListener(QueryMaker queryMaker, ResultsDisplayer resultsDisplayer) {
        this.queryMaker = queryMaker;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        if (queryMaker.getQueryTimePeriod() != null && queryMaker.getWorkerId() != -1) {
            resultsDisplayer.displayWorkerProblemsByDate(queryMaker.workerProblemsByDate());
        }
    }
}
