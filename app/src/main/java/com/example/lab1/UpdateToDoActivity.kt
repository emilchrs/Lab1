package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class UpdateToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_to_do)


        val titleUV = findViewById<EditText>(R.id.titleUV)
        val contentUV = findViewById<EditText>(R.id.contentUV)
        val saveButtonUV = findViewById<Button>(R.id.saveButtonUV)


        val id = intent.getIntExtra("Id", 0)
        val title = intent.getStringExtra("Title")
        val content = intent.getStringExtra("Content")


        titleUV.setText(title)
        contentUV.setText(content)

        val newTitle = findViewById<EditText>(R.id.titleUV).text
        val newContent = findViewById<EditText>(R.id.contentUV).text


        saveButtonUV.setOnClickListener {

            toDoRepository.updateToDoById(id, newTitle.toString(), newContent.toString())
            val intent = Intent(this@UpdateToDoActivity, ViewToDoActivity::class.java)
            intent.putExtra("Title", newTitle.toString())
            intent.putExtra("Content", newContent.toString())
            finish()
            startActivity(intent)
        }
    }

}
