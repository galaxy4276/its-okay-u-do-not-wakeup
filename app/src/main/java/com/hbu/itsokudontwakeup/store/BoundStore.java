package com.hbu.itsokudontwakeup.store;

import android.content.SharedPreferences;

public class BoundStore {
  private static SharedPreferences preferences;
  private static UserStore userStore;
  private static SettingStore settingStore;

  public static void init(SharedPreferences preferences) {
    BoundStore.preferences = preferences;
    userStore = new UserStore(preferences);
    settingStore = new SettingStore(preferences);
  }

  public static UserStore getUserStore() {
    if (userStore == null) throw new RuntimeException("스토어가 초기화되지 않았습니다.");
    return userStore;
  }

  public static SettingStore getSettingStore() {
    if (settingStore == null) throw new RuntimeException("스토어가 초기화되지 않았습니다.");
    return settingStore;
  }

}
