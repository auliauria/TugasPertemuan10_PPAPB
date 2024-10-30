package com.example.tugaspertemuan10

// MainActivity.kt
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspertemuan10.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: EmailAdapter
    private lateinit var emailList: List<Email>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailList = listOf(
            Email("fefefufu", "Pemberitahuan, sarapan gratis akan segera dimulai!", "Sarapan gratis akan segera dimulai...", "20 Oct"),
            Email("Ronaldo", "AKULAH GOAT TERBAIK SEPANJANG MASA", "Jangan mimpi, bro!", "19 Oct"),
            Email("Messi", "Jangan dengerin bang cr, sesat itu..", "mang eakkk", "18 oct"),
            Email("PT NGANG NGONG IND", "Pemberitahuan penerimaan kerja", "Selamat kamu diterima bekerja!!!!!", "18 oct"),
            Email("fefefufu", "Pemberitahuan, sarapan gratis akan segera dimulai!", "Sarapan gratis akan segera dimulai...", "20 Oct"),
            Email("fefefufu", "Pemberitahuan, sarapan gratis akan segera dimulai!", "Sarapan gratis akan segera dimulai...", "20 Oct"),
            Email("fefefufu", "Pemberitahuan, sarapan gratis akan segera dimulai!", "Sarapan gratis akan segera dimulai...", "20 Oct"),
            Email("fefefufu", "Pemberitahuan, sarapan gratis akan segera dimulai!", "Sarapan gratis akan segera dimulai...", "20 Oct"),
            Email("fefefufu", "Pemberitahuan, sarapan gratis akan segera dimulai!", "Sarapan gratis akan segera dimulai...", "20 Oct"),
            Email("fefefufu", "Pemberitahuan, sarapan gratis akan segera dimulai!", "Sarapan gratis akan segera dimulai...", "20 Oct"),

            // Add more entries as needed
        )

        adapter = EmailAdapter(emailList)
        binding.recyclerViewEmails.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewEmails.adapter = adapter

        // Search functionality
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterEmails(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        // Bottom navigation handling
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_email -> {

                    true
                }
                R.id.navigation_video -> {

                    true
                }
                else -> false
            }
        }
    }

    private fun filterEmails(query: String) {
        val filteredList = emailList.filter { it.subject.contains(query, ignoreCase = true) || it.sender.contains(query, ignoreCase = true) }
        adapter.updateList(filteredList)
    }
}
