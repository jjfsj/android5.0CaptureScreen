package com.fsj.fengsj.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fengsj on 2015/12/8.
 */

public class RightFragment extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        System.out.println("RightFragment--->onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        System.out.println("RightFragment--->onCreateView");
        return inflater.inflate(R.layout.rightfragment, container, false);
    }
}
