package database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "worker", schema = "public", catalog = "Carsbase")
public class WorkerEntity {
    private Integer pkWorkerId;
    private String workerName;

    @Id
    @Column(name = "pk_worker_id", nullable = false)
    public Integer getPkWorkerId() {
        return pkWorkerId;
    }

    public void setPkWorkerId(Integer pkWorkerId) {
        this.pkWorkerId = pkWorkerId;
    }

    @Basic
    @Column(name = "worker_name", nullable = false, length = 255)
    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerEntity that = (WorkerEntity) o;
        return Objects.equals(pkWorkerId, that.pkWorkerId) &&
                Objects.equals(workerName, that.workerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkWorkerId, workerName);
    }
}
