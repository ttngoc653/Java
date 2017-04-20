/**
 * Created by Joss on 17/03/2017.
 */
public abstract class Animal {
    private String kind;
    public abstract int legs();

    public String getKind(){return kind;}
    public void setKind(String kind){this.kind=kind;}

    public Animal(String kind) {
        this.kind = kind;
    }
}
