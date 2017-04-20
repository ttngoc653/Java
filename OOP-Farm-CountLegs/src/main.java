import java.util.Scanner;

/**
 * Created by Joss on 17/03/2017.
 */
public class main {

    public static void main(String[] args){
        Farm farm=new Farm();
        int chon=1;
        farm.Menu();
        while (chon!=0){
            System.out.printf("CHỌN CHỨC NĂNG: ");
            Scanner scan=new Scanner(System.in);
            chon=scan.nextInt();
            switch (chon){
                case 1:
                    Animal a=new Chicken("Gà");
                    farm.listAnimal.add(a);
                    System.out.println("ĐÃ THÊM 1 CON "+ a.getKind()+"!");
                    break;
                case 2:
                    Animal b=new Dog("Chó");
                    farm.listAnimal.add(b);
                    System.out.println("ĐÃ THÊM 1 CON "+ b.getKind()+"!");
                    break;
                case 3:
                    Animal c=new Duck("Vịt");
                    farm.listAnimal.add(c);
                    System.out.println("ĐÃ THÊM 1 CON "+ c.getKind()+"!");
                    break;
                case 4:
                    Animal d=new Horse("Ngựa");
                    farm.listAnimal.add(d);
                    System.out.println("ĐÃ THÊM 1 CON "+ d.getKind()+"!");
                    break;
                case 5:
                    Animal e=new Ox("Bò");
                    farm.listAnimal.add(e);
                    System.out.println("ĐÃ THÊM 1 CON "+ e.getKind()+"!");
                    break;
                case 6:
                    Animal f=new Pig("Heo");
                    farm.listAnimal.add(f);
                    System.out.println("ĐÃ THÊM 1 CON "+ f.getKind()+"!");
                    break;
                case 7:
                    System.out.println("TỔNG SỐ CHÂN TRONG TRẠI LÀ "+ farm.sumLeg()+" CHÂN.");
                    break;
                case 8:
                    System.out.println(farm.listAnimal);
                    break;
                case 9:
                    farm.Menu();
                    break;
                case 0:
                    System.out.println("KẾT THÚC CHƯƠNG TRÌNH.");
                    break;
            }
        }
    }
}
