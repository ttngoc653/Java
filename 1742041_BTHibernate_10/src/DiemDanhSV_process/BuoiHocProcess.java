package DiemDanhSV_process;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import DiemDanhSV_class.Buoihoc;
import DiemDanhSV_class.Thoikhoabieu;

public class BuoiHocProcess {
	private static Session ss;
	public static boolean create(Buoihoc bh) {
		return ConnectDb.insert(bh);
	}
	public static boolean update(Buoihoc bh) {
		return ConnectDb.update(bh);
	}
	public static boolean delete(Buoihoc bh) {
		return ConnectDb.delete(bh);
	}
	@SuppressWarnings("unchecked")
	public static List<Buoihoc> getAllList() {
		try {
			ss = ConnectDb.createSession();
			Query qry = ss.createQuery("FROM Nguoidung");
			List<Buoihoc> list = qry.list();
			System.out.println(list.size());
			if(list.size() == 0) return null;
			else return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	@SuppressWarnings("unchecked")
	public static boolean attend(Thoikhoabieu tkb) {
		try {
			ss = ConnectDb.createSession();
			Query qry = ss.createQuery("FROM Buoihoc t WHERE t.ngayhoc = :in_ngay_hoc "
					+ "AND ((:in_gio_bd BETWEEN t.gioHoc AND t.gioRaVe) OR (:in_gio_kt BETWEEN t.gioHoc AND t.gioRaVe)) "
					+ "AND t.phongHoc like :in_phong_hoc ");
			qry.setParameter("in_ngay_hoc", tkb.getNgayBatDau());
			qry.setParameter("in_gio_bd", tkb.getNgayBatDau());
			qry.setParameter("in_gio_kt", tkb.getNgayKetThuc());
			qry.setParameter("in_phong_hoc", tkb.getTenPhongHoc());
			List<Buoihoc> list = qry.list();
			System.out.println(list.size());
			if(list.size() == 0) return false;
			else return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}@SuppressWarnings("unchecked")
	public static boolean attend(Buoihoc bh) {
		try {
			ss = ConnectDb.createSession();
			Query qry = ss.createQuery("FROM Buoihoc t WHERE t.ngayhoc = :in_ngay_hoc "
					+ "AND ((:in_gio_bd BETWEEN t.gioHoc AND t.gioRaVe) OR (:in_gio_kt BETWEEN t.gioHoc AND t.gioRaVe)) "
					+ "AND t.phongHoc like :in_phong_hoc ");
			qry.setParameter("in_ngay_hoc", bh.getId().getNgayHoc());
			qry.setParameter("in_gio_bd", bh.getId().getGioHoc());
			qry.setParameter("in_gio_kt", bh.getGioRaVe());
			qry.setParameter("in_phong_hoc", bh.getPhongHoc());
			List<Buoihoc> list = qry.list();
			System.out.println(list.size());
			if(list.size() == 0) return false;
			else return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
