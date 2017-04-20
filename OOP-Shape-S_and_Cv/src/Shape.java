/**
 * Created by Joss on 28/03/2017.
 */
public abstract class Shape {
    /**
     * bien canh thu 1 (hay ban kinh hinh tron)
     */
    float _a;
    /**
     * bien canh thu 2
     */
    float _b;
    /**
     * bien canh thu 3
     */
    float _c;

    /**
     * bien dien tich
     */
    float _S;
    /**
     * bien chu vi
     */
    float _P;

    /**
     * ham xuat gia tri dien tich
     * @return gia tri dien tich
     */
    public float getS(){
        return _S;
    }

    /**
     * ham xuat gia tri chu vi
     * @return gia tri chu vi
     */
    public float getP(){
        return _P;
    }

    /**
     * ham tinh dien tich
     */
    public abstract void setS();

    /**
     * ham tinh chu vi
     */
    public abstract void setP();

    /**
     * ham nhap thong tin tu ban phim
     */
    public abstract void inputKeyboard();

    /**
     * ham xuat thong tin
     */
    public abstract void outMonitor();

    /**
     * ham xuat thong tin co ca dien tich va chu vi
     */
    public abstract void outMonitorSP();

}
