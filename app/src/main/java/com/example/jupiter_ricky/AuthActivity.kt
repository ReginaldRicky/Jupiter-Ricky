package com.example.jupiter_ricky

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jupiter_ricky.databinding.ActivityAuthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("onCreate", "{AuthActivity} dibuat pertama kali")
        enableEdgeToEdge()

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Kode ini harus selalu dipanggil saat butuh akses "user_pref"
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        //Kondisi jika isLogin bernilai true
        val isLogin = sharedPref.getBoolean("isLogin", false)
        if (isLogin) {
            //Panggil Intent untuk ke MainActivity
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
            finish()
        }
        binding.btnLogin.setOnClickListener {
            val username = binding.editTextText.text.toString()
            val password = binding.editTextTextPassword.text.toString()

            if (username == password) {
                //val set value
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username",username)
                editor.apply()

                //berpindah ke main activity
                val i = Intent(this, MainActivity2::class.java)
                startActivity(i)
                Toast.makeText(this, "${username} - ${password}", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Oops...")
                    .setMessage("Username atau Password salah!")
                    .show()
            }
        }
    }
}