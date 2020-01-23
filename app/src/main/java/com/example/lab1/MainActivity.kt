package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

    lateinit var list: ArrayAdapter<ToDo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val listView = findViewById<ListView>(R.id.ListViewMA)
        list = ArrayAdapter<ToDo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            toDoRepository.getAllToDos()
        )
        listView.adapter=list



        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@MainActivity,ViewToDoActivity::class.java)
            val cell = toDoRepository.getToDoById(position+1)
            intent.putExtra("Id",cell?.id)
            intent.putExtra("Title",cell?.title)
            intent.putExtra("Content",cell?.content)
            startActivity(intent)


           }


        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this@MainActivity, CreateToDoActivity::class.java)
            startActivity(intent)
        }

    }


    override fun onStart() {
        super.onStart()
        list.notifyDataSetChanged()
    }

}




