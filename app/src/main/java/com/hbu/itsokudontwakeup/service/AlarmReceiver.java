package com.hbu.itsokudontwakeup.service;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.hbu.itsokudontwakeup.R;

public class AlarmReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    Toast.makeText(context, "알림이 울립니다!", Toast.LENGTH_LONG).show();

    boolean isBootCompleted = Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction());

    if (isBootCompleted) {
    }

//    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//    long[] vibrationPattern = {0, 500, 500, 500};
//
//    // NotificationBuilder를 사용하여 알림을 생성
//    NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "alarm")
//            .setSmallIcon(R.drawable.dog) // 알림 아이콘 설정
//            .setContentTitle("알람 제목")
//            .setContentText("알람 내용")
//            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .setSound(alarmSound)
//            .setVibrate(vibrationPattern);
//
//    // NotificationManager를 사용하여 알림을 표시
//    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
//    notificationManager.notify(0, builder.build());
//
//    // 진동 기능 설정
//    Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
//    vibrator.vibrate(vibrationPattern, -1);
  }

}
