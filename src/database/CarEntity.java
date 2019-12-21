package database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car", schema = "public", catalog = "Carsbase")
public class CarEntity {
    private Integer pkCarId;
    private String carName;

    @Id
    @Column(name = "pk_car_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getPkCarId() {
        return pkCarId;
    }

    public void setPkCarId(Integer pkCarId) {
        this.pkCarId = pkCarId;
    }

    @Basic
    @Column(name = "car_name", nullable = false, length = 255)
    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return Objects.equals(pkCarId, carEntity.pkCarId) &&
                Objects.equals(carName, carEntity.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkCarId, carName);
    }
}
