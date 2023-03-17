package viewmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLNhanVien {
    private String ma;
    private String ho;
    private String ten_dem;
    private String ten;
    private String gioi_tinh;
    private String ngay_sinh;
    private String dia_chi;
    private String sdt;
    private String mat_khau;
    private String IdCH;
    private String IdCV;
    private String IdGuiBC;

}
