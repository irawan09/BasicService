package irawan.electroshock.sevicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import irawan.electroshock.sevicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serviceIntent = Intent(this, MyBackgroundServices::class.java)
        serviceIntent.putExtra("Data", "Data1")
        serviceIntent.putExtra("Data1", 100)

        binding.btnStart.setOnClickListener {
            startService(serviceIntent)
        }

        binding.btnStop.setOnClickListener {
            stopService(serviceIntent)
        }
    }
}