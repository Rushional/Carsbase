package user_interaction;

import graphics.TableDisplayer;
import queries.QueryManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkTypesComboActionListener implements ActionListener {
    private QueryManager queryManager;
    private TableDisplayer tableDisplayer;

    public WorkTypesComboActionListener(QueryManager queryManager, TableDisplayer tableDisplayer) {
        this.queryManager = queryManager;
        this.tableDisplayer = tableDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        int carId = Integer.parseInt((String)cb.getSelectedItem());
        tableDisplayer.displayCarWorks(queryManager.carWorks(carId));
    }
}
