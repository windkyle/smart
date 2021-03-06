package com.smart.ui.module.other.time;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.base.utils.ToolbarUtil;
import com.smart.R;
import com.smart.app.activity.BaseCompatActivity;
import com.custom.widget.WatcherBoard;

import java.util.Calendar;

import butterknife.BindView;

public class TimeActivity extends BaseCompatActivity {
    private final static String TAG = "TimeActivity";
    @BindView(R.id.watch)
    WatcherBoard watch;
    @BindView(R.id.time_hour)
    TextView timeHour;
    @BindView(R.id.time_min)
    TextView timeMin;
    @BindView(R.id.time_second)
    TextView timeSecond;

    @Override
    protected int setContentView() {
        return R.layout.fragment_time;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ToolbarUtil.setToolbarLeft(toolbar, "手表", null, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        initView();
    }

    private void initView() {
        watch.setOnMoveListener(new WatcherBoard.OnMoveListener() {
            @Override
            public void onMove() {
                onDraw();
            }
        });
    }

    private void onDraw() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY); //时
        int minute = calendar.get(Calendar.MINUTE); //分
        int second = calendar.get(Calendar.SECOND); //秒
        timeHour.setText(checkTime(hour));
        timeMin.setText(checkTime(minute));
        timeSecond.setText(checkTime(second));
    }

    private String checkTime(int time){
        if(time < 10){
            return "0"+time;
        }else{
            return ""+time;
        }
    }
}
