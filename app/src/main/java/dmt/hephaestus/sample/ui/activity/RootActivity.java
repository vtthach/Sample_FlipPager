package dmt.hephaestus.sample.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import dmt.hephaestus.sample.ui.activity.base.BaseActivity;
import dmt.hephaestus.sample.ui.activity.pager.HorizontalPagerActivity;
import dmt.hephaestus.sample.ui.activity.pager.LinkedListFlipPagerActivity;
import dmt.hephaestus.sample.ui.activity.pager.MultipleFlipPagerActivity;
import dmt.hephaestus.sample.ui.activity.pager.SingleFlipPagerActivity;
import dmt.hephaestus.sample.ui.activity.pager.ViewPagerActivity;
import sample.dynamic_pager_adapter.R;
import sample.util.ActivityUtils;
import sample.util.AnimationType;

/**
 * Project:  hephaestus
 * Author:   Khuong Vo
 * Since:    5/18/2016
 * Time:     7:42 AM
 */
public class RootActivity extends BaseActivity {
    @BindView(R.id.btn_view_adapter)
    Button btnViewAdapter;
    @BindView(R.id.btn_single_flip_fragment)
    Button btnSingleFlipFragment;
    @BindView(R.id.btn_multiple_flip_fragment)
    Button btnMultipleFlipFragment;
    @BindView(R.id.btn_horizontal_swipe_fragment)
    Button btnHorizontalSwipeFragment;


    @Override
    public int getContentViewId() {
        return R.layout.activity_root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //btnSingleFlipFragment.performClick();
    }

    @OnClick({R.id.btn_view_adapter,
            R.id.btn_single_flip_fragment,
            R.id.btn_multiple_flip_fragment,
            R.id.btn_horizontal_swipe_fragment,
            R.id.btn_linked_list_pager})
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.btn_view_adapter:
                intent = ViewPagerActivity.intentInstance(RootActivity.this);
                break;
            case R.id.btn_single_flip_fragment:
                intent = SingleFlipPagerActivity.intentInstance(RootActivity.this);
                break;
            case R.id.btn_multiple_flip_fragment:
                intent = MultipleFlipPagerActivity.intentInstance(RootActivity.this);
                break;
            case R.id.btn_horizontal_swipe_fragment:
                intent = HorizontalPagerActivity.intentInstance(RootActivity.this);
                break;
            case R.id.btn_linked_list_pager:
                intent = LinkedListFlipPagerActivity.intentInstance(RootActivity.this);
                break;
        }

        if (intent != null)
            ActivityUtils.startActivity(RootActivity.this, intent, false, AnimationType.FADE);
    }
}
