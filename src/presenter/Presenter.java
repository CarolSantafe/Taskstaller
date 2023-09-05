package presenter;

import model.TaskList;
import view.View;

public class Presenter {
    private TaskList taskList;
    private View view;

    public Presenter() {
        taskList = new TaskList();
        view = new View();
        decision();
    }

    private void add() {
        String taskName = view.input();
        taskList.addTaskToList(taskName);
    }

    private void complete() {
        if (taskList.isEmptyArray()) {
            view.printMessage("No Tasks Created Yet! Try Again!");
            decision();
        }
        String taskName = view.input();
        int result = taskList.completeTask(taskName);
        if (result == 1) {
            view.printMessage("This Task Does Not Exist! Try Again!");
            complete();
        }
        if (result == 2) {
            view.printMessage("Task Completed Successfully!");
        }
    }

    private void showTask() {
        if (taskList.isEmptyArray()) {
            view.printMessage("No Tasks Created Yet! Try Again!");
            decision();
        }
        System.out.print(taskList.showTasks());
    }

    private void delete() {
        if (taskList.isEmptyArray()) {
            view.printMessage("No Tasks Created Yet! Try Again!");
            decision();
        }

        String taskName = view.input();
        boolean check = taskList.deleteTask(taskName);

        if (!check) {
            view.printMessage("This Task Does Not Exist! Try Again!");
            delete();
        } else {
            view.printMessage("Task Deleted Successfully");
        }
    }

    private void showComplete() {
        if (taskList.isEmptyArray()) {
            view.printMessage("No Tasks Created Yet! Try Again!");
            decision();
        }

        int amount = taskList.countTasks();
        System.out.println("Incomplete Tasks: " + amount);
    }

    public void decision() {
        try {
            int option = Integer.parseInt(view.menu());
            switch (option) {
                case 1:
                    add();
                    view.printMessage("Task Added Successfully!");
                    decision();
                    break;
                case 2:
                    complete();
                    decision();
                    break;
                case 3:
                    showTask();
                    decision();
                    break;
                case 4:
                    delete();
                    decision();
                    break;
                case 5:
                    showComplete();
                    decision();
                    break;
                case 6:
                    view.printMessage("Closing App...");
                    System.exit(0);
                    break;
                default:
                    view.printMessage("Invalid Option, Try Again Please!");
                    decision();
            }
        } catch (NumberFormatException e) {
            view.printMessage("Only Numbers Accepted, Try Again Please!");
            decision();
        }
    }

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
    }
}
