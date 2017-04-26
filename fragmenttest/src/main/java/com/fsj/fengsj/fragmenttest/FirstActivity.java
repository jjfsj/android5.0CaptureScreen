package com.fsj.fengsj.fragmenttest;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;


public class FirstActivity extends Activity implements LeftFragment.MyListener
{
    /**
     * 实现MyListener,当LeftFragment中点击第一页的时候，让RightFragment显示第一页信息,同理当点击第二页的时候，RightFragment显示第二页信息
     *
     * @param index
     *            显示的页数
    */
    public void showMessage(int index)
    {
        if(1 == index) {
            showMessageView.setText(R.string.first_page);
            showMessageView.setBackgroundColor(0Xffaa66cc);
        }
        if(2 == index) {
            showMessageView.setText(R.string.second_page);
            showMessageView.setBackgroundColor(0Xffff8800);
        }
        if(3 == index) {
            showMessageView.setText(R.string.third_page);
            showMessageView.setBackgroundColor(0Xff00ddff);
        }
    }

    /** 得到RightFragment中显示信息的控件 */
    private TextView showMessageView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        System.out.println("Activity--->onCreate");

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        // 动态增加Fragment
        RightFragment rightFragment = new RightFragment();
        LeftFragment leftFragment = new LeftFragment();
        transaction.add(R.id.left_layout, leftFragment, "leftfragment");
        transaction.add(R.id.right_layout, rightFragment, "rightfragment");
        transaction.commit();

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        System.out.println("Activity--->onResume");
        showMessageView = (TextView) findViewById(R.id.right_show_message);
    }
}
