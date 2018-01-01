package com.jia.tabulationrecyclerview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);

        final List<ItemBean> beanList = new ArrayList<>();
        beanList.add(new ItemBean("title1", "", 0));
        beanList.add(new ItemBean("", "content1", 1));
        beanList.add(new ItemBean("", "content1", 1));
        beanList.add(new ItemBean("", "content1", 1));
        beanList.add(new ItemBean("", "content1", 1));
        beanList.add(new ItemBean("title2", "", 0));
        beanList.add(new ItemBean("", "content2", 1));
        beanList.add(new ItemBean("", "content2", 1));
        beanList.add(new ItemBean("", "content2", 1));
        beanList.add(new ItemBean("", "content2", 1));
        beanList.add(new ItemBean("", "content2", 1));
        beanList.add(new ItemBean("title3", "", 0));
        beanList.add(new ItemBean("", "content3", 1));
        beanList.add(new ItemBean("", "content3", 1));
        beanList.add(new ItemBean("", "content3", 1));
        beanList.add(new ItemBean("", "content3", 1));
        beanList.add(new ItemBean("", "content3", 1));
        beanList.add(new ItemBean("", "content3", 1));
        beanList.add(new ItemBean("", "content3", 1));
        ItemAdapter adapter = new ItemAdapter(beanList);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (beanList.get(position).mItemType == 0) {
                    return gridLayoutManager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }
}
