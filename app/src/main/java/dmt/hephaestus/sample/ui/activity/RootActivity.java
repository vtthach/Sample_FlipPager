package dmt.hephaestus.sample.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import dmt.hephaestus.sample.ui.activity.base.BaseActivity;
import dmt.hephaestus.sample.ui.activity.pager.FlipPagerActivity;
import dmt.hephaestus.sample.ui.activity.pager.HorizontalPagerActivity;
import dmt.hephaestus.sample.ui.activity.pager.ViewPagerActivity;
import sample.dynamic_pager_adapter.R;
import sample.util.ActivityUtils;
import sample.util.AnimationType;

/**
 * Project:  and_exp
 * Author:   Khuong Vo
 * Since:    5/18/2016
 * Time:     7:42 AM
 */
public class RootActivity extends BaseActivity {
    @BindView(R.id.btn_view_adapter)
    Button btnViewAdapter;
    @BindView(R.id.brn_flip_fragment)
    Button btnFlipFragment;
    @BindView(R.id.btn_horizontal_swipe_fragment)
    Button btnHorizontalSwipeFragment;


    @Override
    public int getContentViewId() {
        return R.layout.activity_root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnFlipFragment.performClick();
    }

    @OnClick({R.id.btn_view_adapter, R.id.brn_flip_fragment, R.id.btn_horizontal_swipe_fragment})
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.btn_view_adapter:
                intent = ViewPagerActivity.intentInstance(RootActivity.this);
                break;
            case R.id.brn_flip_fragment:
                intent = FlipPagerActivity.intentInstance(RootActivity.this);
                break;
            case R.id.btn_horizontal_swipe_fragment:
                intent = HorizontalPagerActivity.intentInstance(RootActivity.this);
                break;
        }

        if (intent != null)
            ActivityUtils.startActivity(RootActivity.this, intent, false, AnimationType.FADE);
    }
}
