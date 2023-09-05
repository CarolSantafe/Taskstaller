package model;

public class Task {

    private String name;
    private Status status;

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Task: " + name + " -> " + "Status: " + status + "\n";
    }
}
