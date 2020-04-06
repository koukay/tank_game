import java.util.Scanner;

public class a {
    public static void main(String[] args) {
//        System.out.println("123---");
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
        int n=3;
//        System.out.println(n);
        int sum=0,x;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(j+" ");
//                x=i+j;
//                sum+=x;
                sum+=j;
            }
            System.out.println("");
        }
        System.out.println(sum);
    }
}
