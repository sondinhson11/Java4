package repository;

import domain_model.KhachHangDomain;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import viewmodel.QLKhachHang;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    private Session hSession;

    public KhachHangRepository() {
        this.hSession= HibernateUtil.getFACTORY().openSession();
    }

    public  void insert(KhachHangDomain kh){
        Transaction transaction=this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.persist(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(KhachHangDomain kh){
        Transaction transaction=this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.merge(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();;
        }
    }
    public void delete(KhachHangDomain kh){
        Transaction transaction=this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.delete(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();;
        }
    }
    public List<KhachHangDomain> findAll(){
        String hql = "SELECT obj FROM KhachHangDomain obj ORDER BY obj.Ma asc ";
        TypedQuery<KhachHangDomain> query = this.hSession.createQuery(hql, KhachHangDomain.class);
        return query.getResultList();
    }
    public KhachHangDomain findByMa(String ma){
        String hql = "SELECT obj FROM KhachHangDomain obj where obj.Ma=?1";
        TypedQuery<KhachHangDomain> query = this.hSession.createQuery(hql, KhachHangDomain.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

}
