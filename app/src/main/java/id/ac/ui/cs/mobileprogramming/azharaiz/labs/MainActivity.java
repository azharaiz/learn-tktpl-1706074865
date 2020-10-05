package id.ac.ui.cs.mobileprogramming.azharaiz.labs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("COUNTER");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Integer intTime = intent.getIntExtra("TIME_REMAINING",0);
                textView.setText(intTime.toString());
            }
        };
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        ExitDialog dialog = new ExitDialog();
        dialog.show(fm, "fragment_exit");
    }

    public void clickStart(View view) {
        TextView inputTime = findViewById(R.id.inputTime);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        textView = findViewById(R.id.textView);

        btnStart.setVisibility(View.INVISIBLE);
        btnStop.setVisibility(View.VISIBLE);

        Intent intentService = new Intent(this, TimerService.class);
        Integer time = Integer.parseInt(inputTime.getText().toString());

        intentService.putExtra("TIME_VALUE", time);
        startService(intentService);
    }

    public void clickStop(View view) {
        btnStop = findViewById(R.id.btnStop);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setVisibility(View.VISIBLE);
        btnStop.setVisibility(View.INVISIBLE);

        Intent intentService = new Intent(this, TimerService.class);
        stopService(intentService);
    }
}