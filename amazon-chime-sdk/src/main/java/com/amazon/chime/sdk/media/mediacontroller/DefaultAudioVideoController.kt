package com.amazon.chime.sdk.media.mediacontroller

import com.amazon.chime.sdk.media.clientcontroller.AudioClientController
import com.amazon.chime.sdk.media.clientcontroller.AudioClientObserver
import com.amazon.chime.sdk.session.MeetingSessionConfiguration

class DefaultAudioVideoController(
    private val audioClientController: AudioClientController,
    private val audioClientObserver: AudioClientObserver,
    private val configuration: MeetingSessionConfiguration
) : AudioVideoControllerFacade {

    override fun start() {
        audioClientController.start(
            configuration.urls.audioHostURL,
            configuration.meetingId,
            configuration.credentials.attendeeId,
            configuration.credentials.joinToken
        )
    }

    override fun stop() {
        audioClientController.stop()
    }

    override fun addObserver(observer: AudioVideoObserver) {
        audioClientObserver.subscribeToAudioClientStateChange(observer)
    }

    override fun removeObserver(observer: AudioVideoObserver) {
        audioClientObserver.unsubscribeFromAudioClientStateChange(observer)
    }
}