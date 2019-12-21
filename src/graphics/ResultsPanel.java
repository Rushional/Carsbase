package graphics;

import javax.swing.*;
import java.awt.*;

public class ResultsPanel extends JPanel {
    public ResultsPanel()
    {
        setBackground(new Color(235, 240, 255));
        setPreferredSize(new Dimension(1100, 850));
    }

    public static GridBagConstraints getConstraints() {
        GridBagConstraints resultsPanelConstraints = new GridBagConstraints();
        resultsPanelConstraints.fill = GridBagConstraints.NONE;
        resultsPanelConstraints.weightx = 0;
        resultsPanelConstraints.weighty = 0;
        resultsPanelConstraints.gridx = 1;
        resultsPanelConstraints.gridy = 0;
        return resultsPanelConstraints;
    }
}
