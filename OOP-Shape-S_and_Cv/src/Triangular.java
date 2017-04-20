import java.util.Scanner;

/**
 * Created by Joss on 29/03/2017.
 */
public class Triangular extends Shape {
    @Override
    /**
     * tinh dien tich hinh tam giac
     */
    public void setS() {
        float temp=_P/2;
        _S= (float) Math.sqrt(temp*(temp-_a)*(temp-_b)*(temp-_c));
    }

    @Override
    /**
     * tinh chu vi hinh tam giac
     */
    public void setP() {
        _P=_a+_b+_c;
    }

    @Override
    /**
     * nhap thong tin tam giac tu ban phim
     */
    public void inputKeyboard() {
        Scanner scan=new Scanner(System.in);
        System.out.println("NHAP THONG TIN HINH TAM GIAC.");
        System.out.print("NHAP CANH 1: ");
        _a=scan.nextFloat();
        System.out.print("NHAP CANH 2: ");
        _b=scan.nextFloat();
        System.out.print("NHAP CANH 3: ");
        _c=scan.nextFloat();
    }

    @Override
    /**
     * xuat thong tin hinh tam giac
     * ma khong hien dien tich va chu vi
     */
    public void outMonitor() {
        System.out.println("THONG TIN HINH TAM GIAC.");
        System.out.println("DO DAI CAC CANH: "+_a+" "+_b+" "+_c);
        System.out.println();
    }

    @Override
    /**
     * xuat thong tin hinh tam giac
     * co dien tich và chu vi
     */
    public void outMonitorSP() {
        System.out.println("THONG TIN HINH TAM GIAC.");
        System.out.println("DO DAI CAC CANH: "+_a+" "+_b+" "+_c);
        System.out.println(" DIEN TICH = "+_S);
        System.out.println(" CHU VI = "+_P);
        System.out.println();
    }
}
