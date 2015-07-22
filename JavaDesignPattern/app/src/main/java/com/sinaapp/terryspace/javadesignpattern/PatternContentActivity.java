package com.sinaapp.terryspace.javadesignpattern;

import android.support.v4.app.Fragment;

/**
 * Created by terry on 6/28/15.
 */
public class PatternContentActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new PatternContentFragment();
    }
}
