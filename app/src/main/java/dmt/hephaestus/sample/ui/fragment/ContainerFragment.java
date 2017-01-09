package dmt.hephaestus.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.BindView;
import dmt.hephaestus.sample.ui.activity.base.BaseFragment;
import sample.dynamic_pager_adapter.R;

/**
 * Project:  hephaestus
 * Author:   Khuong Vo
 * Since:    5/24/2016
 * Time:     12:36 PM
 */
public class ContainerFragment extends BaseFragment {

    @BindView(R.id.layout_container)
    FrameLayout layoutContainer;
    @BindView(R.id.layout_card)
    FrameLayout layoutCard;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_container, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("vtt", "ContainerFragment onDestroy");
    }

    protected void init() {
        Log.i("vtt", "ContainerFragment init");

    }
    public void replaceFragment(Class<?> cls, Bundle b) {
        Fragment f = Fragment.instantiate(getActivity(), cls.getName(), b);
        getChildFragmentManager().beginTransaction().replace(R.id.layout_container, f).commitAllowingStateLoss();
    }
}