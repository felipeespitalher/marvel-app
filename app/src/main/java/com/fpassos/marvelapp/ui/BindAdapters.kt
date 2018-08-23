package com.fpassos.marvelapp.ui

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.fpassos.marvelapp.R

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view.context)
                .load(url)
                .into(view)
    } ?: run {
        view.setImageDrawable(null)
    }
}

@BindingAdapter("visibilityObject")
fun checkVisibility(view: View, obj: Any?) {
    obj?.let {
        view.visibility = View.GONE
    } ?: run {
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter("visible")
fun booleanVisibility(view: View, visible: Boolean) {
    if (visible) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter("placeHolderObject")
fun checkPlaceHolder(view: View, obj: Any?) {
    obj?.let {
        view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.placeholder))
    } ?: run {
        view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.transparent))
    }
}