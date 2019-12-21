package database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "public", catalog = "Carsbase")
public class ClientEntity {
    private String clientName;
    private Integer pkClientId;

    @Basic
    @Column(name = "client_name", nullable = false, length = 255)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Id
    @Column(name = "pk_client_id", nullable = false)
    public Integer getPkClientId() {
        return pkClientId;
    }

    public void setPkClientId(Integer pkClientId) {
        this.pkClientId = pkClientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(clientName, that.clientName) &&
                Objects.equals(pkClientId, that.pkClientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName, pkClientId);
    }
}
