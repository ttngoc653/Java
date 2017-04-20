import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Joss on 17/03/2017.
 */
public class Farm {
    public ArrayList<Animal> listAnimal;

    public ArrayList<Animal> getListAnimal() {
        return listAnimal;
    }

    public void setListAnimal(ArrayList<Animal> listAnimal) {
        this.listAnimal = listAnimal;
    }

    public Farm() {
        listAnimal = new ArrayList<>();
    }

    public int sumLeg(){
        int s=0;
        for(Animal data:listAnimal){
            s+=data.legs();
        }
        return s;
    }

    public void Menu(){
        System.out.println("MENU:");
        System.out.println("1 - thêm Gà");
        System.out.println("2 - thêm Chó");
        System.out.println("3 - thêm Vịt");
        System.out.println("4 - thêm Ngựa");
        System.out.println("5 - thêm Bò");
        System.out.println("6 - thêm Heo");
        System.out.println("7 - tổng sô chân hiện tạo trog trại");
        System.out.println("8 - trật tự đã thêm trong trại");
        System.out.println("9 - xem lại MENU");
        System.out.println("0 - thoát");
    }
}
