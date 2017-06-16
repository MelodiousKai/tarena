package day01.core4_groupon.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import day01.core4_groupon.R;

public class MainActivity extends AppCompatActivity {

    //头部
    @BindView(R.id.main_top_LinearLayout)
    LinearLayout city_LinearLayout;//城市按钮

    @BindView(R.id.main_top_location_TextView)
    TextView city_TextView;//城市文字

    @BindView(R.id.main_top_seek_TextView)
    TextView seek_TextView; //搜索按钮

    @BindView(R.id.main_top_more_ImageButton)
    ImageButton menu_ImageButton;//菜单按钮

    @BindView(R.id.main_menu)
    LinearLayout menu_LinearLayout;//菜单按钮


    //中段
    @BindView(R.id.main_PullToRefreshListView)
    PullToRefreshListView pullToRefreshListView;

    //底部
    @BindView(R.id.main_bottom_RadioGroup)
    RadioGroup radioGroup;

    ListView listView;
    ArrayList<String> datas;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListView();
    }

    private void initListView() {
        listView = pullToRefreshListView.getRefreshableView();
        datas = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datas);
        listView.setAdapter(adapter);

        //添加下拉松手后的刷新
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        datas.add(0,"新增内容");
                        adapter.notifyDataSetChanged();
                        pullToRefreshListView.onRefreshComplete();
                    }
                },2000);
            }
        });

        //为ListView添加若干头部
        LayoutInflater inflater = LayoutInflater.from(this);
        View list_ads=inflater.inflate(R.layout.header_list_ads,listView,false);
        View list_categories=inflater.inflate(R.layout.header_list_categories,listView,false);
        View list_icons=inflater.inflate(R.layout.header_list_icons,listView,false);
        View list_recommend=inflater.inflate(R.layout.header_list_recommend,listView,false);
        View list_square=inflater.inflate(R.layout.header_list_square,listView,false);

        listView.addHeaderView(list_icons);//增加listview的头部
        listView.addHeaderView(list_square);
        listView.addHeaderView(list_ads);
        listView.addHeaderView(list_categories);
        listView.addHeaderView(list_recommend);


    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    private void refresh() {
        datas.add("aaa");
        datas.add("bbb");
        datas.add("ccc");
        datas.add("ddd");
        datas.add("eee");
        datas.add("fff");
        datas.add("ggg");
        datas.add("hhh");
        datas.add("iii");
        datas.add("jjj");
    }

    @OnClick(R.id.main_top_LinearLayout)
    public void jumpToCity(View view){
        //Intent intent = new Intent(this,CityActivity.class);
        //startActivity(intent);
    }

    @OnClick(R.id.main_top_more_ImageButton)
    public void setMenu(View view){
        if (menu_LinearLayout.getVisibility() == View.VISIBLE){
            menu_LinearLayout.setVisibility(View.INVISIBLE);
        }{
            menu_LinearLayout.setVisibility(View.VISIBLE);
        }
    }

}
