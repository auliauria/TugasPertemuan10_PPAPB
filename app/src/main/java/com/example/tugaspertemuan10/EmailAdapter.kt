package com.example.tugaspertemuan10

// EmailAdapter.kt
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan10.databinding.ItemEmailBinding

class EmailAdapter(private var emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    inner class EmailViewHolder(private val binding: ItemEmailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(email: Email) {
            binding.apply {
                senderTextView.text = email.sender
                subjectTextView.text = email.subject
                dateTextView.text = email.date

                root.setOnClickListener {
                    val intent = Intent(root.context, EmailDetailActivity::class.java).apply {
                        putExtra("sender", email.sender)
                        putExtra("subject", email.subject)
                        putExtra("date", email.date)
                        putExtra("content", email.content)
                    }
                    root.context.startActivity(intent)
                }
            }
        }
    }

    fun updateList(newEmails: List<Email>) {
        emails = newEmails
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val binding = ItemEmailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emails[position])
    }

    override fun getItemCount() = emails.size
}

