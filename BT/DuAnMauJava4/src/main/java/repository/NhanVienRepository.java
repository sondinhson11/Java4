package repository;


import domain_model.NhanVienDomain;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import java.util.List;

public class NhanVienRepository {
    private Session hsession;


    public NhanVienRepository() {
        this.hsession = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(NhanVienDomain qlms) {
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

    public void update(NhanVienDomain qlms) {
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

    public void delete(NhanVienDomain qlms) {
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

    public List<NhanVienDomain> findAll() {
        String hql = "SELECT obj FROM NhanVienDomain obj";
        TypedQuery<NhanVienDomain> query = this.hsession.createQuery(hql, NhanVienDomain.class);
        return query.getResultList();
    }

    public NhanVienDomain findByMa(String ma) {
        String hql = "SELECT obj FROM NhanVienDomain obj where obj.Ma=?1";
        TypedQuery<NhanVienDomain> query = this.hsession.createQuery(hql, NhanVienDomain.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }

}
