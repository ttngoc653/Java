package frmStudentManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class processFile {
	public static ArrayList<SinhVien> readFile(String file_name) {
		ArrayList<SinhVien> list=new ArrayList<>();
		SinhVien sv=null;
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file_name), "UTF8"))){
			String str=br.readLine();
			do {
				sv=new SinhVien();
				sv.setCode(str);
				
				str=br.readLine();
				sv.setName(str);
				
				str=br.readLine();
				sv.setYear(str);
				
				str=br.readLine();
				sv.setLayer(str);
				
				str=br.readLine();
				sv.setGpa(str);
				
				str=br.readLine();
				sv.setAddress(str);
				
				list.add(sv);
				
				str=br.readLine();
			} while (str!=null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public static boolean writeFile(ArrayList<SinhVien> listSV,String file_name) {
		try (BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_name), "UTF8"))){
			for (SinhVien sv : listSV) {
				bw.write(sv.getCode()+'\n');
				bw.write(sv.getName()+'\n');
				bw.write(sv.getYear()+'\n');
				bw.write(sv.getLayer()+'\n');
				bw.write(sv.getGpa()+'\n');
				bw.write(sv.getAddress()+'\n');
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
