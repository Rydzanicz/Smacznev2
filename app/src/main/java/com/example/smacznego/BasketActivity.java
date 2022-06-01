package com.example.smacznego;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BasketActivity extends AppCompatActivity {

    Button button;
    int amount = 0;
    private TextView tekst;
    EditText send_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        button = (Button) findViewById(R.id.button);
        tekst = (TextView) findViewById(R.id.amountTekst);
        Intent intent = getIntent();
        amount = intent.getIntExtra("pizza", 0);
        tekst.setText("Do zapłaty: " + amount);
        send_text = (EditText) findViewById(R.id.note11);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amount == 0) {
                    Toast.makeText(BasketActivity.this, "Nic nie dodano do koszyka", Toast.LENGTH_LONG).show();

                } else {
                    String rating = " Kwota:" + amount + "\n Notatka: " + send_text.getText().toString();
                    Toast.makeText(BasketActivity.this, rating, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

}
