package repository;

import domain_model.ChiTietSPDomain;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class ChiTietSPRepository {
    private Session hsession;
   public ChiTietSPRepository() {
       this.hsession= HibernateUtil.getFACTORY().openSession();
   }
   public  void insert(ChiTietSPDomain sp){
       Transaction transaction = this.hsession.getTransaction();
       try{
           transaction.begin();
           this.hsession.persist(sp);
           transaction.commit();
       }catch (Exception e){
           e.printStackTrace();
           transaction.rollback();
       }
   }

   public void update(ChiTietSPDomain sp){
       Transaction transaction = this.hsession.getTransaction();
       try{
           transaction.begin();
           this.hsession.merge(sp);
           transaction.commit();
       }catch (Exception e){
           e.printStackTrace();
           transaction.rollback();
       }
   }
    public void delete(ChiTietSPDomain sp){
        Transaction transaction = this.hsession.getTransaction();
        try{
            transaction.begin();
            this.hsession.delete(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public List<ChiTietSPDomain> findAll(){
        String hql="SELECT obj FROM ChiTietSPDomain obj";
        TypedQuery<ChiTietSPDomain> query = this.hsession.createQuery(hql,ChiTietSPDomain.class);
        return query.getResultList();    }
    public ChiTietSPDomain findByMa(String ma){
        String hql =" SELECT obj FROM ChiTietSPDomain obj where obj.Ma=?1";
        TypedQuery<ChiTietSPDomain> query=this.hsession.createQuery(hql,ChiTietSPDomain.class);
        query.setParameter(1,ma);
        return  query.getSingleResult();
    }
}
