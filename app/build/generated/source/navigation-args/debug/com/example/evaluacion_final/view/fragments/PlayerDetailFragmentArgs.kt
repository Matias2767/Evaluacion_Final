package com.example.evaluacion_final.view.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.evaluacion_final.model.NbaPlayer
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class PlayerDetailFragmentArgs(
  public val player: NbaPlayer
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(NbaPlayer::class.java)) {
      result.putParcelable("player", this.player as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(NbaPlayer::class.java)) {
      result.putSerializable("player", this.player as Serializable)
    } else {
      throw UnsupportedOperationException(NbaPlayer::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(NbaPlayer::class.java)) {
      result.set("player", this.player as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(NbaPlayer::class.java)) {
      result.set("player", this.player as Serializable)
    } else {
      throw UnsupportedOperationException(NbaPlayer::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): PlayerDetailFragmentArgs {
      bundle.setClassLoader(PlayerDetailFragmentArgs::class.java.classLoader)
      val __player : NbaPlayer?
      if (bundle.containsKey("player")) {
        if (Parcelable::class.java.isAssignableFrom(NbaPlayer::class.java) ||
            Serializable::class.java.isAssignableFrom(NbaPlayer::class.java)) {
          __player = bundle.get("player") as NbaPlayer?
        } else {
          throw UnsupportedOperationException(NbaPlayer::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__player == null) {
          throw IllegalArgumentException("Argument \"player\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"player\" is missing and does not have an android:defaultValue")
      }
      return PlayerDetailFragmentArgs(__player)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): PlayerDetailFragmentArgs {
      val __player : NbaPlayer?
      if (savedStateHandle.contains("player")) {
        if (Parcelable::class.java.isAssignableFrom(NbaPlayer::class.java) ||
            Serializable::class.java.isAssignableFrom(NbaPlayer::class.java)) {
          __player = savedStateHandle.get<NbaPlayer?>("player")
        } else {
          throw UnsupportedOperationException(NbaPlayer::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__player == null) {
          throw IllegalArgumentException("Argument \"player\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"player\" is missing and does not have an android:defaultValue")
      }
      return PlayerDetailFragmentArgs(__player)
    }
  }
}
