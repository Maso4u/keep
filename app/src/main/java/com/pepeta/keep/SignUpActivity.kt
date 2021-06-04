package com.pepeta.keep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pepeta.keep.Utils.styleSpan
import com.pepeta.keep.Utils.validateCredential
import com.pepeta.keep.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Keep)
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //style tvSignIn button
        styleSpan(this,binding.tvSignIn, SignInActivity::class.java)
        binding.btnSignUp.setOnClickListener(){
//            Toast.makeText(this,"works",Toast.LENGTH_SHORT).show()
            binding.etUserName.validateCredential(this)
        }
    }
}