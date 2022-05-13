package com.example.smacznego;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.drawable.IconCompat;


public class PizzaActivity extends AppCompatActivity {

    Button pizza1, pizza2, submitButton;
    float rating = 3.5F;
    String CHANNEL_ID = "personal_notifications";
    int NOTIFICATION_ID = 001, pizzaMuch1 = 0, amount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        pizza1 = (Button) findViewById(R.id.addPizza1);
        pizza1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = amount + 25;
                Toast.makeText(PizzaActivity.this, "Dodano do koszyka", Toast.LENGTH_SHORT).show();
            }
        });
        pizza2 = (Button) findViewById(R.id.addPizza2);
        pizza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = amount + 35;
                Toast.makeText(PizzaActivity.this, "Dodano do koszyka", Toast.LENGTH_SHORT).show();
            }
        });


        final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotyChannel();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(PizzaActivity.this, CHANNEL_ID);
                builder.setSmallIcon(android.R.drawable.btn_star_big_on);
                String rating = " " + simpleRatingBar.getRating() + " / " + simpleRatingBar.getNumStars();
                builder.setContentTitle("Ocena");
                builder.setContentText("Dziękujemy ocenianie restaruacji" + rating);
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(PizzaActivity.this);
                notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
                Intent intent = new Intent(getApplicationContext(), BasketActivity.class);


                intent.putExtra("pizza", amount);

                startActivity(intent);
            }
        });
    }

    private void createNotyChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Persolan Notyfication";
            String descripton = "Include all notyficatiomn";
            int importace = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importace);
            notificationChannel.setDescription(descripton);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }


}


