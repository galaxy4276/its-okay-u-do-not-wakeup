package com.hbu.itsokudontwakeup.service;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.hbu.itsokudontwakeup.R;

import java.util.List;

public class AlarmListAdapter extends BaseAdapter {
  private Context context;
  private List<String> alarmList;
  private LayoutInflater inflater;

  public AlarmListAdapter(Context context, List<String> alarmList) {
    this.context = context;
    this.alarmList = alarmList;
    this.inflater = LayoutInflater.from(context);
  }

  @Override
  public int getCount() {
    return alarmList.size();
  }

  @Override
  public Object getItem(int position) {
    return alarmList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      convertView = inflater.inflate(R.layout.alarm_list_item, parent, false);
    }

    TextView alarmTime = convertView.findViewById(R.id.alarm_time);
    Switch alarmSwitch = convertView.findViewById(R.id.alarm_switch);

    String time = alarmList.get(position);
    alarmTime.setText(time);
    // Add any additional logic for Switch or other UI components here

    return convertView;
  }
}
