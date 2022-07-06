import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        String str = null;
        int repeat = 1000;
        System.out.print("Please, enter a string: ");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
           str = br.readLine();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println(str);
        System.out.println(reverseString(str));
        while (repeat <= 100000) {
            LocalTime start = LocalTime.now();
            for (int i = 0; i < repeat; i++) {
                reverseString(str);
            }
            LocalTime end = LocalTime.now();
            System.out.println(Duration.between(start, end).toMillis() + " ms");
            repeat *= 10;
        }
    }

    private static String reverseString(String string) {
        return String.valueOf(new StringBuilder(string).reverse());
    }
}
