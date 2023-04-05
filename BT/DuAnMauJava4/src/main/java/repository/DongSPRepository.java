package repository;

import domain_model.ChucVuDomain;
import domain_model.DongSPDomain;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import java.util.List;
import java.util.UUID;

public class DongSPRepository {
    private Session hsession;

    public DongSPRepository() {
        this.hsession= HibernateUtil.getFACTORY().openSession();
    }

    public void insert(DongSPDomain qlnsx) {
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

    public void update(DongSPDomain qlnsx) {
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

    public void delete(DongSPDomain qlnsx) {
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
    public DongSPDomain findById(UUID id) {
        return this.hsession.find(DongSPDomain.class,id);
    }

    public List<DongSPDomain> findAll(){
        String hql="SELECT obj FROM DongSPDomain obj";
        TypedQuery<DongSPDomain> query = this.hsession.createQuery(hql,DongSPDomain.class);
        return query.getResultList();    }
    public DongSPDomain findByMa(String ma){
        String hql =" SELECT obj FROM DongSPDomain obj where obj.Ma=?1";
        TypedQuery<DongSPDomain> query=this.hsession.createQuery(hql,DongSPDomain.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
