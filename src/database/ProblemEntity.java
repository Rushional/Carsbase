package database;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "problem", schema = "public", catalog = "Carsbase")
public class ProblemEntity {
    private Integer pkProblem;
    private Date deliveryDate;
    private Integer workTypeId;

    @Id
    @Column(name = "pk_problem", nullable = false)
    public Integer getPkProblem() {
        return pkProblem;
    }

    public void setPkProblem(Integer pkProblem) {
        this.pkProblem = pkProblem;
    }

    @Basic
    @Column(name = "delivery_date", nullable = true)
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Basic
    @Column(name = "work_type_id", nullable = true)
    public Integer getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(Integer workTypeId) {
        this.workTypeId = workTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProblemEntity that = (ProblemEntity) o;
        return Objects.equals(pkProblem, that.pkProblem) &&
                Objects.equals(deliveryDate, that.deliveryDate) &&
                Objects.equals(workTypeId, that.workTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkProblem, deliveryDate, workTypeId);
    }
}
