package com.fsj.fengsj.preferencetest;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by fengsj on 2015/12/8.
 */
public class PrefTest extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.text_preference);
    }


}
