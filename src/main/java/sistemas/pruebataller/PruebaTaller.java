package sistemas.pruebataller;

import java.util.ArrayList;
import java.util.Date;
import sistemas.pruebataller.model.Medico;
import sistemas.pruebataller.model.Paciente;
import sistemas.pruebataller.model.Persona;
import sistemas.pruebataller.model.Triage;
import sistemas.pruebataller.persistence.PersistenceController;

public class PruebaTaller {

    public static void main(String[] args) throws Exception {
        PersistenceController controller = new PersistenceController();
        
//        Medico med = new Medico(12345678, "Juan Perez", new Date(1981, 1, 4), 245, "Cardiología");
//        controller.crearMedico(med);
//        Medico med = controller.obtenerMedico(12345678);
//        
//        Triage t = new Triage(1, 1, med);
//        System.out.println(t);
//        controller.crearTriage(t);
//        med.setTriage(controller.triagePorMedico(med.getDni()));
//        System.out.println(med.getTriage());
//        System.err.println(controller.obtenerTriages());
//        System.err.println(controller.triagePorMedico(12345678));

        Persona p1 = controller.obtenerPersona(5476);
//        Paciente p2 = new Paciente(5479136, "Pedro", new Date(), p1);
//        Paciente p3 = new Paciente(5869536, "Juana", new Date(), p1);
        Persona p2 = controller.obtenerPersona(5479136);
        Persona p3 = controller.obtenerPersona(5869536);
        System.out.println(p2);
        p3.setFechaNac(new Date(2015 - 1900, 7, 12));
        System.out.println(p3.getFechaNac());
//        controller.editarPersona(p3);
    }
}
