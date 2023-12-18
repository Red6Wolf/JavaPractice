import java.util.*;
import java.util.HashMap;
import java.util.Map;
public class Main {

    public static String hiddenAnagram(String str1, String str2) {
        String newString = str1.replaceAll("[^A-Za-z]", "");
        str2 = str2.replace(" ", "");
        newString = newString.toLowerCase();
        str2 = str2.toLowerCase();
        for (int i = 0; i <= newString.length() - str2.length(); i++) {
            String subStr = newString.substring(i, i + str2.length());
            char[] array1 = subStr.toCharArray();
            char[] array2 = str2.toCharArray();
            Arrays.sort(array1);
            Arrays.sort(array2);
            if (Arrays.equals(array1, array2)) return subStr;
        }
        return "notfound";
    }

    public static ArrayList<String> collect(String str, int n) {
        if (str.length() < n) return new ArrayList<String>();
        ArrayList<String> list = new ArrayList<>();
        list.add(str.substring(0, n));
        list.addAll(collect(str.substring(n), n));
        Collections.sort(list);
        return list;
    }

    public static String nicoCipher(String message, String key) {
        char[] keyArray = key.toCharArray();
        char[] sortedKeyArray = key.toCharArray();
        Arrays.sort(sortedKeyArray);
        int[] numChar = new int[key.length()];
        int i = 0;
        for (char symbol1: sortedKeyArray) {
            for (int j = 0; j < key.length(); j++) {
                if (symbol1 == keyArray[j]) {
                    numChar[i] = j;
                    keyArray[j] = '_';
                    i++;
                }
            }
        }

        int columns = key.length();
        int rows = (message.length() + columns - 1) / columns;
        char[] messageArray = message.toCharArray();
        StringBuilder answer = new StringBuilder();
        for (i = 0; i < rows; i++) {
            for (int j: numChar) {
                int num = i * columns + j;
                if (num < message.length()) {
                    answer.append(messageArray[num]);
                }
                else {
                    answer.append(" ");
                }
            }
        }
        return answer.toString();
    }

    public static int[] twoProduct(int[] nums, int n) {
        ArrayList<Integer> leftNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < leftNums.size(); j++) {
                if (leftNums.get(j) * nums[i] == n) {
                    return new int[]{leftNums.get(j), nums[i]};
                }
            }
            leftNums.add(nums[i]);
        }
        return new int[0];
    }
    public static int[] isExact(int n) {
        return isExactHelper(n, 1, 1);
    }

    public static int[] isExactHelper(int n, int current, int factorial) {
        if (n == factorial) {
            return new int[]{factorial, current};
        } else if (factorial > n) {
            return new int[]{};
        } else {
            return isExactHelper(n, current + 1, factorial * (current + 1));
        }
    }

    public static String fractions(String s) {
        if (s.isEmpty() || !s.contains("(") || !s.contains(")")) {
            return "Invalid input";
        }

        int nonRepeatingPartLength = s.indexOf('(') - s.indexOf('.') - 1;
        int repeatingPartLength = s.indexOf(')') - s.indexOf('(') - 1;

        if (nonRepeatingPartLength < 0 || repeatingPartLength < 0) {
            return "Invalid input";
        }

        String nonRepeatingPartStr = s.substring(s.indexOf('.') + 1, s.indexOf('('));
        int nonRepeatingPart = nonRepeatingPartStr.isEmpty() ? 0 : Integer.parseInt(nonRepeatingPartStr);

        int numerator = nonRepeatingPart;

        if (repeatingPartLength > 0) {
            String repeatingPartStr = s.substring(s.indexOf('(') + 1, s.indexOf(')'));
            int repeatingPart = repeatingPartStr.isEmpty() ? 0 : Integer.parseInt(repeatingPartStr);
            numerator = numerator * ((int) (Math.pow(10, repeatingPartLength)) - 1) + repeatingPart;
        }

        int denominator = (int) Math.pow(10, nonRepeatingPartLength + repeatingPartLength) -
                (int) Math.pow(10, nonRepeatingPartLength);

        int gcdValue = findGCD(numerator, denominator);
        numerator /= gcdValue;
        denominator /= gcdValue;

        return numerator + "/" + denominator;
    }

    // Helper method to find the greatest common divisor
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public static String pilish_string(String str) {
        if (str.isEmpty()) return "";

        double pi = 3.14159265358979;
        int[] piNums = new int[15];
        int i = 0;
        for (char number: Double.toString(pi).toCharArray()) {
            if (number != '.') {
                piNums[i] = Character.getNumericValue(number);
                i++;
            }
        }

        StringBuilder answer = new StringBuilder();
        int nowSymbols = 0;
        i = 0;
        while (nowSymbols < str.length()) {
            if (i == 15) break;
            if (nowSymbols + piNums[i] > str.length()) {
                answer.append(str, nowSymbols, str.length());
            }
            else {
                answer.append(str, nowSymbols, nowSymbols + piNums[i]);
            }
            nowSymbols += piNums[i];
            i++;
            if (nowSymbols < str.length()) answer.append(" ");
        }
        if (nowSymbols > str.length()) {
            while (nowSymbols != str.length()) {
                answer.append(str.substring(str.length() - 1));
                nowSymbols -= 1;
            }
        }
        return answer.toString();
    }

    public static int generateNonconsecutive(String str) {
        String operations = "+-/*";
        str = str.replaceAll("\\(", "( ");
        str = str.replaceAll("\\)", " )");
        String[] strArray = str.split("\\s+");
        // Красивый показ (на защиту)
        //System.out.println(Arrays.toString(strArray));
        boolean lastNum = false;
        String now;
        int bracketCounter = 0;
        int openBrackets = 0;

        // Обработка ислючений
        for (int i = 0; i < strArray.length; i++) {
            now = strArray[i];
            if (operations.contains(now)) {
                if ((i == 0 || i == strArray.length - 1)) {
                    System.out.println("Неверный формат ввода (начинается или заканичивается операцией)");
                    return 0;
                }
                if (!lastNum) {
                    System.out.println("Неверный формат ввода (две операции подряд или ошибка у скобок)");
                    return 0;
                }
                lastNum = false;
            }
            else if (now.equals("(")) {
                openBrackets += 1;
                bracketCounter += 1;
            }
            else if (now.equals(")")) {
                openBrackets -= 1;
                if (openBrackets < 0) {
                    System.out.println("Неверный формат ввода (неправильный порядок скобок)");
                    return 0;
                }
            }
            else if (now.matches("-?\\d+")) {
                if (lastNum) {
                    System.out.println("Неверный формат ввода (два числа подряд или ошибка у скобок)");
                    return 0;
                }
                lastNum = true;
            }
            else {
                System.out.println("Неверный формат ввода (встречается неизвестная подстрока)");
                return 0;
            }
        }
        if (openBrackets != 0) {
            System.out.println("Неверный формат ввода (неправильный порядок скобок)");
            return 0;
        }

        // Простой случай операции
        if (strArray.length == 3) {
            switch (strArray[1]) {
                case "+" -> {
                    return Integer.parseInt(strArray[0]) + Integer.parseInt(strArray[2]);
                }
                case "-" -> {
                    return Integer.parseInt(strArray[0]) - Integer.parseInt(strArray[2]);
                }
                case "*" -> {
                    return Integer.parseInt(strArray[0]) * Integer.parseInt(strArray[2]);
                }
                case "/" -> {
                    try {
                        return Integer.parseInt(strArray[0]) / Integer.parseInt(strArray[2]);
                    }
                    catch (ArithmeticException e) {
                        System.out.println("Ошибка: В строке происходит деление на ноль");
                        return 0;
                    }
                }
            }
        }
        // Разбиение на простые случаи
        else {
            // Учитывание скобок
            if (bracketCounter != 0) {
                int firstBracket = -1;
                int secondBracket = -1;
                // Ищем скобки
                for (int i = 0; i < strArray.length; i++) {
                    now = strArray[i];
                    if (now.equals("(") && firstBracket == -1) firstBracket = i;
                    if (now.equals(")")) secondBracket = i;
                }

                // Создаем новую строку, учитывая скобки
                String newStr = "";
                if (firstBracket != 0) {
                    newStr += String.join(" ", Arrays.copyOfRange(strArray, 0, firstBracket)) + " ";
                }
                newStr += (generateNonconsecutive(
                        String.join(" ",
                                Arrays.copyOfRange(strArray, firstBracket + 1, secondBracket))
                ));
                if (secondBracket != strArray.length) {
                    newStr += " " +
                            String.join(" ",
                                    Arrays.copyOfRange(strArray, secondBracket + 1, strArray.length));
                }
                return generateNonconsecutive(newStr);
            }
            // Сокращение через базовые операции
            else {
                int operationIndex = -1;
                boolean higher = false;
                for (int i = 0; i < strArray.length; i++) {
                    now = strArray[i];
                    if ("+-".contains(now) && operationIndex == -1) operationIndex = i;
                    if ("*/".contains(now) && !higher) {
                        operationIndex = i;
                        higher = true;
                    }
                }
                // Построение новой строки
                String newStr = "";
                if (operationIndex != 1) {
                    newStr += String.join(" ",
                            Arrays.copyOfRange(strArray, 0, operationIndex - 1)) + " ";
                }
                newStr += (generateNonconsecutive(
                        String.join(" ",
                                Arrays.copyOfRange(strArray, operationIndex - 1, operationIndex + 2))
                ));
                if (openBrackets != strArray.length - 1) {
                    newStr += " " +
                            String.join(" ",
                                    Arrays.copyOfRange(strArray, operationIndex + 2, strArray.length));
                }
                return generateNonconsecutive(newStr);
            }
        }
        // Вывод 0, чтобы компилятор пропустил
        return 0;
    }

    public static String isValid(String str) {
        Map<Character, Integer> dictionary = new HashMap<>();
        int unique = 0;
        for (char symbol: str.toCharArray()) {
            if (dictionary.containsKey(symbol)) {
                dictionary.put(symbol, dictionary.get(symbol) + 1);
            }
            else {
                dictionary.put(symbol, 1);
                unique += 1;
            }
        }

        int[] values = new int[unique];
        int i = 0;
        for(int value: dictionary.values()) {
            values[i] = value;
            i++;
        }

        Arrays.sort(values);
        if (values[0] == values[values.length - 1]) {
            return "YES";
        }
        else if (values[1] == values[values.length - 1] && values[0] == 1) {
            return "YES";
        }
        else if (values[0] == values[values.length - 2] && values[values.length - 1] - 1 == values[0]) {
            return "YES";
        }
        return "NO";
    }

    public static String findLCS(String str1, String str2) {
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
        for (int j = 0; j <= str2.length(); j++) {
            matrix[0][j] = 0;
        }
        for (int i = 0; i <= str1.length(); i++) {
            matrix[i][0] = 0;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }
                else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                }
            }
        }
        ArrayList<Character> chars = new ArrayList<>();
        int temp_i = str1.length() - 1;
        int temp_j = str2.length() - 1;
        while (temp_i >= 0 && temp_j >= 0) {
            if (str1.charAt(temp_i) == str2.charAt(temp_j)) {
                chars.add(str1.charAt(temp_i));
                temp_i -= 1;
                temp_j -= 1;
            }
            else if (matrix[temp_i][temp_j + 1] >= matrix[temp_i + 1][temp_j]) {
                temp_i -= 1;
            }
            else {
                temp_j -= 1;
            }
        }
        Collections.reverse(chars);
        StringBuilder answer = new StringBuilder();
        String test = "sdd";
        String test1 = "sd";
        for (char symbol: test.toCharArray()) {
            if (test1.contains(Character.toString(symbol))) {
                System.out.println("sdasda");
            }
        }
        for (char c: chars) {
            answer.append(c);
        }
        return answer.toString();
    }

    public static void findLCS(String[] args) {
        String str1 = "abcd";
        String str2 = "bd";
        System.out.println(findLCS(str1, str2)); // Output: bd

        String str3 = "aggtab";
        String str4 = "gxtxamb";
        System.out.println(findLCS(str3, str4)); // Output: gtab
    }




    public static void main(String[] args) {

        System.out.println("1--------------------------------------");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));



        System.out.println("2--------------------------------------");
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3) );
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));


        System.out.println("3--------------------------------------");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));



        System.out.println("4--------------------------------------");
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1,  2, -1,  4,  5,  6,  10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));


        System.out.println("5--------------------------------------");
        int[] numbers = {6, 24, 125, 720, 1024, 40320};

        for (int num : numbers) {
            int[] result = isExact(num);
            if (result.length == 0) {
                System.out.println(num + " ➞ []");
            } else {
                System.out.println(num + " ➞ " + Arrays.toString(result));
            }
        }



        System.out.println("6--------------------------------------");
        System.out.println(fractions("0.(6)")); // Output: 2/3
        System.out.println(fractions("1.(1)")); // Output: 10/9
        System.out.println(fractions("3.(142857)")); // Output: 22/7
        System.out.println(fractions("0.19(2367)")); // Output: 5343/27775
        System.out.println(fractions("0.1097(3)")); // Output: 823/7500


        System.out.println("7--------------------------------------");
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println(pilish_string("CANIMAKEAGUESSNOW"));
        System.out.println(pilish_string("FORALOOP"));
        System.out.println(pilish_string("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMME" +
                "CHANICSANDALLTHESECRETSOFTHEUNIVERSE"));

        System.out.println("8--------------------------------------");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));


        System.out.println("9--------------------------------------");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));


        System.out.println("10--------------------------------------");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb") );

    }
}