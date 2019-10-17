package com.wangguan.statusbarutil

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wangguan.statusbarutil.statusbar.StatusBarUtil

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        StatusBarUtil.setRootViewFitsSystemWindows(this, false)
        StatusBarUtil.setTranslucentStatus(this)
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            StatusBarUtil.setStatusBarColor(this, 0x55000000)

        }
    }
}
