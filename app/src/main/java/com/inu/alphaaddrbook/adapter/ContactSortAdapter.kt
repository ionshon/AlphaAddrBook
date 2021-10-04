package com.inu.alphaaddrbook.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inu.alphaaddrbook.R
import com.inu.alphaaddrbook.bean.SortModel
import kotlinx.android.synthetic.main.adapter_sort.view.*
import kotlinx.android.synthetic.main.item_letter_layout.view.*

/**
 *
Created by zs
Date：2018年 07月 23日
Time：15:19
—————————————————————————————————————
About:
—————————————————————————————————————
 */
class ContactSortAdapter : RecyclerView.Adapter<ContactSortAdapter.ContactHolder>() {

    var mData: MutableList<SortModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        var view = View.inflate(parent?.context, R.layout.adapter_sort,null)
        return ContactHolder(view)
    }

    override fun getItemCount(): Int {
        return if (mData == null) 0 else mData!!.size
    }

    fun initData(data: MutableList<SortModel>?){
        this.mData = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder?.bindData(position)
    }


    inner class ContactHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView){
        fun bindData(position: Int) = with(itemView) {
            var sortModel = mData!![position]
            name?.text = sortModel.name
            if (!compareSection(position)){
                tv_letter?.visibility = View.VISIBLE
                tv_letter?.text = sortModel.letter
                line_view?.visibility = View.GONE
            }else{
                tv_letter?.visibility = View.GONE
                line_view?.visibility = View.VISIBLE
            }
        }
    }

    fun compareSection(position: Int): Boolean {
        return if (position == 0) {
            false
        } else {
            val current = getSectionForPosition(position)
            val previous = getSectionForPosition(position - 1)
            current == previous
        }

    }

    // 현재 위치의 첫 번째 문자를 가져옵니다(int는 ASCII 코드를 의미합니다)
    fun getSectionForPosition(position: Int): Int {
        return mData!![position].letter[0].toInt()
    }

    // 获取字母首次出现的位置
    fun getPositionForSection(section: Int): Int {
        for (i in 0 until itemCount) {
            val s = mData!![i].letter
            val firstChar = s.toUpperCase()[0]
            if (firstChar.toInt() == section) {
                return i
            }
        }
        return -1
    }

}