package queries;

import graphics.ControlPanel;
import graphics.ResultsPanel;

import javax.persistence.Tuple;
import java.awt.*;
import java.util.List;

public class QueryManager {
    private QueryMaker queryMaker;
    private List<Tuple> workTypesTuple;
    private List<Tuple> carsClientsTuple;
    private List<Tuple> carWorksTuple;
    private List<Tuple> workerProblemsByDateTuple;

    public QueryManager(QueryMaker queryMaker) {
        this.queryMaker = queryMaker;
    }

    //TO DO method that is constantly waiting to make a query
    //it will have a hatch or how's it called
    public List<Tuple> workTypes() {
        return queryMaker.workTypes();
    }

    public List<Tuple> carsClients() {
        return queryMaker.carsClients();
    }

    public List<Tuple> carWorks(int carId) {
        return queryMaker.carWorks(carId);
    }

    public double clientCost(int clientId) {
        return queryMaker.clientCost(clientId);
    }
}
