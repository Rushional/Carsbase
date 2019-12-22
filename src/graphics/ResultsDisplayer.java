package graphics;

import queries.QueryMaker;
import javax.persistence.Tuple;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResultsDisplayer {
    private Frame frame;
    private QueryMaker queryMaker;

    public void setInterface(Frame frame, QueryMaker queryMaker) {
        this.frame = frame;
        this.queryMaker = queryMaker;
    }

    //TO DO I can fix ResultsPanel blinking if I move "removeAll" from
    //frame to control panel. If it's possible
    //Buuuut I'm not going to because - again - time is of the essence
    public void recreateFramePane() {
        frame.getContentPane().removeAll();
        ControlPanel controlPanel = new ControlPanel(queryMaker, this);
        Container pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());
        pane.add(controlPanel, controlPanel.getConstraints());
        frame.pack();
    }

    //wrong place for this and violates SRP but I've got no time to deal with it!
    private void displayJTable(JTable jTable) {
        ResultsPanel resultsPanel = new ResultsPanel();
        frame.replaceResultsPanel(resultsPanel);
        JScrollPane scrollPane = new JScrollPane(jTable);
        jTable.setFillsViewportHeight(true);
        scrollPane.setPreferredSize(new Dimension(500, 200));
        resultsPanel.setLayout(new GridBagLayout());
        GridBagConstraints scrollPaneConstraints = new GridBagConstraints();
        scrollPaneConstraints.weightx = 1;
        scrollPaneConstraints.weighty = 1;
        scrollPaneConstraints.gridx = 0;
        scrollPaneConstraints.gridy = 0;
        resultsPanel.add(scrollPane, scrollPaneConstraints);
        frame.replaceResultsPanel(resultsPanel);
        frame.pack();
        frame.getResultsPanel().repaint();
    }

    //I know it's better to have 1 displayTable method, but no time to bother thinking about it
    public void displayWorkTypes(List<Tuple> workTypesTuple) {
        recreateFramePane();
        ArrayList<Object[]> table = new ArrayList<Object[]>();
        for (Tuple tuple : workTypesTuple) {
            Object[] tableRow = new Object[2];
            tableRow[0] = tuple.get("work_type_name");
            tableRow[1] = tuple.get("price");
            table.add(tableRow);
        }
        Object[][] dataForJTable = new Object[table.size()][2];
        table.toArray(dataForJTable);
        String[] columnNames = {"Work type", "Price"};
        JTable workTypes = new JTable(dataForJTable, columnNames);
        displayJTable(workTypes);
    }

    public void displayCarsClients(List<Tuple> carsClientsTuple) {
        recreateFramePane();
        ArrayList<Object[]> table = new ArrayList<Object[]>();
        for (Tuple tuple : carsClientsTuple) {
            Object[] tableRow = new Object[2];
            tableRow[0] = tuple.get("car_name");
            tableRow[1] = tuple.get("client_name");
            table.add(tableRow);
        }
        Object[][] dataForJTable = new Object[table.size()][2];
        table.toArray(dataForJTable);
        String[] columnNames = {"Car name", "Client name"};
        JTable carsClients = new JTable(dataForJTable, columnNames);
        displayJTable(carsClients);
    }

    public void displayCarWorks(List<Tuple> carWorksTuple) {
        recreateFramePane();
        ArrayList<Object[]> table = new ArrayList<Object[]>();
        for (Tuple tuple : carWorksTuple) {
            Object[] tableRow = new Object[1];
            tableRow[0] = tuple.get("work_type_name");
            table.add(tableRow);
        }
        Object[][] dataForJTable = new Object[table.size()][1];
        table.toArray(dataForJTable);
        String[] columnNames = {"Work type name"};
        JTable carWorks = new JTable(dataForJTable, columnNames);
        displayJTable(carWorks);
    }

    public void displayWorkerProblemsByDate(List<Tuple> workerProblemsByDateTuple) {
        recreateFramePane();
        ArrayList<Object[]> table = new ArrayList<Object[]>();
        for (Tuple tuple : workerProblemsByDateTuple) {
            Object[] tableRow = new Object[4];
            tableRow[0] = tuple.get("car_name");
            tableRow[1] = tuple.get("client_name");
            tableRow[2] = tuple.get("work_type_name");
            tableRow[3] = tuple.get("delivery_date");
            table.add(tableRow);
        }
        Object[][] dataForJTable = new Object[table.size()][4];
        table.toArray(dataForJTable);
        String[] columnNames = {"Car name", "Client name", "Work type", "Delivery date"};
        JTable workerProblemsByDate = new JTable(dataForJTable, columnNames);
        displayJTable(workerProblemsByDate);
    }

    public void displayClientCost(double clientCost, int clientId) {
        recreateFramePane();
        ResultsPanel resultsPanel = new ResultsPanel();
        frame.replaceResultsPanel(resultsPanel);
        resultsPanel.setLayout(new GridBagLayout());
        JLabel clientCostJLabel = new JLabel("Total cost for client " + clientId + " = " + clientCost);
        clientCostJLabel.setFont(new Font("Verdana", Font.PLAIN,17));
        GridBagConstraints clientCostJLabelConstraints = new GridBagConstraints();
        clientCostJLabelConstraints.weightx = 1;
        clientCostJLabelConstraints.weighty = 1;
        clientCostJLabelConstraints.gridx = 0;
        clientCostJLabelConstraints.gridy = 0;
        resultsPanel.add(clientCostJLabel, clientCostJLabelConstraints);
        frame.replaceResultsPanel(resultsPanel);
        frame.pack();
        frame.getResultsPanel().repaint();
    }
}
