package frmStudentManagement;

import java.util.ArrayList;

public class processData {
	static String file_name="sinhvien.txt";
	private static ArrayList<SinhVien> list=null;
	
	static boolean add(SinhVien sv) {
		list =processFile.readFile(file_name);
		list.add(sv);		
		return processFile.writeFile(list, file_name);
	}
	
	static boolean replace(int idx,SinhVien sv) {
		list=processFile.readFile(file_name);
		list.set(idx, sv);
		return processFile.writeFile(list, file_name);
	}
	
	static boolean delete(int idx) {
		list=processFile.readFile(file_name);
		list.remove(idx);
		return processFile.writeFile(list, file_name);
	}
	
	static boolean checkEqualCode(String code) {
		list=processFile.readFile(file_name);
		for (SinhVien sv : list)
			if(sv.getCode().equals(code)) return true;
		
		return false;
	}
	static ArrayList<SinhVien> search(String keyword){
		list=processFile.readFile(file_name);
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getCode().toLowerCase().indexOf(keyword.toLowerCase())>-1) {
			} else if (list.get(i).getName().toLowerCase().indexOf(keyword.toLowerCase())>-1) {
			} else if (list.get(i).getLayer().toLowerCase().indexOf(keyword.toLowerCase())>-1) {
			} else if (list.get(i).getAddress().toLowerCase().indexOf(keyword.toLowerCase())>-1) {
			} else if (list.get(i).getGpa().toLowerCase().indexOf(keyword.toLowerCase())>-1) {
			} else if (list.get(i).getYear().toLowerCase().indexOf(keyword.toLowerCase())>-1) {
			} else {
				list.remove(i);
				i--;
			}
		}
		return list;
	}
}
