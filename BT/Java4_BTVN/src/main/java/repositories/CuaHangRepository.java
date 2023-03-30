package repositories;

import DomainModel.CuaHang;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    private Session hSession;

    public  CuaHangRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(CuaHang ch)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(ch);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(CuaHang ch)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(ch);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(CuaHang ch)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(ch);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public CuaHang findById(UUID id){
        return this.hSession.find(CuaHang.class , id);
    }
    public CuaHang findByMa(String ma){
        String hql = "SELECT chObj FROM CuaHang chObj WHERE chObj.Ma = ?1";
        TypedQuery<CuaHang> query =
                this.hSession.createQuery(hql, CuaHang.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
    public List<CuaHang> findALL() {
        String hql = "SELECT chObj FROM CuaHang chObj ORDER by chObj.Ma asc";
        TypedQuery<CuaHang> query =
                this.hSession.createQuery(hql, CuaHang.class);
        return query.getResultList();

    }


}
