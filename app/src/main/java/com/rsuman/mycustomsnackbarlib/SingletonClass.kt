package com.rsuman.mycustomsnackbarlib

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import com.rsuman.customsnackbarlib.CustomSnackBar
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SingletonClass {
    @Singleton
    @Provides
    fun provideCustomSnackBar(@ApplicationContext context: Context) : CustomSnackBar {
        return CustomSnackBar(context, ResourcesCompat.getFont(context, R.font.custom_font))
    }
}