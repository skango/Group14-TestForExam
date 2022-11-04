package com.example.testforexam

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.testforexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        println("OnCreate Called!")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            submit()
        }
    }

    public fun submit() {
        var nameInput = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
        var emailInput = findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
        var mobileInput = findViewById<EditText>(R.id.editTextPhone).text.toString()
        var passwordInput = findViewById<EditText>(R.id.editTextTextPassword).text.toString()
        var repasswordInput = findViewById<EditText>(R.id.editTextTextPassword2).text.toString()

        if (nameInput == null || nameInput == "" || !ValidateName(nameInput)) {
            Toast.makeText(baseContext,"Name can not be empty!",Toast.LENGTH_LONG).show()
            return
        }

        if (mobileInput.length != 9) {
            Toast.makeText(baseContext,"Mobile number must contain 9 digits! gaige she debilo!",Toast.LENGTH_LONG).show()
            return
        }
        if (mobileInput[0].toString() != "5") {
            Toast.makeText(baseContext,"Mobile number must start from 5!",Toast.LENGTH_LONG).show()
            return
        }

        if (passwordInput == null || passwordInput == "" || !ValidateName(passwordInput)) {
            Toast.makeText(baseContext,"Password can not be empty!",Toast.LENGTH_LONG).show()
            return
        }

        if (repasswordInput == null || repasswordInput == "" || !ValidateName(repasswordInput)) {
            Toast.makeText(baseContext,"Password can not be empty!",Toast.LENGTH_LONG).show()
            return
        }

        if (repasswordInput != passwordInput) {
            Toast.makeText(baseContext,"Passwords does not match!",Toast.LENGTH_LONG).show()
            return
        }
        Toast.makeText(baseContext,"Successful! Check your email!",Toast.LENGTH_LONG).show()
    }

    private fun ValidateName(name : String): Boolean {

        for (i in name) {
            if (i.toString() != " ") {
                return true
            }
        }
        return false
    }

}