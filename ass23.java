import java.util.Scanner;

public class ass23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double P, T, R, SI;

        System.out.print("Enter Principal: ");
        P = sc.nextDouble();

        System.out.print("Enter Time: ");
        T = sc.nextDouble();

        System.out.print("Enter Rate: ");
        R = sc.nextDouble();

        SI = (P * T * R) / 100;

        System.out.println("Simple Interest = " + SI);
    }
}