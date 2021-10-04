package com.inu.alphaaddrbook.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.inu.alphaaddrbook.R
import com.inu.alphaaddrbook.adapter.ContactSortAdapter
import com.inu.alphaaddrbook.bean.SortModel
import com.inu.alphaaddrbook.util.RecyclerViewUtil
import kotlinx.android.synthetic.main.activity_sort_recycler.*

/**
 *
Created by zs
Date：2018年 07月 23日
Time：15:04
—————————————————————————————————————
About:
—————————————————————————————————————
 */
class ContactViewActivity: AppCompatActivity(){

    private var mAdater: ContactSortAdapter? = null
    private var mDataList: MutableList<SortModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sort_recycler)
        initView()
        initData()
    }

    fun initView(){
        ed_search?.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int,
                                       count: Int) {
                if (TextUtils.isEmpty(s.toString().trim())){
                    contact_view?.initData(mDataList)
                    mAdater?.initData(mDataList)
                }else{
                    mAdater?.initData(contact_view?.updateData(s.toString()))
                }

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           before: Int, count: Int) {

            }

            override fun afterTextChanged(arg0: Editable) {

            }
        })

    }

    fun initData(){
        val arrayData = arrayOf("a", "bd", "ced", "de", "as", "태왕 타이이치", "미야모토 무사시", "왕조군", "리위안팡", "류찬", "후손", "서희명", "익명", "류하이"
            ,"Arthur", "Lu Bu", "Qiuya", "Charlotte", "Gongsunli", "Zhang Liang", "Sun Shangxiang", "I", "You", "Ah", "Haha", "Hey "
            ,"Wu Ming", "Liu Hai", "Arthur", "Lu Bu", "Xia Luo", "Gong Sun Li", "Zhang Liang", "Sun Shang Xiang", "Wu Ming", "Liu Hai ", "Arthur", "Lu Bu", "Liu Bei", "Xia Luo", "Gongsun Li", "Zhang Liang", "Sun Shangxiang"
            ,"Wu Ming", "Liu Hai", "Arthur", "Lu Bu", "Qiu Ya", "Xia Luo", "Gong Sun Li", "Zhang Liang", "Sun Shang Xiang", "Wu Ming" , "Liu Hai", "Arthur", "Lu Bu", "Qiuya", "Charlotte", "Gongsunli", "Zhang Liang", "Sun Shangxiang")
        var data = mutableListOf<String>()
        for (i in arrayData){
            data.add(i)
        }
        mAdater = ContactSortAdapter()
        RecyclerViewUtil.initNoDecoration(this,contact_view?.getRecycler(),mAdater)
        mDataList = contact_view?.sortData(data)
        contact_view?.initData(mDataList)
        mAdater?.initData(mDataList)

    }

}