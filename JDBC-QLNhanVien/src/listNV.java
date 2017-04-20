import sun.net.www.protocol.http.spnego.NegotiateCallbackHandler;

import java.awt.*;
import java.sql.*;
import java.text.DateFormat;
import java.util.*;

import static javax.swing.UIManager.getString;

/**
 * Created by Joss on 04/04/2017.
 */

public class listNV {

    /**
     * day thong tin cua tat ca nhan vien
     */
    private ArrayList<NhanVien> lNV;

    /**
     * bien goi cac chuoi ket noi den database
     */
    ConnectDatabase cd=new ConnectDatabase();

    /**
     * ham khoi tao danh sach nhan vien
     * @return danh sach nhan vien da duoc lay tu database
     */
    public ArrayList<NhanVien> arraylistNhanVien(){
        ArrayList<NhanVien> arraylist=null;
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName(cd.j_d);
            connection= DriverManager.getConnection(cd.DB_URL,cd.u,cd.p);
            statement =connection.createStatement();
            String str="SELECT HONV, TENLOT, TENNV, MANV, NGSINH, DCHI, PHAI, LUONG, MA_NQL, PHG FROM nhanvien WHERE 1";
            ResultSet rs= statement.executeQuery((str));

            while (rs.next()){
                NhanVien nv = null;
                nv._honv=rs.getString("HONV");
                nv._tenlot=rs.getString("TENLOT");
                nv._tennv=rs.getString("TENNV");
                nv._manv=rs.getInt("MANV");
                nv._ngsinh=rs.getString("NGSINH");
                nv._dchi=rs.getString("DCHI");
                nv._phai=rs.getInt("PHAI");
                nv._luong=rs.getLong("LUONG");
                nv._ma_nql=rs.getInt("MA_NQL");
                nv._phg=rs.getInt("PHG");
                arraylist.add(nv);
            }
            rs.close();
            statement.close();
            connection.close();
            return arraylist;
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ham them nhan vien duoc nhap tu ban phim
     * @param nv: bien lop nhan vien chua cac thong tin nhan vien ma nuoi dung da nhap
     * @return tra ve co them nhan vien duoc hay khong
     */
    public boolean add(NhanVien nv){
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName(cd.j_d);
            connection= DriverManager.getConnection(cd.DB_URL,cd.u,cd.p);
            statement =connection.createStatement();
            String str="INSERT INTO nhanvien(HONV, TENLOT, TENNV, NGSINH, DCHI, PHAI, LUONG, MA_NQL, PHG) VALUES ('"+nv._honv+"','"+nv._tenlot+"','"+nv._tennv+"','"+ nv._ngsinh+"','"+nv._dchi+"','"+nv._phai+"','"+nv._luong+"','"+nv._ma_nql+"','"+nv._phg+"')";
            System.out.println(str);
            statement.executeUpdate((str));
            statement.close();
            connection.close();
            return true;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * ham thay doi thong tin cua mot nhan vien nao do
     * @param nv: thong tin nhan vien da duoc thay doi va cho vao bien nay
     * @return tra ve su thay doi nay da duoc cap nhat vao database chua
     */
    public boolean replace(NhanVien nv){
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName(cd.j_d);
            connection= DriverManager.getConnection(cd.DB_URL,cd.u,cd.p);
            statement =connection.createStatement();
            String str="UPDATE nhanvien SET HONV='"+nv._honv+"',TENLOT='"+nv._tenlot+"',TENNV='"+nv._tennv+"',NGSINH='"+nv._ngsinh+"',DCHI='"+nv._dchi+"',PHAI="+nv._phai+",LUONG="+nv._luong+",MA_NQL="+nv._ma_nql+",PHG="+nv._phg+" WHERE MANV="+nv._manv;
            System.out.println(str);
            statement.executeQuery((str));
            statement.close();
            connection.close();
            return true;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * ham xoa nhan vien
     * @param nv: chua duy nhat mot ma nhan vien de xac dinh nhan vien can xoa
     * @return tra ve co xoa duoc trong database hay khong
     */
    public boolean delete(NhanVien nv){
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName(cd.j_d);
            connection= DriverManager.getConnection(cd.DB_URL,cd.u,cd.p);
            statement =connection.createStatement();
            String str="DELETE FROM nhanvien WHERE MANV="+nv._manv;
            System.out.println(str);
            statement.executeUpdate((str));
            statement.close();
            connection.close();
            return true;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * ham tim kiem nhan vien
     * @param hoten: ho ten nhan vien muon tim kiem
     * @return tra ve lop nhanvien chua thong tin nhan vien dang tim
     * tra ve find(hoten)=null neu khong tim duoc nhan vien nay
     */
    public NhanVien find(String hoten){
        Connection connection=null;
        Statement statement=null;
        NhanVien nv = new NhanVien();
        try {
            Class.forName(cd.j_d);
            connection= DriverManager.getConnection(cd.DB_URL,cd.u,cd.p);
            statement =connection.createStatement();
            String str="SELECT HONV, TENLOT, TENNV, MANV, NGSINH, DCHI, PHAI, LUONG, MA_NQL, PHG FROM nhanvien WHERE CONCAT(HONV,' ',TENLOT,' ',TENNV)='"+hoten+"'";
            System.out.println(str);
            ResultSet rs= statement.executeQuery(str);

            while (rs.next()){
                nv._honv=rs.getString("HONV");
                nv._tenlot=rs.getString("TENLOT");
                nv._tennv=rs.getString("TENNV");
                nv._manv=rs.getInt("MANV");
                nv._ngsinh=rs.getString("NGSINH");
                nv._dchi=rs.getString("DCHI");
                nv._phai=rs.getInt("PHAI");
                nv._luong=rs.getLong("LUONG");
                nv._ma_nql=rs.getInt("MA_NQL");
                nv._phg=rs.getInt("PHG");
                return nv;
            }
            rs.close();
            statement.close();
            connection.close();
            return null;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return nv;
        } finally {
            return nv;
        }
    }

    /**
     * xuat tat ca thong tin cua cac nhan vien co trong du lieu tu database
     */
    public void output(){
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName(cd.j_d);
            connection= DriverManager.getConnection(cd.DB_URL,cd.u,cd.p);
            statement =connection.createStatement();
            String str="SELECT HONV, TENLOT, TENNV, MANV, NGSINH, DCHI, PHAI, LUONG, MA_NQL, PHG FROM nhanvien WHERE 1";
            ResultSet rs= statement.executeQuery(str);

            while (rs.next()){
                System.out.print(rs.getInt("MANV")+" - ");
                System.out.print(rs.getString("HONV")+" ");
                System.out.print(rs.getString("TENLOT")+" ");
                System.out.print(rs.getString("TENNV")+", ");
                if (rs.getBoolean("PHAI"))
                    System.out.print("nam, ");
                else System.out.print("nu, ");
                System.out.print(rs.getString("NGSINH")+", ");
                System.out.print(rs.getString("DCHI")+", (luong) ");
                System.out.print(rs.getLong("LUONG")+" VND"+", do ");
                System.out.print(rs.getInt("MA_NQL")+" quan ly, THUOC PHONG: ");
                System.out.println(rs.getInt("PHG"));
            }
            rs.close();
            statement.close();
            connection.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * cac chua nang cua chuong trinh
     */
    public void Menu(){
        System.out.println("\t1. THEM NHAN VIEN");
        System.out.println("\t2. SUA NHAN VIEN");
        System.out.println("\t3. XOA NHAN VIEN");
        System.out.println("\t4. XUAT TAT CA NHAN VIEN RA MAN HINH");
        System.out.println("\t5. TIM KIEM NHAN VIEN TU HO TEN CHINH XAC");
        System.out.println("\t6. HIEN LAI MENU");
        System.out.println("\t0. THOAT CHUONG TRINH");
    }

    public NhanVien findMaNV(int manv) {
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName(cd.j_d);
            connection= DriverManager.getConnection(cd.DB_URL,cd.u,cd.p);
            statement =connection.createStatement();
            String str="SELECT HONV, TENLOT, TENNV, MANV, NGSINH, DCHI, PHAI, LUONG, MA_NQL, PHG FROM nhanvien WHERE MANV='"+manv+"'";
            System.out.println(str);
            ResultSet rs= statement.executeQuery((str));

            while (rs.next()) {
                NhanVien nv = null;
                nv._honv = rs.getString("HONV");
                nv._tenlot = rs.getString("TENLOT");
                nv._tennv = rs.getString("TENNV");
                nv._manv = rs.getInt("MANV");
                nv._ngsinh = rs.getString("NGSINH");
                nv._dchi = rs.getString("DCHI");
                nv._phai = rs.getInt("PHAI");
                nv._luong = rs.getLong("LUONG");
                nv._ma_nql = rs.getInt("MA_NQL");
                nv._phg = rs.getInt("PHG");
                return nv;
            }
            rs.close();
            statement.close();
            connection.close();
            return null;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        } finally {
            return null;
        }
    }
}

