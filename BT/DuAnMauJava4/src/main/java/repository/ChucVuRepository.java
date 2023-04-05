package repository;

import domain_model.ChucVuDomain;
import domain_model.NSXDomain;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    private Session hsession;

    public ChucVuRepository() {
        this.hsession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(ChucVuDomain cv) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.persist(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChucVuDomain cv) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.merge(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChucVuDomain cv) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.delete(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ChucVuDomain findById(UUID id) {
        return this.hsession.find(ChucVuDomain.class, id);
    }

    public List<ChucVuDomain> findAll() {
        String hql = "SELECT obj FROM ChucVuDomain obj";
        TypedQuery<ChucVuDomain> query = this.hsession.createQuery(hql, ChucVuDomain.class);
        return query.getResultList();
    }

    public ChucVuDomain findByMa(String ma) {
        String hql = " SELECT obj FROM ChucVuDomain obj where obj.Ma=?1";
        TypedQuery<ChucVuDomain> query = this.hsession.createQuery(hql, ChucVuDomain.class);
        query.setParameter(1, ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

}
