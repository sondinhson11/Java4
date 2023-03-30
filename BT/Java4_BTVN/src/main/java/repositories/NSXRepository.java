package repositories;


import DomainModel.NSX;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class NSXRepository {
    private Session hSession ;
    public NSXRepository(){

        this.hSession = HibernateUtil.getFACTORY().openSession();

    }
    public void insert(NSX nsx){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(nsx);
            this.hSession.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void update(NSX nsx) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(nsx);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete (NSX nsx) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(nsx);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public NSX findById(UUID id) {
      return this.hSession.find(NSX.class,id);
    }
    public NSX findByMa(String ma){
        String hql ="SELECT nsxObj FROM NSX nsxObj where nsxObj.Ma = ?1";
        TypedQuery<NSX> query =
                this.hSession.createQuery(hql,NSX.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
    public List<NSX> findALL(){
        String hql ="SELECT nsxObj FROM NSX nsxObj order by nsxObj.Ma asc";
        TypedQuery<NSX> query =
                this.hSession.createQuery(hql,NSX.class);

        return query.getResultList();
    }

}
