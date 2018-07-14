package com.arouter.module_begin;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.widget.TabHost;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.arouter.baselibrary.BaseActivity;
import com.arouter.baselibrary.JumpUtil;
import com.arouter.module_home.HomeFragment;
import com.arouter.module_mine.MineFragment;
import com.arouter.module_video.VideoFragment;


@Route(path = JumpUtil.MainActivity)
public class MainActivity extends BaseActivity {

    private int[] tabIcon = {R.drawable.ic_home_red, R.drawable.ic_video_black, R.drawable.ic_mine_black};
    private String[] tabText = {"首页", "视频", "我的"};
    private TabSpec mTabSpec1;
    private TabSpec mTabSpec2;
    private TabSpec mTabSpec3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentTabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabSpec1 = new TabSpec(tabHost, tabText[0], tabIcon[0]);
        mTabSpec2 = new TabSpec(tabHost, tabText[1], tabIcon[1]);
        mTabSpec3 = new TabSpec(tabHost, tabText[2], tabIcon[2]);

        tabHost.addTab(mTabSpec1.getTabSpec(), HomeFragment.class, null);
        tabHost.addTab(mTabSpec2.getTabSpec(), VideoFragment.class, null);
        tabHost.addTab(mTabSpec3.getTabSpec(), MineFragment.class, null);

        tabHost.setCurrentTab(0);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                setSelectImage(s);
            }
        });
    }

    /**
     * 选中时候的背景图片设置
     * @param tagID
     */
    public void setSelectImage(String tagID){
        if (tagID.equals(mTabSpec1.name)) {
            mTabSpec1.imageView.setImageResource(R.drawable.ic_home_red);
            mTabSpec2.imageView.setImageResource(R.drawable.ic_video_black);
            mTabSpec3.imageView.setImageResource(R.drawable.ic_mine_black);
        } else if (tagID.equals(mTabSpec2.name)) {
            mTabSpec1.imageView.setImageResource(R.drawable.ic_home_black);
            mTabSpec2.imageView.setImageResource(R.drawable.ic_video_red);
            mTabSpec3.imageView.setImageResource(R.drawable.ic_mine_black);
        } else if (tagID.equals(mTabSpec3.name)) {
            mTabSpec1.imageView.setImageResource(R.drawable.ic_home_black);
            mTabSpec2.imageView.setImageResource(R.drawable.ic_video_black);
            mTabSpec3.imageView.setImageResource(R.drawable.ic_mine_red);
        }
    }
}
