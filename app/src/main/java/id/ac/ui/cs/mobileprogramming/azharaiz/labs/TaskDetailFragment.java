package id.ac.ui.cs.mobileprogramming.azharaiz.labs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import id.ac.ui.cs.mobileprogramming.azharaiz.labs.model.Task;

public class TaskDetailFragment extends Fragment {
    private EditText taskTitle;
    private CheckBox taskCheckbox;
    private Button saveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        taskTitle = view.findViewById(R.id.taskDetailTitle);
        taskCheckbox = view.findViewById(R.id.taskDetailCheckbox);
        saveButton = view.findViewById(R.id.btnSaveDetail);
        final TaskViewModel model = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.updateData(taskTitle.getText().toString(), taskCheckbox.isChecked());
                saveButton.setText("Saved");
            }
        });

        model.getSelectedTask().observe(getViewLifecycleOwner(), new Observer<Task>() {
            @Override
            public void onChanged(final Task task) {
                taskTitle.setText(task.getTitle());
                taskCheckbox.setChecked(task.getDone());
            }
        });
    }
}