package dmt.hephaestus.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sample.dynamic_pager_adapter.R;

/**
 * Project:  and_exp
 * Author:   Khuong Vo
 * Since:    5/24/2016
 * Time:     12:36 PM
 */
public class ContainerFragment extends Fragment {

    @BindView(R.id.layout_container)
    FrameLayout layoutContainer;
    @BindView(R.id.layout_card)
    FrameLayout layoutCard;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_container, container, false);
        unbinder = ButterKnife.bind(this, view);

        //view.setAlpha(0.0f);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected void init() {
        //layoutCard.setAlpha(0.6f);
    }

    public void replaceFragment(Class<?> cls, Bundle b) {
        Fragment f = Fragment.instantiate(getActivity(), cls.getName(), b);
        getChildFragmentManager().beginTransaction().replace(R.id.layout_container, f).commitAllowingStateLoss();
    }
}