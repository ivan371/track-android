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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountDownTimer timer = new CountDownTimer(TIMER_DURATION, TIMER_STEP) {
            @Override
            public void onTick(long l) {
            }

            public void onFinish() {
                createGame();
            }
        }.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void createGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
