package com.hbu.itsokudontwakeup.store;

import android.content.SharedPreferences;

public class UserStore {
  private final SharedPreferences preferences;


  public UserStore(SharedPreferences preferences) {
    this.preferences = preferences;
  }

  public String getUserName() {
    return preferences.getString("username", null);
  }

  public void updateUserName(String userName) {
    preferences.edit()
            .putString("username", userName)
            .apply();
  }

}
