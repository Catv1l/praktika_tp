import java.util.Scanner;

public class FirstProg {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("1:");
        int a1 = in.nextInt();
        int b1 = in.nextInt();
        System.out.println(String.valueOf(remainder(a1,b1)));

        System.out.print("2:");
        int a2 = in.nextInt();
        int b2 = in.nextInt();
        System.out.println(String.valueOf(triArea(a2,b2)));

        System.out.print("3:");
        int a3 = in.nextInt();
        int b3 = in.nextInt();
        int c3 = in.nextInt();
        System.out.println(String.valueOf(animals(a3,b3,c3)));

        System.out.print("4:");
        double a4 = in.nextDouble();
        int b4 = in.nextInt();
        int c4 = in.nextInt();
        System.out.println(profitableGamble(a4,b4,c4));

        System.out.print("5:");
        int a5 = in.nextInt();
        int b5 = in.nextInt();
        int c5 = in.nextInt();
        operation(a5,b5,c5);
        
    }

    public static int remainder (int a, int b)
    {
        int c = a%b;
        return c;
    }

    public static int triArea (int a, int b)
    {
        int c = a*b/2;
        return c;
    }

    public static int animals (int a, int b, int c)
    {
        int d = a*2+b*4+c*4;
        return d;
    }

    public static boolean profitableGamble (double a, int b, int c)
    {
        if (a*b > c)
        {
            return true;
        }
        else return false;
    }

    public static void operation (int a, int b, int c)
    {
        if (b+c==a)
        {
            System.out.println("added");
        }
        else if (b-c==a)
        {
            System.out.println("subtracted");
        }
        else if (b*c==a)
        {
            System.out.println("multiply");
        }
        else if (b/c==a)
        {
            System.out.println("division");
        }
        else System.out.println("none");
    }

    public static int ctoa (char a)
    {
        return (int) a;
    }
}
