package dmt.hephaestus.sample.ui.activity.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Project:  hephaestus
 * Author:   Khuong Vo
 * Since:    5/18/2016
 * Time:     7:39 AM
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    public abstract int getContentViewId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
