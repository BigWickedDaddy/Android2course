package com.itis.a1semitis

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.annotation.RawRes
import androidx.core.app.NotificationCompat

private const val CHANNEL_ID = "channel_id_1"

class NotificationService(
    context: Context
) {

    private val manager by lazy {
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }


    fun showNotification(context: Context, title: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                CHANNEL_ID,
                context.getString(R.string.notification_channel_title),
                IMPORTANCE_DEFAULT
            ).apply {
                description = context.getString(R.string.notification_channel_desc)
                lightColor = Color.GREEN
                vibrationPattern = arrayOf(100L, 200L, 0, 400L).toLongArray()
                val audioattributes: AudioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build()
                val sound: Uri = context.getSoundUri(R.raw.sound_1)
                setSound(sound, audioattributes)
            }.also {
                manager.createNotificationChannel(it)
            }
        }


        val intent = Intent(context, EmptyActivity::class.java).let {
            PendingIntent.getActivities(
                context,
                123,
                arrayOf(it),
                PendingIntent.FLAG_ONE_SHOT
            )
        }

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setShowWhen(false)
            .setAutoCancel(true)
            .setStyle(NotificationCompat.BigTextStyle().bigText(
                "WAKE UP!"
            ))
            .setContentIntent(intent)
            .setContentText("please")

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            with(builder) {
                setLights(Color.GREEN, 100, 100)
                setVibrate(arrayOf(100L, 200L, 0, 400L).toLongArray())
            }
        }

        manager.notify(1, builder.build())
    }

    private fun Context.getSoundUri(
        @RawRes id: Int
    ) = Uri.parse("android.resource://${packageName}/$id")
}