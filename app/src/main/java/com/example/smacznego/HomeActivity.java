package com.example.smacznego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button kebab,basket,pizza,adress;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        kebab = (Button) findViewById(R.id.TurkishKebab);
        basket = (Button) findViewById(R.id.koszyk);
        pizza = (Button) findViewById(R.id.pizzaItaliana);
        adress = (Button) findViewById(R.id.addresButton);


        basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BasketActivity.class);
                startActivity(intent);
            }
        });
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PizzaActivity.class);
                startActivity(intent);
            }
        });

        kebab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),KebabActivity.class);
                startActivity(intent);
            }
        });

    }
}
