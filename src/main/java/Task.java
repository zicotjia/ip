public class Task {
    protected String description;
    protected boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public void setDone() {
        if (this.done) {
            System.out.println("Task is already done");
            return;
        }
        System.out.println("Task is marked as Done");
        this.done = true;
    }

    public void setNotDone() {
        if (!this.done) {
            System.out.println("Task is still undone");
            return;
        }
        System.out.println("Task is marked as undone");
        this.done = false;
    }

    @Override
    public String toString() {
        if (this.done) {
            return "[X] " + description;
        } else {
            return "[ ] " + description;
        }
    }
}
