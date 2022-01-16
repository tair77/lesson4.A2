package com.example.todomanager06.boarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todomanager06.R;
import com.example.todomanager06.client.ViewPagerClient;
import com.example.todomanager06.databinding.FragmentBoardBinding;
import com.example.todomanager06.model.ViewPagerModel;

import java.util.ArrayList;


public class BoardFragment extends Fragment {
    private FragmentBoardBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBoardBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();

    }
}