package user_interaction;

import graphics.ResultsDisplayer;
import queries.QueryMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerProblemsByDateComboListenerDate implements ActionListener {
    private QueryMaker queryMaker;

    public WorkerProblemsByDateComboListenerDate(QueryMaker queryMaker) {
        this.queryMaker = queryMaker;
    }

    public void actionPerformed(ActionEvent e) {
        WorkerProblemsByDateComboBoxDate workerProblemsByDateComboBoxDate = (WorkerProblemsByDateComboBoxDate)e.getSource();
        String timePeriod = (String)workerProblemsByDateComboBoxDate.getSelectedItem();
        queryMaker.setQueryTimePeriod(timePeriod);
    }
}
