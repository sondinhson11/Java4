package repostory;

import Utils.Hibernate;
import domain_model.MauSacDomain;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view_model.QLChucVu;
import view_model.QLMauSac;

import java.util.ArrayList;
import java.util.List;

public class mausacrepostory {
    private Session hsession;
    public mausacrepostory(){
        this.hsession= Hibernate.getFACTORY().openSession();
    }
    public  void insert(MauSacDomain qlms){
        Transaction transaction = this.hsession.getTransaction();
        try{
            transaction.begin();
            this.hsession.persist(qlms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(MauSacDomain qlms){
        Transaction transaction = this.hsession.getTransaction();
        try{
            transaction.begin();
            this.hsession.merge(qlms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(MauSacDomain qlms){
        Transaction transaction = this.hsession.getTransaction();
        try{
            transaction.begin();
            this.hsession.delete(qlms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public List<MauSacDomain> findAll(){
        String hql="SELECT obj FROM MauSacDomain obj";
        TypedQuery<MauSacDomain> query = this.hsession.createQuery(hql,MauSacDomain.class);
        return query.getResultList();
    }
    public MauSacDomain findByMa(String ma){
        String hql = "SELECT obj FROM MauSacDomain obj where obj.Ma=?1";
        TypedQuery<MauSacDomain> query=this.hsession.createQuery(hql,MauSacDomain.class);
        query.setParameter(1,ma);
        return  query.getSingleResult();
        }
    }

