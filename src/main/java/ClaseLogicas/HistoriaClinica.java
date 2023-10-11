package ClaseLogicas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaClinica {
    private Date fecha;
    private Date hora;
    private String diagnostico;
    private String lugar;
    private String diagnosticoClinico;   
}
