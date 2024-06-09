package com.hbu.itsokudontwakeup.store;

import android.content.SharedPreferences;

public class SettingStore {

  private final SharedPreferences preferences;

  public SettingStore(SharedPreferences preferences) {
    this.preferences = preferences;
  }


  public String getPhone() {
    return preferences.getString("targetPhone", null);
  }

  public void updatePhone(String phone) {
    preferences.edit()
            .putString("targetPhone", phone)
            .apply();
  }

  public String getMessage() {
    return preferences.getString("targetMessage", null);
  }

  public void updateMessage(String message) {
    preferences.edit()
            .putString("targetMessage", message)
            .apply();
  }

}
