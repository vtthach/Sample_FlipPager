package dmt.hephaestus.sample.ui.activity.pager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import dmt.hephaestus.linkedlist.LinkedListDynamicFragmentModel;
import dmt.hephaestus.linkedlist.LinkedListPagerHelper;
import dmt.hephaestus.linkedlist.LinkedListPagerHelperImpl;
import dmt.hephaestus.sample.ui.activity.base.BaseActivity;
import dmt.hephaestus.sample.ui.fragment.RandomFragment;
import dmt.hephaestus.transformer.FlipVerticalTransformer;
import sample.dynamic_pager_adapter.R;

import static dmt.hephaestus.sample.app.Constants.KEY_INDEX;

public class LinkedListFlipPagerActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_next)
    Button btnNext;

    LinkedListPagerHelper fragmentPagerHelper;

    public static Intent intentInstance(Context context) {
        return new Intent(context, LinkedListFlipPagerActivity.class);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_linked_list_pager;
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
                fragmentPagerHelper.goToPreviousPage();
                break;
            case R.id.btn_next:
                fragmentPagerHelper.goToNextPage();
                break;
        }
    }

    //----------------------------------------------------------------------------------------------
    // private methods

    private void init() {
        viewPager.setPageTransformer(false, new FlipVerticalTransformer());
        fragmentPagerHelper = new LinkedListPagerHelperImpl(viewPager, getSupportFragmentManager(), getFirstItemModel());
    }

    private LinkedListDynamicFragmentModel getFirstItemModel() {
        Bundle data = new Bundle();
        data.putString(KEY_INDEX, Integer.toString(index));
        return new LinkedListDynamicFragmentModel(RandomFragment.class, null, data);
    }

    @OnClick(R.id.btn_go_to_next_page)
    public void onAddAndGoNextPage() {
        Bundle data = new Bundle();
        ++index;
        data.putString(KEY_INDEX, Integer.toString(index));
        fragmentPagerHelper.goToNextPage(RandomFragment.class, data);
    }

    @OnClick(R.id.btn_add_to_previous)
    public void onAddPreviousPage() {
        Bundle data = new Bundle();
        ++index;
        data.putString(KEY_INDEX, Integer.toString(index));
        fragmentPagerHelper.addPreviousPage(RandomFragment.class, data);
    }
}
