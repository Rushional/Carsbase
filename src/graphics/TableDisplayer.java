package graphics;

import javax.persistence.Tuple;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TableDisplayer {
    private ResultsPanel resultsPanel;
    private Frame frame;

    public TableDisplayer(Frame frame) {
        this.frame = frame;
    }

    //wrong place for this and violates SRP but I've got no time to deal with it!
    public JTable assembleJTableWorkTypes(List<Tuple> data) {
        ArrayList<Object[]> table = new ArrayList<Object[]>();
        for (Tuple tuple : data) {
            Object[] tableRow = new Object[2];
            tableRow[0] = tuple.get("work_type_name");
            tableRow[1] = tuple.get("price");
            table.add(tableRow);
        }
        Object[][] dataForJTable = new Object[table.size()][2];
        table.toArray(dataForJTable);
        String[] columnNames = {"Work type", "Price"};
        JTable workTypes = new JTable(dataForJTable, columnNames);
        return workTypes;
    }

    public void displayTable() {
        ResultsPanel resultsPanel = new ResultsPanel();
        frame.replaceResultsPanel(resultsPanel);
        //add grid bag layout for the panel
        //assemble JTable
        //make constraints for it
        //add it to the panel with constraints
        //panel.repaint I guess
    }
}
