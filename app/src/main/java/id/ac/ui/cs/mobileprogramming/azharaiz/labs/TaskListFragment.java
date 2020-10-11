package id.ac.ui.cs.mobileprogramming.azharaiz.labs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import id.ac.ui.cs.mobileprogramming.azharaiz.labs.model.Task;

public class TaskListFragment extends Fragment {
    private RecyclerView recyclerView;
    TaskAdapter adapter;
    EditText titleNewTask;
    Button btnNewTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleNewTask = view.findViewById(R.id.newTaskTitle);
        btnNewTask = view.findViewById(R.id.btnAddTask);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final TaskViewModel viewModel = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);
        viewModel.getTaskList().observe(getViewLifecycleOwner(), new Observer<ArrayList<Task>>() {
            @Override
            public void onChanged(ArrayList<Task> tasks) {
                adapter = new TaskAdapter(getParentFragmentManager(), viewModel, tasks);
                recyclerView.setAdapter(adapter);
            }
        });

        btnNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addTask(new Task(titleNewTask.getText().toString()));
            }
        });
    }
}