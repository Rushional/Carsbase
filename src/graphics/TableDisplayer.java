package graphics;

import javax.persistence.Tuple;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TableDisplayer {
    private ResultsPanel resultsPanel;
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
}
