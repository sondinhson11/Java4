package repositories;

import DomainModel.NhanVien;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    private Session hSession;
    public NhanVienRepository(){
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }
   public void insert(NhanVien nv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(nv);
            this.hSession.getTransaction().commit();
        }catch (Exception  e){
       e.printStackTrace();
       this.hSession.getTransaction().rollback();
   }
}
    public void update(NhanVien nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete (NhanVien nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public NhanVien findById(UUID id) {
        return this.hSession.find(NhanVien.class,id);
    }
    public NhanVien findByMa(String ma){
        String hql ="SELECT nvObj FROM NhanVien nvObj where nvObj.Ma = ?1";
        TypedQuery<NhanVien> query =
                this.hSession.createQuery(hql,NhanVien.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
    public List<NhanVien> findALL(){
        String hql ="SELECT nvObj FROM NhanVien nvObj order by nvObj.Ma asc";
        TypedQuery<NhanVien> query =
                this.hSession.createQuery(hql,NhanVien.class);
        return query.getResultList();
    }

   }



