package sistemas.pruebataller.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sistemas.pruebataller.persistence.PersistenceController;


@ToString
@Getter
@Setter
@Entity
public class Medico extends Persona implements Serializable{
    private int matricula;
    private String especialidad;
    @OneToMany
    private ArrayList<Triage> triage;

    public Medico(int dni, String nombre, Date fechaNac,int matricula, String especialidad) {
        super(dni, nombre, fechaNac);
        this.triage = new ArrayList<>();
        this.matricula = matricula;
        this.especialidad = especialidad;
    }

    public Medico(int dni, String nombre, Date fechaNac, int matricula, String especialidad, ArrayList<Triage> triage) {
        super(dni, nombre, fechaNac);
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.triage = triage;
    }

    public Medico() {
        super();
        this.triage = new ArrayList<>();
    }
    
    public void realizarTriage(int respiracion, int pulso){
        Triage t = new Triage(respiracion, pulso, this);
        triage.add(t);
        new PersistenceController().crearTriage(t);
    }
    
    public void modificarTriage(){
        
    }
    
    public void addTriage(Triage t){
        triage.add(t);
    }
}
