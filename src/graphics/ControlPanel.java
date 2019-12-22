package graphics;

import queries.QueryManager;
import user_interaction.CarWorksComboBox;
import user_interaction.ClientCostComboActionListener;
import user_interaction.ClientCostComboBox;
import user_interaction.WorkTypesComboActionListener;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {


    public ControlPanel(QueryManager queryManager, ResultsDisplayer resultsDisplayer)
    {
        setBackground(new Color(116, 255, 207));
        setPreferredSize(new Dimension(500, 850));
        setLayout(new GridBagLayout());
        JLabel carWorksJLabel = new JLabel("Query 3 - services on a car");
        carWorksJLabel.setFont(new Font("Verdana", Font.PLAIN,13));
        GridBagConstraints carWorksJLabelConstraints = new GridBagConstraints();
        carWorksJLabelConstraints.weightx = 1;
        carWorksJLabelConstraints.weighty = 1;
        carWorksJLabelConstraints.gridx = 0;
        carWorksJLabelConstraints.gridy = 0;
        add(carWorksJLabel, carWorksJLabelConstraints);

        String[] carIds = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        CarWorksComboBox carWorksComboBox = new CarWorksComboBox(carIds);
        carWorksComboBox.setSelectedIndex(0);
        WorkTypesComboActionListener workTypesComboActionListener = new WorkTypesComboActionListener(queryManager, resultsDisplayer);
        carWorksComboBox.addActionListener(workTypesComboActionListener);
        GridBagConstraints carWorksComboBoxComboBoxConstraints = new GridBagConstraints();
        carWorksComboBoxComboBoxConstraints.weightx = 1;
        carWorksComboBoxComboBoxConstraints.weighty = 1;
        carWorksComboBoxComboBoxConstraints.gridx = 0;
        carWorksComboBoxComboBoxConstraints.gridy = 1;
        add(carWorksComboBox, carWorksComboBoxComboBoxConstraints);

        JLabel clientCostJLabel = new JLabel("Query 5 - total cost for a client");
        clientCostJLabel.setFont(new Font("Verdana", Font.PLAIN,13));
        GridBagConstraints clientCostJLabelConstraints = new GridBagConstraints();
        clientCostJLabelConstraints.weightx = 1;
        clientCostJLabelConstraints.weighty = 1;
        clientCostJLabelConstraints.gridx = 0;
        clientCostJLabelConstraints.gridy = 2;
        add(clientCostJLabel, clientCostJLabelConstraints);

        String[] clientIds = { "1", "2", "3", "4", "5", "6", "7" };
        ClientCostComboBox clientCostComboBox = new ClientCostComboBox(clientIds);
        clientCostComboBox.setSelectedIndex(0);
        ClientCostComboActionListener clientCostComboActionListener = new ClientCostComboActionListener(queryManager, resultsDisplayer);
        clientCostComboBox.addActionListener(clientCostComboActionListener);
        GridBagConstraints clientCostComboBoxComboBoxConstraints = new GridBagConstraints();
        clientCostComboBoxComboBoxConstraints.weightx = 1;
        clientCostComboBoxComboBoxConstraints.weighty = 1;
        clientCostComboBoxComboBoxConstraints.gridx = 0;
        clientCostComboBoxComboBoxConstraints.gridy = 3;
        add(clientCostComboBox, clientCostComboBoxComboBoxConstraints);
    }

    public static GridBagConstraints getConstraints() {
        GridBagConstraints controlPanelConstraints = new GridBagConstraints();
        controlPanelConstraints.fill = GridBagConstraints.BOTH;
        controlPanelConstraints.weightx = 0;
        controlPanelConstraints.weighty = 0;
        controlPanelConstraints.gridx = 0;
        controlPanelConstraints.gridy = 0;
        return controlPanelConstraints;
    }
}
