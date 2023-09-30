package sistemas.pruebataller.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Triage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private NivelTriage color;
    private int respiracion;
    private int pulso;
//    @ManyToOne
    private int medico_dni;

    public Triage(int respiracion, int pulso, Medico medico) {
        this.respiracion = respiracion;
        this.pulso = pulso;
        this.medico_dni = medico.getDni();
        
        int suma = respiracion + pulso;
        switch(suma/5){
            case 0:
                color = NivelTriage.Verde;
                break;
            case 1:
                color = NivelTriage.Amarillo;
                break;
            case 2:
                color = NivelTriage.Naranja;
                break;
            default:
                color = NivelTriage.Rojo;
                break;
        }
    }
}
