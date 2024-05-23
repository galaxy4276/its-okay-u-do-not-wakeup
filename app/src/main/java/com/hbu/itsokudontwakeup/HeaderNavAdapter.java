package com.hbu.itsokudontwakeup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.hbu.itsokudontwakeup.ui.dashboard.DashboardFragment;
import com.hbu.itsokudontwakeup.ui.home.HomeFragment;
import com.hbu.itsokudontwakeup.ui.notifications.NotificationsFragment;

public class HeaderNavAdapter extends FragmentStateAdapter {

  public HeaderNavAdapter(@NonNull FragmentActivity fragmentActivity) {
    super(fragmentActivity);
  }

  @NonNull
  @Override
  public Fragment createFragment(int position) {
    switch (position) {
      case 0:
        return new HomeFragment();
      case 1:
        return new DashboardFragment();
      case 2:
        return new NotificationsFragment();
      default:
        return new HomeFragment();
    }
  }

  @Override
  public int getItemCount() {
    return 3;
  }
}
