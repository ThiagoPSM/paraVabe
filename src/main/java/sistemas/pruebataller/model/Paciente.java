package sistemas.pruebataller.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Paciente extends Persona{
    @OneToOne
    private Persona personaContacto;
    
    public Paciente(int dni, String nombre, Date fechaNac, Persona persContacto){
        super(dni, nombre, fechaNac);
        personaContacto = persContacto;
    }
}
