/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas.pruebataller.persistence;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sistemas.pruebataller.model.Triage;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sistemas.pruebataller.model.Medico;
import sistemas.pruebataller.persistence.exceptions.NonexistentEntityException;
import sistemas.pruebataller.persistence.exceptions.PreexistingEntityException;

/**
 *
 * @author Deian
 */
public class MedicoJpaController implements Serializable {

    public MedicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public MedicoJpaController() {
        emf = Persistence.createEntityManagerFactory("pruebaTallerPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medico medico) throws PreexistingEntityException, Exception {
        if (medico.getTriage() == null) {
            medico.setTriage(new ArrayList<Triage>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Triage> attachedTriage = new ArrayList<Triage>();
            for (Triage triageTriageToAttach : medico.getTriage()) {
                triageTriageToAttach = em.getReference(triageTriageToAttach.getClass(), triageTriageToAttach.getId());
                attachedTriage.add(triageTriageToAttach);
            }
            medico.setTriage(attachedTriage);
            em.persist(medico);
            for (Triage triageTriage : medico.getTriage()) {
                Medico oldMedicoDniOfTriageTriage = triageTriage.getMedico();
                triageTriage.setMedico(medico);
                triageTriage = em.merge(triageTriage);
                if (oldMedicoDniOfTriageTriage != null) {
                    oldMedicoDniOfTriageTriage.getTriage().remove(triageTriage);
                    oldMedicoDniOfTriageTriage = em.merge(oldMedicoDniOfTriageTriage);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMedico(medico.getDni()) != null) {
                throw new PreexistingEntityException("Medico " + medico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medico medico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico persistentMedico = em.find(Medico.class, medico.getDni());
            ArrayList<Triage> triageOld = persistentMedico.getTriage();
            ArrayList<Triage> triageNew = medico.getTriage();
            ArrayList<Triage> attachedTriageNew = new ArrayList<Triage>();
            for (Triage triageNewTriageToAttach : triageNew) {
                triageNewTriageToAttach = em.getReference(triageNewTriageToAttach.getClass(), triageNewTriageToAttach.getId());
                attachedTriageNew.add(triageNewTriageToAttach);
            }
            triageNew = attachedTriageNew;
            medico.setTriage(triageNew);
            medico = em.merge(medico);
            for (Triage triageOldTriage : triageOld) {
                if (!triageNew.contains(triageOldTriage)) {
                    triageOldTriage.setMedico(null);
                    triageOldTriage = em.merge(triageOldTriage);
                }
            }
            for (Triage triageNewTriage : triageNew) {
                if (!triageOld.contains(triageNewTriage)) {
                    Medico oldMedicoDniOfTriageNewTriage = triageNewTriage.getMedico();
                    triageNewTriage.setMedico(medico);
                    triageNewTriage = em.merge(triageNewTriage);
                    if (oldMedicoDniOfTriageNewTriage != null && !oldMedicoDniOfTriageNewTriage.equals(medico)) {
                        oldMedicoDniOfTriageNewTriage.getTriage().remove(triageNewTriage);
                        oldMedicoDniOfTriageNewTriage = em.merge(oldMedicoDniOfTriageNewTriage);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = medico.getDni();
                if (findMedico(id) == null) {
                    throw new NonexistentEntityException("The medico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico medico;
            try {
                medico = em.getReference(Medico.class, id);
                medico.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medico with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Triage> triage = medico.getTriage();
            for (Triage triageTriage : triage) {
                triageTriage.setMedico(null);
                triageTriage = em.merge(triageTriage);
            }
            em.remove(medico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medico> findMedicoEntities() {
        return findMedicoEntities(true, -1, -1);
    }

    public List<Medico> findMedicoEntities(int maxResults, int firstResult) {
        return findMedicoEntities(false, maxResults, firstResult);
    }

    private List<Medico> findMedicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medico.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Medico findMedico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medico.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medico> rt = cq.from(Medico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
