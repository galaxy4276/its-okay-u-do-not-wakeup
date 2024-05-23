package com.hbu.itsokudontwakeup;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hbu.itsokudontwakeup.loading.FirstLandingActivity;


public class MainActivity extends AppCompatActivity {

  private com.hbu.itsokudontwakeup.databinding.ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeTab();

    redirectFirstLoading();
  }

  private void redirectFirstLoading() {
    Intent intent = new Intent(MainActivity.this, FirstLandingActivity.class);
    startActivity(intent);
  }

  private void initializeTab() {
    TabLayout tabLayout = findViewById(R.id.header_nav);
    ViewPager2 pager = findViewById(R.id.header_nav_pager);
    HeaderNavAdapter adapter = new HeaderNavAdapter(this);
    pager.setAdapter(adapter);

    new TabLayoutMediator(tabLayout, pager, (tab, pos) -> {
      switch (pos) {
        case 0:
          tab.setText("알림");
          break;
        case 1:
          tab.setText("알림 내역 보기");
          break;
        case 2:
          tab.setText("설정");
          break;
      }
    }).attach();
  }

}
