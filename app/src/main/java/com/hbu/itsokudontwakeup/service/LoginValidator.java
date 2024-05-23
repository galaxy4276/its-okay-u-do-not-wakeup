package com.hbu.itsokudontwakeup.service;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.hbu.itsokudontwakeup.R;
import com.hbu.itsokudontwakeup.store.BoundStore;
import com.hbu.itsokudontwakeup.store.UserStore;

public class LoginValidator {
  private final Context context;

  public LoginValidator(Context context) {
    this.context = context;
  }

  public void checkUser() {
    UserStore userStore = BoundStore.getUserStore();
    String userName = userStore.getUserName();
    Log.d("username", "username: " + userName);
    if (userName != null) return;

    LayoutInflater inflater = LayoutInflater.from(context);
    View dialogView = inflater.inflate(R.layout.login_dialog, null);
    TextView textEdit = dialogView.findViewById(R.id.user_input);

    AlertDialog.Builder builder = new AlertDialog.Builder(context);
    builder.setView(dialogView);
    builder.setTitle("최초 유저정보 작성");
    builder.setPositiveButton("등록", (dialog, which) -> {
      userStore.updateUserName(textEdit.getText().toString());
      dialog.cancel();
    });
    builder.create().show();
  }

}
