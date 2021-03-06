package com.kingdee.ah.pda;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.kingdee.ah.pda.ui.fragment.HomeFragment;
import com.kingdee.ah.pda.ui.fragment.MineFragment;
import com.kingdee.ah.pda.util.ToastUtil;
import com.next.easynavigation.constant.Anim;
import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 13799 on 2018/5/29.
 */

public class MainActivity extends FragmentActivity {

    @BindView(R.id.bottom_tab_bar2)
    EasyNavigationBar bottomTabBar2;
    private long exitTime = 0;

    private String[] tabText = {"首页", "我的"};
    //未选中是icon
    private int[] normalIcon = {R.drawable.ic_home, R.drawable.ic_mine};
    //选中时icon
    private int[] selectIcon = {R.drawable.ic_home_select, R.drawable.ic_mine_select};
    private List<Fragment> fragments = new ArrayList<>();
    public static void show(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    protected void initView() {

        fragments.add(new HomeFragment());
        fragments.add(new MineFragment());
        bottomTabBar2.defaultSetting()
                .titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)   //  Tab选中图标集合
                .fragmentList(fragments)
                .fragmentManager(getSupportFragmentManager())
                .iconSize(30)     //Tab图标大小
                .tabTextSize(15)   //Tab文字大小
                .tabTextTop(2)     //Tab文字距Tab图标的距离
                .normalTextColor(Color.parseColor("#666666"))   //Tab未选中时字体颜色
                .selectTextColor(Color.parseColor("#333333"))   //Tab选中时字体颜色
                .scaleType(ImageView.ScaleType.CENTER_INSIDE)  //同 ImageView的ScaleType
                .navigationBackground(Color.parseColor("#ffffff"))   //导航栏背景色
                .setOnTabClickListener(new EasyNavigationBar.OnTabClickListener() {
                    @Override
                    public boolean onTabSelectEvent(View view, int position) {
                        //Tab点击事件  return true 页面不会切换
                        return false;
                    }

                    @Override
                    public boolean onTabReSelectEvent(View view, int position) {
                        //Tab重复点击事件
                        return false;
                    }
                })
                .setOnCenterTabClickListener(new EasyNavigationBar.OnCenterTabSelectListener() {
                    @Override
                    public boolean onCenterTabSelectEvent(View view) {
                        ToastUtil.show(MainActivity.this, "暂无页面");
                        return false;
                    }
                })
                .smoothScroll(false)  //点击Tab  Viewpager切换是否有动画
                .canScroll(true)    //Viewpager能否左右滑动
                .mode(EasyNavigationBar.NavigationMode.MODE_NORMAL)   //默认MODE_NORMAL 普通模式  //MODE_ADD 带加号模式
                .anim(Anim.ZoomIn)                //点击Tab时的动画
                // .centerTextStr("发现")
               // .centerImageRes(R.drawable.ic_friend_select)
              //  .centerIconSize(40)    //中间加号图片的大小
              //  .centerLayoutHeight(100)   //包含加号的布局高度 背景透明  所以加号看起来突出一块
                .navigationHeight(60)  //导航栏高度
                .lineHeight(1)         //分割线高度  默认1px
                .lineColor(Color.parseColor("#B2B2B2"))
                // .centerLayoutRule(EasyNavigationBar.RULE_BOTTOM) //RULE_CENTER 加号居中addLayoutHeight调节位置 EasyNavigationBar.RULE_BOTTOM 加号在导航栏靠下
                .centerLayoutBottomMargin(10)   //加号到底部的距离
                .hasPadding(true)    //true ViewPager布局在导航栏之上 false有重叠
                // .hintPointLeft(-3)  //调节提示红点的位置hintPointLeft hintPointTop（看文档说明）
                //  .hintPointTop(-3)
                // .hintPointSize(6)    //提示红点的大小
                // .msgPointLeft(-10)  //调节数字消息的位置msgPointLeft msgPointTop（看文档说明）
                // .msgPointTop(-10)
                //  .msgPointTextSize(9)  //数字消息中字体大小
                //  .msgPointSize(18)    //数字消息红色背景的大小
                //   .centerAlignBottom(true)  //加号是否同Tab文字底部对齐  RULE_BOTTOM时有效；
                // .centerTextTopMargin(50)  //加号文字距离加号图片的距离
                // .centerTextSize(15)      //加号文字大小
                // .centerNormalTextColor(Color.parseColor("#ff0000"))    //加号文字未选中时字体颜色
                // .centerSelectTextColor(Color.parseColor("#00ff00"))    //加号文字选中时字体颜色
                // .setMsgPointColor(Color.BLUE) //数字消息、红点背景颜色
                // .setMsgPointMoreRadius(5) //消息99+角度半径
                // .setMsgPointMoreWidth(50)  //消息99+宽度
                // .setMsgPointMoreHeight(40)  //消息99+高度
                .textSizeType(EasyNavigationBar.TextSizeType.TYPE_DP)  //字体单位 建议使用DP  可切换SP
                .setOnTabLoadListener(new EasyNavigationBar.OnTabLoadListener() { //Tab加载完毕回调
                    @Override
                    public void onTabLoadCompleteEvent() {

                    }
                })
                //.setupWithViewPager(new ViewPager(AllActivity.this))
                //.setupWithViewPager(new ViewPager2(AllActivity.this))
                .build();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtil.show(this, "再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
