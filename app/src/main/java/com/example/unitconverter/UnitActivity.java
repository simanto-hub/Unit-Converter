package com.example.unitconverter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UnitActivity extends AppCompatActivity  {

    String [] currencyNames;
    String [] weightNames;
    String [] timeNames;
    String [] lengthNames;
    String [] areaNames;
    String [] temperatureNames;
    
    private TextView answer, unitName;
    private Spinner spinnerOne, spinnerTwo;
    private EditText typeUnit;
    private Button convert;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        getWindow().setStatusBarColor(ContextCompat.getColor(UnitActivity.this, R.color.colorAccent));

        answer = (TextView) findViewById(R.id.answerTV);
        spinnerOne = (Spinner) findViewById(R.id.unitOneSP);
        spinnerTwo = (Spinner) findViewById(R.id.unitTwoSP);
        typeUnit = (EditText) findViewById(R.id.typeUnitEV);
        convert = (Button) findViewById(R.id.convertBtn);
        unitName = (TextView) findViewById(R.id.unitTV);
        back = (ImageView) findViewById(R.id.backIV);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //Data Collect from MainActivity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String unit = bundle.getString("unit");

            if (unit.equals("Currency")) {
                showDetailsOfCurrency(unit);
            }
            if (unit.equals("Weight")) {
                showDetailsOfWeight(unit);
            }
            if (unit.equals("Time")) {
                showDetailsOfTime(unit);
            }
            if (unit.equals("Length")) {
                showDetailsOflength(unit);
            }
            if (unit.equals("Area")) {
                showDetailsOfArea(unit);
            }
            if (unit.equals("Temperature")) {
                showDetailsOfTemperature(unit);
            }
        }
    }

    //Temperature
    private void showDetailsOfTemperature(String unit) {

        temperatureNames = getResources().getStringArray(R.array.temperature_name);

        unitName.setText(unit);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.temperature_view, R.id.temperatureViewTV,temperatureNames);
        spinnerOne.setAdapter(adapter);
        spinnerTwo.setAdapter(adapter);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result;
                String celsius = "Celsius";
                String farenheit = "Farenheit";

                String spinnerOneValue = spinnerOne.getSelectedItem().toString();
                String spinnerTwoValue = spinnerTwo.getSelectedItem().toString();

                Double inputValue = Double.parseDouble(typeUnit.getText().toString());

                if (spinnerOneValue.equals(celsius) && spinnerTwoValue.equals(farenheit)) {
                    result = ((inputValue * 9/5) + 32);
                    answer.setText(Double.toString(result) + farenheit);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                } else if (spinnerOneValue.equals(farenheit) && spinnerTwoValue.equals(celsius)) {
                    result = ((inputValue - 32) * 5/9);
                    answer.setText(Double.toString(result)+ celsius);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    //Area
    private void showDetailsOfArea(String unit) {
        areaNames = getResources().getStringArray(R.array.area_name);

        unitName.setText(unit);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.area_view, R.id.areaViewTV,areaNames);
        spinnerOne.setAdapter(adapter);
        spinnerTwo.setAdapter(adapter);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result;
                String sqKilometer = "Square Kilometer";
                String acre = "Acre";

                String spinnerOneValue = spinnerOne.getSelectedItem().toString();
                String spinnerTwoValue = spinnerTwo.getSelectedItem().toString();

                Double inputValue = Double.parseDouble(typeUnit.getText().toString());

                if (spinnerOneValue.equals(sqKilometer) && spinnerTwoValue.equals(acre)) {
                    result = inputValue * 247.105;
                    answer.setText(Double.toString(result) + acre);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                } else if (spinnerOneValue.equals(acre) && spinnerTwoValue.equals(sqKilometer)) {
                    result = inputValue / 247.105;
                    answer.setText(Double.toString(result)+ sqKilometer);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    //Length

    private void showDetailsOflength(String unit) {
        lengthNames = getResources().getStringArray(R.array.length_name);

        unitName.setText(unit);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.length_view, R.id.lengthViewTV,lengthNames);
        spinnerOne.setAdapter(adapter);
        spinnerTwo.setAdapter(adapter);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result;
                String meter = "Meter";
                String centimeter = "Centimeter";

                String spinnerOneValue = spinnerOne.getSelectedItem().toString();
                String spinnerTwoValue = spinnerTwo.getSelectedItem().toString();

                Double inputValue = Double.parseDouble(typeUnit.getText().toString());

                if (spinnerOneValue.equals(meter) && spinnerTwoValue.equals(centimeter)) {
                    result = inputValue * 100;
                    answer.setText(Double.toString(result) + centimeter);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                } else if (spinnerOneValue.equals(centimeter) && spinnerTwoValue.equals(meter)) {
                    result = inputValue / 100;
                    answer.setText(Double.toString(result)+ meter);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    //Time
    private void showDetailsOfTime(String unit) {
        timeNames = getResources().getStringArray(R.array.time_name);

        unitName.setText(unit);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.time_view, R.id.timeViewTV,timeNames);
        spinnerOne.setAdapter(adapter);
        spinnerTwo.setAdapter(adapter);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result;
                String hour = "Hour";
                String minute = "Minute";

                String spinnerOneValue = spinnerOne.getSelectedItem().toString();
                String spinnerTwoValue = spinnerTwo.getSelectedItem().toString();

                Double inputValue = Double.parseDouble(typeUnit.getText().toString());

                if (spinnerOneValue.equals(hour) && spinnerTwoValue.equals(minute)) {
                    result = inputValue * 60;
                    answer.setText(Double.toString(result) + minute);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                } else if (spinnerOneValue.equals(minute) && spinnerTwoValue.equals(hour)) {
                    result = inputValue / 60;
                    answer.setText(Double.toString(result)+ hour);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    //Weight
    private void showDetailsOfWeight(String unit) {

        weightNames = getResources().getStringArray(R.array.weight_name);

        unitName.setText(unit);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.weight_view, R.id.weightViewTV,weightNames);
        spinnerOne.setAdapter(adapter);
        spinnerTwo.setAdapter(adapter);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result;
                String kg = "Kilogram(kg)";
                String gm = "Gram(gm)";

                String spinnerOneValue = spinnerOne.getSelectedItem().toString();
                String spinnerTwoValue = spinnerTwo.getSelectedItem().toString();

                Double inputValue = Double.parseDouble(typeUnit.getText().toString());

                if (spinnerOneValue.equals(kg) && spinnerTwoValue.equals(gm)) {
                    result = inputValue * 1000;
                    answer.setText(Double.toString(result) + gm);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                } else if (spinnerOneValue.equals(gm) && spinnerTwoValue.equals(kg)) {
                    result = inputValue / 1000;
                    answer.setText(Double.toString(result)+kg);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    //Currency
    private void showDetailsOfCurrency (String unit) {

        currencyNames = getResources().getStringArray(R.array.currency_name);

        unitName.setText(unit);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.currency_view, R.id.currencyViewTV,currencyNames);
        spinnerOne.setAdapter(adapter);
        spinnerTwo.setAdapter(adapter);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result;
                String usd = "U.S. Dollar(USD)";
                String eur = "Euro(EUR)";
                String gbp = "Pound(GBP)";
                String jpy = "Japanese-Yen(JPY)";
                String cad = "CanadianDollar(CAD)";
                String taka = "Bangladesh(TAKA)";

                String spinnerOneValue = spinnerOne.getSelectedItem().toString();
                String spinnerTwoValue = spinnerTwo.getSelectedItem().toString();

                //answer.setText(spinnerTwoValue);


                Double inputValue = Double.parseDouble(typeUnit.getText().toString());

                //usd to others

                if (spinnerOneValue.equals(usd) && spinnerTwoValue.equals(eur)) {
                    result = inputValue * 0.82;
                    answer.setText(Double.toString(result) + eur);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                } else if (spinnerOneValue.equals(usd) && spinnerTwoValue.equals(gbp)) {
                    result = inputValue * 0.73;
                    answer.setText(Double.toString(result)+gbp);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
                else if (spinnerOneValue.equals(usd) && spinnerTwoValue.equals(jpy)) {
                    result = inputValue * 103.77;
                    answer.setText(Double.toString(result) + jpy);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
                else if (spinnerOneValue.equals(usd) && spinnerTwoValue.equals(cad)) {
                    result = inputValue * 1.27;
                    answer.setText(Double.toString(result) + cad);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }else if (spinnerOneValue.equals(usd) && spinnerTwoValue.equals(taka)) {
                    result = inputValue * 84.80;
                    answer.setText(Double.toString(result) + taka);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }

                //eur to others

                if (spinnerOneValue.equals(eur) && spinnerTwoValue.equals(usd)) {
                    result = inputValue / 0.82;
                    answer.setText(Double.toString(result) + usd);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                } else if (spinnerOneValue.equals(eur) && spinnerTwoValue.equals(gbp)) {
                    result = inputValue / 1.13;
                    answer.setText(Double.toString(result)+gbp);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
                else if (spinnerOneValue.equals(eur) && spinnerTwoValue.equals(jpy)) {
                    result = inputValue * 126.10;
                    answer.setText(Double.toString(result) + jpy);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
                else if (spinnerOneValue.equals(eur) && spinnerTwoValue.equals(cad)) {
                    result = inputValue * 1.55;
                    answer.setText(Double.toString(result) + cad);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }else if (spinnerOneValue.equals(eur) && spinnerTwoValue.equals(taka)) {
                    result = inputValue * 103.05;
                    answer.setText(Double.toString(result) + taka);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }

                //gbp to others
                if (spinnerOneValue.equals(gbp) && spinnerTwoValue.equals(eur)) {
                    result = inputValue * 1.13;
                    answer.setText(Double.toString(result) + eur);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                } else if (spinnerOneValue.equals(gbp) && spinnerTwoValue.equals(usd)) {
                    result = inputValue / 0.73;
                    answer.setText(Double.toString(result)+usd);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
                else if (spinnerOneValue.equals(gbp) && spinnerTwoValue.equals(jpy)) {
                    result = inputValue * 141.95;
                    answer.setText(Double.toString(result) + jpy);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
                else if (spinnerOneValue.equals(gbp) && spinnerTwoValue.equals(cad)) {
                    result = inputValue * 1.74;
                    answer.setText(Double.toString(result) + cad);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }else if (spinnerOneValue.equals(gbp) && spinnerTwoValue.equals(taka)) {
                    result = inputValue * 116.06;
                    answer.setText(Double.toString(result) + taka);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }

                //jpy to others
                if (spinnerOneValue.equals(jpy) && spinnerTwoValue.equals(eur)) {
                    result = inputValue / 126.10;
                    answer.setText(Double.toString(result) + eur);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                } else if (spinnerOneValue.equals(jpy) && spinnerTwoValue.equals(gbp)) {
                    result = inputValue / 141.95;
                    answer.setText(Double.toString(result)+gbp);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
                else if (spinnerOneValue.equals(jpy) && spinnerTwoValue.equals(usd)) {
                    result = inputValue / 103.77;
                    answer.setText(Double.toString(result) + usd);
                        Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
                else if (spinnerOneValue.equals(jpy) && spinnerTwoValue.equals(cad)) {
                    result = inputValue * 0.012;
                    answer.setText(Double.toString(result) + cad);
                        Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }else if (spinnerOneValue.equals(jpy) && spinnerTwoValue.equals(taka)) {
                    result = inputValue * 0.82;
                    answer.setText(Double.toString(result) + taka);
                        Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }

                //cad to others

                if (spinnerOneValue.equals(cad) && spinnerTwoValue.equals(eur)) {
                    result = inputValue / 1.55;
                    answer.setText(Double.toString(result) + eur);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();

                } else if (spinnerOneValue.equals(cad) && spinnerTwoValue.equals(gbp)) {
                    result = inputValue / 1.74;
                    answer.setText(Double.toString(result)+gbp);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
                else if (spinnerOneValue.equals(cad) && spinnerTwoValue.equals(jpy)) {
                    result = inputValue / 0.012;
                    answer.setText(Double.toString(result) + jpy);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
                else if (spinnerOneValue.equals(cad) && spinnerTwoValue.equals(usd)) {
                    result = inputValue / 1.27;
                    answer.setText(Double.toString(result) + usd);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }else if (spinnerOneValue.equals(cad) && spinnerTwoValue.equals(taka)) {
                    result = inputValue * 66.67;
                    answer.setText(Double.toString(result) + taka);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }

                //taka to others
                if (spinnerOneValue.equals(taka) && spinnerTwoValue.equals(eur)) {
                    result = inputValue / 103.05;
                    answer.setText(Double.toString(result) + eur);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                } else if (spinnerOneValue.equals(taka) && spinnerTwoValue.equals(gbp)) {
                    result = inputValue / 116.06;
                    answer.setText(Double.toString(result)+gbp);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
                else if (spinnerOneValue.equals(taka) && spinnerTwoValue.equals(jpy)) {
                    result = inputValue / 0.82;
                    answer.setText(Double.toString(result) + jpy);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
                else if (spinnerOneValue.equals(taka) && spinnerTwoValue.equals(cad)) {
                    result = inputValue / 66.67;
                    answer.setText(Double.toString(result) + cad);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }else if (spinnerOneValue.equals(taka) && spinnerTwoValue.equals(usd)) {
                    result = inputValue / 84.80;
                    answer.setText(Double.toString(result) + usd);
                    Toast.makeText(UnitActivity.this,"Successfully Converted",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}