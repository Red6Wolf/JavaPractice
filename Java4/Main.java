import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static String nonRepeatable(String str) {
        return str.isEmpty() ? "" : str.charAt(0) + nonRepeatable(str.replaceAll("[" + str.charAt(0) + "]", ""));
    }

    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        generateBracketsHelper(result, "", n, n);
        return result;
    }

    public static void generateBracketsHelper(List<String> result, String current, int open, int close) {
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }

        if (open > 0) {
            generateBracketsHelper(result, current + "(", open - 1, close);
        }
        if (close > open) {
            generateBracketsHelper(result, current + ")", open, close - 1);
        }
    }


    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        generateBinaryCombinations(result, "", n, -1);
        return result;
    }

    public static void generateBinaryCombinations(List<String> result, String current, int n, int lastDigit) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        if (lastDigit != 0) {
            generateBinaryCombinations(result, current + "0", n, 0);
        }

        generateBinaryCombinations(result, current + "1", n, 1);
    }

    public static String alphabeticRow(String str) {
        return Arrays.stream(str.split("(?<=(.))(?!\\1)"))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }
    public static String countAndSort(String str) {
        return str.replaceAll("(.)\\1*", "$1" + (str.length() > 1 ? str.length() : ""));
    }


    public static int convertToNum(String str) {
        Map<String, Integer> wordToNumber = new HashMap<>();
        wordToNumber.put("one", 1);
        wordToNumber.put("two", 2);
        wordToNumber.put("three", 3);
        wordToNumber.put("four", 4);
        wordToNumber.put("five", 5);
        wordToNumber.put("six", 6);
        wordToNumber.put("seven", 7);
        wordToNumber.put("eight", 8);
        wordToNumber.put("nine", 9);
        wordToNumber.put("ten", 10);
        wordToNumber.put("eleven", 11);
        wordToNumber.put("twelve", 12);
        wordToNumber.put("thirteen", 13);
        wordToNumber.put("fourteen", 14);
        wordToNumber.put("fifteen", 15);
        wordToNumber.put("sixteen", 16);
        wordToNumber.put("seventeen", 17);
        wordToNumber.put("eighteen", 18);
        wordToNumber.put("nineteen", 19);
        wordToNumber.put("twenty", 20);
        wordToNumber.put("thirty", 30);
        wordToNumber.put("forty", 40);
        wordToNumber.put("fifty", 50);
        wordToNumber.put("sixty", 60);
        wordToNumber.put("seventy", 70);
        wordToNumber.put("eighty", 80);
        wordToNumber.put("ninety", 90);
        wordToNumber.put("hundred", 100);
        wordToNumber.put("thousand", 1000);

        String[] words = str.split(" ");
        int result = 0;
        int currentNumber = 0;

        for (String word : words) {
            int num = wordToNumber.getOrDefault(word, 0);
            if (num == 100) {
                currentNumber *= num;
            } else if (num == 1000) {
                currentNumber = currentNumber * num + result;
                result = currentNumber;
                currentNumber = 0;
            } else {
                currentNumber += num;
            }
        }

        result += currentNumber;
        return result;
    }

    public static String uniqueSubstring(String input) {
        return IntStream.range(0, input.length())
                .mapToObj(i -> IntStream.range(i + 1, input.length() + 1)
                        .mapToObj(j -> input.substring(i, j))
                        .filter(s -> s.chars().distinct().count() == s.length())
                        .max(Comparator.comparing(String::length))
                        .orElse(""))
                .max(Comparator.comparing(String::length))
                .orElse("");
    }
    public static int shortestWay(int[][] grid) {
        int n = grid.length;
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[n - 1][n - 1];
    }

    public static String numericOrder(String input) {
        return Arrays.stream(input.split(" "))
                .sorted(Comparator.comparingInt(word -> Integer.parseInt(word.replaceAll("[^0-9]", ""))))
                .map(word -> word.replaceAll("[0-9]", ""))
                .collect(Collectors.joining(" "));
    }

    public static int switchNums(int num1, int num2) {
        return Integer.parseInt(String.valueOf(num2).chars()
                .mapToObj(c -> (char) c)
                .map(c -> num1 % 10 > c - '0' ? String.valueOf(num1 % 10) + c : String.valueOf(c))
                .collect(Collectors.joining()));
    }






    public static void main(String[] args) {

        //1
        System.out.println("1--------------------------------------");
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println(nonRepeatable("abracadabra"));


        //2
        System.out.println("2--------------------------------------");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));



        //3
        System.out.println("3--------------------------------------");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));

        //4
        System.out.println("4--------------------------------------");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));


        //5
        System.out.println("5--------------------------------------");
        System.out.println(countAndSort("aaabbcdd"));
        System.out.println(countAndSort("vvvvaajaaaaa"));


        //6
        System.out.println("6--------------------------------------");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));

        //7
        System.out.println("7--------------------------------------");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77807898"));

        //8
        System.out.println("8--------------------------------------");

            int[][] grid = {
                    {1, 3, 1},
                    {1, 5, 1},
                    {4, 2, 1}
            };

            int result = shortestWay(grid);
            System.out.println(result);


        //9
        System.out.println("9--------------------------------------");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));


        //10
        System.out.println("10--------------------------------------");

        int result1 = switchNums(519, 723);
        System.out.println(result1); // Вывод: 953

        int result2 = switchNums(491, 3912);
        System.out.println(result2); // Вывод: 9942

        int result3 = switchNums(6274, 71259);
        System.out.println(result3); // Вывод: 77659

    }
}