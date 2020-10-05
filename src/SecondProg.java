import java.util.Scanner;

public class SecondProg {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("1: ");
        String str1 = in.next();
        int a1 = in.nextInt();
        repeat(str1,a1);

        System.out.print("2: ");
        int k2 = in.nextInt();
        int mas2 []= new int [k2];
        for (int i=0;i<k2;i++)
        {
            mas2[i]=in.nextInt();
        }
        differenceMaxMin(mas2);

        System.out.print("3: ");
        int k3 = in.nextInt();
        int mas3 []= new int [k3];
        for (int i=0;i<k3;i++)
        {
            mas3[i]=in.nextInt();
        }
        isAvgWhole(mas3);

        System.out.print("4: ");
        int k4 = in.nextInt();
        int mas4 []= new int [k4];
        for (int i=0;i<k4;i++)
        {
            mas4[i]=in.nextInt();
        }
        cumulativeSum(mas4);

        System.out.print("5: ");
        String str5 = in.next();
        getDecimalPlaces(str5);

        System.out.print("6: ");
        int k6 = in.nextInt();
        fibonacci(k6);


    }

    public static void repeat(String str, int a)
    {
        int k= str.length();
        for (int i=0;i<k;i++)
        {
            for(int j=0; j<a;j++)
            {
            System.out.print(str.charAt(i));
            }
        }
    }
    public static void differenceMaxMin(int[] mas)
    {
        int result, min=100000, max=-100000;
        for (int i=0; i< mas.length; i++)
        {
            if (mas[i]<min)
            {
                min=mas[i];
            }
            if (mas[i]>max)
            {
                max=mas[i];
            }
        }
        result = max - min;
        System.out.print(result);
    }

    public static void isAvgWhole(int[] mas)
    {
        int sum=0;
        for (int i=0;i<mas.length;i++)
        {
            sum=sum+mas[i];
        }
        if((sum%mas.length)==0)
        {
            System.out.print("true");
        }
        else
        {
            System.out.print("false");
        }
    }

    public static void cumulativeSum(int [] mas)
    {
        int m=0;
        int mas1[]=new int[mas.length];
        for (int i=0; i<mas.length;i++)
        {
            m=m+mas[i];
            mas1[i]=m;
        }
        for (int j=0;j<mas1.length;j++)
        {
            System.out.print(mas1[j]+" ");
        }
    }
    public static void getDecimalPlaces(String str)
    {
        int k=0;
        for(int i=0; i<str.length();i++)
        {
            if (str.charAt(i)=='.')
            {
                k= str.length()-i-1;
            }
        }
        System.out.print(k);
    }

    public static void fibonacci(int a)
    {
        int n0=0, n1=1, n2=1;
        for (int i=2;i<=a;i++)
        {
           n2=n0+n1;
           n0=n1;
           n1=n2;
        }
        System.out.print(n2);
    }
}
