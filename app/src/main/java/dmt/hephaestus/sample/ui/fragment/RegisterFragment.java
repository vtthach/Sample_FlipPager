package dmt.hephaestus.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dmt.hephaestus.sample.ui.activity.base.BaseFragment;
import sample.dynamic_pager_adapter.R;

/**
 * Project:  hephaestus
 * Author:   Khuong Vo
 * Since:    5/24/2016
 * Time:     7:13 AM
 */
public class RegisterFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("vtt", "RegisterFragment onDestroy");
    }

    protected void init() {
        Log.i("vtt", "RegisterFragment init");

    }
}
