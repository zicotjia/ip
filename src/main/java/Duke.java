import java.util.Scanner;

public class Duke {

    public class Task {
        private String description;
        private boolean done;

        public Task(String description) {
            this.description = description;
            this.done = false;
        }

        private void setDone() {
            if (this.done) {
                System.out.println("Task is already done");
                return;
            }
            System.out.println("Task is marked as Done");
            this.done = true;
        }

        private void setNotDone() {
            if (!this.done) {
                System.out.println("Task is still undone");
                return;
            }
            System.out.println("Task is marked as undone");
            this.done = false;
        }
    }
    private static Task[] lst = new Task[100];
    private static int currEmpty = 0;

    private void add(String str) {
        if (currEmpty == 100) {
            System.out.println("List is Already Full, Cannot add anymore item");
            return;
        }
        lst[currEmpty] = new Task(str);
        System.out.println("added: " + str);
        currEmpty++;
    }

    private void read() {
        if (currEmpty == 0) {
            System.out.println("You have no task");
            return;
        }

        System.out.println("Here are the tasks in your list");
        for (int i = 0; i < currEmpty; i++) {
            Task curr = lst[i];
            if (curr.done) {
                System.out.println(i + 1 + ".[X] " + lst[i].description);
            } else {
                System.out.println(i + 1 + ".[ ] " + lst[i].description);
            }

        }
    }

    private void mark(int index) {
        if (index >= currEmpty) {
            System.out.println("There is no task with that index");
            return;
        }
        lst[index].setDone();
    }

    private void unMark(int index) {
        if (index >= currEmpty) {
            System.out.println("There is no task with that index");
            return;
        }
        lst[index].setNotDone();
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Scanner myScanner = new Scanner(System.in);

        Duke duke = new Duke();

        System.out.println("Hello! i am Duke");



        while (true) {
            System.out.println("What do you want me to do?");
            String input = myScanner.nextLine();
            if (input.equals("list")) {
                duke.read();
            } else if (input.equals("bye")) {
                System.out.println("See you later :)");
                System.exit(0);
            } else if (input.equals("mark")) {
                System.out.print("Select task index to mark as done:");
                int index = myScanner.nextInt();
                myScanner.nextLine();
                if (index < 0) {
                    System.out.println("index cannot be negative");
                } else {
                    duke.mark(index - 1);
                }
            } else if (input.equals("unmark")) {
                System.out.print("Select task index to mark as not done:");
                int index = myScanner.nextInt();
                myScanner.nextLine();
                if (index < 0) {
                    System.out.println("index cannot be negative");
                } else {
                    duke.unMark(index - 1);
                }
            } else if (!input.equals("")) {
                duke.add(input);
            }
        }


    }

}
