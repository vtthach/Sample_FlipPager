package dmt.hephaestus.sample.ui.activity.pager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import dmt.hephaestus.adapter.helper.FragmentPagerHelper;
import dmt.hephaestus.adapter.helper.MultipleFlipFragmentPagerHelperImpl;
import dmt.hephaestus.sample.app.Constants;
import dmt.hephaestus.sample.ui.activity.base.BaseActivity;
import dmt.hephaestus.sample.ui.fragment.ContainerFragment;
import dmt.hephaestus.sample.ui.fragment.LoginFragment;
import dmt.hephaestus.sample.ui.fragment.RegisterFragment;
import dmt.hephaestus.sample.ui.fragment.WelcomeFragment;
import dmt.hephaestus.transformer.FlipVerticalTransformer;
import sample.dynamic_pager_adapter.R;

public class MultipleFlipPagerActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.btn_home)
    Button btnHome;

    FragmentPagerHelper fragmentPagerHelper;

    public static Intent intentInstance(Context context) {
        Intent intent = new Intent(context, MultipleFlipPagerActivity.class);
        return intent;
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_multiple_flip_pager;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    int index = 0;
    @OnClick({R.id.btn_back,
            R.id.btn_next,
            R.id.btn_next_1,
            R.id.btn_next_2,
            R.id.btn_next_3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                goToPreviousPage();
                break;
            case R.id.btn_next:
                Bundle b = new Bundle();
                b.putInt(Constants.KEY_INDEX, viewPager.getCurrentItem() + 1);

                if (index == 0) {
                    fragmentPagerHelper.addPage(LoginFragment.class, b);
                    index++;
                } else if (index == 1) {
                    fragmentPagerHelper.addPage(RegisterFragment.class, b);
                    index++;
                } else if (index == 2) {
                    fragmentPagerHelper.addPage(WelcomeFragment.class, b);
                    index = 0;
                }
                //addDefaultFragment(viewPager.getAdapter().getCount());
                fragmentPagerHelper.goToNextPage();
                break;
            /*case R.id.btn_next_1:
                goToNextPage(LoginFragment.class, null);
                break;
            case R.id.btn_next_2:
                goToNextPage(WelcomeFragment.class, null);
                break;
            case R.id.btn_next_3:
                goToNextPage(RegisterFragment.class, null);
                break;*/
        }
    }

    @OnClick(R.id.btn_home)
    public void onClick() {
        fragmentPagerHelper.goToPage(0);
    }

    //----------------------------------------------------------------------------------------------
    // private methods

    private void init() {
        viewPager.setPageTransformer(false, new FlipVerticalTransformer());

        fragmentPagerHelper = new MultipleFlipFragmentPagerHelperImpl(viewPager, getSupportFragmentManager());

        addDefaultFragment(viewPager.getAdapter().getCount());
    }

    private void addDefaultFragment(int index) {
        Bundle b = new Bundle();
        b.putInt(Constants.KEY_INDEX, index);
        fragmentPagerHelper.addPage(ContainerFragment.class, b);
    }

    private void goToPreviousPage() {
        fragmentPagerHelper.goToPreviousPage();
    }

    private void goToNextPage(Class<?> cls, Bundle b) {
        /*if (viewPager.getAdapter().getCount() == viewPager.getCurrentItem() + 1) {
            addDefaultFragment(viewPager.getAdapter().getCount());
        }
        fragmentPagerHelper.addNextPage(cls, b);
        fragmentPagerHelper.goToNextPage();*/
    }
}
