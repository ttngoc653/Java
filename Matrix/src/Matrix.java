import javax.lang.model.type.NullType;
import java.util.Scanner;

/**
 * Created by Joss on 10/03/2017.
 */

public class Matrix {
    public static int[][] inMatrix(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("NHAP SO DONG: ");
        int m = scan.nextInt();
        System.out.printf("NHAP S0 COT: ");
        int n = scan.nextInt();

        System.out.println("NHAP MA TRAN: ");
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++)
                matrix[i][j]=scan.nextInt();
            System.out.println();
        }
        return matrix;
    }

    public static void outMatrix(int[][] matrix){
        int m=matrix.length;
        if (m==0) return;
        int n=matrix[0].length;

        System.out.println("MA TRAN HIEN TAI LA: ");
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++)
                System.out.printf("%3d ",matrix[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] rotate90(int[][] matrix){
        if (matrix.length==0) return null;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] matrixRotate=new int[m][n];
        for(int i=0;i<m;i++)
            for (int j=0;j<n;j++){
                matrixRotate[i][j]=matrix[m-1-j][i];
            }
        return matrixRotate;
    }

    public static void rotate90NTimes(int[][] matrix){
        Scanner scan = new Scanner(System.in);
        System.out.print("SO LAN XOAY MA TRAN 90 DO: ");
        int s= scan.nextInt();
        int[][] matrixR=matrix;
        for(int i=0;i<s;i++){
            System.out.printf("LAN XOAY THU %d. ",i+1);
            matrixR=rotate90(matrixR);
            outMatrix(matrixR);
        }
    }

    public static void delermineValue(int[][] matrix){
        Scanner scan = new Scanner(System.in);
        System.out.println("TIM PHAN TU.");
        System.out.printf("NHAP THU TU DONG CUA PHAN TU (bat dau tu 1): ");
        int i=scan.nextInt();
        System.out.printf("NHAP THU TU COT CUA PHAN TU (bat dau tu 1): ");
        int j=scan.nextInt();
        if(i>=matrix.length || j>=matrix[0].length || i<0 || j<0)
            System.out.printf("VUOT QUA GIOI HAN TIM KIEM!");
        else System.out.printf("PHAN TU CAN TIM CO GIA TRI: %d", matrix[i][j]);
        System.out.println();
    }

    public static void main(String[] args){
        System.out.println("hello world");
        int[][] matrix=inMatrix();
        outMatrix(matrix);
        rotate90NTimes(matrix);
        delermineValue(matrix);
    }
}
