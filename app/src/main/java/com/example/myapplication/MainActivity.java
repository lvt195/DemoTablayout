package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.myapplication.main.MainFragment;
import com.example.myapplication.model.Category;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mainAdapter;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        mainAdapter = new MainAdapter(this);
        viewPager.setAdapter(mainAdapter);
        mainAdapter.setCategories(Category.createCategory());
        tabLayout = findViewById(R.id.tableLayout);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            Category category = mainAdapter.getCategories().get(position);
            tab.setText(category.getName());
        }).attach();

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Category category = mainAdapter.getCategories().get(position);
                tabLayout.getTabAt(position).setText(category.getName());
            }
        });
    }

    public void updateData(int categoryId) {
        Log.d("abc", "updateData: " + categoryId);
        List<Category> newCategories = Category.createCategory();
        mainAdapter.updateCategories(newCategories);
        for (int i = 0; i < newCategories.size(); i++) {
            if (newCategories.get(i).getId() == categoryId) {
                int finalI = i;
                viewPager.post(new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setCurrentItem(finalI);
                    }
                });
                break;
            }
        }
    }
}
