package com.oguzhancetin.dgcase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.oguzhancetin.dgcase.network.HashResponse
import com.oguzhancetin.dgcase.network.MessageResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var textView: TextView
    private lateinit var progressCircle: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        progressCircle = findViewById(R.id.progressBarCircle)




        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.hashedMessage.collect {
                    when (it) {
                        is MessageResponse.Loading -> progressCircle.turnVisible()
                        is MessageResponse.Success -> {

                            val mail = solver((it.data as HashResponse).hash)
                            withContext(Dispatchers.Main) {
                                progressCircle.turnInVisible()
                                textView.text = mail
                            }

                        }
                        else -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }


}