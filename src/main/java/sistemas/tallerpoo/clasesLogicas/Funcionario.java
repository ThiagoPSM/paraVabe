package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Deian
 */
@Getter
@Setter
@NoArgsConstructor
public class Funcionario extends Persona{
    private SectorTrabajo trabajaEn;
    private ArrayList<Rol> rolesSistema;

    public Funcionario(int dni, String Nombre, String Apellido, Date fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema) {
        super(dni, Nombre, Apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect);
        this.trabajaEn = trabajaEn;
        this.rolesSistema = rolesSistema; 
    }
}