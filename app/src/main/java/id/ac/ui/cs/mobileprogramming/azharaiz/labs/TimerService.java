package id.ac.ui.cs.mobileprogramming.azharaiz.labs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {
    private Timer timer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        final Integer[] timeRemaining = {intent.getIntExtra("TIME_VALUE", 0)};
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Intent intentLocal = new Intent();
                intentLocal.setAction("COUNTER");
                timeRemaining[0]--;
                if (timeRemaining[0] <= 0) {
                    timer.cancel();
                }
                intentLocal.putExtra("TIME_REMAINING", timeRemaining[0]);
                sendBroadcast(intentLocal);
            }
        }, 0, 1000);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        Intent intentLocal = new Intent();
        intentLocal.setAction("COUNTER");
        intentLocal.putExtra("TIME_REMAINING", 0);
        sendBroadcast(intentLocal);
        super.onDestroy();
    }
}
