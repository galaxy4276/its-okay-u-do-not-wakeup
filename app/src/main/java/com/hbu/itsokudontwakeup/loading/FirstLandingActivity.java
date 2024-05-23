package com.hbu.itsokudontwakeup.loading;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hbu.itsokudontwakeup.R;

public class FirstLandingActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.landing);

    process();
  }

  private void process() {
    new Thread() {
      @Override
      public void run() {
        try {
          super.run();
          sleep(2000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        } finally {
          finish();
        }
      }
    }.start();
  }

}
