package com.example.apple.janken;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    int comHand = 0;
    int rand = 0;
    int myHand = 0;
    ImageView computerhand;
    ImageView myhandimage;
    int JANKEN_GU = 0;
    int JANKEN_PA = 1;
    int JANKEN_CHOKI = 2;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        computerhand = findViewById(R.id.com_hand);
        myhandimage = findViewById(R.id.myhand);
        Intent intent = getIntent();
        id = intent.getIntExtra("myhand", 0);


        rand = (int) (Math.random() * 3);
        switch (rand) {
            case 0:
                computerhand.setImageResource(R.drawable.gu);
                comHand = JANKEN_GU;
                break;
            case 1:
                computerhand.setImageResource(R.drawable.choki);
                comHand = JANKEN_CHOKI;
                break;
            case 2:
                computerhand.setImageResource(R.drawable.pa);
                comHand = JANKEN_PA;
                break;
            default:
                System.out.println("エラー");
        }

        switch (id) {
            case R.id.gu:
                myhandimage.setImageResource(R.drawable.gu);
                myHand = JANKEN_GU;
                break;
            case R.id.choki:
                myhandimage.setImageResource(R.drawable.choki);
                myHand = JANKEN_CHOKI;
                break;
            case R.id.pa:
                myhandimage.setImageResource(R.drawable.pa);
                myHand = JANKEN_PA;
                break;
            default:
                myHand = JANKEN_GU;
                break;
        }

        result();
    }


    private void result() {
        TextView resultview = findViewById(R.id.result);
        if (comHand == myHand) {

            resultview.setText("あいこです");
        } else if (myHand == comHand + 1 || myHand + 2 == comHand) {

            resultview.setText("勝ちです");
        } else {

            resultview.setText("負けです");
        }


    }

    public void returnSwitch(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

