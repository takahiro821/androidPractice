package com.example.apple.janken;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton gu = findViewById(R.id.gu);
        ImageButton choki = findViewById(R.id.choki);
        ImageButton pa = findViewById(R.id.pa);


    }

    public void onJankenButtonTapped(View view){
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("myhand",view.getId());
        startActivity(intent);
    }

    public void onValueTapped(View view){
        int tabNumber = 0;
        switch (view.getId()){
            case R.id.toTab2:
                tabNumber = 1;
                break;
            case R.id.toTab3:
                tabNumber = 2;
                break;
        }
        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = data.edit();

        editor.putInt("SavedTabNumber", tabNumber);
        editor.apply();
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);

    }

}
