package queries;

import javax.persistence.Tuple;
import java.util.List;

public class QueryManager {
    private int carId;
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
    public List<Tuple> carWorks() {
        return queryMaker.carWorks(carId);
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCarId() {
        return carId;
    }
}
