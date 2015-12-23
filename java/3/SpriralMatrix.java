package ntou.cs.java2015.yuhang;
import java.util.Scanner;
class SpriralMatrix{
    public void spriralMatrix(){
        Scanner scanner = new Scanner(System.in);
        int clkW,vari,n;
        System.out.print("請輸入順時針(1)或逆時針(2)：");
        clkW=scanner.nextInt();
        System.out.print("請輸入內迴旋(1)或外迴旋(2)：");
        vari=scanner.nextInt();
        do{
            System.out.print("請輸入邊長（"+(vari==1?"奇數且":"")+"<100）：");
            n=scanner.nextInt();
        }while(n<=0||n>=100||((vari==1)&&n%2==0));
        int A[][]=new int[n][n];

        int k=(vari==1?n*n:1),c1=0,c2=n-1,r1=0,r2=n-1;
        while(k<=n*n&&k>=1){
        for(int i=c1;i<=c2;i++)
            A[r1][i]=(vari==1?k--:k++);
        for(int j=r1+1;j<=r2;j++)
            A[j][c2]=(vari==1?k--:k++);
        for(int i=c2-1;i>=c1;i--)
            A[r2][i]=(vari==1?k--:k++);
        for(int j=r2-1;j>=r1+1;j--)
            A[j][c1]=(vari==1?k--:k++);
        c1++;c2--;r1++;r2--;
        }
        /*output*/
        System.out.println("The Circular Matrix is:");
        for(int i=0;i<n;i++){
            if(vari==2){
                for(int j=0;j<n;j++)
                    System.out.print((clkW==1?A[i][j]:A[j][i])+ "\t");
            }else{
                if(clkW==2)
                    for(int j=0;j<n;j++)
                        System.out.print(A[i][j]+ "\t");
                else
                    for(int j=n-1;0<=j;j--)
                        System.out.print(A[i][j]+ "\t");
            }
            System.out.println();
        }
    }
}
