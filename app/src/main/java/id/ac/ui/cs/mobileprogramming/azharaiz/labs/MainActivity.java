package id.ac.ui.cs.mobileprogramming.azharaiz.labs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMainSubmit(View view) {
        TextView textGreeting = findViewById(R.id.textGreet);
        TextView textEmail = findViewById(R.id.textEmail);
        EditText name = findViewById(R.id.editTextName);
        EditText email = findViewById(R.id.editTextEmail);

        User user = new User(name.getText().toString(), email.getText().toString());

        textGreeting.setText(user.greetUser());
        textEmail.setText(user.checkEmail());
    }
}