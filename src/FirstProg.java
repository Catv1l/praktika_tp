import java.util.Scanner;

public class FirstProg {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("1: ");
        int a1 = in.nextInt();
        int b1 = in.nextInt();
        System.out.println(String.valueOf(remainder(a1,b1)));

        System.out.print("2: ");
        int a2 = in.nextInt();
        int b2 = in.nextInt();
        System.out.println(String.valueOf(triArea(a2,b2)));

        System.out.print("3: ");
        int a3 = in.nextInt();
        int b3 = in.nextInt();
        int c3 = in.nextInt();
        System.out.println(String.valueOf(animals(a3,b3,c3)));

        System.out.print("4: ");
        double a4 = in.nextDouble();
        int b4 = in.nextInt();
        int c4 = in.nextInt();
        System.out.println(profitableGamble(a4,b4,c4));

        System.out.print("5: ");
        int a5 = in.nextInt();
        int b5 = in.nextInt();
        int c5 = in.nextInt();
        operation(a5,b5,c5);


        System.out.print("6: ");
        char a6 = in.next().charAt(0);
        System.out.println(ctoa(a6));

        System.out.print("7: ");
        int a7 = in.nextInt();
        System.out.println(addUpTo(a7));

        System.out.print("8: ");
        int a8 = in.nextInt();
        int b8 = in.nextInt();
        System.out.println(nextEdge(a8, b8));

        System.out.print("9: ");
        double[] array;
        System.out.println("Введите длинну массива: ");
        int i = in.nextInt();
        array = new  double [i];
        System.out.println("Введите массив: ");
        for (int j=0; j<i; j++)
        {
            array[j]=in.nextInt();
        }
        System.out.println(sumOfCubes(array, i));

        System.out.print("10: ");
        int a10 = in.nextInt();
        int b10 = in.nextInt();
        int c10 = in.nextInt();
        System.out.println(abcmath(a10,b10,c10));
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
        return (int)a;
    }

    public static int addUpTo(int a)
    {
        int c=0;
        for (int i=1; i<=a; i++)
        {
            c=c+i;
        }
        return c;
    }

    public static int nextEdge(int a, int b)
    {
        return (a+b-1);
    }

    public static double sumOfCubes (double[] array, int i)
    {
        double k=0;
        for (int j=0; j<i;j++)
        {
            k=k+Math.pow(array[j],3);
        }
        return k;
    }

    public static boolean abcmath (int a, int b, int c)
    {
        for (int j=0;j<b; j++)
            a=+a;
        if (a%c==0)
            return true;
        else return false;
    }
}
