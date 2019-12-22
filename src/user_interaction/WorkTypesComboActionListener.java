package user_interaction;

import graphics.ResultsDisplayer;
import queries.QueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkTypesComboActionListener implements ActionListener {
    private QueryManager queryManager;
    private ResultsDisplayer resultsDisplayer;

    public WorkTypesComboActionListener(QueryManager queryManager, ResultsDisplayer resultsDisplayer) {
        this.queryManager = queryManager;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        CarWorksComboBox carWorksComboBox = (CarWorksComboBox)e.getSource();
        int carId = Integer.parseInt((String)carWorksComboBox.getSelectedItem());
        resultsDisplayer.displayCarWorks(queryManager.carWorks(carId));
    }
}
