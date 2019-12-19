package query_results;

import javax.persistence.*;

@Entity
public class WorkTypesQuery {
    private String work_type_name;
    private Double price;

    @Id
    @Column(name = "work_type_name", nullable = false, length = 255)
    public String getWorkTypeName() {
        return work_type_name;
    }

    public void setWorkTypeName(String pkCarId) {
        this.work_type_name = pkCarId;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double carName) {
        this.price = carName;
    }
}
