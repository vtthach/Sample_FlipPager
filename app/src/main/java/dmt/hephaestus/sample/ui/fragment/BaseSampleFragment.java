package dmt.hephaestus.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sample.dynamic_pager_adapter.R;
import sample.util.LibUtils;

/**
 * Project:  and_exp
 * Author:   Khuong Vo
 * Since:    5/18/2016
 * Time:     1:51 PM
 */
public class BaseSampleFragment extends Fragment {

    @BindView(R.id.fragment_sample_lbl_index)
    TextView lblIndex;

    public static BaseSampleFragment newInstance(Bundle b) {
        BaseSampleFragment fragment = new BaseSampleFragment();
        fragment.setArguments(b);
        return fragment;
    }

    @BindView(R.id.fragment_sample_container)
    protected FrameLayout sampleContainer;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
    }

    protected void init() {
        sampleContainer.setBackgroundColor(LibUtils.generateRandomColor());

        lblIndex.setText(String.format("Page %d", getArguments().getInt("INDEX")));
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
