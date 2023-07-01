/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Molder.NguoiDungModel;
import View.DangKyView;
import View.DangNhapView;
import View.ManHinhChinh;
import View.ManHinhNC;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author AD
 */
public class NguoiDungController {

    private static DangKyView dkview;
    private static DangNhapView dnview;
    public static NguoiDungModel ndOn;

    public NguoiDungController(DangKyView view) {
        NguoiDungController.dkview = view;
    }

    public NguoiDungController(DangNhapView view) {
        NguoiDungController.dnview = view;
    }

    public NguoiDungController(NguoiDungModel view) {

        NguoiDungController.ndOn = view;
    }
// dang nhap 

    public void doLogin() {
        NguoiDungModel nd = dnview.LayDangNhap();
        if (nd.getTaiKhoan().equals("") || nd.getMatKhau().equals("")) {
            dnview.Thongbao("Vui long nhap day du\n");
        } else {
            NguoiDungModel ndc = new NguoiDungModel().checkLogin(nd.getTaiKhoan(), nd.getMatKhau());
            
            if ("Quan ly".equals(ndc.getVaiTro())) {
                ndOn = ndc;
                dnview.Thongbao1("Đăng nhập thành công");
                ManHinhChinh mhc = new ManHinhChinh();
                mhc.setVisible(true);
                dnview.dispose();
            } else if ("Nhan Cong".equals(ndc.getVaiTro())) {
                ndOn = ndc;
                dnview.Thongbao1("Đăng nhập thành công");
                ManHinhNC mhc = new ManHinhNC();
                mhc.setVisible(true);
                dnview.dispose();
            } else {
                dnview.Thongbao("Đăng nhập thất bại");
            }
        }
    }
    // dang ky
//    ^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$
//    ^([a-zA-Z0-9._%-]+@nhom7\.[vn]{2,4})*$
    public String regexTaiKhoan = "^([a-zA-Z0-9._%-]+@nhom7\\.[vn]{2,4})*$";

    public boolean Regex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public void add() {
        NguoiDungModel nd = dkview.checkDangKy();
        if (nd.getTaiKhoan().equals("") || nd.getHoTen().equals("") || nd.getMatKhau().equals("")) {
            dkview.Thongbao("Vui lòng nhập đầy đủ thông tin");
        } else if (!Regex(nd.getTaiKhoan(), regexTaiKhoan)) {
            dkview.Thongbao("Sai định dạng @nhom7.vn");
        } else if (nd.getMatKhau().length() < 6) {
            dkview.Thongbao("Mật khẩu đủ 6 ký tự");
        } else {
            boolean dkm = new NguoiDungModel().checDangKyModel(nd);
            if (dkm == true) {
                dkview.Thongbao("Tạo thành công tài khoản\n Vui lòng đợi quản lý duyệt !");
            } else {
                dkview.Thongbao("bai bai");
            }
        }

    }
}

//        String thongbao = "";
//        if (txt.getText().equals("")) {
//            thongbao += "Vui long nhap taiKhoan \n";
//        }
//        else if (txtTen.getText().equals("")) {
//            thongbao += "Vui long nhap Ten \n";
//        }
//        else if (String.valueOf(txtpw1.getPassword()).equals("")) {
//            thongbao +=" Mat Khau";
//        }
//   
//        else{
//        DangKyModel dk = new DangKyModel(txtTen.getText(), txtTaiKhoan.getText(), new String(txtpw1.getPassword()));
//        boolean dkmd = new DangKyModel().checDangKyModel(dk);
//        if (dkmd) {
//            JOptionPane.showMessageDialog(this, "Tạo thành công tài khoản", "Thông báo", JOptionPane.OK_OPTION);
//
//        } else {
//            
//            JOptionPane.showMessageDialog(this, "Đăng ký không thành công! ", "Thông báo", JOptionPane.OK_OPTION);
//
//        }
//    }
//        if (!"".equals(thongbao)) {
//            JOptionPane.showMessageDialog(this, thongbao);
//        } 
//    }

