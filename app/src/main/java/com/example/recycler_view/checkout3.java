package com.example.recycler_view;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class checkout3 extends AppCompatActivity {
    int q;
    TextView t1;
    Button b2;
    String h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout3);
        Bundle extras = getIntent().getExtras();
        q = extras.getInt("total");
        h= extras.getString("add");
        t1 = findViewById(R.id.textView19);
        t1.setText("Rs" + String.valueOf(q));
        b2 = findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addNotification(h,q);
               Intent p=new Intent(checkout3.this,checkout2.class);
               startActivity(p);


            }
        });


    }

    /*private void addNotification() {
        Intent intent = new Intent(checkout3.this, shop.class);
        PendingIntent contentIntent = PendingIntent.getActivity(checkout3.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder b = new NotificationCompat.Builder(checkout3.this);

        b.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                //.setSmallIcon(R.drawable.ic_launcher)
                .setTicker("Hearty365")
                .setContentTitle("Default notification")
                .setContentText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
                .setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_SOUND)
                .setContentIntent(contentIntent)
                .setContentInfo("Info");


        NotificationManager notificationManager = (NotificationManager) checkout3.this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, b.build());
    }
}
*/
    private void addNotification(String h,int q) {
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {


            String CHANNEL_ID = "my";
            CharSequence name = "my_channel";
            String Description = "This is my channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mChannel.setDescription(Description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] events = new String[6];
        events[0] = new String("THANK YOU FOR PURCHASING");
        events[1] = new String("YOUR ORDER WILL BE DELIVERED TO");
        events[2] = new String("'"+h+"'");
        events[3] = new String("WORTH Rs'"+String.valueOf(q)+"'");


        // Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("SHOP ON");

        // Moves events into the big view
        for (int i=0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "my")
                .setSmallIcon(R.drawable.main)
                .setContentTitle("SHOP ON")
                .setStyle(inboxStyle);

        Intent resultIntent = new Intent(this, checkout3.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(checkout3.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(resultPendingIntent);

        notificationManager.notify(0, builder.build());
    }
}