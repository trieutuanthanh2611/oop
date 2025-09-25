import java.util.Scanner;

public class UseThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên thứ nhất: ");
        String name1 = sc.nextLine();

        System.out.print("Nhập tên thứ hai: ");
        String name2 = sc.nextLine();

        System.out.print("Nhập tên thứ ba: ");
        String name3 = sc.nextLine();

        System.out.println("Hi " + name3 + ", " + name2 + ", and " + name1 + ".");
        
    }
}
