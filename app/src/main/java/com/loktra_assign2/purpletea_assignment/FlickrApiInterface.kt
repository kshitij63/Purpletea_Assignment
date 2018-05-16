package com.loktra_assign2.purpletea_assignment

import com.loktra_assign2.purpletea_assignment.POJOS.FlickrObject
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by user on 5/16/2018.
 */
interface FlickrApiInterface {

    @GET("rest/")
    fun getAllPhotosData(@Query("method") method: String,
                         @Query("nojsoncallback") nojsoncallback: String,
                         @Query("format") format: String
                         , @Query("tags") tags: String
                         , @Query("api_key") api_key: String): Observable<FlickrObject>
}