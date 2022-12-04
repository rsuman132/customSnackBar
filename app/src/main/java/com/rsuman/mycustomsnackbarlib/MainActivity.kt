package com.rsuman.mycustomsnackbarlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.rsuman.customsnackbarlib.CustomSnackBar
import com.rsuman.customsnackbarlib.SnackBarType
import com.rsuman.mycustomsnackbarlib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val customSnackBar : CustomSnackBar by lazy {
        CustomSnackBar(this, ResourcesCompat.getFont(applicationContext, R.font.custom_font))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            showSnackBarBtn1.setOnClickListener {
                customSnackBar.showSnackBarStyleOne(
                    parentView = binding.root,
                    snackType = SnackBarType.ERROR,
                    title = "Oh Yes!!, Snackbar1 Works",
                    desc = "Customize snackbar successfully implemented. You can use it in future projects",
                    onDismissListener = {

                    }
                )
            }
            showSnackBarBtn2.setOnClickListener {
                customSnackBar.showSnackBarStyleTwo(
                    parentView = binding.root,
                    snackType = SnackBarType.ERROR,
                    title = "Oh Yes!!, Snackbar1 Works",
                    desc = "Customize snackbar successfully implemented. You can use it in future projects",
                    onDismissListener = {

                    }
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}