package com.example.myweathers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        String name = "我是冲突";
        String text = "还有一行";
        Toast.makeText(this,"冲突来了",Toast.LENGTH_SHORT).show();
        String content = "这是冲突";
        String toast = "我不是冲突";
    }
}
