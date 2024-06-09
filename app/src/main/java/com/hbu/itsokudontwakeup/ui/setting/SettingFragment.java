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

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentSettingBinding.inflate(inflater, container, false);
    LinearLayout root = binding.getRoot();
    store = BoundStore.getSettingStore();

    Button settingSaveButton = root.findViewById(R.id.save_setting_button);

    settingSaveButton.setOnClickListener(v -> {
      EditText phoneEditText = root.findViewById(R.id.target_phone);
      EditText messageEditText = root.findViewById(R.id.target_message);

      String phone = phoneEditText.getText().toString();
      String message = messageEditText.getText().toString();

      store.updatePhone(phone);
      store.updateMessage(message);
    });

    return root;
  }

}
