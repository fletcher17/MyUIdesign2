package com.decadev.myuidesign2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


  //  private lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //To initialize the fragment

        //The different fragments for the menu items in the bottom navigation bar
        val productFragment = ProductFragment()
        val paymentFragment = PaymentFragment()
        val historyFragment = HistoryFragment()
        val supportFragment = SupportFragment()
        val moreFragment = MoreFragment()

        setCurrentFragment(productFragment)

        //This is the bottom navigattion

        val bottomnavigation = findViewById<BottomNavigationView>(R.id.bottomnavigation)
        bottomnavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.productView -> setCurrentFragment(productFragment)
                R.id.paymentView -> setCurrentFragment(paymentFragment)
                R.id.historyView -> setCurrentFragment(historyFragment)
                R.id.supportView -> setCurrentFragment(supportFragment)
                R.id.moreView -> setCurrentFragment(moreFragment)
            }
            true
        }

        bottomnavigation.getOrCreateBadge(R.id.paymentView).apply {
            number = 10
            isVisible = true
        }



        //Notifiction alert/builder
        fun showNotification(title: String, message: String) {
            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel("YOUR_CHANNEL_ID",
                    "YOUR_CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_DEFAULT)
                channel.description = "YOUR_NOTIFICATION_CHANNEL_DESCRIPTION"
                mNotificationManager.createNotificationChannel(channel)
            }

            // Pending Intent and Intent to navigate from the notification bar to the activity
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.putExtra("datain", "Active")
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            val mBuilder = NotificationCompat.Builder(applicationContext, "YOUR_CHANNEL_ID")
                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle(title) // title for notification
                .setContentText(message)// message for notification
                .setAutoCancel(true) // clear notification after click
                .setContentIntent(pendingIntent)
            mNotificationManager.notify(0, mBuilder.build())
        }

        //notification button to create the text and message in notification
        val notificationBell = findViewById<ImageView>(R.id.notification)
        notificationBell.setOnClickListener{
            showNotification("special offers", "Alert ti wole")
        }
    }


    //Fragment creation
    private fun setCurrentFragment(fragment : Fragment) = supportFragmentManager.beginTransaction()
        .apply { replace(R.id.fragment_container, fragment)
                commit()
        }


}













/*Method to Add Initial Fragment*/
/*    private fun initFragment() {
       val productFragment = ProductFragment.newInstance()
       fragmentTransaction = supportFragmentManager.beginTransaction()
       fragmentTransaction.apply {
           setReorderingAllowed(true)
           replace(R.id.fragment_container, productFragment)
           addToBackStack(null)
           commit()
       }
   }*/