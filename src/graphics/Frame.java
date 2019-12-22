package graphics;

import queries.QueryManager;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public TableDisplayer getTableDisplayer() {
        return tableDisplayer;
    }

    private TableDisplayer tableDisplayer;

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    private ControlPanel controlPanel;

    public void setResultsPanel(ResultsPanel resultsPanel) {
        this.resultsPanel = resultsPanel;
    }

    private ResultsPanel resultsPanel;
    private Container pane;

    public Frame(QueryManager queryManager, TableDisplayer tableDisplayer) {
        super("Работа с базой данных");
        this.tableDisplayer = tableDisplayer;
        controlPanel = new ControlPanel(queryManager, tableDisplayer);
        resultsPanel = new ResultsPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pane = this.getContentPane();
        pane.setLayout(new GridBagLayout());
        pane.add(controlPanel, controlPanel.getConstraints());
        pane.add(resultsPanel, resultsPanel.getConstraints());
    }

    public void replaceResultsPanel(ResultsPanel newPanel) {
        this.resultsPanel = newPanel;
        pane.add(resultsPanel, resultsPanel.getConstraints());
    }

    public ResultsPanel getResultsPanel() {
        return resultsPanel;
    }
}
