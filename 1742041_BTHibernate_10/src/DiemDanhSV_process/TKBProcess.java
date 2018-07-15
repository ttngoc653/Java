package DiemDanhSV_process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import DiemDanhSV_class.Thoikhoabieu;
import DiemDanhSV_class.ViewTKB;

public class TKBProcess {
	private static Session ss;
	@SuppressWarnings("unchecked")
	public static boolean attend(Thoikhoabieu tkb) {
		try {
			ss = ConnectDb.createSession();
			Query qry = ss.createQuery("FROM Thoikhoabieu t WHERE ((:in_gio_bd like BETWEEN t.gioBatDau AND t.gioKetThuc) OR (:in_gio_kt BETWEEN t.gioBatDau AND t.gioKetThuc)) AND t.ngayBatDau == :in_ngay_bd AND t.tenPhongHoc like :in_ten_phong_hoc");
			qry.setParameter("in_gio_bd", tkb.getGioBatDau());
			qry.setParameter("in_gio_kt", tkb.getGioKetThuc());
			qry.setParameter("in_ngay_bd", tkb.getNgayBatDau());
			qry.setParameter("in_ten_phong_hoc", tkb.getTenPhongHoc());
			List<Thoikhoabieu> list = qry.list();
			
			System.out.println(list.size());
			if(list.size() == 0) return true;
			else return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public static boolean create(Thoikhoabieu tkb) {
		return ConnectDb.insert(tkb);
	}
	public static boolean update(Thoikhoabieu tkb) {
		return ConnectDb.update(tkb);
	}
	public static boolean delete(Thoikhoabieu tkb) {
		return ConnectDb.delete(tkb);
	}
	@SuppressWarnings("unchecked")
	public static Integer getCode(Thoikhoabieu tkb) {
		try {
			ss = ConnectDb.createSession();
			Query qry = ss.createQuery("FROM Thoikhoabieu t WHERE t.gioBatDau = :in_gio_bd and t.ngayBatDau = :in_ngay_bd and t.tenPhongHoc like :in_ten_phong_hoc");
			qry.setParameter("in_gio_bd", tkb.getGioBatDau());
			qry.setParameter("in_ngay_bd", tkb.getNgayBatDau());
			qry.setParameter("in_ten_phong_hoc", tkb.getTenPhongHoc());
			List<Thoikhoabieu> list = qry.list();
			System.out.println(list.size());
			if(list.size() == 0) return null;
			else return list.get(0).getMaTkb();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<ViewTKB> getTableTKB() {
		try {
			ss = ConnectDb.createSession();
			Query qry = ss.createQuery("FROM Thoikhoabieu t");
			List<Thoikhoabieu> list = qry.list();
			List<ViewTKB> list_return = new ArrayList();
			for (Thoikhoabieu i : list) {
				list_return.add(new ViewTKB(MonHocProcess.getTenMonHoc(i.getMaMonHoc()),i.getNgayBatDau(),i.getNgayKetThuc(),i.getThuTrongTuan(),i.getGioBatDau(),i.getGioKetThuc(),i.getTenPhongHoc()));
			}
			if(list.size() == 0) return null;
			else return list_return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
