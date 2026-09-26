import java.math.BigInteger;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int a = sc.nextInt();
        System.out.println("Введите второе число:");
        int b = sc.nextInt();
        int result1 = cicle(a, b);
        BigInteger result2 = bigInteger(a, b);
        int result3 = recursion(a, b);
        int result4 = Math.multiplyExact(a, b);
        int result5 = russianPeasant(a, b);
        System.out.println("Результат умножения через цикл равен " + result1);
        System.out.println("Результат умножения через BigInteger равен " + result2);
        System.out.println("Результат умножения через рекурсию равен " + result3);
        System.out.println("Результат умножения через метод multiplyExact() равен " + result4);
        System.out.println("Результат умножения через побитовые операции равен " + result5);
    }

    public static int cicle(int a, int b) {
        int count = Math.abs(a);
        int result = 0;
        for (int i = 1; i <= count; i++) {
            if (a < 0) {
                result -= b;
            } else {
                result += b;
            }
        }
        return result;
    }

    public static BigInteger bigInteger(int a, int b) {
        BigInteger n1 = new BigInteger(String.valueOf(a));
        BigInteger n2 = new BigInteger(String.valueOf(b));
        return n1.multiply(n2);
    }

    public static int recursion(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (b == 1) {
            return a;
        }
        if (b < 0) {
            return -recursion(a, -b);
        }
        return a + recursion(a, b-1);
    }

    public static int russianPeasant(int a, int b) {
        int result = 0;
        int x = Math.abs(a);
        int y = Math.abs(b);
        while (x >= 1) {
            if (x % 2 != 0) {
                result += y;
            }
            x /= 2;
            y *= 2;
        }
        if (a > 0 && b > 0 || a < 0 && b < 0){
            return result;
        } else {
            return -result;
        }
    }
}