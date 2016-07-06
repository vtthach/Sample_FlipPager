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
    private static final float MIN_ALPHA = 0.60f;

    public void transformPage(final View view, float position) {
        if (position < -1.5) { // [-Infinity, -1.5)
            // This page is way off-screen to the left.
            view.setAlpha(0);
        } else if (position <= 1.5) { // [-1.5, 1.5]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            // Scale the page down (between MIN_SCALE and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            float f = MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA);
            view.setAlpha(f);
        } else { // (1.5, +Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}
