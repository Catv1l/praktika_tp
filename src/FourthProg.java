import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class FourthProg {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("1:"); z1();
        System.out.println("2:"); for (int i=0;i<4;i++) z2();
        System.out.println("3:"); for (int i=0;i<4;i++) z3();
        System.out.println("4:"); for (int i=0;i<3;i++) z4();
        System.out.println("5:"); for (int i=0;i<3;i++) z5();
        System.out.println("6:"); for (int i=0;i<3;i++) z6();
        System.out.println("7:"); for (int i=0;i<4;i++) z7();
        System.out.println("8:"); for (int i=0;i<4;i++) z8();
        System.out.println("9:"); for (int i=0;i<4;i++) z9();
        System.out.println("10:"); for (int i=0;i<3;i++) z10();
    }

    public static void z1() {
        int n = in.nextInt();
        int k = in.nextInt();
        String str = in.nextLine();
        System.out.println(text(n, k, str));
    }
    public static String text(int kolvo, int dlina, String str)
    {
        int line=0;
        String fin_str="";
        String[] lines = str.split(" ");
        for (String l: lines)
        {
            if (l.length()+line<=dlina)
            {
                fin_str+=" "+l;
                line+=l.length();
            }
            else
            {
                fin_str+="\n"+l;
                line=l.length();
            }
        }
        return fin_str;
    }

    public static void z2()
    {
        String str = in.nextLine();
        split(str);
    }
    public static void split(String str)
    {
        ArrayList<String> res = new ArrayList<String>();

        int open=0, close=0;
        int start=0;
        for (int i=0; i<str.length(); i++)
        {
            if (str.charAt(i)=='(')
            {
                open++;
                if (open==1)
                    start=i;
            }
            else
            {
                close++;
            }
            if (open==close)
            {
                res.add(str.substring(start,i+1));
                open=0;
                close=0;
            }
        }
        String res_str[]= res.toArray(new String[0]);
        System.out.print("[");
        for (int i = 0; i < res_str.length - 1; i++)
        {
            System.out.print(res_str[i] + ", ");
        }
        if (res_str.length > 0)
            System.out.println(res_str[res_str.length-1] + "]");
        else
            System.out.println("]");
    }

    public static void z3()
    {
        String str = in.nextLine();
        if (str.indexOf('_')!=-1)
            toCamelCase(str);
        else
            toSnakeCase(str);
    }
    public static void toCamelCase(String str)
    {
        String[] words = str.split("_");
        String camelcase = words[0];
        for (int i = 1; i < words.length; i++)
        {
            camelcase += words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        System.out.println(camelcase);
    }
    public static void toSnakeCase(String str)
    {
        String snakecase="";
        int k=0;
        for(int i=0; i<str.length();i++)
        {
            if(Character.isUpperCase(str.charAt(i)))
            {
                if (k==0)
                    snakecase+=str.substring(k,i);
                else
                    snakecase+="_"+Character.toLowerCase(str.charAt(k))+str.substring(k+1,i);
                k=i;
            }
        }
        if(k!=0) snakecase+="_";
        snakecase += Character.toLowerCase(str.charAt(k)) + str.substring(k + 1);
        System.out.println(snakecase);
    }

    public static void z4()
    {
        double start = in.nextDouble();
        double end = in.nextDouble();
        double stavka = in.nextDouble();
        double sverx = in.nextDouble();
        overTime(start,end,stavka,sverx);
    }
    public static void overTime (double start, double end, double stavka, double sverx)
    {
        double pererab=0;
        if (end>17)
        {
            pererab=end-17;
        }
        double zarab = (end-start-pererab)*stavka+pererab*stavka*sverx;
        System.out.println("$"+(int)zarab+"."+(int)Math.round((zarab % 1) * 100)+(((int)Math.round((zarab % 1) * 100) == 0 ? "0" : "")));
    }

    public static void z5()
    {
        String weight = in.nextLine();
        String height = in.nextLine();
        BMI(weight, height);
    }
    public static void BMI(String weight, String height)
    {
        double w = Double.parseDouble(weight.split(" ")[0]);
        if (weight.endsWith("pounds"))
            w *= 0.4535923745;
        double h = Double.parseDouble(height.split(" ")[0]);
        if (height.endsWith("inches"))
            h *= 0.0254;
        double index = Math.round((w/(h*h)) * 10) / 10.0;
        if (index < 18.5)
            System.out.println(index + " Underweight");
        else if (index < 25)
            System.out.println(index +" Normal weight");
        else System.out.println(index +" Overweight");
    }

    public static void z6()
    {
        int k=in.nextInt();
        bugger(k);
    }
    public static void bugger(int k1)
    {
        int n=0;
        while (k1>10)
        {
            int i=k1;
            int k2=1;
            while (i>0)
            {
                k2*=(i%10);
                i/=10;
            }
            k1=k2;
            n++;
        }
        System.out.println(n);
    }

    public static void z7()
    {
        String str = in.nextLine();
        toStarShorthand(str);
    }
    public static void toStarShorthand(String str)
    {
        String res="";
        int k=0;
        char ch=' ';
        for (int i=0; i<str.length();i++)
        {
            if (str.charAt(i)==ch)
            {
                k++;
            }
            else
            {
                if (ch!=' ')
                {
                    if (k>1)
                        res+=ch+"*"+k;
                    else res+=ch;
                }
                ch=str.charAt(i);
                k=1;
            }
        }
        if (k>1)
            res+=ch+"*"+k;
        else res+=ch;
        System.out.println(res);
    }

    public static void z8()
    {
        String str1=in.nextLine();
        String str2=in.nextLine();
        doesRhyme(str1,str2);
    }
    public static void doesRhyme(String str1, String str2)
    {
        String a="";
        String b="";
        str1=str1.substring(str1.lastIndexOf(" ")+1).toLowerCase();
        str2=str2.substring(str2.lastIndexOf(" ")+1).toLowerCase();
        for(int i=0; i<str1.length()-1; i++)
        {
            if ("aeiouy".contains(str1.substring(i,i+1)))
            {
                a+=str1.charAt(i);
            }
        }
        for(int i=0; i<str2.length()-1; i++)
        {
            if ("aeiouy".contains(str2.substring(i,i+1)))
            {
                b+=str2.charAt(i);
            }
        }
        a=a.toLowerCase();
        b=b.toLowerCase();
        if (a.equals(b))
            System.out.println(true);
        else System.out.println(false);
    }

    public static void z9()
    {
        long a = in.nextLong();
        long b= in.nextLong();
        trouble(a,b);
    }
    public static void trouble(long a, long b)
    {
        boolean tr=false;
        String str1= Long.toString(a);
        String str2= Long.toString(b);
        int[] mas1= new int[10];
        int[] mas2= new int[10];
        for (int i=0; i< str1.length();i++)
        {
            mas1[Integer.parseInt(str1.substring(i,i+1))]++;
        }
        for (int j=0; j< str2.length();j++)
        {
            mas2[Integer.parseInt(str2.substring(j,j+1))]++;
        }
        for (int k=0;k<10;k++) {
            if (mas1[k] == 3 && mas2[k] == 2) tr = true;
        }
        System.out.println(tr);
    }

    public static void z10()
    {
        String str=in.nextLine();
        char ch=in.nextLine().charAt(0);
        countUniqueBooks(str,ch);
    }
    public static void countUniqueBooks(String str, char ch)
    {
        boolean book = false;
        String chars = "";
        for (int i=0; i<str.length();i++)
        {
            if (str.charAt(i)==ch)
                book=!book;
            else
            {
                if (book)
                    if (!chars.contains(str.substring(i,i+1)))
                        chars+=str.charAt(i);
            }
        }
        System.out.println(chars.length());
    }
}

