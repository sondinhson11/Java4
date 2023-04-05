package repository;

import domain_model.DongSPDomain;
import domain_model.MauSacDomain;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class MauSacRepository {
    private Session hsession;

    public MauSacRepository() {
        this.hsession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(MauSacDomain qlms) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.persist(qlms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(MauSacDomain qlms) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.merge(qlms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(MauSacDomain qlms) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.delete(qlms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public MauSacDomain findById(UUID id) {
        return this.hsession.find(MauSacDomain.class,id);
    }
    public List<MauSacDomain> findAll(){
        String hql="SELECT obj FROM MauSacDomain obj";
        TypedQuery<MauSacDomain> query = this.hsession.createQuery(hql,MauSacDomain.class);
        return query.getResultList();    }
    public MauSacDomain findByMa(String ma){
        String hql =" SELECT obj FROM MauSacDomain obj where obj.Ma=?1";
        TypedQuery<MauSacDomain> query=this.hsession.createQuery(hql,MauSacDomain.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

}
