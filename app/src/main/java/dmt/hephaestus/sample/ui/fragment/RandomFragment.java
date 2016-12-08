package dmt.hephaestus.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dmt.hephaestus.sample.ui.activity.base.BaseFragment;
import sample.dynamic_pager_adapter.R;

import static dmt.hephaestus.sample.app.Constants.KEY_INDEX;

/**
 * Project:  hephaestus
 * Author:   Khuong Vo
 * Since:    5/24/2016
 * Time:     7:13 AM
 */
public class RandomFragment extends BaseFragment {
    String index;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = getArguments() != null ? getArguments().getString(KEY_INDEX) : "-";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_random, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View viewBkg = view.findViewById(R.id.fragment_sample_container);
        TextView textView = (TextView) view.findViewById(R.id.fragment_sample_lbl_index);
        textView.setText(index);
        viewBkg.setBackgroundResource(R.drawable.bg_test_memory);
        Log.i("vtt", "RandomFragment onViewCreated: " + index);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("vtt", "RandomFragment onDestroyView" + index);
    }
}
