package gg.lisomandiy.taskmanager;

public class Task {

    private final int id;
    private final String title;
    private boolean done;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.done = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public void markDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        String status = done ? "[x]" : "[ ]";
        return status + " #" + id + " " + title;
    }
}
