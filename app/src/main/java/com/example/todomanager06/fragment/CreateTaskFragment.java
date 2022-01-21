package com.example.todomanager06.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.Navigation;

import com.example.todomanager06.R;
import com.example.todomanager06.databinding.FragmentCreateTaskBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;

public class CreateTaskFragment extends BottomSheetDialogFragment implements DatePickerDialog.OnDateSetListener {
    FragmentCreateTaskBinding binding;
    private int startYear;
    private int startMonth;
    private int startDay;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
    }

    private void initClickers() {
        binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendText();
            }
        });
        binding.chooseDateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        binding.chooseRepeatTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRepeatDialog();
            }
        });
    }

    private void sendText() {
        String text = binding.taskEd.getText().toString();
        if (text.isEmpty()) {
            binding.taskEd.setError("Ошибка");
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("key", text);
            Navigation.findNavController(requireView()).navigate(R.id.homeFragment, bundle);
        }
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        startYear = calendar.get(Calendar.YEAR);
        startMonth = calendar.get(Calendar.MONTH);
        startDay = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), this, startYear, startMonth, startDay);
        datePickerDialog.show();
    }

    private void showRepeatDialog() {

        Dialog alertDialog = new Dialog(requireContext(), R.style.CustomBottomSheetDialogTheme);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.repeat_dialog, requireView().findViewById(R.id.bottom_shit_con));

        alertDialog.setContentView(view);
        alertDialog.show();


        RadioButton never = alertDialog.findViewById(R.id.never_radioBtn);
        RadioButton everyDay = alertDialog.findViewById(R.id.Every_day_btn);
        RadioButton everyWeer = alertDialog.findViewById(R.id.Every_week_btn);
        RadioButton everyMonth = alertDialog.findViewById(R.id.Every_month_btn);
        RadioButton everyYear = alertDialog.findViewById(R.id.Every_year_btn);
        RadioButton custom = alertDialog.findViewById(R.id.Custom_btn);
        never.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.chooseRepeatTv.setText("Never");
                alertDialog.dismiss();
                }
        });
        everyDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.chooseRepeatTv.setText("Every day");
                alertDialog.dismiss();
            }
        });
        everyWeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.chooseRepeatTv.setText("Every week");
                alertDialog.dismiss();
            }
        });
        everyMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.chooseRepeatTv.setText("Every month");
                alertDialog.dismiss();
            }
        });
        everyYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.chooseRepeatTv.setText("Every year");
                alertDialog.dismiss();
            }
        });
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.chooseRepeatTv.setText("Custom");
                alertDialog.dismiss();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        binding.chooseDateTv.setText("" + day + "." + month + 1 + "." + year);
    }
}