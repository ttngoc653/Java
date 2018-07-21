package DiemDanhSV_process;

import org.hibernate.Query;
import org.hibernate.Session;

public class DiemDanhProcess {
	public static Integer check(String date,String time,String ten_mon_hoc,String mssv) {
		Session session = ConnectDb.createSession();
		session.getTransaction().begin();
		Query query = session.createSQLQuery(
		    "UPDATE diemdanh " + 
		    "SET co_di_hoc = 1 " + 
		    "WHERE ngay_hoc = :in_ngay_hoc " + 
		    "AND gio_hoc = :in_gio_hoc " + 
		    "AND mssv LIKE :in_mssv " + 
		    "AND ma_tkb IN (SELECT ma_tkb " + 
		    "               FROM thoikhoabieu " + 
		    "               WHERE ma_mon_hoc LIKE :in_ma_mh)");
		query.setParameter("in_ngay_hoc", date);
		query.setParameter("in_gio_hoc", time);
		query.setParameter("in_mssv", mssv);
		query.setParameter("in_ma_mh", MonHocProcess.getMaMonHoc(ten_mon_hoc));
		int result = query.executeUpdate();
		session.getTransaction().commit();
		return result;
	}
}
