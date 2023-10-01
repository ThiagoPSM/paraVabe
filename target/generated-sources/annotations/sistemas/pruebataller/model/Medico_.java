package sistemas.pruebataller.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sistemas.pruebataller.model.Triage;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-09-29T16:19:46", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Medico.class)
public class Medico_ extends Persona_ {

    public static volatile SingularAttribute<Medico, Integer> matricula;
    public static volatile SingularAttribute<Medico, String> especialidad;
    public static volatile ListAttribute<Medico, Triage> triage;

}