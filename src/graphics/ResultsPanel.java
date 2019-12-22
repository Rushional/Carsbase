package graphics;

import javax.swing.*;
import java.awt.*;

public class ResultsPanel extends JPanel {
    public ResultsPanel()
    {
        setBackground(new Color(235, 240, 255));
        setPreferredSize(new Dimension(700, 600));
    }

    public static GridBagConstraints getConstraints() {
        GridBagConstraints resultsPanelConstraints = new GridBagConstraints();
        resultsPanelConstraints.fill = GridBagConstraints.BOTH;
        resultsPanelConstraints.weightx = 0;
        resultsPanelConstraints.weighty = 0;
        resultsPanelConstraints.gridx = 1;
        resultsPanelConstraints.gridy = 0;
        return resultsPanelConstraints;
    }
}
