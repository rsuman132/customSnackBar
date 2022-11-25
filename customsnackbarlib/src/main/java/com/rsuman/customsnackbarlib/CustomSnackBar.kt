package com.rsuman.customsnackbarlib

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.rsuman.customsnackbarlib.R

class CustomSnackBar(
    private val context: Context,
    private val fontTypeface: Typeface? = null
) {
    private val view: View = View.inflate(context, R.layout.custom_snackbar_layout, null)
    private val snackDividerLineCard : CardView by lazy {
        view.findViewById(R.id.snackDividerLineCard)
    }
    private val snackIconBackground : CardView by lazy {
        view.findViewById(R.id.snackIconBackground)
    }
    private val snackIconImg : ImageView by lazy {
        view.findViewById(R.id.snackIconImg)
    }
    private val snackTitleText : TextView by lazy {
        view.findViewById(R.id.snackTitleText)
    }
    private val snackDescText : TextView by lazy {
        view.findViewById(R.id.snackDescText)
    }
    private val snackCancelIcon : ImageView by lazy {
        view.findViewById(R.id.snackCancelIcon)
    }
    fun showSnackBar(
        parentView : View,
        snackType : SnackBarType,
        title : String?,
        desc : String?,
        onDismissListener : () -> Unit
    ) {
        val snackBar = Snackbar.make(parentView, "", Snackbar.LENGTH_LONG)
        snackBar.view.setBackgroundColor(Color.TRANSPARENT)
        val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout
        snackBarLayout.apply {
            if (view.parent != null) {
                (view.parent as ViewGroup).removeView(view)
            }
            setPadding(0, 0, 0, 0)
            addView(view)
            setBackgroundResource(android.R.color.transparent)
            when (snackType) {
                SnackBarType.SUCCESS -> {
                    snackDividerLineCard.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_green_light))
                    snackIconBackground.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_green_light))
                    snackIconImg.setImageResource(R.drawable.ic_lib_success)
                }
                SnackBarType.INFO -> {
                    snackDividerLineCard.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_blue_dark))
                    snackIconBackground.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_blue_dark))
                    snackIconImg.setImageResource(R.drawable.ic_lib_info)
                }
                SnackBarType.ERROR -> {
                    snackDividerLineCard.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_light))
                    snackIconBackground.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_light))
                    snackIconImg.setImageResource(R.drawable.ic_lib_error)
                }
            }
            snackTitleText.apply {
                text = title
                setTextColor(ContextCompat.getColor(context, android.R.color.black))
                if (fontTypeface != null) {
                    typeface = fontTypeface
                }
            }
            snackDescText.apply {
                text = desc
                if (fontTypeface != null) {
                    typeface = fontTypeface
                }
            }
            snackCancelIcon.setOnClickListener {
                snackBar.dismiss()
            }
        }
        snackBar.apply {
            animationMode = BaseTransientBottomBar.ANIMATION_MODE_FADE
            addCallback(object : Snackbar.Callback() {
                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    onDismissListener()
                }
            })
        }
        val layoutParams = snackBarLayout.layoutParams as FrameLayout.LayoutParams
        layoutParams.apply {
            gravity = Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM
            setMargins(0, 0, 0, 0)
        }
        view.layoutParams = layoutParams
        snackBar.show()
    }
}