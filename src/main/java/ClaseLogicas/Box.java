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
public class Box {
    private Date fecha;
    private Date hora;
    private int numero;
    private boolean ocupado;
}
