import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students: ");
        int n = sc.nextInt();

        float[] marks = new float[n];
        float sum = 0;
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;
        System.out.println("input marks out of 500:");
        for (int i = 0; i < n; i++) {
            int c = i + 1;
            System.out.println("Enter marks of student " + c + ":");
            marks[i] = sc.nextFloat();
            sum += marks[i];
            if (marks[i] > 500) {
                System.out.println("Your input is invalid. Try again.");
                return; // Exit the program if input is invalid
            }
            if (marks[i] > max) {
                max = marks[i];
            }
            if (marks[i] < min) {
                min = marks[i];
            }
        }

        float avg = sum / n;

        System.out.println("Average marks of students: " + avg);
        System.out.println("Lowest marks: " + min);
        System.out.println("Highest marks: " + max);
    }
}
