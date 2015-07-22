package com.sinaapp.terryspace.javadesignpattern;

import android.support.v4.app.Fragment;

/**
 * Created by terry on 6/27/15.
 */
public class PatternListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new PatternListFragment();
    }
}
