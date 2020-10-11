package id.ac.ui.cs.mobileprogramming.azharaiz.labs.model;

public class Task {
    private String title;
    private Boolean isDone;

    public Task(String title) {
        this.title = title;
        this.isDone = false;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
