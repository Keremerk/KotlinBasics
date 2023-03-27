package com.example.myapplication

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class AppInfoFragmentArgs(
  val `data`: AppDataClass? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(AppDataClass::class.java)) {
      result.putParcelable("data", this.data as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(AppDataClass::class.java)) {
      result.putSerializable("data", this.data as Serializable?)
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(AppDataClass::class.java)) {
      result.set("data", this.data as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(AppDataClass::class.java)) {
      result.set("data", this.data as Serializable?)
    }
    return result
  }

  companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    fun fromBundle(bundle: Bundle): AppInfoFragmentArgs {
      bundle.classLoader = AppInfoFragmentArgs::class.java.classLoader
      val __data : AppDataClass?
      if (bundle.containsKey("data")) {
        if (Parcelable::class.java.isAssignableFrom(AppDataClass::class.java) ||
            Serializable::class.java.isAssignableFrom(AppDataClass::class.java)) {
          __data = bundle.get("data") as AppDataClass?
        } else {
          throw UnsupportedOperationException(AppDataClass::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __data = null
      }
      return AppInfoFragmentArgs(__data)
    }

    @JvmStatic
    fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): AppInfoFragmentArgs {
      val __data : AppDataClass?
      if (savedStateHandle.contains("data")) {
        if (Parcelable::class.java.isAssignableFrom(AppDataClass::class.java) ||
            Serializable::class.java.isAssignableFrom(AppDataClass::class.java)) {
          __data = savedStateHandle.get<AppDataClass?>("data")
        } else {
          throw UnsupportedOperationException(AppDataClass::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __data = null
      }
      return AppInfoFragmentArgs(__data)
    }
  }
}
