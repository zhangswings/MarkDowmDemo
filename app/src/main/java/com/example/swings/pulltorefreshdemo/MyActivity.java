package com.example.swings.pulltorefreshdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

/**
 * EventBus的实际项目案例演示
 *
 * @author Administrator
 *
 */
public class MyActivity extends Activity {
    private TextView tv_content;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        tv_content = (TextView) this.findViewById(R.id.tv_content);
        btn_send = (Button) this.findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {// 发送数据事件
                MyEvent my = new MyEvent();
                my.setType("1");
                my.setContent("1内容");
                EventBus.getDefault().post(my);
            }
        });
        EventBus.getDefault().register(this);
    }

    public void onEvent(MyEvent event) {
        if (event.getType().equals("0")) {
            tv_content.setText(event.getContent());
        }
    }

    public void onEventMainThread(MyEvent event) {
        if (event.getType().equals("1")) {
            tv_content.setText(event.getContent());
        }
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
