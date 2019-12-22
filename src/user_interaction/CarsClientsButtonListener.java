package user_interaction;

import graphics.ResultsDisplayer;
import queries.QueryMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarsClientsButtonListener implements ActionListener {
    private QueryMaker queryMaker;
    private ResultsDisplayer resultsDisplayer;

    public CarsClientsButtonListener(QueryMaker queryMaker, ResultsDisplayer resultsDisplayer) {
        this.queryMaker = queryMaker;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        resultsDisplayer.displayCarsClients(queryMaker.carsClients());
    }
}
