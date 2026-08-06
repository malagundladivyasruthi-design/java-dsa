import java.util.Scanner;

public class ass25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b;

        System.out.print("Enter first number: ");
        a = sc.nextInt();

        System.out.print("Enter second number: ");
        b = sc.nextInt();

        if (a > b)
            System.out.println(a + " is largest");
        else if (b > a)
            System.out.println(b + " is largest");
        else
            System.out.println("Both numbers are equal");
    }
}