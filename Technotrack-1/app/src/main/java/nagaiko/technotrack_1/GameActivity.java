package nagaiko.technotrack_1;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity {

    private static final int TIMER_DURATION = 1001000;
    private static final int TIMER_STEP = 1000;
    public int counter;
    public boolean isStop;
    private Button button;
    private TextView textView;
    private MyTimer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        button= (Button) findViewById(R.id.button);
        textView= (TextView) findViewById(R.id.textView2);
        if(savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter");
            isStop = savedInstanceState.getBoolean("isStop");
        }
        else {
            counter = 1;
            isStop = false;
        }
        timer = new MyTimer(TIMER_DURATION - counter * TIMER_STEP, TIMER_STEP);
        if(isStop) {
            timer.start();
            button.setText(R.string.stop_timer);
        }
        button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    if(!isStop) {
                        button.setText(R.string.stop_timer);
                        isStop = true;
                        timer.start();
                    }
                    else {
                        button.setText(R.string.start_timer);
                        isStop = false;
                        counter = 1;
                        textView.setText("");
                        timer.cancel();
                    }
                }
            });
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        isStop = savedInstanceState.getBoolean("isStop");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("counter", counter);
        outState.putBoolean("isStop", isStop);
        super.onSaveInstanceState(outState);
    }
    private class MyTimer extends CountDownTimer {

        MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            textView.setText(Nums.toString(counter));
            counter++;
        }

        @Override
        public void onFinish() {
            button.setText(R.string.start_timer);
            isStop = false;
            counter = 1;
            textView.setText("");
        }
    }
}
