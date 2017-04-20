import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Joss on 29/03/2017.
 */
public class GeometricManagement {

    /**
     * bien chua danh sach cac hinh
     */
    private ArrayList<Shape> _shapeArrayList;

    /**
     * khoi tao gia tri cho bien mang
     */
    public GeometricManagement() {
        _shapeArrayList=null;
    }

    /**
     * ham gab tri cho bien mang
     * @return mang da gan
     */
    public ArrayList<Shape> get_shapeArrayList() {
        return _shapeArrayList;
    }

    /**
     * ham khoi tao da co danh sach tu dau
     * @param shapeArrayList: danh sach chua cac hinh dau vao
     */
    public GeometricManagement(ArrayList<Shape> shapeArrayList) {
        _shapeArrayList = shapeArrayList;
    }

    /**
     * ham xuat ra thong tin tat ca cac hinh trong mang
     */
    public void outputAllShape(){
        System.out.println("DANH SACH CAC HINH DA NHAP.");
        for (int i = 0; i < _shapeArrayList.size(); i++) {
            _shapeArrayList.get(i).outMonitor();
        }
    }

    /**
     * ham tinh tong dien tich cua tat ca cac hinh
     * @return tong tat ca cac hinh
     */
    public double SumS(){
        double sum=0;
        for (Shape a_shapeArrayList : _shapeArrayList) {
            sum += a_shapeArrayList.getS();
        }
        return sum;
    }

    /**
     * ham tim kiem cac hinh co dien tich cao nhat
     * @return mang chua danh sach cac hinh co dien tich cao nhat
     */
    private List<Integer> SearchSMax(){
        float max=_shapeArrayList.get(0).getS();
        List<Integer> location = null;
        for (int i = 1; i < _shapeArrayList.size(); i++) {
            if (max <= _shapeArrayList.get(i).getS())
                if (max == _shapeArrayList.get(i).getS()) {
                    location.add(i);
                } else {
                    location.clear();
                    location.add(i);
                    max = _shapeArrayList.get(i).getS();
                }
        }
        return location;
    }

    /**
     * xuat ra man hinh danh sach thong tin cac hinh co  dien tich cao nhat
     */
    public void outputShapeSMax(){
        System.out.println("THONG TIN CAC HINH CO DIEN TICH LON NHAT.");
        List<Integer> SMax=SearchSMax();
        for (int i = 0; i < SMax.size(); i++) {
            _shapeArrayList.get(i).outMonitorSP();
        }
    }

    /**
     * ham tinh tong dien tich cac hinh phan theo tung loai hinh
     * @return mang chua tong dien tich phan theo loai hinh
     */
    private double[] SumSByShape(){
        double[] SumShape=new double[3];
        for (int i = 0; i < SumShape.length; i++) {
            SumShape[i]=0;
        }

        for (Shape a_shapeArrayList : _shapeArrayList) {
            if (a_shapeArrayList._c != 0)
                SumShape[0] += a_shapeArrayList._S;
            else if (a_shapeArrayList._b != 0)
                SumShape[1] += a_shapeArrayList._S;
            else SumShape[2] += a_shapeArrayList._S;
        }

        return SumShape;
    }

    /**
     * ham xuat ra loai hinh nao co tong dien tich cao nhat
     */
    public void outputTypeShapeSumSMax(){
        double[] SType=SumSByShape();
        if (SType[0] > SType[1] && SType[0]  > SType[2])
            System.out.println("HINH TAM GIAC CO TONG DIEN TICH LON NHAT: " + SType[0]);
        else if (SType[0] < SType[1] && SType[1]  > SType[2])
            System.out.println("HINH CHU NHAT CO TONG DIEN TICH LON NHAT: " + SType[1]);
        else     System.out.println("HINH TRON CO TONG DIEN TICH LON NHAT: " + SType[2]);
    }

    /**
     * ham tim hinh chu nhat co dien tich cao nhat
     * @return danh sach hinh chu nhat co dien tich cao nhat
     */
    private List<Integer> SearchRetangleSMax(){
        float max=_shapeArrayList.get(0).getS();
        List<Integer> location = null;
        for (int i = 1; i < _shapeArrayList.size(); i++) {
            if (max <= _shapeArrayList.get(i).getS()&&_shapeArrayList.get(i)._b!=0&&_shapeArrayList.get(i)._c==0)
                if (max == _shapeArrayList.get(i).getS()) {
                    location.add(i);
                } else {
                    location.clear();
                    location.add(i);
                    max = _shapeArrayList.get(i).getS();
                }
        }
        return location;
    }

    /**
     * ham xuat danh sach cac hinh chu nhat co dien tich cao nhat
     */
    public void outputRectangleSMax(){
        System.out.println("THONG TIN CAC HINH CHU NHAT CO DIEN TICH LON NHAT.");
        List<Integer> SMax=SearchRetangleSMax();
        for (int i = 0; i < SMax.size(); i++) {
            _shapeArrayList.get(i).outMonitorSP();
        }
    }

    /**
     * ham them 1 hinh vao danh sach chua tat ca cac hinh
     * @param s: bien hinh da duoc khoi tao va phan loai
     */
    public void addShape(Shape s){
        _shapeArrayList.add(s);
    }

    /**
     * ham liet ke danh sach cac chua nang co trong chuong trinh
     */
    public void Menu(){
        System.out.println("MENU:");
        System.out.println("1 - thêm hình Tròn");
        System.out.println("2 - thêm hình Chữ Nhật");
        System.out.println("3 - thêm hình Tam Giác");
        System.out.println("4 - xuất Tất cả Thông tin các Hình đã nhập");
        System.out.println("5 - xuất Tổng Diện tích Tất cả các Hình");
        System.out.println("6 - xuất Thông tin các Hình có Diện tích Lớn nhất");
        System.out.println("7 - xuất Loại Hình có Tổng Diện tích Lớn nhất");
        System.out.println("8 - xuất Hình Chữ nhật có Diện tích Lớn nhất");
        System.out.println("9 - xem lại MENU");
        System.out.println("0 - thoát");
    }
}