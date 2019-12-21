package database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "worker_work_type", schema = "public", catalog = "Carsbase")
public class WorkerWorkTypeEntity {
    private Integer workerWorkTypeId;

    @Id
    @Column(name = "worker_work_type_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getWorkerWorkTypeId() {
        return workerWorkTypeId;
    }

    public void setWorkerWorkTypeId(Integer workerWorkTypeId) {
        this.workerWorkTypeId = workerWorkTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerWorkTypeEntity that = (WorkerWorkTypeEntity) o;
        return Objects.equals(workerWorkTypeId, that.workerWorkTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerWorkTypeId);
    }
}
