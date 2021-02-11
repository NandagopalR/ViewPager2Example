package com.navikolabs.viewpager2example

import android.view.View
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2

class MultiScreenTransformer(private val offsetPx: Int, private val pageMarginPx: Int) : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val viewPager = page.parent.parent as ViewPager2
        val offset = position * -(2 * offsetPx + pageMarginPx)
        if (viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
            if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                page.translationX = -offset
            } else {
                page.translationX = offset
            }
        } else {
            page.translationY = offset
        }
    }
}