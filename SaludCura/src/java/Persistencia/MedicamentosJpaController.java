/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Medicamentos;

/**
 *
 * @author DELL
 */
public class MedicamentosJpaController implements Serializable {

    public MedicamentosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public MedicamentosJpaController () {
    
        emf = Persistence.createEntityManagerFactory("SaludCuraPU");
        
    }

    public void create(Medicamentos medicamentos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(medicamentos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medicamentos medicamentos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            medicamentos = em.merge(medicamentos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = medicamentos.getIdMedicamento();
                if (findMedicamentos(id) == null) {
                    throw new NonexistentEntityException("The medicamentos with id " + id + " no longer exists.");
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
            Medicamentos medicamentos;
            try {
                medicamentos = em.getReference(Medicamentos.class, id);
                medicamentos.getIdMedicamento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medicamentos with id " + id + " no longer exists.", enfe);
            }
            em.remove(medicamentos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medicamentos> findMedicamentosEntities() {
        return findMedicamentosEntities(true, -1, -1);
    }

    public List<Medicamentos> findMedicamentosEntities(int maxResults, int firstResult) {
        return findMedicamentosEntities(false, maxResults, firstResult);
    }

    private List<Medicamentos> findMedicamentosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medicamentos.class));
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

    public Medicamentos findMedicamentos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medicamentos.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicamentosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medicamentos> rt = cq.from(Medicamentos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
