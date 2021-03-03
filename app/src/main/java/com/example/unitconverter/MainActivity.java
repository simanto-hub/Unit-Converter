package com.example.unitconverter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView currencyCV, weightCV, timeCV, lengthCV, areaCV, temperatureCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.colorAccent));



        currencyCV= (CardView) findViewById(R.id.currencyCV);
        weightCV= (CardView) findViewById(R.id.weightCV);
        timeCV= (CardView) findViewById(R.id.timeCV);
        lengthCV= (CardView) findViewById(R.id.lengthCV);
        areaCV = (CardView) findViewById(R.id.areaCV);
        temperatureCV= (CardView) findViewById(R.id.temperatureCV);

        currencyCV.setOnClickListener(this);
        weightCV.setOnClickListener(this);
        timeCV.setOnClickListener(this);
        lengthCV.setOnClickListener(this);
        areaCV.setOnClickListener(this);
        temperatureCV.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.currencyCV){
            Intent intent = new Intent(MainActivity.this, UnitActivity.class);
            intent.putExtra("unit","Currency");
            startActivity(intent);
        }
        if(v.getId() == R.id.weightCV){
            Intent intent = new Intent(MainActivity.this, UnitActivity.class);
            intent.putExtra("unit","Weight");
            startActivity(intent);
        }
        if(v.getId() == R.id.timeCV){
            Intent intent = new Intent(MainActivity.this, UnitActivity.class);
            intent.putExtra("unit","Time");
            startActivity(intent);
        }
        if(v.getId() == R.id.lengthCV){
            Intent intent = new Intent(MainActivity.this, UnitActivity.class);
            intent.putExtra("unit","Length");
            startActivity(intent);
        }
        if(v.getId() == R.id.areaCV){
            Intent intent = new Intent(MainActivity.this, UnitActivity.class);
            intent.putExtra("unit","Area");
            startActivity(intent);
        }
        if(v.getId() == R.id.temperatureCV){
            Intent intent = new Intent(MainActivity.this, UnitActivity.class);
            intent.putExtra("unit","Temperature");
            startActivity(intent);
        }
    }
}