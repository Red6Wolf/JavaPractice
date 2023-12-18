public class Main {
    public static double convert(int gallons) {
        // 1 галлон равен приблизительно 3.78541 литрам
        return gallons * 3.78541;
    }
    //2
    public static double fitCalc(int minutes, int intensity) {
        return minutes * switch (intensity) { case 1 -> 5; case 2 -> 7; case 3 -> 10; default -> 0; };
    }

//3

    public static int containers(int boxes, int bags, int barrels) {
        return boxes * 20 + bags * 50 + barrels * 100;
    }

    //4
    public static String coordination(int x, int y, int z) {
        if (x <= 0 || y <= 0 || z <= 0 || x + y <= z || x + z <= y || y + z <= x) {
            return ("Не является треугольником");
        }
        else if (x == y && y == z) {
            return ("Равносторонний");
        }
        else if (x == y || y == z || x == z){
            return ("Равнобедренный");
        }
        else {
            return ("Разносторонним");
        }
    }
    //5
    public static int aorb(int a, int b) {
        int result = (a > b) ? a : b;
        return result;
    }
    //6
    public static int howManyItems(double n, double w, double h) {
        return (int)(n * 2 / (w * h));
    }

//7

    public static long factorial(int n) {
        return n == 0 ? 1 : n * factorial(n-1);
    }

    //8
    public static int gcd(int a, int b) {
        return b== 0 ? a : gcd(b,a % b);
    }

    //9
    public static int ticketSaler(int numberOftickets, int ticketPrice) {
        return numberOftickets * (ticketPrice - 666);
    }

//10

    public static int tables(int students, int tables) {
        return Math.max(0, (students - tables * 2 + 1)/ 2);
    }
    public static void main(String[] args) {
        System.out.println("5 галлонов равно " + convert(5) + " литрам.");
        System.out.println("3 галлона равно " + convert(3) + " литрам.");
        System.out.println("8 галлонов равно " + convert(8) + " литрам.");
        System.out.println("1---------------------");
//2
        int minutes1 = 15;
        int intensity1 = 1;
        System.out.println("fitCalc(" + minutes1 + "," + intensity1 + ") - " + fitCalc(minutes1, intensity1) + " калорий.");

        int minutes2 = 24;
        int intensity2 = 2;
        System.out.println("fitCalc(" + minutes2 + "," + intensity2 + ") - " + fitCalc(minutes2, intensity2) + " калорий.");

        int minutes3 = 41;
        int intensity3 = 3;
        System.out.println("fitCalc(" + minutes3 + "," + intensity3 + ") - " + fitCalc(minutes3, intensity3) + " калорий.");
        System.out.println("2---------------------");

//3
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        System.out.println("3---------------------");

//4
        System.out.println(coordination(5, 5, 5));
        System.out.println(coordination(5, 4, 5));
        System.out.println(coordination(3, 4, 5));
        System.out.println(coordination(5, 1, 1));
        System.out.println("4---------------------");

//5
        System.out.println(aorb(8, 4));
        System.out.println(aorb(1, 11));
        System.out.println(aorb(5, 9));
        System.out.println("5---------------------");

//6
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));
        System.out.println("6---------------------");

//7
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println("7---------------------");

//8
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println("8---------------------");

//9
        System.out.println(ticketSaler(70,1500));
        System.out.println(ticketSaler(24,950));
        System.out.println(ticketSaler(53,1250));
        System.out.println("9---------------------");

//10
        System.out.println(tables(5,2));
        System.out.println(tables(31,20));
        System.out.println(tables(123,58));
        System.out.println("10---------------------");
    }


}
