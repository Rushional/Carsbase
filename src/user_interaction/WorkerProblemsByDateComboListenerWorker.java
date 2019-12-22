package user_interaction;

import queries.QueryMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerProblemsByDateComboListenerWorker implements ActionListener {
    private QueryMaker queryMaker;

    public WorkerProblemsByDateComboListenerWorker(QueryMaker queryMaker) {
        this.queryMaker = queryMaker;
    }

    public void actionPerformed(ActionEvent e) {
        WorkerProblemsByDateComboBoxWorker workerProblemsByDateComboBoxWorker = (WorkerProblemsByDateComboBoxWorker) e.getSource();
        int workerId = Integer.parseInt((String) workerProblemsByDateComboBoxWorker.getSelectedItem());
        queryMaker.setWorkerId(workerId);
    }
}
