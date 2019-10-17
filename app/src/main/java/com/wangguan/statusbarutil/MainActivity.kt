package com.wangguan.statusbarutil

import android.content.Intent
import android.os.Bundle
import com.wangguan.statusbarutil.statusbar.StatusBarUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_toolbar.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bar_back.setOnClickListener { finish() }
        text_enter.setOnClickListener { startActivity(Intent(this,EditActivity::class.java)) }
    }
}
