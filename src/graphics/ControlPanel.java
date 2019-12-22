package graphics;

import queries.QueryMaker;
import user_interaction.*;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {


    public ControlPanel(QueryMaker queryMaker, ResultsDisplayer resultsDisplayer)
    {
        setBackground(new Color(116, 255, 207));
        setPreferredSize(new Dimension(500, 600));
        setLayout(new GridBagLayout());
        JLabel workTypesJLabel = new JLabel("Query 1 - available services");
        workTypesJLabel.setFont(new Font("Verdana", Font.PLAIN,13));
        GridBagConstraints workTypesJLabelConstraints = new GridBagConstraints();
        workTypesJLabelConstraints.weightx = 1;
        workTypesJLabelConstraints.weighty = 1;
        workTypesJLabelConstraints.gridx = 0;
        workTypesJLabelConstraints.gridy = 0;
        workTypesJLabelConstraints.anchor = GridBagConstraints.PAGE_END;
        workTypesJLabelConstraints.gridwidth = 3;
        add(workTypesJLabel, workTypesJLabelConstraints);

        WorkTypesButton workTypesButton = new WorkTypesButton("Make query");
        WorkTypesButtonListener workTypesButtonListener = new WorkTypesButtonListener(queryMaker, resultsDisplayer);
        workTypesButton.addActionListener(workTypesButtonListener);
        GridBagConstraints workTypesButtonConstraints = new GridBagConstraints();
        workTypesButtonConstraints.weightx = 1;
        workTypesButtonConstraints.weighty = 1;
        workTypesButtonConstraints.gridx = 0;
        workTypesButtonConstraints.gridy = 1;
        workTypesButtonConstraints.anchor = GridBagConstraints.PAGE_START;
        workTypesButtonConstraints.gridwidth = 3;
        add(workTypesButton, workTypesButtonConstraints);

        JLabel carsClientsJLabel = new JLabel("Query 2 - all cars and their clients");
        carsClientsJLabel.setFont(new Font("Verdana", Font.PLAIN,13));
        GridBagConstraints carsClientsJLabelConstraints = new GridBagConstraints();
        carsClientsJLabelConstraints.weightx = 1;
        carsClientsJLabelConstraints.weighty = 1;
        carsClientsJLabelConstraints.gridx = 0;
        carsClientsJLabelConstraints.gridy = 2;
        carsClientsJLabelConstraints.anchor = GridBagConstraints.PAGE_END;
        carsClientsJLabelConstraints.gridwidth = 3;
        add(carsClientsJLabel, carsClientsJLabelConstraints);

        CarsClientsButton carsClientsButton = new CarsClientsButton("Make query");
        CarsClientsButtonListener carsClientsButtonListener = new CarsClientsButtonListener(queryMaker, resultsDisplayer);
        carsClientsButton.addActionListener(carsClientsButtonListener);
        GridBagConstraints carsClientsButtonConstraints = new GridBagConstraints();
        carsClientsButtonConstraints.weightx = 1;
        carsClientsButtonConstraints.weighty = 1;
        carsClientsButtonConstraints.gridx = 0;
        carsClientsButtonConstraints.gridy = 3;
        carsClientsButtonConstraints.anchor = GridBagConstraints.PAGE_START;
        carsClientsButtonConstraints.gridwidth = 3;
        add(carsClientsButton, carsClientsButtonConstraints);

        JLabel carWorksJLabel = new JLabel("Query 3 - services on a car");
        carWorksJLabel.setFont(new Font("Verdana", Font.PLAIN,13));
        GridBagConstraints carWorksJLabelConstraints = new GridBagConstraints();
        carWorksJLabelConstraints.weightx = 1;
        carWorksJLabelConstraints.weighty = 1;
        carWorksJLabelConstraints.gridx = 0;
        carWorksJLabelConstraints.gridy = 4;
        carWorksJLabelConstraints.anchor = GridBagConstraints.PAGE_END;
        carWorksJLabelConstraints.gridwidth = 3;
        add(carWorksJLabel, carWorksJLabelConstraints);

        String[] carIds = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        CarWorksComboBox carWorksComboBox = new CarWorksComboBox(carIds);
        carWorksComboBox.setSelectedIndex(0);
        CarWorksComboListener carWorksComboListener = new CarWorksComboListener(queryMaker, resultsDisplayer);
        carWorksComboBox.addActionListener(carWorksComboListener);
        GridBagConstraints carWorksComboBoxConstraints = new GridBagConstraints();
        carWorksComboBoxConstraints.weightx = 1;
        carWorksComboBoxConstraints.weighty = 1;
        carWorksComboBoxConstraints.gridx = 0;
        carWorksComboBoxConstraints.gridy = 5;
        carWorksComboBoxConstraints.anchor = GridBagConstraints.PAGE_START;
        carWorksComboBoxConstraints.gridwidth = 3;
        add(carWorksComboBox, carWorksComboBoxConstraints);

        JLabel workerProblemsByDateJLabel = new JLabel("Query 4 - jobs of a worker by date");
        workerProblemsByDateJLabel.setFont(new Font("Verdana", Font.PLAIN,13));
        GridBagConstraints workerProblemsByDateJLabelConstraints = new GridBagConstraints();
        workerProblemsByDateJLabelConstraints.weightx = 1;
        workerProblemsByDateJLabelConstraints.weighty = 1;
        workerProblemsByDateJLabelConstraints.gridx = 0;
        workerProblemsByDateJLabelConstraints.gridy = 6;
        workerProblemsByDateJLabelConstraints.anchor = GridBagConstraints.PAGE_END;
        workerProblemsByDateJLabelConstraints.gridwidth = 3;
        add(workerProblemsByDateJLabel, workerProblemsByDateJLabelConstraints);

        String[] timePeriods = { "Past day", "Past week", "Past month", "Past quarter of a year", "Past year" };
        WorkerProblemsByDateComboBoxDate workerProblemsByDateComboBoxDate = new WorkerProblemsByDateComboBoxDate(timePeriods);
        workerProblemsByDateComboBoxDate.setSelectedIndex(0);
        WorkerProblemsByDateComboListenerDate workerProblemsByDateComboListenerDate = new WorkerProblemsByDateComboListenerDate(queryMaker);
        workerProblemsByDateComboBoxDate.addActionListener(workerProblemsByDateComboListenerDate);
        GridBagConstraints workerProblemsByDateComboBoxConstraintsDate = new GridBagConstraints();
        workerProblemsByDateComboBoxConstraintsDate.weightx = 1;
        workerProblemsByDateComboBoxConstraintsDate.weighty = 1;
        workerProblemsByDateComboBoxConstraintsDate.gridx = 0;
        workerProblemsByDateComboBoxConstraintsDate.gridy = 7;
        add(workerProblemsByDateComboBoxDate, workerProblemsByDateComboBoxConstraintsDate);

        String[] workerIds = { "1", "2", "3", "4", "5", "6", "7", "8" };
        WorkerProblemsByDateComboBoxWorker workerProblemsByDateComboBoxWorker = new WorkerProblemsByDateComboBoxWorker(workerIds);
        workerProblemsByDateComboBoxWorker.setSelectedIndex(0);
        WorkerProblemsByDateComboListenerWorker workerProblemsByDateComboListenerWorker = new WorkerProblemsByDateComboListenerWorker(queryMaker);
        workerProblemsByDateComboBoxWorker.addActionListener(workerProblemsByDateComboListenerWorker);
        GridBagConstraints workerProblemsByDateComboBoxConstraintsWorker = new GridBagConstraints();
        workerProblemsByDateComboBoxConstraintsWorker.weightx = 1;
        workerProblemsByDateComboBoxConstraintsWorker.weighty = 1;
        workerProblemsByDateComboBoxConstraintsWorker.gridx = 1;
        workerProblemsByDateComboBoxConstraintsWorker.gridy = 7;
        add(workerProblemsByDateComboBoxWorker, workerProblemsByDateComboBoxConstraintsWorker);

        WorkerProblemsByDateButton workerProblemsByDateButton = new WorkerProblemsByDateButton("Make query");
        WorkerProblemsByDateButtonListener workerProblemsByDateButtonListener = new WorkerProblemsByDateButtonListener(queryMaker, resultsDisplayer);
        workerProblemsByDateButton.addActionListener(workerProblemsByDateButtonListener);
        GridBagConstraints workerProblemsByDateButtonConstraints = new GridBagConstraints();
        workerProblemsByDateButtonConstraints.weightx = 1;
        workerProblemsByDateButtonConstraints.weighty = 1;
        workerProblemsByDateButtonConstraints.gridx = 2;
        workerProblemsByDateButtonConstraints.gridy = 7;
        add(workerProblemsByDateButton, workerProblemsByDateButtonConstraints);

        JLabel clientCostJLabel = new JLabel("Query 5 - total cost for a client");
        clientCostJLabel.setFont(new Font("Verdana", Font.PLAIN,13));
        GridBagConstraints clientCostJLabelConstraints = new GridBagConstraints();
        clientCostJLabelConstraints.weightx = 1;
        clientCostJLabelConstraints.weighty = 1;
        clientCostJLabelConstraints.gridx = 0;
        clientCostJLabelConstraints.gridy = 8;
        clientCostJLabelConstraints.anchor = GridBagConstraints.PAGE_END;
        clientCostJLabelConstraints.gridwidth = 3;
        add(clientCostJLabel, clientCostJLabelConstraints);

        String[] clientIds = { "1", "2", "3", "4", "5", "6", "7" };
        ClientCostComboBox clientCostComboBox = new ClientCostComboBox(clientIds);
        clientCostComboBox.setSelectedIndex(0);
        ClientCostComboListener clientCostComboListener = new ClientCostComboListener(queryMaker, resultsDisplayer);
        clientCostComboBox.addActionListener(clientCostComboListener);
        GridBagConstraints clientCostComboBoxConstraints = new GridBagConstraints();
        clientCostComboBoxConstraints.weightx = 1;
        clientCostComboBoxConstraints.weighty = 1;
        clientCostComboBoxConstraints.gridx = 0;
        clientCostComboBoxConstraints.gridy = 9;
        clientCostComboBoxConstraints.anchor = GridBagConstraints.PAGE_START;
        clientCostComboBoxConstraints.gridwidth = 3;
        add(clientCostComboBox, clientCostComboBoxConstraints);
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
