package com.example.myapplication.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.Category;

public class MainFragment extends Fragment {

    private Category category;

    public static MainFragment newInstance(Category category) {
        MainFragment fragment = new MainFragment();
        fragment.category = category;
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        TextView textView = view.findViewById(R.id.textView);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            if (getActivity() != null) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.updateData(category.getId());
            }
        });

        if (category != null) {
            String categoryName = category.getName();
            textView.setText(categoryName);
        }

        return view;
    }
}
