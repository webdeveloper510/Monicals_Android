package com.monicals.monicalspizza

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.app.NotificationManager
import android.media.RingtoneManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class MyFirebaseMessagingService : FirebaseMessagingService() {
    val TAG = "FCM Service"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "From: ${remoteMessage.from}")

        // Check if message contains a data payload.
        remoteMessage.data.isNotEmpty().let {
            Log.d(TAG, "Message data payload: " + remoteMessage.data)
        }

        // Check if message contains a notification payload.
        remoteMessage.notification.let {
            Log.d(TAG, "Message Notification Body: ${it?.body}")
        }
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0!!)

        Log.d(TAG, "Refreshed token: $p0")
    }


}
