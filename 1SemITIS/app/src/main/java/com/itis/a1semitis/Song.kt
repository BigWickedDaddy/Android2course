package com.itis.a1semitis

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import java.io.Serializable

data class Song(@DrawableRes val cover: Int, val title:String, @RawRes val audio:Int, val author:String):Serializable