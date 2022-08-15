import java.util.Scanner;

public class Duke {
    private static String[] lst = new String[100];
    private static int currEmpty = 0;

    private static void add(String str) {
        if (currEmpty == 100) {
            System.out.println("List is Already Full, Cannot add anymore item");
            return;
        }
        lst[currEmpty] = str;
        System.out.println("added: " + str);
        currEmpty++;
    }

    private static void read() {
        for (int i = 0; i < currEmpty; i++) {
            System.out.println(i + 1 + ". " + lst[i]);
        }
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Hello! I am Duke \n What do you want me to do? \n");

        String input;

        while (true) {
            input = myScanner.nextLine();
            if (input.equals("list")) {
                read();
            } else if (input.equals("bye")) {
                System.out.println("See you later :)");
                System.exit(0);
            } else {
                add(input);
            }
        }
    }

}
