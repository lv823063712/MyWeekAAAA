package soexample.bigfly.com.myweekdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import soexample.bigfly.com.myweekdemo.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.MyTime)
    TextView MyTime;
    private int MyTimes = 3;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (MyTimes == -1) {
                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                startActivity(intent);
            } else {
                MyTime.setText("剩余" + MyTimes + "S");
                MyTimes--;
                handler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.item);
        //进行延时
        handler.sendEmptyMessageDelayed(0, 1000);
    }
}
