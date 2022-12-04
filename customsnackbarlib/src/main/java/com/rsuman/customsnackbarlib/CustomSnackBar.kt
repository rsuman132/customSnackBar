package com.rsuman.customsnackbarlib

import android.content.Context
import android.content.res.ColorStateList
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

class CustomSnackBar(
    private val context: Context,
    private val fontTypeface: Typeface? = null
) {
    fun showSnackBarStyleOne(
        parentView : View,
        snackType : SnackBarType,
        title : String?,
        desc : String?,
        onDismissListener : () -> Unit
    ) {
        val view: View = View.inflate(context, R.layout.custom_snackbar_layout, null)
        val snackDividerLineCard : CardView = view.findViewById(R.id.snackDividerLineCard)
        val snackIconBackground : CardView = view.findViewById(R.id.snackIconBackground)
        val snackIconImg : ImageView = view.findViewById(R.id.snackIconImg)
        val snackTitleText : TextView = view.findViewById(R.id.snackTitleText)
        val snackDescText : TextView = view.findViewById(R.id.snackDescText)
        val snackCancelIcon : ImageView = view.findViewById(R.id.snackCancelIcon)
        val snackBar = Snackbar.make(parentView, "", Snackbar.LENGTH_LONG)
        snackBar.view.setBackgroundColor(Color.TRANSPARENT)
        val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout
        snackBarLayout.apply {
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
                SnackBarType.WARNING -> {
                    snackDividerLineCard.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_orange_light))
                    snackIconBackground.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_orange_light))
                    snackIconImg.setImageResource(R.drawable.ic_lib_warning)
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

    fun showSnackBarStyleTwo(
        parentView : View,
        snackType : SnackBarType,
        title : String?,
        desc : String?,
        onDismissListener : () -> Unit
    ) {
        val view: View = View.inflate(context, R.layout.custom_snackbar_layout_two, null)
        val errorImageBG : FrameLayout = view.findViewById(R.id.errorImageBG)
        val snackIconImg : ImageView = view.findViewById(R.id.snackIconImg)
        val snackTitleText : TextView = view.findViewById(R.id.snackTitleText)
        val snackDescText : TextView = view.findViewById(R.id.snackDescText)
        val snackCancelIcon : ImageView = view.findViewById(R.id.snackCancelIcon)
        val snackBar = Snackbar.make(parentView, "", Snackbar.LENGTH_LONG)
        snackBar.view.setBackgroundColor(Color.TRANSPARENT)
        val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout
        snackBarLayout.apply {
            setPadding(0, 0, 0, 0)
            addView(view)
            setBackgroundResource(android.R.color.transparent)
            when (snackType) {
                SnackBarType.SUCCESS -> {
                    errorImageBG.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_green_light))
                    snackTitleText.setTextColor(ContextCompat.getColor(context, android.R.color.holo_green_light))
                    snackIconImg.apply {
                        setImageResource(R.drawable.ic_lib_success)
                        imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, android.R.color.holo_green_light))
                    }
                }
                SnackBarType.INFO -> {
                    errorImageBG.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_blue_dark))
                    snackTitleText.setTextColor(ContextCompat.getColor(context, android.R.color.holo_blue_dark))
                    snackIconImg.apply {
                        setImageResource(R.drawable.ic_lib_info)
                        imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, android.R.color.holo_blue_dark))
                    }
                }
                SnackBarType.WARNING -> {
                    errorImageBG.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_orange_light))
                    snackTitleText.setTextColor(ContextCompat.getColor(context, android.R.color.holo_orange_light))
                    snackIconImg.apply {
                        setImageResource(R.drawable.ic_lib_warning)
                        imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, android.R.color.holo_orange_light))
                    }
                }
                SnackBarType.ERROR -> {
                    errorImageBG.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_light))
                    snackTitleText.setTextColor(ContextCompat.getColor(context, android.R.color.holo_red_light))
                    snackIconImg.apply {
                        setImageResource(R.drawable.ic_lib_error)
                        imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, android.R.color.holo_red_light))
                    }
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