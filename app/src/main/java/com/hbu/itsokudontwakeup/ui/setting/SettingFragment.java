package com.hbu.itsokudontwakeup.ui.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hbu.itsokudontwakeup.R;
import com.hbu.itsokudontwakeup.databinding.FragmentSettingBinding;
import com.hbu.itsokudontwakeup.store.BoundStore;
import com.hbu.itsokudontwakeup.store.SettingStore;

public class SettingFragment extends Fragment {

  private FragmentSettingBinding binding;
  private SettingStore store;
  private EditText phoneEditText;
  private EditText messageEditText;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentSettingBinding.inflate(inflater, container, false);
    LinearLayout root = binding.getRoot();
    store = BoundStore.getSettingStore();
    loadData();

    Button settingSaveButton = root.findViewById(R.id.save_setting_button);
    phoneEditText = root.findViewById(R.id.target_phone);
    messageEditText = root.findViewById(R.id.target_message);

    settingSaveButton.setOnClickListener(v -> {
      String phone = phoneEditText.getText().toString();
      String message = messageEditText.getText().toString();
      store.updatePhone(phone);
      store.updateMessage(message);
    });

    return root;
  }

  public void loadData() {
    String phone = store.getPhone();
    String message = store.getMessage();

    if (phone != null) {
      phoneEditText.setText(phone);
    }

    if (message != null) {
      messageEditText.setText(message);
    }
  }

}
