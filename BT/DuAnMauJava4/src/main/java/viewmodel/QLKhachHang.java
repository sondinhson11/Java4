package viewmodel;


public class QLKhachHang {
    private String Ma;
    private String Ho;
    private String TenDem;
    private String Ten;
    private String DiaChi;
    private String Sdt;
    private String MatKhau;
    private String ThanhPho;
    private String QuocGia;
    private String NgaySinh;

    public QLKhachHang() {
    }

    public QLKhachHang(String ma, String ho, String tenDem, String ten, String diaChi, String sdt, String matKhau, String thanhPho, String quocGia, String ngaySinh) {
        Ma = ma;
        Ho = ho;
        TenDem = tenDem;
        Ten = ten;
        DiaChi = diaChi;
        Sdt = sdt;
        MatKhau = matKhau;
        ThanhPho = thanhPho;
        QuocGia = quocGia;
        NgaySinh = ngaySinh;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        Ho = ho;
    }

    public String getTenDem() {
        return TenDem;
    }

    public void setTenDem(String tenDem) {
        TenDem = tenDem;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(String thanhPho) {
        ThanhPho = thanhPho;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String quocGia) {
        QuocGia = quocGia;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }
}
