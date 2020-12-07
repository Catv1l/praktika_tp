import java.util.ArrayList;
import java.util.Scanner;

public class FifthProg {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("1:"); for (int i=0;i<3;i++) z1();
        System.out.println("2:"); for (int i=0;i<3;i++) z2();
        System.out.println("3:"); for (int i=0;i<4;i++) z3();
        System.out.println("4:"); for (int i=0;i<3;i++) z4();
        System.out.println("5:"); for (int i=0;i<3;i++) z5();
        System.out.println("6:"); for (int i=0;i<2;i++) z6();
        System.out.println("7:"); for (int i=0;i<4;i++) z7();

        //System.out.println("8:"); for (int i=0;i<4;i++) z8();
        //System.out.println("9:"); for (int i=0;i<4;i++) z9();
        //System.out.println("10:"); for (int i=0;i<3;i++) z10();
    }


    public static void z1(){
        String str = in.nextLine();
        String[] strs = str.split(" ");
        try {
            int[] mas = new int[strs.length];
        for (int i = 0; i < strs.length; i++) mas[i] = Integer.parseInt(strs[i]);
        decrypt(mas);
        }
        catch(Exception e){
            encrypt(str);
        }
    }
    public static void encrypt(String str)
    {
        int chcode = (int) str.charAt(0);
        int[] res = new int[str.length()];
        res[0] = chcode;
        System.out.print(res[0]+" ");
        for (int i = 1; i < str.length(); i++)
        {
            res[i] = (int)str.charAt(i) - chcode;
            chcode = (int)str.charAt(i);
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
    public static void decrypt(int[] mas)
    {
        int chcode = mas[0];
        String res = Character.toString((char)chcode);
        for (int i=1; i<mas.length; i++)
        {
            res+=(char)(chcode+mas[i]);
            chcode+=mas[i];
        }
        System.out.println(res);
    }

    public static void z2() {
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        String str3 = in.nextLine();
        System.out.println(canMove(str1,str2,str3));
    }
    public static boolean canMove(String figura, String start, String finish)
    {
        int chStart=(int)start.charAt(0);
        int chFinish=(int)finish.charAt(0);
        int numStart=(int) start.charAt(1);
        int numFinish=(int)finish.charAt(1);
        int numMove=Math.abs(numStart - numFinish);
        int chMove=Math.abs(chStart - chFinish);
        switch (figura){
        case "King":
            return (numMove == 1 || chMove == 1);
        case "Queen":
            return (numStart == numFinish || chStart == chFinish || numMove ==  chMove);
        case "Bishop":
            return (numMove == chMove);
        case "Knight":
            return ((chMove == 1 && numMove == 2)||(chMove == 2 && numMove == 1));
        case "Rook":
            return ((numStart == numFinish) || (chStart == chFinish));
        case "Pawns":
            return (numMove == 1);
        default:
            return false;
        }
    }

    public static void z3(){
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println(canComplete(str1,str2));
    }
    public static boolean canComplete(String chars, String word)
    {
        int ch=0;
        int wd=0;
        while (ch<chars.length() && wd<word.length())
        {
            if (chars.charAt(ch)==word.charAt(wd))
            {
                ch++;
            }
            wd++;
        }
        if (ch==chars.length())
            return true;
        else
            return false;
    }

    public static void z4(){
        String str = in.nextLine();
        String[] strs = str.split(" ");
        try {
            int[] mas = new int[strs.length];
            for (int i = 0; i < strs.length; i++) mas[i] = Integer.parseInt(strs[i]);
            sumDigProd(mas);
        }
        catch(Exception e){}
    }
    public static void sumDigProd(int[] mas)
    {
        int k=0;
        for (int i=0; i<mas.length;i++)
        {
            k+=mas[i];
        }
        while (k>10)
        {
            int temp=k;
            int res=1;
            while(temp>0)
            {
                res*=(temp%10);
                temp/=10;
            }
            k=res;
        }
        System.out.println(k);
    }
    public static void z5(){
        String str = in.nextLine();
        String[] words = str.split(" ");
        sameVowelGroup(words);
    }
    public static void sameVowelGroup(String[] words)
    {
        ArrayList<String> res= new ArrayList<String>();
        String glas1="";
        String ch1="";
        String ch2="";
        int k;
        for (int i=0; i<words[0].length();i++)
        {
            ch1=words[0].substring(i,i+1).toLowerCase();
            if (!glas1.contains(ch1) && "aouiey".contains(ch1))
            {
                glas1+=ch1;
            }
        }
        for (String word: words)
        {
            String glas2="";
            for (int i=0; i<word.length(); i++)
            {
                ch2= word.substring(i,i+1).toLowerCase();
                if ("aouiey".contains(ch2))
                    glas2+=ch2;
            }
            k=1;
            for (int i = 0; i < glas1.length(); i++)
                if (!glas2.contains(glas1.substring(i, i+1)))
                {
                    k=0;
                }
            for (int i = 0; i < glas2.length(); i++)
                if (!glas1.contains(glas2.substring(i, i+1)))
                {
                    k=0;
                }
            if (k==1)
                res.add(word);
        }
        System.out.println(res);
    }
    public static void z6(){
        long k=in.nextLong();
        System.out.println(validateCard(k));
    }
    public static boolean validateCard(long k)
    {
        String str= Long.toString(k);
        int res;
        int sum=0;
        int j=0;
        if (str.length()<14 || str.length()>19) return false;
        int index =Integer.parseInt(str.substring(str.length()-1));
        for (int i=str.length()-1; i>0 ;i--)
        {
            j++;
            int temp=Integer.parseInt(str.substring(i-1,i));
            if (j%2==0)
            {
                int doubletemp=temp*2;
            if (doubletemp > 9)
                temp = (doubletemp / 10) + (doubletemp % 10);
            else
                temp = doubletemp;
            }
                sum+=temp;
        }
        res=10-(sum % 10);
        return res==index;
    }
    public static void z7(){
        int k=in.nextInt();
        numToEng(k);
        numToRus(k);
    }
    public static void numToEng(int num)
    {
        String res="";
        String[] x={"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] xx={"zero", "ten","twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] xxx={"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen"};
        if (num==0) res="zero";
        if(num/100>0)
        {
            res+=x[num/100]+" hundred";
        }
        if((num%100)/10==1)
        {
            if (res.length() > 0) res += " ";
            res += xxx[(num%10)];
        }
        else if((num%100)/10>1)
        {
            if (res.length() > 0) res += " ";
            res += xx[(num%100)/10];
        }
        if((num%10>0) && ((num%100)/10!=1))
        {
            if (res.length() > 0) res += " ";
            res += x[num%10];
        }
    System.out.println("Eng: "+res);
    }
    public static void numToRus(int num)
    {
        String res="";
        String[] x={"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
        String[] xx={"ноль", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        String[] xxx={"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
                "шестнадцать", "семьнадцать", "восемьнадцать", "девятнадцать"};
        String[] xxxx={"ноль", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        if (num==0) res="ноль";
        if(num/100>0)
        {
            res+=xxxx[num/100];
        }
        if((num%100)/10==1)
        {
            if (res.length() > 0) res += " ";
            res += xxx[(num%10)];
        }
        else if((num%100)/10>1)
        {
            if (res.length() > 0) res += " ";
            res += xx[(num%100)/10];
        }
        if((num%10>0) && ((num%100)/10!=1))
        {
            if (res.length() > 0) res += " ";
            res += x[num%10];
        }
        System.out.println("Rus: "+res);
    }
    public static void z8(){
        String str = in.nextLine();
        getSha256Hash(str);
    }
    public static void getSha256Hash(String str)
    {

    }
    public static void z9(){}
    public static void z10(){}
}