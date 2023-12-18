import java.util.*;

public class Main {

    //1
    public static String replaceVowels(String input) {
        return input.replaceAll("[AEIOUaeiou]", "*");
    }

    //2
    public static String stringTransform(String input) {
        return input.replaceAll("(.)\\1", "Double$1");
    }

    //3
    public static boolean doesBlockkFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) || (b <= w && c <= h) || (b <= h && c <= w) || (a <= w && c <= h) || (a <= h && c <= w);
    }

    //4
    public static boolean numCheck(int num) {
        int sumOfSquares = 0;
        int originalNum = num;

        while (num > 0) {
            int digit = num % 10;
            sumOfSquares += digit * digit;
            num /= 10;
        }

        return originalNum % 2 == sumOfSquares % 2;
    }

    //5
    public static int countRoots(int[] coefficients) {
        int a = coefficients[0];
        int b = coefficients[1];
        int c = coefficients[2];

        int discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            return 2;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //6

    //7
    public static boolean validSplit(String sentence) {
        String[] words = sentence.split(" ");

        if (words.length < 2) {
            return false;
        }

        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String currentWord = words[i];

            if (prevWord.charAt(prevWord.length() - 1) != currentWord.charAt(0)) {
                return false;
            }
        }

        return true;
    }

    //8
    public static boolean isWaveForm(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true; // Массив из 0 или 1 элемента считается "волнообразным".
        }

        boolean increasing = arr[0] < arr[1];

        for (int i = 1; i < arr.length; i++) {
            if ((increasing && arr[i - 1] >= arr[i]) || (!increasing && arr[i - 1] <= arr[i])) {
                return false; // Не соответствует условию "волнообразности".
            }
            increasing = !increasing; // Меняем направление.
        }


        return true;
    }

    //9
    public static char commonVowel(String sentence) {
        sentence = sentence.replaceAll("[^aeiouAEIOU]", ""); // Удаляем все символы, кроме гласных
        int[] counts = new int[256]; // Создаем массив для подсчета частоты встречи символов

        for (char c : sentence.toCharArray()) {
            counts[c]++;
        }

        char mostCommonVowel = ' ';
        int maxCount = 0;

        for (char c : "aeiouAEIOU".toCharArray()) {
            if (counts[c] > maxCount) {
                maxCount = counts[c];
                mostCommonVowel = c;
            }
        }

        return mostCommonVowel;
    }

    //10
    public static int[][] dataScience(int[][] matrix) {
        int n = matrix.length;
        int[][] resultMatrix = new int[n][n];

        // Вычисляем среднее арифметическое для каждого столбца
        for (int col = 0; col < n; col++) {
            int sum = 0;
            for (int row = 0; row < n; row++) {
                sum += matrix[row][col];
            }
            int average = sum / n;

            // Изменяем n-ый элемент n-го массива на среднее значение
            resultMatrix[n - 1][col] = average;
        }

        // Копируем остальные элементы из исходной матрицы
        for (int row = 0; row < n - 1; row++) {
            for (int col = 0; col < n; col++) {
                resultMatrix[row][col] = matrix[row][col];
            }
        }

        return resultMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        //1
        System.out.println("1--------------------------------------");
        System.out.println(replaceVowels("apple"));
        System.out.println(replaceVowels("Even if you did this task not by yourself, you have to understand every single line of code."));


        //2
        System.out.println("2--------------------------------------");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));

        //3
        System.out.println("3--------------------------------------");
        System.out.println(doesBlockkFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockkFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockkFit(1, 2, 2, 1, 1));

        //4
        System.out.println("4--------------------------------------");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));

        //5
        System.out.println("5--------------------------------------");
        System.out.println(countRoots(new int[]{1, -3, 2}));
        System.out.println(countRoots(new int[]{2, 5, 2}));
        System.out.println(countRoots(new int[]{1, -6, 9}));

        //6
        System.out.println("6--------------------------------------");

        //7
        System.out.println("7--------------------------------------");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));

        //8
        System.out.println("8--------------------------------------");
        int[] arr1 = {3, 1, 4, 2, 7, 5};
        System.out.println(isWaveForm(arr1));

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(isWaveForm(arr2));

        int[] arr3 = {1, 2, -6, 10, 3};
        System.out.println(isWaveForm(arr3));

        //9
        System.out.println("9--------------------------------------");
        System.out.println(commonVowel("Hello world"));

        //10
        int[][] inputMatrix1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        };

        int[][] inputMatrix2 = {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        };

        int[][] resultMatrix1 = dataScience(inputMatrix1);
        int[][] resultMatrix2 = dataScience(inputMatrix2);

        // Выводим результаты
        printMatrix(resultMatrix1);
        System.out.println();
        printMatrix(resultMatrix2);
    }
}
