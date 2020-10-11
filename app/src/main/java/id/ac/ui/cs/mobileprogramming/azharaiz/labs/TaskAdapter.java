package id.ac.ui.cs.mobileprogramming.azharaiz.labs;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.ac.ui.cs.mobileprogramming.azharaiz.labs.model.Task;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    ArrayList<Task> tasks;
    private FragmentManager manager;
    private TaskViewModel viewModel;
    public TaskAdapter(FragmentManager manager, TaskViewModel viewModel, ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.viewModel = viewModel;
        this.manager = manager;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_task_list_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TaskViewHolder holder, final int position) {
        final Task selectedTask = tasks.get(position);
        holder.taskTitle.setText(selectedTask.getTitle());
        holder.checkBox.setChecked(selectedTask.getDone());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setSelectedTask(position);
                selectedTask.setDone(!selectedTask.getDone());
            }
        });
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setSelectedTask(position);
                TaskDetailFragment fragment = new TaskDetailFragment();
                manager.beginTransaction().replace(R.id.fragment_task_list_main, fragment)
                        .addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private CheckBox checkBox;
        private TextView taskTitle;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            checkBox = mView.findViewById(R.id.checkBox);
            taskTitle = mView.findViewById(R.id.taskListTitle);
        }
    }
}
