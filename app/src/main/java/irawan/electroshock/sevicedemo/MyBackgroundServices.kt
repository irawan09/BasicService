package irawan.electroshock.sevicedemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBackgroundServices : Service() {

    init{
        Log.i("MyTag", "Service has been created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("MyTag", "Service started")
        val data = intent?.getStringExtra("Data")
        val data1 = intent?.getIntExtra("Data1", 0)
        Log.i("MyTag", "data1=$data, data2=$data1")

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        Log.i("MyTag", "Service destroyed")
        super.onDestroy()
    }
}