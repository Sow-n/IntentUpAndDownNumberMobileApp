package com.bkacad.upanddownnumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView tvRs, tvChuSo;
    private Button btnBack;
    private String inpNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvRs = findViewById(R.id.tvRs);
        tvChuSo = findViewById(R.id.tvChuSo);
        btnBack = findViewById(R.id.btnBack);

        try{
            Intent intent = getIntent();
            inpNum = intent.getStringExtra("number");
        } catch (Exception e){
            e.printStackTrace();
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("numResult",inpNum);
                startActivity(intent);
            }
        });

        tvRs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        int inputNum = intent.getExtras().getInt("number");
        tvRs.setText(String.valueOf(inputNum));
        int n = Integer.parseInt(String.valueOf(inputNum));
        String text = Function.numberToWord(n);
        tvChuSo.setText(text);
    }
}