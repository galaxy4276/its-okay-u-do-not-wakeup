package com.hbu.itsokudontwakeup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hbu.itsokudontwakeup.ui.alarmlist.AlarmListFragment;
import com.hbu.itsokudontwakeup.ui.dashboard.DashboardFragment;
import com.hbu.itsokudontwakeup.ui.notifications.NotificationsFragment;
import com.hbu.itsokudontwakeup.ui.setting.SettingFragment;

public class HeaderNavAdapter extends FragmentStateAdapter {

  public HeaderNavAdapter(@NonNull FragmentActivity fragmentActivity) {
    super(fragmentActivity);
  }

  @NonNull
  @Override
  public Fragment createFragment(int position) {
    switch (position) {
      case 1:
        return new DashboardFragment();
      case 2:
        return new SettingFragment();
      default:
        return new AlarmListFragment();
    }
  }

  @Override
  public int getItemCount() {
    return 3;
  }
}
