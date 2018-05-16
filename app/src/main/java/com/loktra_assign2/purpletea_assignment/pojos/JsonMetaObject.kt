package com.loktra_assign2.purpletea_assignment.pojos

/**
 * Created by user on 5/16/2018.
 */
data class JsonMetaObject(var page:Long, var pages:Long, var perpage:Long, var total:String
                          , var photo:ArrayList<PhotoSearchObject>)
