package com.example.lifecycledemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btn_count;
    TextView tv_count;

    int count = 0;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("clickCount", count);
    }

    @Override
    public void onRestoreInstanceState( Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("clickCount");

        tv_count = findViewById(R.id.tv_count);
        tv_count.setText(String.format(Integer.toString(count)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecyclefilter", "This is start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecyclefilter", "This is stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecyclefilter", "This is destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecyclefilter", "This is paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecyclefilter", "This is Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecyclefilter", "This is Restart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("lifecyclefilter", "This is created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_count = (Button)findViewById(R.id.btn_count);
        tv_count = (TextView)findViewById(R.id.tv_count);

        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("test");
                count++;

                tv_count.setText(Integer.toString(count));
            }
        });

    }
}
