import java.util.Scanner;

/**
 * Created by Joss on 28/03/2017.
 */
public class Circle extends Shape {
    @Override
    /**
     * tinh dien tich hinh tron
     */
    public void setS() {
        _S= (float) (_a*_a*Math.PI);
    }

    @Override
    /**
     * tinh chu vi hinh tron
     */
    public void setP() {
        _P= (float) (2*_a*Math.PI);
    }

    @Override
    /**
     * nhap thong tin tron tu ban phim
     */
    public void inputKeyboard() {
        Scanner scan=new Scanner(System.in);
        System.out.println("NHAP THONG TIN HINH TRON.");
        System.out.print("NHAP BAN KINH: ");
        _a=scan.nextFloat();
    }

    @Override
    /**
     * xuat thong tin hinh tron
     * ma khong hien dien tich va chu vi
     */
    public void outMonitor() {
        System.out.println("THONG TIN HINH TRON.");
        System.out.println("BAN KINH: "+_a);
        System.out.println();
    }

    @Override
    /**
     * xuat thong tin hinh tron
     * co dien tich và chu vi
     */
    public void outMonitorSP() {
        System.out.println("THONG TIN HINH TRON.");
        System.out.println("BAN KINH: "+_a);
        System.out.println(" DIEN TICH = "+_S);
        System.out.println(" CHU VI = "+_P);
        System.out.println();
    }
}
