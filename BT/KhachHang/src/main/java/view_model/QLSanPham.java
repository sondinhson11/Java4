package view_model;

public class QLSanPham {
//    private Integer id ;
    private String ma;
    private String ten;

    public QLSanPham() {
    }

    public QLSanPham(String ma, String ten) {
//        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
