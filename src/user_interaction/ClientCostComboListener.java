package user_interaction;

import graphics.ResultsDisplayer;
import queries.QueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientCostComboListener implements ActionListener {
    private QueryManager queryManager;
    private ResultsDisplayer resultsDisplayer;

    public ClientCostComboListener(QueryManager queryManager, ResultsDisplayer resultsDisplayer) {
        this.queryManager = queryManager;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        ClientCostComboBox clientCostComboBox = (ClientCostComboBox)e.getSource();
//        int clientId = Integer.parseInt((String)clientCostComboBox.getSelectedItem());
        int index = clientCostComboBox.getSelectedIndex();
        int clientId = (int)queryManager.getClientNames().get(index).get("id");
        resultsDisplayer.displayClientCost(queryManager.clientCost(clientId), (String)clientCostComboBox.getSelectedItem());
    }
}
