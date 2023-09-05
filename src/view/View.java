package view;

import java.util.Scanner;

public class View {

    private Scanner io;

    public View() {
        io = new Scanner(System.in);
    }

    public String menu() {
        System.out.println("+---------------------------------+");
        System.out.println("|        TASK LIST MANAGER        |");
        System.out.println("+---------------------------------+");
        System.out.println("|        AVAILABLE OPTIONS        |");
        System.out.println("+---------------------------------+");
        System.out.println("| 1. Add Task                     |");
        System.out.println("| 2. Complete Task                |");
        System.out.println("| 3. Show Tasks                   |");
        System.out.println("| 4. Delete Tasks                 |");
        System.out.println("| 5. Count Incomplete Tasks       |");
        System.out.println("| 6. Exit                         |");
        System.out.println("+---------------------------------+");
        System.out.print("Enter your option: ");
        return io.next();
    }

    public String input() {
        System.out.print("Enter Task Name: ");
        return io.next();
    }

    public void printMessage(String message) {
        int messageLength = message.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < messageLength + 2; i++) {
            sb.append("-");
        }
        String border = "+" + sb.toString() + "+";

        System.out.println(border);
        System.out.println("| " + message + " |");
        System.out.println(border);
    }


}
