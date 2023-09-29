package sistemas.pruebataller.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona implements Serializable {
    @Id
    private int dni;
    private String nombre;
    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", fechaNac=" + fechaNac + '}';
    }
}
