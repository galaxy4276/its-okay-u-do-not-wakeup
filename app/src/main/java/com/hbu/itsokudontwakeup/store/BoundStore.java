package com.hbu.itsokudontwakeup.store;

import android.content.SharedPreferences;

public class BoundStore {
  private static SharedPreferences preferences;
  private static UserStore userStore;

  public static void init(SharedPreferences preferences) {
    BoundStore.preferences = preferences;
    userStore = new UserStore(preferences);
  }

  public static UserStore getUserStore() {
    if (userStore == null) throw new RuntimeException("스토어가 초기화되지 않았습니다.");
    return userStore;
  }

}
