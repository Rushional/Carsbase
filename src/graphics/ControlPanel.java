package graphics;

import queries.QueryManager;
import user_interaction.WorkTypesComboActionListener;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {


    public ControlPanel(QueryManager queryManager)
    {
        setBackground(new Color(116, 255, 207));
        setPreferredSize(new Dimension(500, 850));
        setLayout(new GridBagLayout());
        String[] carIds = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        JComboBox petListComboBox = new JComboBox(carIds);
        petListComboBox.setSelectedIndex(0);
        WorkTypesComboActionListener workTypesComboActionListener = new WorkTypesComboActionListener(queryManager);
        petListComboBox.addActionListener(workTypesComboActionListener);
        GridBagConstraints comboBoxConstraints = new GridBagConstraints();
        comboBoxConstraints.weightx = 1;
        comboBoxConstraints.weighty = 1;
        comboBoxConstraints.gridx = 0;
        comboBoxConstraints.gridy = 0;
        add(petListComboBox, comboBoxConstraints);
    }

    public static GridBagConstraints getConstraints() {
        GridBagConstraints controlPanelConstraints = new GridBagConstraints();
        controlPanelConstraints.fill = GridBagConstraints.NONE;
        controlPanelConstraints.weightx = 0;
        controlPanelConstraints.weighty = 0;
        controlPanelConstraints.gridx = 0;
        controlPanelConstraints.gridy = 0;
        return controlPanelConstraints;
    }
}
