public class RollLoadedDie {
    public static void main(String[] args) {

        double r = Math.random();

        int result;

        if (r < 0.125) {
            result = 1;
        } else if (r < 0.25) {
            result = 2;
        } else if (r < 0.375) {
            result = 3;
        } else if (r < 0.5) {
            result = 4;
        } else if (r < 0.625) {
            result = 5;
        } else {
            result = 6;
        }

        System.out.println("Kết quả gieo xúc xắc: " + result);
    }
}
