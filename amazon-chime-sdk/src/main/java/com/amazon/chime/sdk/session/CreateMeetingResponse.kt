package com.amazon.chime.sdk.session

// https://docs.aws.amazon.com/chime/latest/APIReference/API_CreateMeeting.html
data class CreateMeetingResponse(val Meeting: Meeting)

data class Meeting(
    val MeetingId: String,
    val MediaPlacement: MediaPlacement
)

data class MediaPlacement(val AudioHostUrl: String)