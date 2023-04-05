package repositories;


import DomainModel.SanPham;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;


public class SanPhamRepository {

    private Session hSession ;
    public SanPhamRepository(){

        this.hSession = HibernateUtil.getFACTORY().openSession();

    }
    public void insert(SanPham sp){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(sp);
            this.hSession.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void update(SanPham sp) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(sp);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete (SanPham sp) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(sp);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public SanPham findById(UUID id) {
        return this.hSession.find(SanPham.class,id);
    }
    public SanPham findByMa(String ma){
        String hql ="SELECT spObj FROM SanPham spObj where spObj.Ma = ?1";
        TypedQuery<SanPham> query =
                this.hSession.createQuery(hql,SanPham.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
    public List<SanPham> findALL(){
        String hql ="SELECT spObj FROM SanPham spObj order by spObj.Ma asc";
        TypedQuery<SanPham> query =
                this.hSession.createQuery(hql,SanPham.class);

        return query.getResultList();
    }

}
