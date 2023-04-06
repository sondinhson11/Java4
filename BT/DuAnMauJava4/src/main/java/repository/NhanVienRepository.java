package repository;


import domain_model.NhanVienDomain;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import java.util.List;

public class NhanVienRepository {
    private Session hss;

    public NhanVienRepository() {

        this.hss = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(NhanVienDomain nv){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.persist(nv);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void update(NhanVienDomain nv){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.merge(nv);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void delete(NhanVienDomain nv){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.delete(nv);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public NhanVienDomain findById(String id){
        return this.hss.find(NhanVienDomain.class,id);

    }
    public NhanVienDomain login(String ma, String matKhau)
    {
        String hql = "SELECT nv FROM NhanVienDomain nv WHERE nv.ma = ?1 AND nv.matKhau = ?2" ;
        TypedQuery<NhanVienDomain> query = this.hss.createQuery(hql, NhanVienDomain.class);
        query.setParameter(1, ma);
        query.setParameter(2, matKhau);
        try {
            NhanVienDomain nv = query.getSingleResult();
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<NhanVienDomain> findAll(){
        String hql = "SELECT obj FROM NhanVienDomain obj  ORDER BY obj.ma asc ";
        TypedQuery<NhanVienDomain> query = this.hss.createQuery(hql,NhanVienDomain.class);
        List<NhanVienDomain> list = query.getResultList();
        return list;
    }
    public NhanVienDomain findByMa(String ma){
        String hql = "SELECT obj FROM NhanVienDomain obj WHERE obj.ma = ?1";
        TypedQuery<NhanVienDomain> query = this.hss.createQuery(hql,NhanVienDomain.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
