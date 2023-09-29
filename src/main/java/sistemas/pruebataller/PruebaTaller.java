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
        
//        Medico med = controller.obtenerMedico(1547932);
//        Triage t = controller.obtenerTriage(1);
//        System.out.println(t);
//        med.setTriage(controller.obtenerTriages());
//        System.out.println(med.getTriage());
        Persona p1  = controller.obtenerPersona(32165498);
        Persona pac1 = controller.obtenerPersona(12345678);
        
        System.out.println(p1);
        System.out.println(pac1);
        for(Medico m : controller.obtenerMedicos()){
            m.setTriage(controller.obtenerTriages());
            System.out.println(m.getTriage());
        }
    }
}
