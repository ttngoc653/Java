/**
 * Created by Joss on 17/03/2017.
 */
public class Dog extends Animal {
    public Dog(String kind) {
        super("Chó");
    }

    @Override
    public int legs() {
        return 4;
    }
}
