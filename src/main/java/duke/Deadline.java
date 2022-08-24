package duke;

import java.time.LocalDate;

public class Deadline extends Task {
    private LocalDate deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = LocalDate.parse(deadline);
    }

    public Deadline(String description, boolean isDone , String deadline) {
        super(description, isDone);
        this.deadline = LocalDate.parse(deadline);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " ( by: " + deadline + " )";
    }

    @Override
    public String toStorageFormat() {
        return "D | " + super.toStorageFormat() + " | " + deadline;
    }
}