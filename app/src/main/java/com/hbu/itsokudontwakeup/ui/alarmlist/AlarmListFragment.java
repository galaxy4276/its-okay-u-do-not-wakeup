package com.hbu.itsokudontwakeup.ui.alarmlist;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hbu.itsokudontwakeup.R;
import com.hbu.itsokudontwakeup.databinding.FragmentAlarmlistBinding;
import com.hbu.itsokudontwakeup.service.AlarmReceiver;
import com.hbu.itsokudontwakeup.service.AlarmService;

import java.util.Calendar;

public class AlarmListFragment extends Fragment {

  private FragmentAlarmlistBinding binding;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentAlarmlistBinding.inflate(inflater, container, false);
    LinearLayout root = binding.getRoot();
    Button alarmAddButton = root.findViewById(R.id.add_alarm_button);
    alarmAddButton.setOnClickListener(v -> showAddAlarmDialog());

    return root;
  }

  private void showAddAlarmDialog() {
    Context context = binding.getRoot().getContext();
    AlertDialog.Builder builder = new AlertDialog.Builder(context);
    builder.setTitle("새로운 알람 등록");
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.add_alarm_dialog, null);
    builder.setView(view);
    TimePicker timePicker = view.findViewById(R.id.alarm_timepicker);

    builder.setPositiveButton("생성", ((dialog, which) -> {
      int hour = timePicker.getHour();
      int minute = timePicker.getMinute();
      setAlarm(getCalendar(hour, minute));

      dialog.cancel();
    }));
    builder.setNegativeButton("닫기", (dialog, which) -> dialog.cancel());

    builder.create().show();
  }

  private Calendar getCalendar(int hour, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);

    return calendar;
  }

  private void setAlarm(Calendar calendar) {
    Intent intent = new Intent(getContext(), AlarmReceiver.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(
            getContext(),
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
    );
    AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
    alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
  }

}
