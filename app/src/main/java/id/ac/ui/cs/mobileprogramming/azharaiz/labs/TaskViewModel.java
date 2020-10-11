package id.ac.ui.cs.mobileprogramming.azharaiz.labs;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import id.ac.ui.cs.mobileprogramming.azharaiz.labs.model.Task;

public class TaskViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Task>> taskList;
    private MutableLiveData<Task> selectedTask = new MutableLiveData<>();
    private ArrayList<Task> tasks;
    private int position;

    public TaskViewModel() {
        taskList = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<Task>> getTaskList() {
        return taskList;
    }

    public void setSelectedTask(int position) {
        this.position = position;
        this.selectedTask.setValue(this.taskList.getValue().get(position));
    }

    public void updateData(String title, Boolean isDone) {
        ArrayList<Task> taskArrayList = this.taskList.getValue();
        if (taskArrayList != null) {
            Task selected = taskArrayList.get(this.position);
            selected.setDone(isDone);
            selected.setTitle(title);
            this.taskList.setValue(taskArrayList);
        }
    }

    public MutableLiveData<Task> getSelectedTask() {
        return selectedTask;
    }

    public void addTask(Task task) {
        ArrayList<Task> taskArrayList = this.taskList.getValue();
        if (taskArrayList != null) {
            taskArrayList.add(task);
            this.taskList.setValue(taskArrayList);
        }
    }

    public void init() {
        populateList();
        taskList.setValue(tasks);
    }

    public void populateList() {
        tasks = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Task templateTask = new Task("This is template task " + i);
            tasks.add(templateTask);
        }
    }
}
