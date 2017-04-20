import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.SimpleTimeZone;

/**
 * Created by Joss on 03/04/2017.
 */
public class JDBC {
    public static void main(String[] args){
        listNV l=new listNV();
        int tool=1;
        Scanner scan=new Scanner(System.in);

        l.Menu();
        while (tool!=0){
            System.out.print("NHAP CHUC NANG: ");
            tool=scan.nextInt();scan.nextLine();
            NhanVien nv=new NhanVien();
            if(tool==1){
                System.out.print("NHAP HO: ");
                nv._honv=scan.nextLine();
                System.out.print("NHAP HO LOT: ");
                nv._tenlot=scan.nextLine();
                System.out.print("NHAP TEN: ");
                nv._tennv=scan.nextLine();
                System.out.print("NHAP PHAI (nam OR nu): ");
                if (Objects.equals(scan.nextLine(), "nam"))
                    nv._phai=1;
                else nv._phai=0;
                System.out.print("NHAP NGAY SINH (VD: 1996-12-31): ");
                nv._ngsinh=scan.nextLine();
                System.out.print("NHAP DIA CHI: ");
                nv._dchi=scan.nextLine();
                System.out.print("NHAP LUONG: ");
                nv._luong=scan.nextLong();scan.nextLine();
                System.out.print("NHAP MA QUAN LY: ");
                nv._ma_nql=scan.nextInt();scan.nextLine();
                System.out.print("NHAP PHONG BAN: ");
                nv._phg=scan.nextInt();scan.nextLine();
                l.add(nv);
            }
            if (tool==2){

                System.out.print("NHAP MA THAY DOI: ");
                nv._manv=scan.nextInt();scan.nextLine();
                nv = l.findMaNV(nv._manv);
                if (nv == null) {
                    System.out.println("NGUOI NAY KHONG CO TRONG DU LIEU!");
                }
                else {
                    System.out.println("THONG TIN CU: ");
                    System.out.print(nv._manv+" - ");
                    System.out.print(nv._honv+" ");
                    System.out.print(nv._tenlot+" ");
                    System.out.print(nv._tennv+", ");
                    if (nv._phai==1)
                        System.out.print("male"+", ");
                    else System.out.print("female"+", ");
                    System.out.print(nv._ngsinh.toString()+", (luong) ");
                    System.out.print(nv._dchi+", ");
                    System.out.print(nv._luong+" VND, ");
                    System.out.print(nv._ma_nql+" quan ly, PHONG: ");
                    System.out.println(nv._phg);

                    System.out.print("NHAP HO THAY DOI: ");
                    nv._honv=scan.nextLine();
                    System.out.print("NHAP HO LOT THAY DOI: ");
                    nv._tenlot=scan.nextLine();
                    System.out.print("NHAP TEN THAY DOI: ");
                    nv._tennv=scan.nextLine();
                    System.out.print("NHAP PHAI THAY DOI (0 OR 1): ");
                    nv._phai=scan.nextInt();
                    scan.nextLine();
                    System.out.print("NHAP NGAY SINH THAY DOI (VD: 31/12/1996): ");
                    nv._ngsinh=scan.nextLine();
                    System.out.print("NHAP DIA CHI THAY DOI: ");
                    nv._dchi=scan.nextLine();
                    System.out.print("NHAP LUONG MUON THAY DOI: ");
                    nv._luong=scan.nextLong();scan.nextLine();
                    System.out.print("NHAP MA QUAN LY THAY DOI: ");
                    nv._ma_nql=scan.nextInt();scan.nextLine();
                    System.out.print("NHAP PHONG BAN MUON THAY DOI: ");
                    nv._phg=scan.nextInt();scan.nextLine();
                    l.replace(nv);
                }

            }
            if (tool==3){
                System.out.print("NHAP MA MUON XOA: ");
                nv._manv=scan.nextInt();scan.nextLine();
                l.delete(nv);
            }
            if(tool==4){
                l.output();
            }
            if (tool==5){
                System.out.print("NHAP HO TEN NHAN VIEN: ");
                String str= scan.nextLine();
                nv = l.find(str);
                if (nv == null) {
                    System.out.println("NGUOI NAY KHONG CO TRONG DU LIEU!");
                }
                else {
                    System.out.print(nv._manv+" - ");
                    System.out.print(nv._honv+" ");
                    System.out.print(nv._tenlot+" ");
                    System.out.print(nv._tennv+", ");
                    if (nv._phai==1)
                        System.out.print("male"+", ");
                    else System.out.print("female"+", ");
                    System.out.print(nv._ngsinh.toString()+", (luong) ");
                    System.out.print(nv._dchi+", ");
                    System.out.print(nv._luong+" VND, ");
                    System.out.print(nv._ma_nql+" quan ly, PHONG: ");
                    System.out.println(nv._phg);
                }
            }
            if (tool==6){
                l.Menu();
            }
        }
    }
}
