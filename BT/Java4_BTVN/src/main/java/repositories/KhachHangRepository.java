package repositories;

import DomainModel.KhachHang;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;


public class KhachHangRepository {
    private Session hSession;

    public KhachHangRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(KhachHang kh)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(kh);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(KhachHang kh)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(kh);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(KhachHang kh)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(kh);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public KhachHang findById(UUID id){
        return this.hSession.find(KhachHang.class , id);
    }
    public KhachHang findByMa(String ma){
        String hql = "SELECT khObj FROM KhachHang khObj WHERE khObj.Ma = ?1";
        TypedQuery<KhachHang> query =
                this.hSession.createQuery(hql, KhachHang.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
   public List<KhachHang> findALL(){
       String hql = "SELECT khObj FROM KhachHang khObj ORDER by khObj.Ma asc";
       TypedQuery<KhachHang> query =
               this.hSession.createQuery(hql, KhachHang.class);
       return query.getResultList();
   }




}
