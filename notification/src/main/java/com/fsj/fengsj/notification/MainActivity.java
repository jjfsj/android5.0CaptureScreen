package com.fsj.fengsj.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    boolean flag = false;

    //通知栏消息
    private int messageNotificationID = 1000;
    private Notification messageNotification = null;
    private NotificationManager messageNotificatioManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse("http://android.d.cn/rm/2/1100/147182/?http://down.androidgame-store.com/201307121000/079D2048C0545D7DE6B4D077B12DAADD/new/game1/39/109139/txsjgj_1372383471296.apk");
        Intent intent =new Intent(Intent.ACTION_VIEW, uri);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        //更新通知栏
        messageNotification = new Notification.Builder(this)
                .setContentTitle("新消息")
                .setContentText("点我就下载!")
                .setSmallIcon(R.drawable.face)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.face))
                .setTicker("有新版本升级了，快去看看！")
                .setDefaults(Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setContentIntent(pIntent)
                .build();
        messageNotificatioManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        Button messageBt= (Button)findViewById(R.id.messageBt);
        messageBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageNotificatioManager.notify(messageNotificationID, messageNotification);
            }
        });

        //每次通知完，通知ID递增一下，避免消息覆盖掉
       // messageNotificationID++;

        Button cancelBt= (Button)findViewById(R.id.cancelBt);
        cancelBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageNotificatioManager.cancel(messageNotificationID);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
