package com.loktra_assign2.purpletea_assignment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.loktra_assign2.purpletea_assignment.pojos.PhotoPickerObject
import com.loktra_assign2.purpletea_assignment.ui.PhotoPickerAdapter
import com.loktra_assign2.purpletea_assignment.ui.PhotoPickerViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var adapter = PhotoPickerAdapter(this@MainActivity, ArrayList<PhotoPickerObject>())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        var model = ViewModelProviders.of(this).get(PhotoPickerViewModel::class.java)
        model.getListFromModel("tiger").observe(this, object : Observer<ArrayList<PhotoPickerObject>> {
            override fun onChanged(t: ArrayList<PhotoPickerObject>?) {
                Log.e("size is", "${t!!.size}")
                adapter.setList1(t!!)

            }
        })

    }


}
