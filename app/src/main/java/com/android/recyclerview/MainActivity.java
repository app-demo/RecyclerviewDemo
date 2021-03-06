package com.android.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 相关的类:
 * 1.Adapter
 * 2.ViewHolder
 * 3.RecyclerView.LayoutManager
 * 4.RecyclerView.ItemDecoration
 * 5.RecyclerView.ItemAnimator
 * <p/>
 * 作用：
 * 1.Lisview风格
 * 2.GridView风格
 * 3.横向Lisview风格
 * 4.横向GridView风格
 * 5.瀑布流
 * 6.定制Item增加和删除的动画
 */
public class MainActivity extends AppCompatActivity {
    /**
     * 主要就是回收和复用View
     */
    private RecyclerView mRecyclerView;
    private List<String> mDatas;

    private RecyclerViewAdapter mRecyclerViewAdapter;

    /**
     * 设置RecyclerView显示风格
     */
    RecyclerView.LayoutManager layoutManager;

    /**
     * 设置RecyclerView中的Item分隔
     */
    RecyclerView.ItemDecoration itemDecoration;

    /**
     * 设置RecyclerView中的Item增加和删除的动画
     */
    RecyclerView.ItemAnimator itemAnimator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initViews();
    }

    /**
     * 初始化数据
     */
    private void initDatas() {
        mDatas = new ArrayList<>();

        for (int i = 'A'; i < 'Z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    /**
     * 初始化组件
     */
    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerViewAdapter = new RecyclerViewAdapter(this, mDatas);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);


        // 垂直的布局管理
        LinearLayoutManager linearLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayout);

        //设置Item View分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_lisview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_gridview:
                // 设置3列
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.action_hor_gridview:

                break;
            case R.id.action_staggered:
                // 瀑布流: item宽度必须是固定，确切的
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
