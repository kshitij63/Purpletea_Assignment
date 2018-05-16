package com.loktra_assign2.purpletea_assignment

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loktra_assign2.purpletea_assignment.POJOS.PhotoPickerObject
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_photo_view.view.*


/**
 * Created by user on 5/16/2018.
 */
class PhotoPickerAdapter(var con: Context, var list: ArrayList<PhotoPickerObject>) : RecyclerView.Adapter<PhotoPickerAdapter.FlickViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlickViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.single_photo_view, parent, false)
        var holder = FlickViewHolder(view)

        return holder

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FlickViewHolder, position: Int) {


        var obj = list.get(position)
        if (obj.rotated == true)
            holder.photo.visibility = View.GONE
        else
            holder.photo.visibility = View.VISIBLE


        Picasso.get().load(obj.url).placeholder(R.drawable.placeholder).into(holder.photo)
        holder.title.setText(obj.title)


    }


    class FlickViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var photo = view.flickr_image
        var title = view.flickr_title

    }

    fun setList1(list: ArrayList<PhotoPickerObject>) {
        this.list = list
        notifyDataSetChanged()
    }
}