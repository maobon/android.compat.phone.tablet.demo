package com.xin.bob.fragmentbestpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xin.bob.fragmentbestpractice.adapter.NewsTitleListAdapter;
import com.xin.bob.fragmentbestpractice.entity.News;
import com.xin.bob.fragmentbestpractice.mock.MockDataUtils;

import java.util.List;

/**
 * 同时兼容手机和平板电脑的DEMO
 */
public class MainActivity extends AppCompatActivity {

    public boolean isWorkingOnPhone;

    private List<News> data;
    private RecyclerView rvNewsTitleList;
    private NewsTitleListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = MockDataUtils.generate();

        whetherPhoneOrTablet();
        initViews();
    }

    private void whetherPhoneOrTablet() {
        View contentFragment = findViewById(R.id.fragment_content);
        if (contentFragment != null) {
            isWorkingOnPhone = false;
        } else {
            isWorkingOnPhone = true;
        }
    }

    private void initViews() {
        rvNewsTitleList = (RecyclerView) findViewById(R.id.rv_title_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvNewsTitleList.setLayoutManager(layoutManager);

        adapter = new NewsTitleListAdapter(this, data);
        rvNewsTitleList.setAdapter(adapter);
    }

}
