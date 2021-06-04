package com.pepeta.keep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pepeta.keep.Utils.styleSpan
import com.pepeta.keep.Utils.validateCredential
import com.pepeta.keep.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Keep)
        super.onCreate(savedInstanceState)
        binding= ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        styleSpan(this,binding.tvSignUp, SignUpActivity::class.java)

    }
}