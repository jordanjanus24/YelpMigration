package com.app.yelpm.utils

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

data class GlideResponse(
    val bitmap: Bitmap?,
    val success: Boolean
)

@SuppressLint("UnrememberedMutableState")
@Composable
fun loadPicture(url: String, @DrawableRes defaultImage:Int): MutableState<GlideResponse?> {
    val bitmapState: MutableState<GlideResponse?> = mutableStateOf(null)
    Glide.with(LocalContext.current)
        .asBitmap()
        .load(defaultImage)
        .into(object: CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = GlideResponse(
                    bitmap = resource,
                    success = false
                )
            }

            override fun onLoadCleared(placeholder: Drawable?) {

            }
        })
    Glide.with(LocalContext.current)
        .asBitmap()
        .load(url)
        .into(object: CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = GlideResponse(
                    bitmap = resource,
                    success = true
                )
            }
            override fun onLoadCleared(placeholder: Drawable?) {

            }
        })
    return bitmapState
}