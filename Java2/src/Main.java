import java.util.Arrays;

public class Main {
    //1
    public static boolean duplicateChars(String str) {
        return str.chars().distinct().count() != str.length();
    }
    //2
    public static String getInitials(String fullName){
        return fullName.replaceAll("\\b(\\w)\\w*\\s*", "$1");
    }
    //3
    public static int differenceEvenOdd(int[] array){
        return java.util.Arrays.stream(array).reduce(0, (sum, num) -> sum + (num % 2 == 0 ? num : -num));
    }
    //4
    public static boolean equalToAvg(int[] array){
        return java.util.Arrays.stream(array).anyMatch(x -> x == Arrays.stream(array).average().orElse(0));
    }
    //5
    public static int[] indexMult(int[] array) {
        return java.util.stream.IntStream.range(0, array.length).map(i -> array[i] * i).toArray();
    }
    //6
    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
    //7
    public static int Tribonacci(int n) {
        int j = 0; int a = 0; int b = 0; int c = 1; int timer = n;
        if ( n== 0 || n == 1 || n ==2){return 0;} else if (n == 3) { return 1;} else {
            for (int i = 3; i < timer;) {
                if (j == 0){j = 1; a = a + b + c; n = a;}
                else if ( j == 1){j = 2; b = a + b + c; n = b;}
                else if ( j == 2){ j = 0; c = a + b + c; n = c;}
                i++;
            }
        }
        return n;
    }

    //8
    public static String pseudoHash(int length) {
        return length <= 0 ? "" : java.util.UUID.randomUUID().toString().replaceAll("-", "").substring(0, length);
    }
    //9
    public static String botHelper(String transcript) {
        return transcript.matches("(?i).*\\bhelp\\b.*") ? "Calling for a staff member" : "Keep waiting";
    }

    //10
    public static boolean isAnagram(String str1, String str2) {
        return str1.length() == str2.length() && str1.chars().sum() == str2.chars().sum();
    }


    //1
    public static void main(String[] args) {
        System.out.println("1--------------------------------------");
        System.out.println(duplicateChars("Donald")); // false
        System.out.println(duplicateChars("Orange")); // false

    //2
        System.out.println("2--------------------------------------");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));

    //3
        System.out.println("3--------------------------------------");
        System.out.println(differenceEvenOdd(new int[]{44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55}));

    //4
        System.out.println("4--------------------------------------");
        System.out.println(equalToAvg(new int[]{1,2,3,4,5}));
        System.out.println(equalToAvg(new int[]{1,2,3,4,6}));

    //5
        System.out.println("5--------------------------------------");
        System.out.println(Arrays.toString(indexMult(new int[]{1,2,3})));
        System.out.println(Arrays.toString(indexMult(new int[]{3,3,-2,408,3,31})));

        //6
        System.out.println("6--------------------------------------");
        System.out.println(reverse("Hello world"));
        System.out.println(reverse("The quick brown fox"));

        //7
        System.out.println("7--------------------------------------");
        int n1 = Tribonacci(7);
        int n2 = Tribonacci(11);
        System.out.println(n1); // Выведет 7
        System.out.println(n2);

        //8
        System.out.println("8--------------------------------------");
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));

        //9
        System.out.println("9--------------------------------------");
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));

        //10
        System.out.println("10--------------------------------------");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));


    }

}
