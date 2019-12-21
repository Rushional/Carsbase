package graphics;

import javax.persistence.Tuple;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TableDisplayer {
    private Frame frame;

    public TableDisplayer(Frame frame) {
        this.frame = frame;
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
        String[] columnNames = {"Car name", "Client name"};
        JTable workerProblemsByDate = new JTable(dataForJTable, columnNames);
        displayJTable(workerProblemsByDate);
    }
}
