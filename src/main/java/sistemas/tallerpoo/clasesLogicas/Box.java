package sistemas.tallerpoo.clasesLogicas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Box {
    private Date fecha;
    private Date hora;
    private int numero;
    private boolean ocupado;
}
