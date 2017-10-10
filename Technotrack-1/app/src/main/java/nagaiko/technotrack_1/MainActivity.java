package nagaiko.technotrack_1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    private static final int TIMER_DURATION = 3000;
    private static final int TIMER_STEP = 1000;
    private boolean isFinish;
    private CountDownTimer timer;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            isFinish = false;
            counter = 1;
        }
        else {
            isFinish = savedInstanceState.getBoolean("isFinish");
            counter = savedInstanceState.getInt("counter");
        }

        timer = new CountDownTimer(TIMER_DURATION - TIMER_STEP * (counter - 1), TIMER_STEP) {
            @Override
            public void onTick(long l) {
                counter++;
            }

            public void onFinish() {
                createGame();
                isFinish = true;
            }
        }.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isFinish) {
            timer.cancel();
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isFinish = savedInstanceState.getBoolean("isFinish");
        counter = savedInstanceState.getInt("counter");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("isFinish", isFinish);
        outState.putInt("counter", counter);
        super.onSaveInstanceState(outState);
    }

    public void createGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
