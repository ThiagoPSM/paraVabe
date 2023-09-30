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
        
    }
}
