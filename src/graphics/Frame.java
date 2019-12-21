package graphics;

import queries.QueryManager;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private ControlPanel controlPanel;
    private ResultsPanel resultsPanel;
    private Container pane;

    public Frame(QueryManager queryManager) {
        super("Работа с базой данных");
        controlPanel = new ControlPanel(queryManager);
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
