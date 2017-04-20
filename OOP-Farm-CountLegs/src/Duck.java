/**
 * Created by Joss on 17/03/2017.
 */
public class Duck extends Animal {
    public Duck(String kind) {
        super("Vịt");
    }

    @Override
    public int legs() {
        return 2;
    }
}
