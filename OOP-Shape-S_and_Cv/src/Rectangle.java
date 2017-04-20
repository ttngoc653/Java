import java.util.Scanner;

/**
 * Created by Joss on 28/03/2017.
 */
public class Rectangle extends Shape {
    @Override
    /**
     * tinh dien tich hinh chu nhat
     */
    public void setS() {
        _S=_a*_b;
    }

    @Override
    /**
     * tinh chu vi hinh chu nhat
     */
    public void setP() {
        _P=(_a+_b)*2;
    }

    @Override
    /**
     * nhap thong tin chu nhat tu ban phim
     */
    public void inputKeyboard() {
        Scanner scan=new Scanner(System.in);
        System.out.println("NHAP THONG TIN HINH CHU NHAT.");
        System.out.print("NHAP CHIEU DAI: ");
        _a=scan.nextFloat();
        System.out.print("NHAP CHIEU RONG: ");
        _b=scan.nextFloat();
    }

    @Override
    /**
     * xuat thong tin hinh chu nhat
     * ma khong hien dien tich va chu vi
     */
    public void outMonitor() {
        System.out.println("THONG TIN HINH CHU NHAT.");
        System.out.println("DAI: "+_a+" VA RONG: "+_b);
        System.out.println();
    }

    @Override
    /**
     * xuat thong tin hinh chu nhat
     * co dien tich và chu vi
     */
    public void outMonitorSP() {
        System.out.println("THONG TIN HINH CHU NHAT.");
        System.out.println(" DAI = "+_a+" VA RONG = "+_b);
        System.out.println(" DIEN TICH = "+_S);
        System.out.println(" CHU VI = "+_P);
        System.out.println();
    }
}
