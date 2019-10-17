package com.wangguan.statusbarutil.statusbar

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * Created by WG on 2019-10-17.
 * Email: wg5329@163.com
 * Github: https://github.com/WGwangguan
 * Desc:
 */
class ImmerseGroup : FrameLayout {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setPadding(paddingLeft, paddingTop, paddingRight, 0)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}
