package com.example.apple.janken;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class SecondActivity extends FragmentActivity implements FragmentTabHost.OnTabChangeListener , TabFragment.OnFragmentInteractionListener, TabFragment2.OnFragmentInteractionListener, TabFragment3.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        String levelString = String.valueOf(Level);
//        TextView resultview = findViewById(R.id.value);
//        resultview.setText(levelString);

        //FragmentTabHost を取得する
        FragmentTabHost tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.container);

        TabHost.TabSpec tabSpec1, tabSpec2, tabSpec3;

        // TabSpec を生成する
        tabSpec1 = tabHost.newTabSpec("tab1");
        tabSpec1.setIndicator("tab1");
        // TabHost に追加
        tabHost.addTab(tabSpec1, TabFragment.class, null);

        // TabSpec を生成する
        tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setIndicator("tab2");
        // TabHost に追加
        tabHost.addTab(tabSpec2, TabFragment2.class, null);

        // TabSpec を生成する
        tabSpec3 = tabHost.newTabSpec("tab3");
        tabSpec3.setIndicator("tab3");
        // TabHost に追加
        tabHost.addTab(tabSpec3, TabFragment3.class, null);



        // リスナー登録
        tabHost.setOnTabChangedListener(this);


        //データ渡し
        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        int tabNumber = data.getInt("SavedTabNumber",0);
        //データ渡し終わり

        //初期タブ
        tabHost.setCurrentTab(tabNumber);

    }

    public void returnSwitch2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void onTabChanged(String tabId) {
        Log.d("onTabChanged", "tabId: " + tabId);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
