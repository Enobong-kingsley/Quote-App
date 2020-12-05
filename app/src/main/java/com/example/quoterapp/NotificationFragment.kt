package com.example.quoterapp

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment


class NotificationFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener { v: View? ->
            Toast.makeText(context, "Reminder set!", Toast.LENGTH_LONG).show()
            val alarmManager = requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(context, ReminderBroadcast::class.java)
            val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)
            val interval = (60 * 1000).toLong()
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent)
//            Toast.makeText(context, "Reminder set!", Toast.LENGTH_LONG).show()
//            val intent =   findNavController().navigate(R.id.inspirationFragment)
//            val pendingIntent = PendingIntent.getBroadcast(context, 0, V, 0)
//            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//            val timeAtButtonClicked = System.currentTimeMillis()
//            val oneMinute: Long = 60000
//            alarmManager[AlarmManager.RTC_WAKEUP, timeAtButtonClicked + oneMinute] = pendingIntent
        }

        return view
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "ReminderChannel"
            val description = "Chanel for reminder"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("notifyMe", name, importance)
            channel.description = description
            val notificationManager = activity?.getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
    }
}
