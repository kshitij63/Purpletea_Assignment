package com.loktra_assign2.purpletea_assignment.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.loktra_assign2.purpletea_assignment.network.FlickrApiInterface
import com.loktra_assign2.purpletea_assignment.network.FlickrRetrofitClient
import com.loktra_assign2.purpletea_assignment.pojos.FlickrObject
import com.loktra_assign2.purpletea_assignment.pojos.PhotoPickerObject
import com.loktra_assign2.purpletea_assignment.repository.PhotoRepository
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by user on 5/16/2018.
 */
class PhotoPickerViewModel : ViewModel() {

    fun getListFromModel(str: String): LiveData<ArrayList<PhotoPickerObject>> {
        return PhotoRepository().getPhotoList(str)
    }



}