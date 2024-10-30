package com.example.tugaspertemuan10

// EmailDetailActivity.kt
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspertemuan10.databinding.ActivityEmailDetailBinding

class EmailDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmailDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sender = intent.getStringExtra("sender") ?: ""
        val subject = intent.getStringExtra("subject") ?: ""
        val date = intent.getStringExtra("date") ?: ""
        val content = intent.getStringExtra("content") ?: ""

        binding.senderTextView.text = sender
        binding.subjectTextView.text = subject
        binding.dateTextView.text = date
        binding.contentTextView.text = content
    }

    fun onBackPressed(view: View) {
        finish() // Or any other action you'd like
    }
}

