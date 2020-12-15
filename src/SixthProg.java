import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SixthProg {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1:"); for (int i = 0; i < 3; i++) z1();
        System.out.println("2:"); for (int i = 0; i < 6; i++) z2();
        System.out.println("3:"); for (int i = 0; i < 4; i++) z3();
        System.out.println("4:"); for (int i = 0; i < 3; i++) z4();
        System.out.println("5:"); for (int i = 0; i < 4; i++) z5();
        System.out.println("6:"); for (int i = 0; i < 3; i++) z6();
        System.out.println("7:"); for (int i = 0; i < 4; i++) z7();
        System.out.println("8:"); for (int i = 0; i < 3; i++) z8();
        System.out.println("9:"); for (int i = 0; i < 4; i++) z9();
        System.out.println("10:"); for (int i = 0; i < 4; i++) z10();
    }

    public static void z1() {
        int n=in.nextInt();
        bell(n);
    }
    public static void bell(int n){
        int[][] mas = new int[n+1][n+1];
        mas[0][0] = 1;

        for (int i=1; i <= n; i++)
        {
            mas[i][0] = mas[i-1][i-1];
            for (int j=1; j<=i; j++)
                mas[i][j] = mas[i-1][j-1] + mas[i][j-1];
        }
        System.out.println(mas[n][0]);
    }

    public static void z2() {
        String str = in.nextLine();
        translateSentence(str);
    }
    public static String translateWord(String str)
    {
        if("aoueiy".contains(str.substring(0, 1).toLowerCase()))
        {
            return str + "yay";
        }
        else
        {
            while(!"aoueiy".contains(str.substring(0, 1).toLowerCase()))
            {
                if (Character.isUpperCase(str.charAt(0)))
                    str = str.substring(1,2).toUpperCase() + str.substring(2) + str.substring(0,1).toLowerCase();
                else
                    str = str.substring(1) + str.substring(0,1);
            }
            return str + "ay";
        }
    }
    public static void translateSentence(String str)
    {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(str);
        int i = 0;
        while (m.find())
        {
            String word = m.group();
            i = str.indexOf(word, i);
            str = str.substring(0, i) + str.substring(i).replaceFirst(word, translateWord(word));
        }
        System.out.println(str);
    }


    public static void z3() {
        String str = in.nextLine();
        System.out.println(validColor(str));
    }
    public static boolean validColor(String str)
    {
        str = str.toLowerCase();
        if (str.charAt(str.length() - 1) != ')') return false;
        if (str.substring(0, 4).contentEquals("rgb(") || str.substring(0, 5).contentEquals("rgba("))
        {
            String[] coln = null;
            if(str.charAt(3) == 'a')
                coln = str.substring(5, str.length()-1).split(",");
            else
                coln = str.substring(4, str.length()-1).split(",");
            if (coln.length < 3 || coln.length > 4) return false;
            for (int i = 0; i < 3; i++)
            {
                try
                {
                    int num = Integer.parseInt(coln[i]);
                    if (num < 0 || num > 255) return false;
                }
                catch (NumberFormatException e)
                {
                    return false;
                }
            }
            if (coln.length == 4)
            {
                try
                {
                    double numd = Double.parseDouble(coln[3]);
                    if (numd < 0 || numd > 1) return false;
                }
                catch(NumberFormatException e)
                {
                    return false;
                }
            }
            return true;
        }
        else return false;
    }

    public static void z4()
    {
        System.out.println("Cтрока - 1, Строка и параметры - 2");
        int cmd = in.nextInt();
        String input = in.nextLine();
        String[] params = null;
        params = in.nextLine().split(" ");
        if(cmd == 1)
        {
            System.out.println(stripUrlParams(input));
        }
        else
            {
                System.out.println(stripUrlParams(input, params));
            }
    }

    public static String stripUrlParams(String str)
    {
        int questionMarkIndex = str.indexOf("?");
        if (questionMarkIndex == -1) return str;
        String[] params = str.substring(questionMarkIndex + 1).split("&");
        String res = str.substring(0, questionMarkIndex);
        String paramsResult = "";
        for (int i = 0; i < params.length; i++)
        {
            String paramName = params[i].substring(0, params[i].indexOf("="));
            String paramValue = params[i].substring(params[i].indexOf("=") + 1);
            boolean foundEarlier = false;
            for (int j = 0; j < i; j++)
            {
                String earlierParamName = params[j].substring(0, params[j].indexOf("="));
                if(paramName.contentEquals(earlierParamName))
                {
                    foundEarlier = true;
                    break;
                }
            }
            if (foundEarlier) continue;
            for (int j = i + 1; j < params.length; j++)
            {
                String laterParamName = params[j].substring(0, params[j].indexOf("="));
                if(paramName.contentEquals(laterParamName))
                {
                    paramValue = params[j].substring(params[j].indexOf("=") + 1);
                }
            }

            if (paramsResult.length() > 0) paramsResult += "&";
            paramsResult += paramName + "=" + paramValue;
        }
        if (paramsResult.length() > 0)
        {
            res += "?" + paramsResult;
        }
        return res;
    }

    public static String stripUrlParams(String str, String[] param)
    {
        int questionMarkIndex = str.indexOf("?");
        if (questionMarkIndex == -1) return str;
        String[] params = str.substring(questionMarkIndex + 1).split("&");
        String res = str.substring(0, questionMarkIndex);
        String paramsResult = "";
        for (int i = 0; i < params.length; i++)
        {
            String paramName = params[i].substring(0, params[i].indexOf("="));
            String paramValue = params[i].substring(params[i].indexOf("=") + 1);
            boolean foundEarlier = false;
            for (int j = 0; j < i; j++)
            {
                String earlierParamName = params[j].substring(0, params[j].indexOf("="));
                if(paramName.contentEquals(earlierParamName))
                {
                    foundEarlier = true;
                    break;
                }
            }
            if (foundEarlier) continue;
            for (int j = i + 1; j < params.length; j++)
            {
                String laterParamName = params[j].substring(0, params[j].indexOf("="));
                if(paramName.contentEquals(laterParamName))
                {
                    paramValue = params[j].substring(params[j].indexOf("=") + 1);
                }
            }
            boolean foundInParamsToStrip = false;
            for (int j = 0; j < param.length; j++)
            {
                if (param[j].contentEquals(paramName))
                {
                    foundInParamsToStrip = true;
                    break;
                }
            }
            if (!foundInParamsToStrip)
            {
                if (paramsResult.length() > 0) paramsResult += "&";
                paramsResult += paramName + "=" + paramValue;
            }
        }

        if (paramsResult.length() > 0)
        {
            res += "?" + paramsResult;
        }
        return res;
    }


    public static void z5() {
        String str = in.nextLine();
        getHashTags(str);
    }
    public static void getHashTags(String str)
    {
        str = str.toLowerCase();
        String[] words = str.split("\\W");
        String fst = "";
        String snd = "";
        String trd = "";
        for (int i = 0; i < words.length; i++)
        {
            if (words[i].length() > fst.length())
            {
                trd = snd;
                snd = fst;
                fst = words[i];
            }
            else if (words[i].length() > snd.length())
            {
                trd = snd;
                snd = words[i];
            }
            else if (words[i].length() > trd.length())
            {
                trd = words[i];
            }
        }
        String[] res = null;
        if (fst.length() == 0) res = new String[0];
        else if (snd.length() == 0) res = new String[1];
        else if (trd.length() == 0) res = new String[2];
        else res= new String[3];

        if (res.length > 0) res[0] = fst;
        if (res.length > 1) res[1] = snd;
        if (res.length > 2) res[2] = trd;

        for (int i = 0; i < res.length; i++)
        {
            res[i] = "#" + res[i];
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    public static void z6() {
        int n=in.nextInt();
        ulam(n);
    }
    public static void ulam(int n)
    {
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(1);
        sequence.add(2);

        int number = 2;
        for (int i = 2; i < n; i++)
        {
            while (true)
            {
                number++;
                int count = 0;
                for (int j = 0; j < sequence.size() - 1; j++)
                {
                    for (int k = j + 1; k < sequence.size(); k++)
                    {
                        if (sequence.get(j) + sequence.get(k) == number)
                            count++;
                    }
                }
                if (count == 1)
                {
                    sequence.add(number);
                    break;
                }
            }
        }
        System.out.println(sequence.get(n - 1));
    }

    public static void z7() {
        String str = in.nextLine();
        longestNonrepeatingSubstring(str);
    }
    public static void longestNonrepeatingSubstring(String str)
    {
        String st = "";
        String ch = "";
        for (int i = 0; i < str.length(); i++)
        {
            if(!ch.contains(str.substring(i, i+1)))
            {
                ch += str.substring(i, i+1);
            }
            else
            {
                if (ch.length() > st.length())
                    st = ch;
                ch = "";
            }
        }
        if (ch.length() > st.length())
            st = ch;
        System.out.println(st);
    }


    public static void z8() {
        int n=in.nextInt();
        System.out.println(convertToRoman(n));
    }
    public static String convertToRoman(int n)
    {
        TreeMap<Integer, String> num = new TreeMap<Integer, String>();
        num.put(1, "I"); num.put(4, "IV"); num.put(5, "V"); num.put(9, "IX");
        num.put(10, "X"); num.put(40, "XL"); num.put(50, "L"); num.put(90, "XC");
        num.put(100, "C"); num.put(400, "CD"); num.put(500, "D"); num.put(900, "CM");
        num.put(1000, "M");

        int k = num.floorKey(n);
        if (k == n) return num.get(k);
        else return num.get(k) + convertToRoman(n - k);
    }

    public static void z9() {
        String str= in.nextLine();
        formula(str);
    }
    public static double umnog(String str)
    {
        double res = 1;
        String currentNumber = "";
        boolean multiplying = true;
        for (int i = 0; i < str.length(); i++)
        {
            if ("*/".contains(str.substring(i,i+1)))
            {
                if (currentNumber.length() > 0)
                {
                    if (multiplying) res *= Double.parseDouble(currentNumber);
                    else res /= Double.parseDouble(currentNumber);
                }
                currentNumber = "";
                multiplying = (str.charAt(i) == '*');
            }
            else
            {
                currentNumber += str.substring(i,i+1);
            }
        }
        if (multiplying) res *= Double.parseDouble(currentNumber);
        else res /= Double.parseDouble(currentNumber);
        return res;
    }

    public static double addition(String str)
    {
        double res = 0;
        String currentNumber = "";
        if (!"+-".contains(str.substring(0, 1)))
            currentNumber = "+";
        for (int i = 0; i < str.length(); i++)
        {
            if ("+-".contains(str.substring(i,i+1)))
            {
                if (currentNumber.length() > 0) res += umnog(currentNumber);
                currentNumber = str.substring(i,i+1);
            }
            else
            {
                currentNumber += str.substring(i,i+1);
            }
        }
        res += umnog(currentNumber);
        return res;
    }

    public static void formula(String str)
    {
        String res="true";
        str = str.replace(" ", "");
        String[] equalities = str.split("=");
        double value = 0;
        if (equalities.length > 0) value = addition(equalities[0]);
        for (int i = 1; i < equalities.length; i++)
        {
            if (value != addition(equalities[i])) res= "false";
        }
        System.out.println(res);
    }

    public static void z10() {
        int n = in.nextInt();
        System.out.println(palindromeDescendant(n));
    }

    public static boolean palindromeDescendant(int n)
    {
        String str = Integer.toString(n);
        while (str.length() > 1)
        {
            if (palindrom(str)) return true;
            String k = "";
            for (int i = 0; i < str.length() / 2; i++)
            {
                k += Integer.toString(Integer.parseInt(str.substring(i*2, i*2+1))
                        + Integer.parseInt(str.substring(i*2+1, i*2+2)));
            }
            str = k;
        }
        return false;
    }
    public static boolean palindrom(String str)
    {
        for (int i = 0; i < str.length() / 2; i++)
        {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }
}