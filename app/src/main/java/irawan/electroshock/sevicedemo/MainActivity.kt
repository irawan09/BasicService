package irawan.electroshock.sevicedemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import irawan.electroshock.sevicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isStarted: Boolean = false
    private lateinit var serviceIntent:Intent
    private var time = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            startOrStop()
        }

        binding.btnReset.setOnClickListener {
            reset()
        }

        serviceIntent = Intent(applicationContext, StopWatchServices::class.java)
        registerReceiver(updateTime, IntentFilter(StopWatchServices.UPDATED_TIME))
    }

    private fun startOrStop(){
        if (isStarted) {
            stop()
        } else {
            start()
        }
    }

    private fun start(){
        serviceIntent.putExtra(StopWatchServices.CURRENT_TIME, time)
        startService(serviceIntent)
        binding.btnStart.text = "Stop"
        isStarted = true

    }

    private fun stop(){
        stopService(serviceIntent)
        binding.btnStart.text = "Start"
        isStarted = false

    }

    private fun reset(){

    }

    private val updateTime : BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            time = intent.getDoubleExtra(StopWatchServices.CURRENT_TIME, 0.0)
            binding.tvTime.text = time.toString()
        }
    }
}