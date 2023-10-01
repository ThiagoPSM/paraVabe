package sistemas.pruebataller.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sistemas.pruebataller.model.Medico;
import sistemas.pruebataller.model.NivelTriage;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-09-29T16:19:46", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Triage.class)
public class Triage_ { 

    public static volatile SingularAttribute<Triage, Integer> pulso;
    public static volatile SingularAttribute<Triage, Integer> respiracion;
    public static volatile SingularAttribute<Triage, NivelTriage> color;
    public static volatile SingularAttribute<Triage, Medico> medico;
    public static volatile SingularAttribute<Triage, Integer> id;

}