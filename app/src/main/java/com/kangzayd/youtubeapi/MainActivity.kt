package com.kangzayd.youtubeapi

import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : YouTubeBaseActivity() {
    var mYoutubePlayer: YouTubePlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (mYoutubePlayer != null) {
            mYoutubePlayer?.release()
        }
        youtubePlayer.initialize("AIzaSyCpyzlgUOP2n-iWKWFTucoUDy-CHKRz2E0", object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
                p1?.setPlayerStateChangeListener(playerStateChangeListener)
                p1?.cueVideo("4270dTu5eJA")
                mYoutubePlayer = p1
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {

            }

        })
    }
    private val playerStateChangeListener: YouTubePlayer.PlayerStateChangeListener? = object : YouTubePlayer.PlayerStateChangeListener {
        override fun onAdStarted() {

        }

        override fun onLoading() {
        }

        override fun onVideoStarted() {

        }

        override fun onLoaded(p0: String?) {
            mYoutubePlayer?.play()
        }

        override fun onVideoEnded() {

        }

        override fun onError(p0: YouTubePlayer.ErrorReason?) {
        }

    }

}
