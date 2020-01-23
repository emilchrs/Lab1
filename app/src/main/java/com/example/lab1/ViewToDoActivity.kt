package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog


class ViewToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_to_do)


        val updateButton = findViewById<Button>(R.id.updButton)
        val deleteButton = findViewById<Button>(R.id.delButton)
        val titleVTD = findViewById<TextView>(R.id.textViewVTD)
        val contentVTD = findViewById<TextView>(R.id.textViewVTD2)

        val id = intent.getIntExtra("Id", 0)
        val title = intent.getStringExtra("Title")
        val content = intent.getStringExtra("Content")

        titleVTD.text = "Title: "+title
        contentVTD.text= "Content: "+content


        updateButton.setOnClickListener {
            val intent = Intent(this@ViewToDoActivity, UpdateToDoActivity::class.java)
            intent.putExtra("Id", id)
            intent.putExtra("Title", title)
            intent.putExtra("Content", content)
            finish()
            startActivity(intent)
        }

    deleteButton.setOnClickListener {
        AlertDialog.Builder(this)
            .setTitle(R.string.dialogTitle)
            .setMessage(R.string.dialogMessage)
            .setPositiveButton(
                (R.string.yes)
            ) { dialog, whichButton ->
                toDoRepository.deleteToDoById(id)
                finish()
            }.setNegativeButton(
                (R.string.no)
            ) { dialog, whichButton ->
                // Do not delete it.
            }.show()
    }
    }
}

