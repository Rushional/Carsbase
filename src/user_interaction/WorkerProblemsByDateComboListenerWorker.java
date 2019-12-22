package user_interaction;

import queries.QueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerProblemsByDateComboListenerWorker implements ActionListener {
    private QueryManager queryManager;

    public WorkerProblemsByDateComboListenerWorker(QueryManager queryManager) {
        this.queryManager = queryManager;
    }

    public void actionPerformed(ActionEvent e) {
        WorkerProblemsByDateComboBoxWorker workerProblemsByDateComboBoxWorker = (WorkerProblemsByDateComboBoxWorker) e.getSource();
        int workerId = Integer.parseInt((String) workerProblemsByDateComboBoxWorker.getSelectedItem());
        queryManager.setWorkerId(workerId);
    }
}
