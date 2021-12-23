/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pws.c.pws.c9;

import com.pws.c.pws.c9.exceptions.NonexistentEntityException;
import com.pws.c.pws.c9.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Rafif Fuaddoshofha
 */
public class DatamaahasiswaJpaController implements Serializable {

    public DatamaahasiswaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.pws.c_pws.c.20190140129_jar_0.0.1-SNAPSHOTPU");

    public DatamaahasiswaJpaController() {
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Datamaahasiswa datamaahasiswa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(datamaahasiswa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDatamaahasiswa(datamaahasiswa.getNim()) != null) {
                throw new PreexistingEntityException("Datamaahasiswa " + datamaahasiswa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Datamaahasiswa datamaahasiswa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            datamaahasiswa = em.merge(datamaahasiswa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = datamaahasiswa.getNim();
                if (findDatamaahasiswa(id) == null) {
                    throw new NonexistentEntityException("The datamaahasiswa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Datamaahasiswa datamaahasiswa;
            try {
                datamaahasiswa = em.getReference(Datamaahasiswa.class, id);
                datamaahasiswa.getNim();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datamaahasiswa with id " + id + " no longer exists.", enfe);
            }
            em.remove(datamaahasiswa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Datamaahasiswa> findDatamaahasiswaEntities() {
        return findDatamaahasiswaEntities(true, -1, -1);
    }

    public List<Datamaahasiswa> findDatamaahasiswaEntities(int maxResults, int firstResult) {
        return findDatamaahasiswaEntities(false, maxResults, firstResult);
    }

    private List<Datamaahasiswa> findDatamaahasiswaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Datamaahasiswa.class));
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

    public Datamaahasiswa findDatamaahasiswa(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Datamaahasiswa.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatamaahasiswaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Datamaahasiswa> rt = cq.from(Datamaahasiswa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
