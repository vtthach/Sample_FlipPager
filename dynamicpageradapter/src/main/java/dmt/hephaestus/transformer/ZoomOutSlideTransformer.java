package dmt.hephaestus.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Author:   Khuong Vo
 * Since:    5/19/2016
 * Time:     3:44 PM
 */
public class ZoomOutSlideTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.961f;
    private static final float MIN_ALPHA = 0.800f;
    private static final float NEARLY_MAX_ALPHA = 0.95f;
    private static final float NEARLY_MAX_SCALE = 0.99f;

    public void transformPage(final View view, float position) {
        if (position < -1.5) { // [-Infinity, -1.5)
            // This page is way off-screen to the left.
            view.setAlpha(0);
        } else if (position <= 1.5) { // [-1.5, 1.5]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = (1 - Math.abs(position)) * (1 - MIN_SCALE) + MIN_SCALE;
            if (scaleFactor > NEARLY_MAX_SCALE) {
                view.setScaleY(1);
            } else {
                view.setScaleY(Math.max(MIN_SCALE, scaleFactor));
            }

            float alpha = (1 - Math.abs(position)) * (1 - MIN_ALPHA) + MIN_ALPHA;
            if (alpha > NEARLY_MAX_ALPHA) {
                view.setAlpha(Math.max(MIN_ALPHA, 1));
            } else {
                view.setAlpha(Math.max(MIN_ALPHA, alpha));
            }
        } else { // (1.5, +Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}
