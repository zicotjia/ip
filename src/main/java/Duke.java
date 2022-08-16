import java.util.Scanner;

public class Duke {

    private static Task[] lst = new Task[100];
    private static int currEmpty = 0;
    private final static Scanner myScanner = new Scanner(System.in);
    private final static String SEPARATOR = "------------------------------------";

    private void add(Task task) {

        if (currEmpty == 100) {
            System.out.println("List is Already Full, Cannot add anymore item");
            return;
        }
        lst[currEmpty] = task;
        System.out.println("added: " + task.toString());
        currEmpty++;
    }

    private void read() {
        if (currEmpty == 0) {
            System.out.println("You have no task");
            return;
        }

        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < currEmpty; i++) {
            Task curr = lst[i];
            System.out.println(i + 1 + "." + curr.toString());
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
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);

        Duke duke = new Duke();

        System.out.println("Hello! i am Duke");



        while (true) {
            System.out.println("What do you want me to do?");
            String input = myScanner.nextLine();

            switch (input) {
                case "list":
                    System.out.println(SEPARATOR);
                    duke.read();
                    System.out.println(SEPARATOR);
                    break;
                case "mark":
                    System.out.println(SEPARATOR);
                    System.out.print("Select task index to mark as done: ");
                    int index = myScanner.nextInt();
                    myScanner.nextLine();
                    System.out.println(SEPARATOR);
                    if (index < 0) {
                        System.out.println("index cannot be negative");
                    } else {

                        duke.mark(index - 1);
                    }
                    System.out.println(SEPARATOR);
                    break;
                case "unmark":
                    System.out.println(SEPARATOR);
                    System.out.print("Select task index to mark as not done: ");
                    int index2 = myScanner.nextInt();
                    myScanner.nextLine();
                    System.out.println(SEPARATOR);
                    if (index2 < 0) {
                        System.out.println("index cannot be negative");
                    } else {
                        duke.unMark(index2 - 1);
                    }
                    System.out.println(SEPARATOR);
                    break;
                case "deadline":
                    System.out.println(SEPARATOR);
                    System.out.print("What Deadline item do you want to add: ");
                    String newDesc = myScanner.nextLine();
                    System.out.print("When is the Deadline itself: ");
                    String by = myScanner.nextLine();
                    Deadline newDeadLine = new Deadline(newDesc, by);
                    System.out.println(SEPARATOR);
                    duke.add(newDeadLine);
                    System.out.println(SEPARATOR);
                    break;
                case "todo":
                    System.out.println(SEPARATOR);
                    System.out.print("What ToDo item do you want to add: ");
                    String newDesc2 = myScanner.nextLine();
                    ToDo newToDo = new ToDo(newDesc2);
                    System.out.println(SEPARATOR);
                    duke.add(newToDo);
                    System.out.println(SEPARATOR);
                    break;
                case "event":
                    System.out.println(SEPARATOR);
                    System.out.print("What Event item do you want to add: ");
                    String newDesc3 = myScanner.nextLine();
                    System.out.print("What is the duration: ");
                    String at = myScanner.nextLine();
                    Event newEvent = new Event(newDesc3, at);
                    System.out.println(SEPARATOR);
                    duke.add(newEvent);
                    System.out.println(SEPARATOR);
                    break;
                case "bye":
                    System.out.println(SEPARATOR);
                    System.out.println("See you later :)");
                    System.exit(0);
                    break;
            }
        }


    }

}
