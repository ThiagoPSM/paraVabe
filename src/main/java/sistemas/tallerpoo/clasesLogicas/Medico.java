package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Medico extends Persona{
    private int NMatricula;

    Medico(int dni, String Nombre, String Apellido, Date fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, int NMatricula  ){
        super(dni, Nombre, Apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect);
        this.NMatricula = NMatricula;
    }
    
}
