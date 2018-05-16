package com.loktra_assign2.purpletea_assignment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.loktra_assign2.purpletea_assignment.POJOS.FlickrObject
import com.loktra_assign2.purpletea_assignment.POJOS.PhotoPickerObject
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by user on 5/16/2018.
 */
class PhotoPickerViewModel : ViewModel() {
    var mutableLiveData = MutableLiveData<ArrayList<PhotoPickerObject>>()
    fun getPhotoMetaList(str: String) {

        FlickrRetrofitClient.getRetrofitClient()
                .create(FlickrApiInterface::class.java)
                .getAllPhotosData("flickr.photos.search", "1",
                        "json", str, "2155e9406043b7494453105eec99ae37")
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<FlickrObject> {
                    override fun onComplete() {
                    }

                    override fun onError(e: Throwable) {
                        Log.e("Failure ", e!!.message)

                    }

                    override fun onNext(t: FlickrObject) {
                        var displayPhotoList = ArrayList<PhotoPickerObject>()

                        var photoList = t!!.photos.photo
                        for (i in 0..photoList.size - 1) {
                            var obj = photoList.get(i)
                            var url = "https://farm${obj.farm}.staticflickr.com/${obj.server}/${obj.id}_${obj.secret}.jpg"
                            var title = obj.title
                            var photObject = PhotoPickerObject(url, title, false, null)
                            displayPhotoList.add(photObject)
                        }
                        mutableLiveData.postValue(displayPhotoList)

                    }

                    override fun onSubscribe(d: Disposable) {

                    }
                })
        /*   .enqueue(object : Callback<FlickrObject> {
               override fun onFailure(call: Call<FlickrObject>?, t: Throwable?) {
                   Log.e("Failure ", t!!.message)
               }

               override fun onResponse(call: Call<FlickrObject>?, response: Response<FlickrObject>?) {
                   //     Log.e("response is : ", response!!.body().toString())
                   var displayPhotoList = ArrayList<PhotoPickerObject>()

                   var photoList = response!!.body()!!.photos.photo
                   for (i in 0..photoList.size - 1) {
                       var obj = photoList.get(i)
                       var url = "https://farm${obj.farm}.staticflickr.com/${obj.server}/${obj.id}_${obj.secret}.jpg"
                       var title = obj.title
                       var photObject = PhotoPickerObject(url, title, false, null)
                       displayPhotoList.add(photObject)
                   }
                   mutableLiveData.postValue(displayPhotoList)
               }

           })*/
    }

    fun getPhotoList(str: String): LiveData<ArrayList<PhotoPickerObject>> {

        getPhotoMetaList(str)
        return mutableLiveData
    }
}