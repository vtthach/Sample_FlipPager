package dmt.hephaestus.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dmt.hephaestus.adapter.helper.FlipFragmentPagerHelper;
import dmt.hephaestus.adapter.helper.FlipFragmentPagerHelperImpl;
import dmt.hephaestus.sample.util.transformer.FlipVerticalTransformer;
import sample.dynamic_pager_adapter.R;

/**
 * Project:  and_exp
 * Author:   Khuong Vo
 * Since:    5/24/2016
 * Time:     6:50 AM
 */
public class FlipContainerFragment extends Fragment {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private Unbinder unbinder;

    FlipFragmentPagerHelper flipPagerHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flip_container, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
    }

    protected void init() {
        viewPager.setPageTransformer(false, new FlipVerticalTransformer());

        flipPagerHelper = new FlipFragmentPagerHelperImpl(viewPager, getChildFragmentManager());

        addDefaultFlipFragment();
    }


    public void addWelcomeFragment() {
        flipPagerHelper.addPage(WelcomeFragment.class, null);
    }

    public void addFragment(Class<?> cls, Bundle b) {
        flipPagerHelper.addPage(cls, null);
    }

    private void addDefaultFlipFragment() {
        flipPagerHelper.addPage(DefaultFlipFragment.class, null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_up, R.id.btn_down})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_up:
                /*Bundle b = new Bundle();
                b.putInt(Constants.KEY_INDEX, viewPager.getCurrentItem() + 1);
                Class<?> cls = BaseSampleFragment.class;
                flipPagerHelper.addPage(cls, b);*/
                flipPagerHelper.goToNextPage();
                break;
            case R.id.btn_down:
                flipPagerHelper.goToPreviousPage();
                break;
        }
    }
}
