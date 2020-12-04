import com.sun.deploy.util.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThirdProg {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("1: ");
        int k1_1 = in.nextInt();
        int k1_2 = in.nextInt();
        int k1_3 = in.nextInt();
        solutions(k1_1,k1_2,k1_3);

        System.out.print("2: ");
        String str2 = in.nextLine();
        findZip(str2);

        System.out.print("3: ");
        int k3 = in.nextInt();
        checkPerfect(k3);

        System.out.print("4: ");
        String str4 = in.nextLine();
        flipEndChars(str4);

        System.out.print("5: ");
        String str5 = in.nextLine();
        isValidHexCode(str5);

        System.out.print("6: ");
        String str6_1 = in.nextLine();
        int mas6_1[] = new int [str6_1.length()];
        try
        {
            for (int i = 0; i < str6_1.length(); i++) mas6_1[i] = (str6_1.charAt(i));
        }
        catch (Exception e){}
        String str6_2 = in.nextLine();
        int mas6_2[] = new int [str6_2.length()];
        try
        {
            for (int i = 0; i < str6_2.length(); i++) mas6_2[i] = (str6_2.charAt(i));
        }
        catch (Exception e){}
        System.out.println(same(mas6_1, mas6_2));


        System.out.print("7: ");
        int k7 = in.nextInt();
        System.out.println(isKaprekar(k7));

        System.out.print("8: ");
        String str8 = in.nextLine();
        longestZero(str8);


        System.out.print("9: ");
        int k9 = in.nextInt();
        nextPrime(k9);

        System.out.print("10: ");
        int a10 = in.nextInt();
        int b10 = in.nextInt();
        int c10 = in.nextInt();
        rightTriangle(a10,b10,c10);
    }
    public static void solutions(double a, double b, double c)
    {
        double d=b*b-4*a*c;
        if (d<0)
            System.out.println("0");
        else if (d>0)
            System.out.println("2");
        else
            System.out.println("1");
    }

    public static void findZip(String str)
    {
        int i=0;

        Pattern p = Pattern.compile("zip");
        Matcher m = p.matcher(str);
        while (m.find()) {
            i++;
        }

        int index = str.indexOf("zip");
        if (i<2) System.out.println("-1");
        else System.out.println(str.indexOf("zip", index+4));

    }
    public static void checkPerfect (int k)
    {
        int s=0;
        for (int i=1; i<k; i++)
        {
            if (k%i==0) s=s+i;
        }
        if (k==s) System.out.println("true");
        else System.out.println("false");
    }

    public static void flipEndChars(String str)
    {
        if (str.length()<3) System.out.println("Incompatible.");
        else if (str.charAt(0)==str.charAt(str.length()-1)) System.out.println("Two's a pair.");
        else
        {
            System.out.println(str.charAt(str.length() - 1) + str.substring(1, str.length() - 1) + str.charAt(0));
        }
    }

    public static void isValidHexCode(String str)
    {
        if (str.charAt(0) != '#'|| str.length() != 7) {
            System.out.println("false");
            return;
        }
        for (int i = 1; i < str.length(); i++)
        {
            if (!(("ABCDEFabcdef".contains(Character.toString(str.charAt(i))))||(Character.isDigit(str.charAt(i)))))
            {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }

    public static boolean same(int a[], int b[])
    {
        int uniq1 = 0;
        for (int i = 0; i < a.length - 1; i++)
        {
            boolean u1= true;
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] == a[j]) u1 = false;
            }
            if (u1) uniq1++;
        }
        int uniq2 = 0;
        for (int i = 0; i < b.length - 1; i++)
        {
            boolean u2= true;
            for (int j = i + 1; j < b.length; j++)
            {
                if (b[i] == b[j]) u2 = false;
            }
            if (u2) uniq2++;
        }

        return uniq1==uniq2;
    }

    public static boolean isKaprekar(int n)
    {
        String sq = Integer.toString(n*n);
        String a = ""; String b= "";
        a = sq.substring(0, sq.length() / 2);
        b = sq.substring(sq.length() / 2, sq.length());
        int i = a.equals("") ? 0 : Integer.parseInt(a);
        int j = b.equals("") ? 0 : Integer.parseInt(b);
        return i + j == n;
    }

    public static void longestZero (String str)
    {
        int max=0;
        int k=0;
        for (int i=0; i<str.length(); i++)
        {
            if (str.charAt(i)=='0')
            {
                k++;
            }
            else
            {
                if (k>max) max = k;
                k=0;
            }
        }
        if (k>max) max = k;
        String res="";
        for (int i=0; i<max;i++)
            res+="0";
        System.out.println(res);
    }

    public static void nextPrime(int a)
    {
        int k=0;
        for (int i=2; i<Math.sqrt(a)+1; i++) if (a%i==0) k=1;
        if (k==1)
        {
            while(k!=0)
            {
                a++;
                k=0;
                for (int i=2; i<Math.sqrt(a)+1; i++)
                {
                    if (a%i==0) k=1;
                }
            }
        }
        System.out.println(a);
    }

    public static void rightTriangle(int a,int b,int c)
    {
        if ((a*a + b*b == c*c) || (a*a + c*c == b*b) || (b*b + c*c == a*a))
        {
            System.out.println(true);
        }
        else
            System.out.println(false);
    }
}
