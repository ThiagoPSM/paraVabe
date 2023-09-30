package sistemas.pruebataller.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemas.pruebataller.model.Medico;
import sistemas.pruebataller.model.Paciente;
import sistemas.pruebataller.model.Persona;
import sistemas.pruebataller.model.Triage;
import sistemas.pruebataller.persistence.exceptions.NonexistentEntityException;

public class PersistenceController {
    MedicoJpaController medicoController = new MedicoJpaController();
    PersonaJpaController personaController = new PersonaJpaController();
    PacienteJpaController pacienteController = new PacienteJpaController();
    TriageJpaController triageController = new TriageJpaController();
    
    //Persona
    public void crearPersona(Persona p){
        try {
            personaController.create(p);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarPersona(int dni){
        try {
            personaController.destroy(dni);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarPersona(Persona p){
        try {
            personaController.edit(p);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Persona obtenerPersona(int dni){
        return personaController.findPersona(dni);
    }
    
    public ArrayList<Persona> obtenerPersonas(){
        return new ArrayList<>(personaController.findPersonaEntities());
    }
    
    //Medico
    public void crearMedico(Medico m){
        try {
            medicoController.create(m);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Medico> obtenerMedicos(){
        return new ArrayList<>(medicoController.findMedicoEntities());
    }
    
    public Medico obtenerMedico(int dni){
        Medico med = medicoController.findMedico(dni);
        med.setTriage(triagePorMedico(dni));
        return med;
    }
    
    //Paciente
    public ArrayList<Paciente> obtenerPacientes(){
        return new ArrayList(pacienteController.findPacienteEntities());
    }
    
    public Paciente obtenerPaciente(int dni){
        return pacienteController.findPaciente(dni);
    }
    
    //Triage
    public void crearTriage(Triage triage){
        try {
            triageController.create(triage);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Triage obtenerTriage(int id){
        return triageController.findTriage(id);
    }
    
    public ArrayList<Triage> obtenerTriages(){
        return new ArrayList<>(triageController.findTriageEntities());
    }
    
    public ArrayList<Triage> triagePorMedico(int dni){
        ArrayList<Triage> lista = new ArrayList();
        for(Triage t : obtenerTriages()){
            if(t.getMedico_dni()== dni){
                lista.add(t);
            }
        }
        return lista;
    }
}
