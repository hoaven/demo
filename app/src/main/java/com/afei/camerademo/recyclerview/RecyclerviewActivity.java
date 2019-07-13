package com.afei.camerademo.recyclerview;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.afei.camerademo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerviewActivity extends AppCompatActivity {
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private DataAdapter adapter;
    private LinearLayoutManager layoutManager;
    private List<Integer> listData = new ArrayList<>();
    private int count = 0;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        handler=new Handler();
        layoutManager = new LinearLayoutManager(this);
        adapter = new DataAdapter(this,listData,layoutManager);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        //设置下拉时圆圈的颜色（可以尤多种颜色拼成）
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light);
        //设置下拉时圆圈的背景颜色（这里设置成白色）
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData("refresh");
            }
        });

        recyclerView.addOnScrollListener(new onLoadMoreListener() {
            @Override
            protected void onLoading(int countItem,int lastItem) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getData("loadMore");
                    }
                },3000);
            }
        });

        getData("reset");


    }

    private void getData(final String type) {
        if ("refresh".equals(type)) {
            listData.clear();
            count = 0;
            for (int i = 0; i < 5; i++) {
                count += 1;
                listData.add(count);
            }
        }
        else {
            for (int i = 0; i < 12; i++) {
                count += 1;
                listData.add(count);
            }
        }

        adapter.notifyDataSetChanged();
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        if ("refresh".equals(type)) {
            Toast.makeText(getApplicationContext(), "刷新完毕", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "加载完毕", Toast.LENGTH_SHORT).show();
        }
    }
}
