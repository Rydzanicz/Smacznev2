package com.example.smacznego;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class BasketActivity extends AppCompatActivity {

    Button button;
    int amount = 0, tip = 0;
    SeekBar simpleSeekBar;
    private TextView tekst;
    private AppBarConfiguration appBarConfiguration;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        button = (Button) findViewById(R.id.button);
        tekst = (TextView) findViewById(R.id.amountTekst);
        Intent intent = getIntent();
        amount = intent.getIntExtra("pizza", 0);
        tekst.setText("Do zapłaty: " + amount);

        simpleSeekBar = (SeekBar) findViewById(R.id.seekBar);

        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                tip = progressChangedValue;
                tekst.setText("Do zapłaty: " + (amount + tip));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdressActivity.class);
                startActivity(intent);
            }
        });


    }

}
