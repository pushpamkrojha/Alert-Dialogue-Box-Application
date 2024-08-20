package com.example.dialogue

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialogue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you Sure?")
            builder1.setMessage("Do You want to close the App.")
            builder1.setIcon(R.drawable.exit_to_app_24)
            builder1.setPositiveButton(
                "Yes",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    // what action should be performed when "Yes" is clicked
                    finish()
                })

            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed when "No" is clicked?
            })
            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val options = arrayOf("Hollywood", "Bollywood", "South")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite?")
            builder2.setIcon(R.drawable.exit_to_app_24)
            builder2.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener { dialog, which ->
                    // what action should be perform when user clicks on any options?
                    Toast.makeText(this, "You have clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
                })

            builder2.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    // what action should be performed when "Yes" is clicked
                    Toast.makeText(this, "Your request is submitted", Toast.LENGTH_LONG).show()
                    //finish()
                })

            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed when "No" is clicked?
            })
            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val options = arrayOf("Hollywood", "Bollywood", "South")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite?")
            builder2.setIcon(R.drawable.exit_to_app_24)
            builder2.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this,"You have selected ${options[which]}",Toast.LENGTH_SHORT).show()
            })

            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                    // what action should be performed when "Yes" is clicked
                    Toast.makeText(this, "Your request is submitted", Toast.LENGTH_LONG).show()
                    //finish()
                })

            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed when "No" is clicked?
            })
            builder2.show()
        }
    }
}