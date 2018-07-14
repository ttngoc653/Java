package DiemDanhSV_process;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ConnectDb {
	public static Session createSession() {
		return (new Configuration().configure()).buildSessionFactory().openSession();
	}
	static Session ss = null;
	public static boolean insert(Object obj) {
		try {
			ss = createSession();
			ss.beginTransaction();
			ss.save(obj);
			ss.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			ss.flush();
			return false;
		}finally {
			//ss.close();
		}
		ss.flush();
		return true;
	}
	public static boolean update(Object obj) {
		try {
			ss = createSession();
			ss.beginTransaction();
			ss.saveOrUpdate(obj);
			ss.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			ss.flush();
			return false;
		}finally {
			//ss.close();
		}
		
		ss.flush();
		return true;
	}
	public static boolean delete(Object obj) {
		try {
			ss = createSession();
			
			ss.beginTransaction();
			ss.delete(obj);
			ss.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			ss.flush();
			return false;
		}finally {
			ss.close();
		}
		ss.flush();
		return true;
	}
}
