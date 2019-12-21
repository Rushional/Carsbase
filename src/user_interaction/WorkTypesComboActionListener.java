package user_interaction;

import queries.QueryManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkTypesComboActionListener implements ActionListener {
    private QueryManager queryManager;

    public WorkTypesComboActionListener(QueryManager queryManager) {
        this.queryManager = queryManager;
    }

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        int carId = Integer.parseInt((String)cb.getSelectedItem());
//        System.out.println("I listen to " + carId);
        notifyQueryManager(carId);
    }

    private void notifyQueryManager(int carId) {
        queryManager.setCarId(carId);
    }
}
