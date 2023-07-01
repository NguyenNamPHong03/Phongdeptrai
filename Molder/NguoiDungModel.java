/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Molder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;

/**
 *
 * @author AD
 */
public class NguoiDungModel extends BaseModel {

    @Override
    public String toString() {
        return "NguoiDungModel{" + "maNguoiDung=" + maNguoiDung + ", hoTen=" + hoTen + ", email=" + email + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", canCuocCongDan=" + canCuocCongDan + ", soDienThoai=" + soDienThoai + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", vaiTro=" + vaiTro + ", trangThaiTaiKhoan=" + trangThaiTaiKhoan + ", maHopDong=" + maHopDong + '}';
    }

    private String maNguoiDung;
    private String hoTen;
    private String email;
    private String diaChi;
    private Boolean gioiTinh;
    private String canCuocCongDan;
    private String soDienThoai;
    private String taiKhoan;
    private String matKhau;
    private String vaiTro;
    private Boolean trangThaiTaiKhoan;
    private String maHopDong;

    public NguoiDungModel(String maNguoiDung, String hoTen, String email, String diaChi, Boolean gioiTinh, String canCuocCongDan, String soDienThoai, String taiKhoan, String matKhau, String vaiTro, Boolean trangThaiTaiKhoan, String maHopDong) {
        this.maNguoiDung = maNguoiDung;
        this.hoTen = hoTen;
        this.email = email;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.canCuocCongDan = canCuocCongDan;
        this.soDienThoai = soDienThoai;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
        this.maHopDong = maHopDong;
    }

    public NguoiDungModel(String hoTen, String taiKhoan, String matKhau) {
        this.hoTen = hoTen;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public NguoiDungModel(String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public NguoiDungModel(String hoTen, String email, String diaChi, String canCuocCongDan, String soDienThoai) {
        this.hoTen = hoTen;
        this.email = email;
        this.diaChi = diaChi;
        this.canCuocCongDan = canCuocCongDan;
        this.soDienThoai = soDienThoai;
    }

    public NguoiDungModel() {
        this.maNguoiDung = null;
        this.hoTen = null;
        this.email = null;
        this.diaChi = null;
        this.gioiTinh = null;
        this.canCuocCongDan = null;
        this.soDienThoai = null;
        this.taiKhoan = null;
        this.matKhau = null;
        this.vaiTro = null;
        this.trangThaiTaiKhoan = null;
        this.maHopDong = null;
    }

//    public ArrayList<NguoiDungModel> getNguoiDung(){
//        ArrayList<NguoiDungModel> arr = new ArrayList<>();
//        try (Connection conn = this.getConnBaseModel();) {
//            String sql = "select*from NguoiDung";
//            PreparedStatement st = conn.prepareStatement(sql);
//            ResultSet rs = st.executeQuery(sql);
//            arr.clear();
//            while (rs.next()) {
//                NguoiDungModel nd = new NguoiDungModel();
//                nd.setMaNguoiDung(rs.getString(1));
//                nd.setHoTen(rs.getString(2));
//                nd.setEmail(rs.getString(3));
//                nd.setDiaChi(rs.getString(4));
//                nd.setGioiTinh(rs.getBoolean(5));
//                nd.setCanCuocCongDan(rs.getString(6));
//                nd.setSoDienThoai(rs.getString(7));
//                nd.setTrangThaiTaiKhoan(rs.getBoolean(11));
//                //String s = rs.getString(2);
//                //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                //Date d = formatter.parse(s);
//                //nd.setNgaySinh(d);
//                nd.setTaiKhoan(rs.getString(8));
//                nd.setMatKhau(rs.getString(9));
//                nd.setVaiTro(rs.getString(10));
//                nd.setMaHopDong(rs.getString(12));
//                arr.add(nd);
//            }
//            return arr;
//        }catch (Exception ex) {
//            System.out.println("huhu");
//        }
//        return arr;
//    }
    public NguoiDungModel checkLogin(String taiKhoan, String matKhau) {
        NguoiDungModel nd = new NguoiDungModel();
        String sql = "";
        try (Connection conn = this.getConnBaseModel()) {
            sql = "select * from NguoiDung where TaiKhoan = ? and MatKhau = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, taiKhoan);

            statement.setString(2, matKhau);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                nd.setMaNguoiDung(rs.getString(1));
                nd.setHoTen(rs.getString(2));
                nd.setEmail(rs.getString(3));
                nd.setDiaChi(rs.getString(4));
                nd.setGioiTinh(rs.getBoolean(5));
                nd.setCanCuocCongDan(rs.getString(6));
                nd.setSoDienThoai(rs.getString(7));
                nd.setTrangThaiTaiKhoan(rs.getBoolean(11));
                //String s = rs.getString(2);
                //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                //Date d = formatter.parse(s);
                //nd.setNgaySinh(d);
                nd.setTaiKhoan(rs.getString(8));
                nd.setMatKhau(rs.getString(9));
                nd.setVaiTro(rs.getString(10));
                nd.setMaHopDong(rs.getString(12));
                return nd;
            }
        } catch (Exception e) {
            System.out.println(sql);
            System.out.println("Lỗi lấy model!");
        }
        return nd;
    }

    public boolean checDangKyModel(NguoiDungModel dk) {
        String sql = "";
        try (Connection conn = this.getConnBaseModel()) {
            sql = "insert into NguoiDung (HoTen,TaiKhoan,MatKhau) values(?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, dk.getHoTen());
            st.setString(2, dk.getTaiKhoan());
            st.setString(3, dk.getMatKhau());
            st.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println(sql);

        }
        return false;
    }

    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
    }

    public void setCanCuocCongDan(String canCuocCongDan) {
        this.canCuocCongDan = canCuocCongDan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Boolean getTrangThaiTaiKhoan() {
        return trangThaiTaiKhoan;
    }

    public void setTrangThaiTaiKhoan(Boolean trangThaiTaiKhoan) {
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
    }
}
//    public String getHoTen() {
//        return hoTen;
//    }
//
//    public void setHoTen(String hoTen) {
//        this.hoTen = hoTen;
//    }
//
//   // public Date getNgaySinh() {
//     //   return ngaySinh;
//    //}
//
//    //public void setNgaySinh(Date ngaySinh) {
//      //  this.ngaySinh = ngaySinh;
//    //}
//
//    public String getTaiKhoan() {
//        return taiKhoan;
//    }
//
//    public void setTaiKhoan(String taiKhoan) {
//        this.taiKhoan = taiKhoan;
//    }
//
//    public String getMatKhau() {
//        return matKhau;
//    }
//
//    public void setMatKhau(String matKhau) {
//        this.matKhau = matKhau;
//    }
//
//}
