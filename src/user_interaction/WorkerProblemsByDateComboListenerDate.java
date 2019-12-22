package user_interaction;

import queries.QueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerProblemsByDateComboListenerDate implements ActionListener {
    private QueryManager queryManager;

    public WorkerProblemsByDateComboListenerDate(QueryManager queryManager) {
        this.queryManager = queryManager;
    }

    public void actionPerformed(ActionEvent e) {
        WorkerProblemsByDateComboBoxDate workerProblemsByDateComboBoxDate = (WorkerProblemsByDateComboBoxDate)e.getSource();
        String timePeriod = (String)workerProblemsByDateComboBoxDate.getSelectedItem();
        queryManager.setQueryTimePeriod(timePeriod);
    }
}
