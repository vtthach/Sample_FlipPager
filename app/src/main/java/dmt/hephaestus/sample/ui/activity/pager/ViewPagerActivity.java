package dmt.hephaestus.sample.ui.activity.pager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import dmt.hephaestus.sample.ui.activity.base.BaseActivity;
import dmt.hephaestus.sample.util.view.ViewItemPagerAdapter;
import dmt.hephaestus.sample.util.view.ViewPagerHelper;
import sample.dynamic_pager_adapter.R;

public class ViewPagerActivity extends BaseActivity {

    public static Intent intentInstance(Context context) {
        Intent intent = new Intent(context, ViewPagerActivity.class);
        return intent;
    }

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_next)
    Button btnNext;


    ViewPagerHelper viewPagerHelper = null;

    @Override
    public int getContentViewId() {
        return R.layout.activity_view_item;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {
        viewPagerHelper = new ViewPagerHelper(viewPager, new ViewItemPagerAdapter());
    }

    @OnClick({R.id.btn_back, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                viewPager.setCurrentItem(viewPager.getCurrentItem() > 0 ? viewPager.getCurrentItem() - 1 : 0);
                break;
            case R.id.btn_next:
                viewPagerHelper.addView(viewPagerHelper.createViewInstance(this));
                break;
        }
    }
}
