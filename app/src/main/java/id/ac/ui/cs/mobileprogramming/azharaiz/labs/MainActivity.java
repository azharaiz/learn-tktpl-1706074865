package id.ac.ui.cs.mobileprogramming.azharaiz.labs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submitBtn = findViewById(R.id.button);
        final EditText inputName = findViewById(R.id.inputName);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String greeting = helloFromJNI(inputName.getText().toString());
                Toast.makeText(getApplicationContext(), greeting, Toast.LENGTH_LONG).show();
            }
        });
    }

    public native String helloFromJNI(String inputName);
}