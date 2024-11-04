package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.main.MainFragment;
import com.example.myapplication.model.Category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainAdapter extends FragmentStateAdapter {

    private List<Category> categories = new ArrayList<>();

    public MainAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return MainFragment.newInstance(categories.get(position));
    }

    @Override
    public long getItemId(int position) {
        return categories.get(position).getId();
    }

    @Override
    public boolean containsItem(long itemId) {
        return categories.stream().anyMatch(category -> category.getId() == itemId);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void updateCategories(List<Category> categories) {
        this.categories.clear();
        Collections.shuffle(categories);
        this.categories.addAll(categories);
        notifyDataSetChanged();
    }
}
