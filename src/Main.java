import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        game();
    }

    public static void game() throws IOException {
        int best = 100;
        int count = 0;
        Random rand = new Random();
        int number = rand.nextInt(0, 101);
        String numberString = Integer.toString(number);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (input != numberString) {
            input = reader.readLine();
            count ++;
            if (Integer.parseInt(input) < number) {
                System.out.println("Я сам в шоке, но загаданное число больше, брат");
            } else if (Integer.parseInt(input) > number) {
                System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
            } else if (Integer.parseInt(input) == number) {
                if (count < best) {
                    best = count;
                }
                System.out.println(input + " " + count + " " + best);
                System.out.println("Хотите сыграть еще раз?");
                input = reader.readLine();
                if (input.equalsIgnoreCase("y")) {
                    game();
                } else if (input.equalsIgnoreCase("n")) {
                    reader.close();
                } else if (input.equalsIgnoreCase("result")) {
                    System.out.println(best);
                } else {
                    reader.close();
                    break;
                }
            }
        }
    }
}
