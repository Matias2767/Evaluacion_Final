package com.example.evaluacion_final.view.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.evaluacion_final.R
import com.example.evaluacion_final.model.NbaPlayer
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class PlayerFavoriteFragmentDirections private constructor() {
  private data class ActionPlayerFavoriteFragmentToPlayerDetailFragment(
    public val player: NbaPlayer
  ) : NavDirections {
    public override val actionId: Int = R.id.action_playerFavoriteFragment_to_playerDetailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionPlayerFavoriteFragmentToPlayerDetailFragment(player: NbaPlayer): NavDirections
        = ActionPlayerFavoriteFragmentToPlayerDetailFragment(player)
  }
}
