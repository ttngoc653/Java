class Diem{
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Diem() {
		x=0;y=0;
	}
	public Diem(int _x,int _y) {
		x=_x;y=_y;
	}
	public void nhap() {
	System.out.println("");
	}
}

class DuongTron{
	private Diem I;
	private int r;
	public Diem getI() {
		return I;
	}
	public void setI(Diem i) {
		I = i;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public DuongTron() {
		I = new Diem();
		r=0;
	}
	public DuongTron(Diem _I,int _r) {
		I = new Diem(I.getX(), I.getY());
		r = _r;
	}
	
	public void nhap() {
		
	}
}

public class unit03 {
	public static void main(String[] args) {

	}
}
