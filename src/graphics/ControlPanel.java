package graphics;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {


    public ControlPanel()
    {
        setBackground(new Color(116, 255, 207));
        setPreferredSize(new Dimension(500, 850));
    }

    public GridBagConstraints getConstraints() {
        GridBagConstraints controlPanelConstraints = new GridBagConstraints();
        controlPanelConstraints.fill = GridBagConstraints.NONE;
        controlPanelConstraints.weightx = 0;
        controlPanelConstraints.weighty = 0;
        controlPanelConstraints.gridx = 0;
        controlPanelConstraints.gridy = 0;
        return controlPanelConstraints;
    }
}
