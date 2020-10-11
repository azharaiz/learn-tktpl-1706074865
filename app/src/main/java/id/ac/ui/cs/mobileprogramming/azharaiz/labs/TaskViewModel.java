package id.ac.ui.cs.mobileprogramming.azharaiz.labs;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import id.ac.ui.cs.mobileprogramming.azharaiz.labs.model.Task;

public class TaskViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Task>> taskList;
    private ArrayList<Task> tasks;

    public TaskViewModel() {
        taskList = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<Task>> getTaskList() {
        return taskList;
    }

    public void init() {
        populateList();
        taskList.setValue(tasks);
    }

    public void populateList() {
        Task templateTask = new Task("This is template task");
        tasks = new ArrayList<>();

        tasks.add(templateTask);
        tasks.add(templateTask);
        tasks.add(templateTask);
        tasks.add(templateTask);
        tasks.add(templateTask);
    }
}
