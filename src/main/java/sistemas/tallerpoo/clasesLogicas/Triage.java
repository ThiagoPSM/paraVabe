package sistemas.tallerpoo.clasesLogicas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Triage {
    private NivelTriage color;
    private String respiracion;
    private String pulso;
    private String estadoMental;
    private String conciencia;
    private String dificultadRespiratoria;
    private String lesionesGraves;
    private String edad;
    private String fiebre;
    private String vomitos;
    private String dolorAbdominal;
    private String signosDeShock;
    private String lesionesLeves;
    private String sangrado;
    private Date fecha;
    private Date hora;
    private String encargadoTriage;
    private NivelTriage colorModificado;
    private String motivoModificacion;
}
