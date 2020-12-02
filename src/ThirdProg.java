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
}
