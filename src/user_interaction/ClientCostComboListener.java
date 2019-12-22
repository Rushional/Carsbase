package user_interaction;

import graphics.ResultsDisplayer;
import queries.QueryMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientCostComboListener implements ActionListener {
    private QueryMaker queryMaker;
    private ResultsDisplayer resultsDisplayer;

    public ClientCostComboListener(QueryMaker queryMaker, ResultsDisplayer resultsDisplayer) {
        this.queryMaker = queryMaker;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        ClientCostComboBox clientCostComboBox = (ClientCostComboBox)e.getSource();
        int clientId = Integer.parseInt((String)clientCostComboBox.getSelectedItem());
        resultsDisplayer.displayClientCost(queryMaker.clientCost(clientId), clientId);
    }
}
