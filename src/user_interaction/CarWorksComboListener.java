package user_interaction;

import graphics.ResultsDisplayer;
import queries.QueryMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarWorksComboListener implements ActionListener {
    private QueryMaker queryMaker;
    private ResultsDisplayer resultsDisplayer;

    public CarWorksComboListener(QueryMaker queryMaker, ResultsDisplayer resultsDisplayer) {
        this.queryMaker = queryMaker;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        CarWorksComboBox carWorksComboBox = (CarWorksComboBox)e.getSource();
        int carId = Integer.parseInt((String)carWorksComboBox.getSelectedItem());
        resultsDisplayer.displayCarWorks(queryMaker.carWorks(carId));
    }
}
