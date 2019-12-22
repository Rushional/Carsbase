package user_interaction;

import graphics.ResultsDisplayer;
import queries.QueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientCostComboActionListener implements ActionListener {
    private QueryManager queryManager;
    private ResultsDisplayer resultsDisplayer;

    public ClientCostComboActionListener(QueryManager queryManager, ResultsDisplayer resultsDisplayer) {
        this.queryManager = queryManager;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        ClientCostComboBox clientCostComboBox = (ClientCostComboBox)e.getSource();
        int clientId = Integer.parseInt((String)clientCostComboBox.getSelectedItem());
        resultsDisplayer.displayClientCost(queryManager.clientCost(clientId), clientId);
    }
}
