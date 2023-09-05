package model;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList(){
        taskList = new ArrayList<>();
    }

    public void addTaskToList(String taskName) {
        Task task = new Task();
        task.setName(taskName);
        task.setStatus(Status.INCOMPLETE);
        taskList.add(task);
    }

    public int positionTask(String task) {
        int position = -1;
            for (int i = 0; i < taskList.size(); i++) {
                if (task.equals(taskList.get(i).getName())){
                    position = i;
                }
            }
        return position;
    }

    public boolean isEmptyArray() {
        boolean flag = false;
        if (taskList.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    public int completeTask(String task) {
        int flag = 1;
        int position = positionTask(task);

        if (position != -1) {
            taskList.get(position).setStatus(Status.COMPLETE);
            flag = 2;
        }
        return flag;
    }

    public String showTasks(){
        String tasks = "";
        for (int i = 0; i < taskList.size(); i++) {
            tasks += i + 1 + ". " + taskList.get(i).toString();
        }
        return tasks;
    }

    public boolean deleteTask(String task){
        boolean flag = false;
        int position = positionTask(task);
        if (position != -1) {
            taskList.remove(position);
            flag = true;
        }
        return flag;
    }

    public int countTasks() {
        int amount = 0;
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getStatus().equals(Status.INCOMPLETE)){
                amount++;
            }
        }
        return amount;
    }

    public ArrayList<Task> getTaskList(){
        return taskList;
    }
}
