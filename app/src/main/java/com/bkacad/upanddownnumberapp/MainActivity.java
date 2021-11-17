package com.bkacad.upanddownnumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvNumber;
    private Button btnGo, btnAdd, btnSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumber = findViewById(R.id.tvNumber);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnGo = findViewById(R.id.btnGo);

        try{
            Intent intent = getIntent();
            String number = intent.getStringExtra("numResult");
            if(number != null){
                int num = Integer.parseInt(number);
                tvNumber.setText(String.valueOf(num));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tvNum = Integer.parseInt(tvNumber.getText().toString());
                if(v.getId() == R.id.btnAdd){
                    if(tvNum < 100){
                        tvNum++;
                        tvNumber.setText(String.valueOf(tvNum));
                    } else {
                        Toast.makeText(getBaseContext(), "Hết rồi không phải cố!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tvNum = Integer.parseInt(tvNumber.getText().toString());
                if(v.getId() == R.id.btnSub){
                    if(tvNum > 0) {
                        tvNum--;
                        tvNumber.setText(String.valueOf(tvNum));
                    } else{
                        Toast.makeText(getBaseContext(), "Hết rồi không phải cố!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tvNum = Integer.parseInt(tvNumber.getText().toString());
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("number", tvNum);
                startActivity(intent);
            }
        });
    }
}