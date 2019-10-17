package com.wangguan.statusbarutil

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.wangguan.statusbarutil.statusbar.AndroidBug5497Workaround
import com.wangguan.statusbarutil.statusbar.StatusBarUtil
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.include_toolbar.*

class EditActivity : BaseActivity() {

    private val dataList by lazy { ArrayList<String>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        AndroidBug5497Workaround.assistActivity(this)

        // 可以代码自己设置控件加上 padding 但是要去掉控件的 fitSystemWindows 属性，这就不需要包上 ImmerseGroup
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val statusBarHeight = StatusBarUtil.getStatusBarHeight(this)
            toolBar.fitsSystemWindows = false
            toolBar.setPadding(
                toolBar.paddingLeft,
                statusBarHeight,
                toolBar.paddingRight,
                toolBar.paddingBottom
            )
        }

        for (i in 0 until 5) {
            dataList.add("item $i")
        }

        val adapter = Adapter(this, dataList)

        list_item.adapter = adapter

        btn_send.setOnClickListener {
            dataList.add(edit_input.text.toString())
            adapter.notifyDataSetChanged()
        }

        bar_back.setOnClickListener { finish() }

    }

    class Adapter(val context: Context, val list: ArrayList<String>) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            var viewHolder: ViewHolder
            val item = getItem(position)
            var ctv = convertView

            if (convertView == null) {
                viewHolder = ViewHolder()
                ctv = LayoutInflater.from(context).inflate(R.layout.item_show, null)
                viewHolder.textContent = ctv.findViewById(R.id.text)
                ctv.tag = viewHolder
            } else {
                viewHolder = ctv?.tag as ViewHolder
            }
            viewHolder.textContent?.text = item
            return ctv
        }

        override fun getItem(position: Int): String? {
            return list[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount() = list.size

        class ViewHolder {
            var textContent: TextView? = null
        }

    }
}
