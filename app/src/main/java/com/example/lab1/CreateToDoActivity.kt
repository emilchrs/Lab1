package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CreateToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        val titleEt = findViewById<EditText>(R.id.titleEt)
        val contentEt = findViewById<EditText>(R.id.contentEt)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {

           if (titleEt.text.toString().length > 0) {
               val title = titleEt.text.toString()
               val content = contentEt.text.toString()

               toDoRepository.addToDo(title, content)

               val intent = Intent(this@CreateToDoActivity, ViewToDoActivity::class.java)
               intent.putExtra("Title", title)
               intent.putExtra("Content", content)
               finish()
               startActivity(intent)
           }
            else{
               Toast.makeText(this, R.string.errorInput,Toast.LENGTH_SHORT).show()
           }

        }
    }






}
