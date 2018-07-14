package DiemDanhSV_process;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import DiemDanhSV_class.Nguoidung;

public class NguoiDungProcess {
	private static Session ss;
	public static boolean create(Nguoidung nd) {
		return ConnectDb.insert(nd);
	}
	public static boolean update(Nguoidung nd) {
		return ConnectDb.update(nd);
	}
	public static boolean delete(Nguoidung nd) {
		return ConnectDb.delete(nd);
	}
	@SuppressWarnings("unchecked")
	public static Nguoidung login(Nguoidung nd) {
		//System.out.println("da vao ham...");
		try {
			ss = ConnectDb.createSession();
			Query qry = ss.createQuery("FROM Nguoidung n WHERE n.tenDn like :in_ten_dn and n.matKhau like :in_mat_khau");
			qry.setParameter("in_ten_dn", nd.getTenDn());
			qry.setParameter("in_mat_khau", nd.getMatKhau());
			List<Nguoidung> list = qry.list();
			System.out.println(list.size());
			if(list.size() == 0) return null;
			else return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
