/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Molder;

/**
 *
 * @author AD
 */
public class CongViecModel extends BaseModel{
    private String maCongViec;
    private String tenCongViec;
    private boolean trangThaiCongViec;

    public CongViecModel(String maCongViec, String tenCongViec, boolean trangThaiCongViec) {
        this.maCongViec = maCongViec;
        this.tenCongViec = tenCongViec;
        this.trangThaiCongViec = trangThaiCongViec;
    }

    public void getDuLieu(){
    
    }
    public CongViecModel() {
    }

    public String getMaCongViec() {
        return maCongViec;
    }

    public void setMaCongViec(String maCongViec) {
        this.maCongViec = maCongViec;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public boolean isTrangThaiCongViec() {
        return trangThaiCongViec;
    }

    public void setTrangThaiCongViec(boolean trangThaiCongViec) {
        this.trangThaiCongViec = trangThaiCongViec;
    }
    
}
