package repository;

import domain_model.MauSacDomain;
import domain_model.SanPhamDomain;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {
    private Session hsession;


    public SanPhamRepository() {
        this.hsession= HibernateUtil.getFACTORY().openSession();
    }

    public void insert(SanPhamDomain qlnsx) {
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

    public void update(SanPhamDomain qlnsx) {
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

    public void delete(SanPhamDomain qlnsx) {
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
    public SanPhamDomain findById(UUID id) {
        return this.hsession.find(SanPhamDomain.class,id);
    }
    public List<SanPhamDomain> findAll(){
        String hql="SELECT obj FROM SanPhamDomain obj ORDER BY obj.Ma asc ";
        TypedQuery<SanPhamDomain> query = this.hsession.createQuery(hql,SanPhamDomain.class);
        return query.getResultList();    }
    public SanPhamDomain findByMa(String ma){
        String hql =" SELECT obj FROM SanPhamDomain obj where obj.Ma=?1";
        TypedQuery<SanPhamDomain> query=this.hsession.createQuery(hql,SanPhamDomain.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
