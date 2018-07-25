package DiemDanhSV_process;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import DiemDanhSV_class.Diemdanh;

public class DiemDanhProcess {
	static Session session;
	public static Integer check(String date, String time, String ten_mon_hoc, String mssv) {
		session = ConnectDb.createSession();
		session.getTransaction().begin();
		Query query = session.createSQLQuery(
		    "UPDATE Diemdanh " + 
		    "SET coDiHoc = 1 " + 
		    "WHERE ngayHoc = :in_ngay_hoc " + 
		    "AND gioHoc = :in_gio_hoc " + 
		    "AND mssv LIKE :in_mssv " + 
		    "AND maTkb IN (SELECT maTkb " + 
		    "               FROM Thoikhoabieu " + 
		    "               WHERE maMonHoc LIKE :in_ma_mh)");
		query.setParameter("in_ngay_hoc", ConnectDb.convertDate(date));
		query.setParameter("in_gio_hoc", time);
		query.setParameter("in_mssv", mssv);
		query.setParameter("in_ma_mh", MonHocProcess.getMaMonHoc(ten_mon_hoc));
		int result = query.executeUpdate();
		session.getTransaction().commit();
		return result;
	}
	@SuppressWarnings("unchecked")
	public static List<Diemdanh> loadDSNgayDiemDanh(String mon_hoc, String date_hien_tai, String mssv) {
		try {
			session = ConnectDb.createSession();
			Query qry = session.createQuery(
					"FROM Diemdanh t "
					+ "WHERE mssv like :in_mssv "
					+ "	AND maTkb in (SELECT maTkb "
					+ "				FROM Thoikhoabieu "
					+ "				WHERE maMonHoc like :in_mon_hoc "
					+ "					AND (:in_date_hien_tai BEWEEN ngayBatDau AND ngayKetThuc)");
			qry.setParameter("in_mssv", mssv);
			qry.setParameter("in_mon_hoc", MonHocProcess.getMaMonHoc(mon_hoc));
			qry.setParameter("in_date_hien_tai", ConnectDb.convertDate(date_hien_tai));
			List<Diemdanh> list = qry.list();
			
			System.out.println(list.size());
			if(list.size() == 0) return list;
			else return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	@SuppressWarnings("unchecked")
	public static List<String> getMonDangHoc(String mssv) {
		try {
			session = ConnectDb.createSession();
			Query qry = session.createQuery(
					"SELECT m.tenMonHoc FROM Monhoc m "
					+ "WHERE m.maMonHoc IN (SELECT maMonHoc "
					+ "				FROM Thoikhoabieu "
					+ "				WHERE (:in_date_hien_tai BEWEEN ngayBatDau AND ngayKetThuc) "
					+ "					AND maTkb IN (SELECT maTkb "
					+ "									FROM Diemdanh "
					+ "									WHERE mssv like :in_mmsv))");
			qry.setParameter("in_mssv", mssv);
			qry.setParameter("in_date_hien_tai", new SimpleDateFormat("yyyy-MM-dd").format(new Date(0)));
			List<String> list = qry.list();
			
			System.out.println(list.size());
			if(list.size() == 0) return list;
			else return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
