package repositories;

import DomainModel.DongSP;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;


public class DongSpRepository {
    private Session hSession;
    public DongSpRepository(){
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(DongSP dongSP){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(dongSP);
            this.hSession.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void update(DongSP dongSP){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(dongSP);
            this.hSession.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete(DongSP dongSP){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(dongSP);
            this.hSession.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public DongSP findByID(UUID id){
        return this.hSession.find(DongSP.class,id);
    }
    public DongSP findByMa(String ma){
        String hql ="SELECT dspObj FROM DongSP dspObj where  dspObj.Ma=?1";
        TypedQuery<DongSP> query =
                this.hSession.createQuery(hql,DongSP.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
    public List<DongSP> findALL(){
        String hql = "SELECT dspObj FROM DongSP dspObj order by dspObj.Ma asc";
        TypedQuery<DongSP> query =
                this.hSession.createQuery(hql,DongSP.class);
        return query.getResultList();
    }
}
