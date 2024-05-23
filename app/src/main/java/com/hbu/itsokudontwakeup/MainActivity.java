package com.hbu.itsokudontwakeup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.tabs.TabLayout;
import com.hbu.itsokudontwakeup.loading.FirstLandingActivity;


public class MainActivity extends AppCompatActivity {

  private com.hbu.itsokudontwakeup.databinding.ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    redirectFirstLoading();

    TabLayout tabLayout = findViewById(R.id.header_nav);
    tabLayout.addTab(tabLayout.newTab().setText("알림"));
    tabLayout.addTab(tabLayout.newTab().setText("알림 내역 보기"));
    tabLayout.addTab(tabLayout.newTab().setText("설정"));
  }

  private void redirectFirstLoading() {
    Intent intent = new Intent(MainActivity.this, FirstLandingActivity.class);
    startActivity(intent);
  }

}
