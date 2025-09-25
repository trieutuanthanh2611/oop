public class UseThree {
    public static void main(String[] args) {
      
        if (args.length != 3) {
            System.out.println("Cách dùng: java UseThree <tên1> <tên2> <tên3>");
            return;
        }

        String ten1 = args[0];
        String ten2 = args[1];
        String ten3 = args[2];

        System.out.println("Hi " + ten3 + ", " + ten2 + ", and " + ten1 + ".");
    }
}
