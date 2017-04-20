/**
 * Created by Joss on 17/03/2017.
 */
public class Horse extends Animal {
    public Horse(String kind) {
        super("Ngựa");
    }

    @Override
    public int legs() {
        return 4;
    }
}
