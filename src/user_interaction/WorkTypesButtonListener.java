package user_interaction;

import graphics.ResultsDisplayer;
import queries.QueryMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkTypesButtonListener implements ActionListener {
    private QueryMaker queryMaker;
    private ResultsDisplayer resultsDisplayer;

    public WorkTypesButtonListener(QueryMaker queryMaker, ResultsDisplayer resultsDisplayer) {
        this.queryMaker = queryMaker;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        resultsDisplayer.displayWorkTypes(queryMaker.workTypes());
    }
}
