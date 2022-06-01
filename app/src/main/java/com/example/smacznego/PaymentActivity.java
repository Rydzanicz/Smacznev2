package com.example.smacznego;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {


    Button send_button;
    EditText send_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        send_button = (Button) findViewById(R.id.sendadressbutton);
        send_text = (EditText) findViewById(R.id.sendadress);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String kod = send_text.getText().toString();

                if (kod.matches("[0-9]+") && kod.length() == 6) {

                    Toast.makeText(PaymentActivity.this, "Płatność przeszła pozytywnie", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), MapActivity.class);

                    startActivity(intent);

                } else {
                    Toast.makeText(PaymentActivity.this, "Kod błędny", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}

