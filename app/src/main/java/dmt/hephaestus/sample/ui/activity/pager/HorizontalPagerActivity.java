package dmt.hephaestus.sample.ui.activity.pager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dmt.hephaestus.adapter.helper.HorizontalFragmentPagerHelper;
import dmt.hephaestus.adapter.helper.HorizontalFragmentPagerHelperImpl;
import dmt.hephaestus.sample.app.Constants;
import dmt.hephaestus.sample.ui.activity.base.BaseActivity;
import dmt.hephaestus.sample.ui.fragment.ContainerFragment;
import dmt.hephaestus.sample.ui.fragment.DefaultFlipFragment;
import dmt.hephaestus.sample.ui.fragment.LoginFragment;
import dmt.hephaestus.sample.ui.fragment.WelcomeFragment;
import dmt.hephaestus.transformer.ZoomOutSlideTransformer;
import sample.dynamic_pager_adapter.R;

public class HorizontalPagerActivity extends BaseActivity {


    public static Intent intentInstance(Context context) {
        Intent intent = new Intent(context, HorizontalPagerActivity.class);
        return intent;
    }


    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_home)
    Button btnHome;

    private Unbinder unbinder;
    HorizontalFragmentPagerHelper horizontalPagerHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_swipe_pager);
        unbinder = ButterKnife.bind(this);

        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void init() {
        viewPager.setPageTransformer(false, new ZoomOutSlideTransformer());
        // Necessary or the pager will only have one extra page to show
        // make this at least however many pages you can see
        viewPager.setOffscreenPageLimit(3);

        // Set margin for pages as a negative number, so a part of next and
        // previous pages will be showed
        viewPager.setPageMargin(-368);

        horizontalPagerHelper = new HorizontalFragmentPagerHelperImpl(viewPager, getSupportFragmentManager()) {
            @Override
            public void onAddFirstFlipPage(Fragment f, Class<?> cls, Bundle b) {
                ContainerFragment fm = (ContainerFragment) getFragmentAtPosition(viewPager.getCurrentItem() + 1);
                fm.replaceFragment(cls, b);
            }
        };

        addDefaultFragment(viewPager.getAdapter().getCount());
        addDefaultFragment(viewPager.getAdapter().getCount());
        addDefaultFragment(viewPager.getAdapter().getCount());
        horizontalPagerHelper.goToPage(1);
    }

    private void addDefaultFragment(int index) {
        Bundle b = new Bundle();
        b.putInt(Constants.KEY_INDEX, index);
        horizontalPagerHelper.addPage(ContainerFragment.class, b);
    }

    private void goToPreviousPage() {
        horizontalPagerHelper.goToPreviousPage();
    }

    private void goToNextPage(Class<?> cls, Bundle b) {
        addDefaultFragment(viewPager.getAdapter().getCount());
        horizontalPagerHelper.addFirstFlipPage(cls, b);
        horizontalPagerHelper.goToNextPage();
    }

    @OnClick({R.id.btn_back, R.id.btn_next_1, R.id.btn_next_2, R.id.btn_next_3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                goToPreviousPage();
                break;
            case R.id.btn_next_1:
                goToNextPage(LoginFragment.class, null);
                break;
            case R.id.btn_next_2:
                goToNextPage(WelcomeFragment.class, null);
                break;
            case R.id.btn_next_3:
                goToNextPage(DefaultFlipFragment.class, null);
                break;
        }
    }

    @OnClick(R.id.btn_home)
    public void onClick() {
        horizontalPagerHelper.goToPage(1);
    }
}
