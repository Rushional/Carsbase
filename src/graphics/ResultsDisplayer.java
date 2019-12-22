package graphics;

import queries.QueryManager;
import javax.persistence.Tuple;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResultsDisplayer {
    private Frame frame;
    private QueryManager queryManager;

    public void setInterface(Frame frame, QueryManager queryManager) {
        this.frame = frame;
        this.queryManager = queryManager;
    }

    //TO DO I can fix ResultsPanel blinking if I move "removeAll" from
    //frame to control panel. If it's possible
    //Buuuut I'm not going to because - again - time is of the essence
    public void recreateFramePane() {
        frame.getContentPane().removeAll();
        ControlPanel controlPanel = new ControlPanel(queryManager, this);
        Container pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());
        pane.add(controlPanel, controlPanel.getConstraints());
        frame.pack();
    }

    //wrong place for this and violates SRP but I've got no time to deal with it!
    private void displayJTable(JTable jTable, String tableName) {
        ResultsPanel resultsPanel = new ResultsPanel();
        resultsPanel.setLayout(new GridBagLayout());
        frame.replaceResultsPanel(resultsPanel);
        JLabel tableNameJLabel = new JLabel(tableName);
        tableNameJLabel.setFont(new Font("Verdana", Font.PLAIN,16));
        GridBagConstraints tableNameJLabelConstraints = new GridBagConstraints();
        tableNameJLabelConstraints.weightx = 1;
        tableNameJLabelConstraints.weighty = 1;
        tableNameJLabelConstraints.gridx = 0;
        tableNameJLabelConstraints.gridy = 0;
        tableNameJLabelConstraints.anchor = GridBagConstraints.PAGE_END;
        resultsPanel.add(tableNameJLabel, tableNameJLabelConstraints);

        JScrollPane scrollPane = new JScrollPane(jTable);
        jTable.setFillsViewportHeight(true);
        scrollPane.setPreferredSize(new Dimension(500, 200));
        GridBagConstraints scrollPaneConstraints = new GridBagConstraints();
        scrollPaneConstraints.weightx = 1;
        scrollPaneConstraints.weighty = 1;
        scrollPaneConstraints.gridx = 0;
        scrollPaneConstraints.gridy = 1;
        scrollPaneConstraints.anchor = GridBagConstraints.PAGE_START;
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
        displayJTable(workTypes, "Available services");
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
        displayJTable(carsClients, "Cars and their owners");
    }

    public void displayCarWorks(List<Tuple> carWorksTuple, String carName) {
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
        displayJTable(carWorks, "Services for " + carName);
    }

    public void displayWorkerProblemsByDate(List<Tuple> workerProblemsByDateTuple, String workerName) {
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
        displayJTable(workerProblemsByDate, queryManager.getQueryTimePeriod() + " services for "+ workerName);
    }

    public void displayClientCost(double clientCost, String clientName) {
        recreateFramePane();
        ResultsPanel resultsPanel = new ResultsPanel();
        frame.replaceResultsPanel(resultsPanel);
        resultsPanel.setLayout(new GridBagLayout());
        JLabel clientCostJLabel = new JLabel("Total cost for client " + clientName + " = " + clientCost);
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
