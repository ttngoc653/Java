import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);
		System.out.println("toa do Ox: ");
		x = sc.nextInt();
		System.out.println("toa do Oy: ");
		y = sc.nextInt();
	}
	public void xuat() {
		System.out.println("(" + x +", "+y+")");
	}
}

class DuongTron{
	private Diem I;
	private float r;
	public Diem getI() {
		return I;
	}
	public void setI(Diem i) {
		I = i;
	}
	public float getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	// 3a.1
	public DuongTron() {
		I = new Diem();
		r = 1;
	}
	
	public DuongTron(float s) {
		I = new Diem(0,0);
		r=s;
	}
	
	public DuongTron(Diem A,float s) {
		I = new Diem(A.getX(), A.getY());
		r = s;
	}
	
	public DuongTron(Diem A) {
		I = new Diem(A.getX(), A.getY());
		r = 1;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap tam I duong tron: ");
		I.nhap();
		System.out.println("nhap ban kinh duong tron: ");
		r = sc.nextInt();
	}
	public void xuat() {
		System.out.print("toa tam I: ");
		I.xuat();
		System.out.println("ban kinh duong tron: " + r);
	}
	public double chuVi() {
		return Math.PI * 2 * r;
	}
}

class MangDuongTron{
	private List<DuongTron> list;
	public MangDuongTron() {
		setList(new ArrayList<DuongTron>());
	}
	public List<DuongTron> getList() {
		return list;
	}
	public void setList(List<DuongTron> list) {
		this.list = list;
	}
}

public class unit03 {
	public static void main(String[] args) {

	}
}
