package DiemDanhSV_process;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import DiemDanhSV_class.Monhoc;

public class MonHocProcess {
	public static Integer addMonHoc(Monhoc mh) {
		if(equalTen(mh.getTenMonHoc()) != null) return 1;
		else if (equalCode(mh.getMaMonHoc()) != null) return 2;
		else if (ConnectDb.insert(mh) == true) return 3;
		return 0;
	}
	@SuppressWarnings("unchecked")
	public static List<String> getAllTen() {
		try {
			Session ss = ConnectDb.createSession();
			Query qry = ss.createQuery("SELECT n.tenMonHoc FROM Monhoc n");
			List<String> list = qry.list();
			System.out.println(list.size());
			if(list.size() == 0) return null;
			else return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public static List<Monhoc> getDanhSachMonHoc() {
		try {
			Session ss = ConnectDb.createSession();
			Query qry = ss.createQuery("FROM Monhoc n");
			List<Monhoc> list = qry.list();
			System.out.println(list.size());
			if(list.size() == 0) return null;
			else return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public static String getMaMonHoc(String ten_mon_hoc) {
		Session ss = ConnectDb.createSession();
		Query qry = ss.createQuery("SELECT n.maMonHoc FROM Monhoc n WHERE n.tenMonHoc like :in_name");
		qry.setParameter("in_name", ten_mon_hoc);
		List<String> list = qry.list();
		System.out.println(list.size());
		if(list.size() == 0) return null;
		else return list.get(0);
	}
	@SuppressWarnings("unchecked")
	public static String getTenMonHoc(String ma_mon_hoc) {
		Session ss = ConnectDb.createSession();
		Query qry = ss.createQuery("SELECT n.tenMonHoc FROM Monhoc n WHERE n.maMonHoc like :in_name");
		qry.setParameter("in_name", ma_mon_hoc);
		List<String> list = qry.list();
		System.out.println(list.size());
		if(list.size() == 0) return null;
		else return list.get(0);
	}
	@SuppressWarnings("unchecked")
	private static Monhoc equalTen(String name) {
		try {
			Session ss = ConnectDb.createSession();
			Query qry = ss.createQuery("FROM Monhoc n WHERE n.tenMonHoc like :in_name");
			qry.setParameter("in_name", name);
			List<Monhoc> list = qry.list();
			System.out.println(list.size());
			if(list.size() == 0) return null;
			else return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	private static Monhoc equalCode(String code) {
		try {
			Session ss = ConnectDb.createSession();
			Query qry = ss.createQuery("FROM Monhoc n WHERE n.maMonHoc like :in_name");
			qry.setParameter("in_name", code);
			List<Monhoc> list = qry.list();
			System.out.println(list.size());
			if(list.size() == 0) return null;
			else return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
