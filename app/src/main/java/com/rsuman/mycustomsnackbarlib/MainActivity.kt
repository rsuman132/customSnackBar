package com.rsuman.mycustomsnackbarlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rsuman.customsnackbarlib.CustomSnackBar
import com.rsuman.customsnackbarlib.SnackBarType
import com.rsuman.mycustomsnackbarlib.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var customSnackBar: CustomSnackBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.showSnackBarBtn.setOnClickListener {
            customSnackBar.showSnackBar(
                parentView = binding.root,
                snackType = SnackBarType.INFO,
                title = "Oh Yes!!, Snackbar Works",
                desc = "Customize snackbar successfully implemented. You can use it in future projects",
                onDismissListener = {

                }
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}