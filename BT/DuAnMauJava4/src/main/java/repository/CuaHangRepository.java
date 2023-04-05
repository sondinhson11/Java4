package repository;

import domain_model.ChucVuDomain;
import domain_model.CuaHangDomain;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    private Session hsession;


    public CuaHangRepository() {
        this.hsession= HibernateUtil.getFACTORY().openSession();
    }

    public void insert(CuaHangDomain qlnsx) {
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

    public void update(CuaHangDomain qlnsx) {
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

    public void delete(CuaHangDomain qlnsx) {
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
    public CuaHangDomain findById(UUID id) {
        return this.hsession.find(CuaHangDomain.class,id);
    }

    public List<CuaHangDomain> findAll(){
        String hql="SELECT obj FROM CuaHangDomain obj";
        TypedQuery<CuaHangDomain> query = this.hsession.createQuery(hql,CuaHangDomain.class);
        return query.getResultList();    }
    public CuaHangDomain findByMa(String ma){
        String hql =" SELECT obj FROM CuaHangDomain obj where obj.Ma=?1";
        TypedQuery<CuaHangDomain> query=this.hsession.createQuery(hql,CuaHangDomain.class);
        query.setParameter(1,ma);
        return  query.getSingleResult();
    }
}
