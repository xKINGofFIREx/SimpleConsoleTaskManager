import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import manager.Interface;

public class Main {

    public static void main(String... args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                int command = Interface.getCommand(consoleReader);

                if (command == 1) {
                    Interface.getTask(consoleReader);
                } else if (command == 2) {
                    Interface.showAllTasks();
                } else if (command == 3) {
                    Interface.deleteTaskById(consoleReader);
                } else if (command == 4) {
                    System.out.println("Завершение программы");
                    break;
                } else {
                    throw new NumberFormatException();
                }

            } catch (NumberFormatException e) {
                System.out.println("Комманда может быть только целым числом, одним из предложенных");
                continue;
            }

        }

        consoleReader.close();
    }
}
