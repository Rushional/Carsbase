package database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "work_type", schema = "public", catalog = "Carsbase")
public class WorkTypeEntity {
    private Integer pkWorkTypeId;
    private String workTypeName;
    private Double price;

    @Id
    @Column(name = "pk_work_type_id", nullable = false)
    public Integer getPkWorkTypeId() {
        return pkWorkTypeId;
    }

    public void setPkWorkTypeId(Integer pkWorkTypeId) {
        this.pkWorkTypeId = pkWorkTypeId;
    }

    @Basic
    @Column(name = "work_type_name", nullable = false, length = 255)
    public String getWorkTypeName() {
        return workTypeName;
    }

    public void setWorkTypeName(String workTypeName) {
        this.workTypeName = workTypeName;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkTypeEntity that = (WorkTypeEntity) o;
        return Objects.equals(pkWorkTypeId, that.pkWorkTypeId) &&
                Objects.equals(workTypeName, that.workTypeName) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkWorkTypeId, workTypeName, price);
    }
}
