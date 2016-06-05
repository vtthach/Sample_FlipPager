package dmt.hephaestus.sample.ui.activity.pager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dmt.hephaestus.adapter.helper.FlipFragmentPagerHelperImpl;
import dmt.hephaestus.adapter.helper.FragmentPagerHelper;
import dmt.hephaestus.sample.app.Constants;
import dmt.hephaestus.sample.ui.activity.base.BaseActivity;
import dmt.hephaestus.sample.ui.fragment.BaseSampleFragment;
import dmt.hephaestus.transformer.FlipVerticalTransformer;
import sample.dynamic_pager_adapter.R;

public class FlipPagerActivity extends BaseActivity {

    public static Intent intentInstance(Context context) {
        Intent intent = new Intent(context, FlipPagerActivity.class);
        return intent;
    }

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.btn_home)
    Button btnHome;

    private Unbinder unbinder;
    FragmentPagerHelper fragmentPagerHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_pager);
        unbinder = ButterKnife.bind(this);

        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void init() {
        viewPager.setPageTransformer(false, new FlipVerticalTransformer());

        fragmentPagerHelper = new FlipFragmentPagerHelperImpl(viewPager, getSupportFragmentManager());

        Bundle b = new Bundle();
        b.putInt(Constants.KEY_INDEX, 0);
        fragmentPagerHelper.addPage(BaseSampleFragment.class, b);
    }

    @OnClick({R.id.btn_back, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                fragmentPagerHelper.goToPreviousPage();
                break;
            case R.id.btn_next:
                Bundle b = new Bundle();
                b.putInt(Constants.KEY_INDEX, viewPager.getCurrentItem() + 1);

                Class<?> cls = BaseSampleFragment.class;
                fragmentPagerHelper.addPage(cls, b);
                fragmentPagerHelper.goToNextPage();
                break;
        }
    }

    @OnClick(R.id.btn_home)
    public void onClick() {
        fragmentPagerHelper.goToPage(0);
    }
}
