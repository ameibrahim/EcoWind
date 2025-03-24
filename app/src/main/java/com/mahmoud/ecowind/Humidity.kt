package com.mahmoud.ecowind

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private val esp32Url = "http://ecowind.local/moisture" // ESP32'nin IP adresi veya mDNS adı
    private val client = OkHttpClient()
    private lateinit var moistureTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moistureTextView = findViewById(R.id.moistureTextView)

        // ESP32'den nem verisini al ve ekranda göster
        fetchSoilMoisture()
    }

    private fun fetchSoilMoisture() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val request = Request.Builder().url(esp32Url).build()
                val response = client.newCall(request).execute()

                if (response.isSuccessful) {
                    val jsonData = response.body?.string()
                    jsonData?.let {
                        val jsonObject = JSONObject(it)
                        val moisture = jsonObject.getInt("moisture")

                        withContext(Dispatchers.Main) {
                            moistureTextView.text = "Toprak Nem: $moisture%"
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        moistureTextView.text = "Veri alınamadı!"
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    moistureTextView.text = "Bağlantı hatası: ${e.message}"
                }
            }
        }
    }
}