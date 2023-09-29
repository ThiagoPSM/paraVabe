/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas.pruebataller.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sistemas.pruebataller.model.Triage;
import sistemas.pruebataller.persistence.exceptions.NonexistentEntityException;

/**
 *
 * @author Deian
 */
public class TriageJpaController implements Serializable {

    public TriageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public TriageJpaController() {
        emf = Persistence.createEntityManagerFactory("pruebaTallerPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Triage triage) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(triage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Triage triage) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            triage = em.merge(triage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = triage.getId();
                if (findTriage(id) == null) {
                    throw new NonexistentEntityException("The triage with id " + id + " no longer exists.");
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
            Triage triage;
            try {
                triage = em.getReference(Triage.class, id);
                triage.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The triage with id " + id + " no longer exists.", enfe);
            }
            em.remove(triage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Triage> findTriageEntities() {
        return findTriageEntities(true, -1, -1);
    }

    public List<Triage> findTriageEntities(int maxResults, int firstResult) {
        return findTriageEntities(false, maxResults, firstResult);
    }

    private List<Triage> findTriageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Triage.class));
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

    public Triage findTriage(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Triage.class, id);
        } finally {
            em.close();
        }
    }

    public int getTriageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Triage> rt = cq.from(Triage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
