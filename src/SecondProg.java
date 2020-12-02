import java.util.Scanner;

public class SecondProg {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("1: ");
        String str1 = in.next();
        int a1 = in.nextInt();
        repeat(str1,a1);

        System.out.println("2: ");
        int k2 = in.nextInt();
        int mas2 []= new int [k2];
        for (int i=0;i<k2;i++)
        {
            mas2[i]=in.nextInt();
        }
        differenceMaxMin(mas2);

        System.out.println("3: ");
        int k3 = in.nextInt();
        int mas3 []= new int [k3];
        for (int i=0;i<k3;i++)
        {
            mas3[i]=in.nextInt();
        }
        isAvgWhole(mas3);

        System.out.println("4: ");
        int k4 = in.nextInt();
        int mas4 []= new int [k4];
        for (int i=0;i<k4;i++)
        {
            mas4[i]=in.nextInt();
        }
        cumulativeSum(mas4);

        System.out.println("5: ");
        String str5 = in.next();
        getDecimalPlaces(str5);

        System.out.println("6: ");
        int k6 = in.nextInt();
        fibonacci(k6);

        System.out.println("7: ");
        String str7 = in.next();
        isValid(str7);

        System.out.println("8: ");
        String str8_1 = in.next();
        String str8_2 = in.next();
        isStrangePair(str8_1,str8_2);

        System.out.println("9: ");
        String str9_1 = in.next();
        String str9_2 = in.next();
        if (str9_2.charAt(0)=='-')
        {
            isSuffix(str9_1, str9_2);
        }
        if (str9_2.charAt(str9_2.length()-1)=='-')
        {
            isPrefix(str9_1,str9_2);
        }

        System.out.println("10: ");
        int k10 = in.nextInt();
        boxSeq(k10);
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
        System.out.println();
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
        System.out.println(result);
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
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
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
        System.out.println();
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
        System.out.println(k);
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
        System.out.println(n2);
    }

    public static void isValid(String str)
    {
        int k=0;
        if (str.length()!=5)
        {
            k++;
        }
        for(int i=0; i<str.length();i++)
        {
            if(str.charAt(i)==' '|| Character.isLetter(str.charAt(i)))
            {
            k++;
            }
        }
        if (k==0) {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }

    public static void isStrangePair(String str1, String str2)
    {
        int k1 = str1.length();
        int k2 = str2.length();
        if (str1.charAt(0)==str2.charAt(k2-1) && str1.charAt(k1-1)==str2.charAt(0))
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }
    public static void isPrefix(String word, String prefix)
    {
        System.out.println(word.startsWith(prefix.substring(0, prefix.length()-1)));
    }

    public static void isSuffix(String word, String suffix)
    {
        System.out.println(word.endsWith(suffix.substring(1, suffix.length())));
    }

    public static void boxSeq(int k)
    {
        if (k % 2 == 0)
            System.out.println(k);
        else
            System.out.println(k + 2);
    }
}
