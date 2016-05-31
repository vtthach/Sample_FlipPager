package dmt.dynamicpageradapter.adapter.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Project:  and_exp
 * Author:   Khuong Vo
 * Since:    5/19/2016
 * Time:     1:16 PM
 */
public class DynamicFragmentModel {
    private Class<?> cls;
    private Fragment fragment;
    private Bundle bundle;

    public DynamicFragmentModel(Class<?> cls, Fragment fragment, Bundle bundle) {
        this.cls = cls;
        this.fragment = fragment;
        this.bundle = bundle;
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
