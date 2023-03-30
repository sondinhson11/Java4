package repostory;

import Utils.Hibernate;
import domain_model.MauSacDomain;
import domain_model.NSXDomain;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view_model.QLMauSac;
import view_model.QLNSX;

import java.util.ArrayList;
import java.util.List;

public class nsxrepostory {
    private Session hsession;
    public nsxrepostory(){
        this.hsession= Hibernate.getFACTORY().openSession();
    }
    public  void insert(NSXDomain qlnsx){
        Transaction transaction = this.hsession.getTransaction();
        try{
            transaction.begin();
            this.hsession.persist(qlnsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(NSXDomain qlnsx){
        Transaction transaction = this.hsession.getTransaction();
        try{
            transaction.begin();
            this.hsession.merge(qlnsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(NSXDomain qlnsx){
        Transaction transaction = this.hsession.getTransaction();
        try{
            transaction.begin();
            this.hsession.delete(qlnsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public List<NSXDomain> findAll(){
        String hql="SELECT obj FROM NSXDomain obj";
        TypedQuery<NSXDomain> query = this.hsession.createQuery(hql,NSXDomain.class);
        return query.getResultList();    }
    public NSXDomain findByMa(String ma){
        String hql = "SELECT obj FROM NSXDomain obj where obj.Ma=?1";
        TypedQuery<NSXDomain> query=this.hsession.createQuery(hql,NSXDomain.class);
        query.setParameter(1,ma);
        return  query.getSingleResult();
    }
}

