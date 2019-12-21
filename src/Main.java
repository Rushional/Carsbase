import database.WorkTypeEntity;
import graphics.Frame;
import graphics.InterfaceInitiator;
import graphics.ResultsPanel;
import graphics.TableDisplayer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import queries.QueryManager;
import javax.persistence.Tuple;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) {
        final Session session = getSession();
        QueryManager queryManager = new QueryManager(session);
        InterfaceInitiator interfaceInitiator = new InterfaceInitiator();
        Frame frame = interfaceInitiator.initiateInterface();
        TableDisplayer tableDisplayer = new TableDisplayer(frame);
        JTable workTypesTable;
        JTable carsClientsTable;
        JTable carWorksTable;
        JTable workerProblemsByDateTable;
        double totalCost;
        try {
            //task1
            List<Tuple> workTypes = queryManager.workTypes();
            workTypesTable = tableDisplayer.assembleJTableWorkTypes(workTypes);
            //task2
            List<Tuple> carsClients = queryManager.carsClients();
//            carsClientsTable = tableDisplayer.assembleJTableWorkTypes(carsClients);
            //task3
            List<Tuple> carWorks = queryManager.carWorks(6);
//            carWorksTable = tableDisplayer.assembleJTableWorkTypes(carWorks);
            //task4
            List<Tuple> workerProblemsByDate = queryManager.workerProblemsByDate(new Date(119, Calendar.DECEMBER, 20), new Date(119, Calendar.DECEMBER, 30));
//            workerProblemsByDateTable = tableDisplayer.assembleJTableWorkTypes(workerProblemsByDate);
            //task5
            totalCost =  queryManager.clientCost(7);
//            WorkTypeEntity workType = new WorkTypeEntity();
//            workType.setWorkTypeName("Test work type");
//            workType.setPrice((double)54);
//            session.beginTransaction();
//            session.save(workType);
//            System.out.println("Inserted Successfully");
//            session.getTransaction().commit();
//
//            session.beginTransaction();
//            WorkTypeEntity workType = (WorkTypeEntity)session.get(WorkTypeEntity.class, 8);
//            workType.setWorkTypeName("Testing update");
//            System.out.println("Updated Successfully");
//            session.getTransaction().commit();
        } finally {
            session.close();
        }
        JScrollPane scrollPane = new JScrollPane(workTypesTable);
        workTypesTable.setFillsViewportHeight(true);
        scrollPane.setPreferredSize(new Dimension(500, 200));
        ResultsPanel resultsPanel = new ResultsPanel();
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
}