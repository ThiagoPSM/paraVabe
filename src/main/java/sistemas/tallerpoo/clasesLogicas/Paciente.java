package sistemas.tallerpoo.clasesLogicas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Paciente extends Persona {
    private Persona contacto;
}
