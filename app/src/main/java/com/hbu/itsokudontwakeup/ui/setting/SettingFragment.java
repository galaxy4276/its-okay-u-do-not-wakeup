package com.hbu.itsokudontwakeup.ui.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hbu.itsokudontwakeup.databinding.FragmentAlarmlistBinding;
import com.hbu.itsokudontwakeup.databinding.FragmentSettingBinding;

public class SettingFragment extends Fragment {

  private FragmentSettingBinding binding;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentSettingBinding.inflate(inflater, container, false);
    LinearLayout root = binding.getRoot();

    return root;
  }
}
