import java.util.Scanner;

/**
 * Created by Joss on 29/03/2017.
 */
public class main {
    public static void main(String[] args) {
        GeometricManagement GeoMana = new GeometricManagement();
        int select = 1;
        while (select != 0) {
            System.out.printf("CHỌN CHỨC NĂNG: ");
            Scanner scan = new Scanner(System.in);
            select = scan.nextInt();
            switch (select) {
                case 1:
                    Shape a = new Circle();
                    a.inputKeyboard();
                    GeoMana.addShape(a);
                    System.out.println("ĐÃ THÊM HÌNH TRÒN!");
                    break;
                case 2:
                    Shape b = new Rectangle();
                    b.inputKeyboard();
                    GeoMana.addShape(b);
                    System.out.println("ĐÃ THÊM HÌNH CHỮ NHẬT!");
                    break;
                case 3:
                    Shape c = new Circle();
                    c.inputKeyboard();
                    GeoMana.addShape(c);
                    System.out.println("ĐÃ THÊM HÌNH TAM GIÁC!");
                    break;
                case 4:
                    GeoMana.outputAllShape();
                    break;
                case 5:
                    System.out.println("TỔNG DIỆN TÍCH CÁC HÌNH: " + GeoMana.SumS());
                    break;
                case 6:
                    GeoMana.outputShapeSMax();
                    break;
                case 7:
                    GeoMana.outputTypeShapeSumSMax();
                    break;
                case 8:
                    GeoMana.outputRectangleSMax();
                    break;
                case 9:
                    GeoMana.Menu();
                    break;
                case 0:
                    System.out.println("KẾT THÚC CHƯƠNG TRÌNH.");
                    break;
            }
        }
    }
}