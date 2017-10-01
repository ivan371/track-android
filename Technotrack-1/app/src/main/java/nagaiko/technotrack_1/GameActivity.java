package nagaiko.technotrack_1;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    public int counter;
    public boolean isStop;
    Button button;
    TextView textView;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        isStop = false;
        button= (Button) findViewById(R.id.button);
        counter = 1;
        textView= (TextView) findViewById(R.id.textView2);
        timer = new CountDownTimer(11000, 1000){
            public void onTick(long millisUntilFinished){
                textView.setText(String.valueOf(counter));
                counter++;
            }
            public  void onFinish(){
                button.setText("start");
                isStop = false;
                counter = 1;
                textView.setText("");
            }
        };
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(!isStop) {
                    button.setText("stop");
                    isStop = true;
                    timer.start();
                }
                else {
                    button.setText("start");
                    isStop = false;
                    counter = 1;
                    textView.setText("");
                    timer.cancel();
                }
            }
        });

    }
}
