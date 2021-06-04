package com.pepeta.keep

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout
import com.pepeta.keep.Utils.validateEmail
import com.pepeta.keep.Utils.validatePassword
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_in.*
import java.util.regex.Matcher
import java.util.regex.Pattern


object Utils {
    private val PASSWORD_PATTERN: Pattern = Pattern.compile("^" +
            "(?=.*[0-9])" +         //at least 1 digit
            "(?=.*[a-z])" +         //at least 1 lower case letter
            "(?=.*[A-Z])" +         //at least 1 upper case letter
            //"(?=.*[a-zA-Z])" +      //any letter
            "(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{8,}" +               //at least 4 characters
            "$")
//    companion object{
//        fun openIntent(context: Context, passTo: Class<*>) {
//            //declare intent with context and class to pass the value to
//            //val i = Intent(context, passTo)
//            val intent = Intent(context,passTo::class.java)
//            //start Activity
////            context.startActivity(i)
//            context.startActivity(intent)
//        }
//    }
    fun Activity.styleSpan(context: Context, textView: TextView, classTo: Class<*>){
            val spannableString = SpannableString(textView.text)
            val clickableSpannableString = object : ClickableSpan(){
                override fun onClick(widget: View) {
                    Intent(context, classTo).also {
                        startActivity(it)
                        finish()
                    }
                }
                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.color= ContextCompat.getColor(this@styleSpan,R.color.darkCyan)
                    ds.isUnderlineText=false
                }
            }

            when(textView){
                tvSignIn-> {
                    spannableString.setSpan(clickableSpannableString,25,textView.text.length, android.text.Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    textView.text=spannableString
                }
                tvSignUp->{
                    spannableString.setSpan(clickableSpannableString,23,textView.text.length, android.text.Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    textView.text=spannableString
                }
            }
            textView.movementMethod = LinkMovementMethod.getInstance()
        }

    fun Activity.hideStatusBar(){
        // If the Android version is lower than Jellybean, use this call to hide
        // the status bar.
        //TODO - hide the status bar.
    }

    fun EditText.validateCredential(context: Context): Boolean {

    }

//    fun validateEmail(editText: EditText): Boolean{
//        return (editText.text.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(editText.text).matches())
//    }

    fun EditText.validateEmail(): Boolean{
        return (this.text.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this.text).matches())
    }
    fun EditText.validatePassword(): Boolean?{
        val pw: String = ""
        val PASSWORD_PATTERN: Pattern = Pattern.compile("^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                //"(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 4 characters
                "$")

        return (this.text.isNotEmpty() && PASSWORD_PATTERN.matcher(this.text).matches())
    }

    fun TextInputLayout.validateEmail():Boolean{
        when {
            this.editText?.text!!.trim()!!.isEmpty() -> {
                this.isErrorEnabled = true
                this.error = R.string.err_field_empty.toString()
                return false
            }
            Patterns.EMAIL_ADDRESS.matcher(this.editText?.text).matches() -> {
                this.isErrorEnabled = true
                this.error = R.string.err_email_format.toString()
                return false
            }
            else -> {
                this.error=null
                this.isErrorEnabled = false
                return true
            }
        }
    }

    fun TextInputLayout.validatePassword():Boolean{
        when{
            this.editText?.text!!.trim()!!.isEmpty() -> {
                this.isErrorEnabled = true
                this.error = R.string.err_field_empty.toString()
                return false
            }
            PASSWORD_PATTERN.matcher(this.editText?.text).matches() ->{
                this.isErrorEnabled = true
                this.error = R.string.err_weak_pw.toString()
                return false
            }
            else->{
                this.error=null
                this.isErrorEnabled = false
                return true
            }
        }
    }

    fun TextInputLayout.validateUsername():Boolean{
        when{
            this.editText?.text!!.trim()!!.isEmpty() -> {
                this.isErrorEnabled = true
                this.error = R.string.err_field_empty.toString()
                return false
            }
            PASSWORD_PATTERN.matcher(this.editText?.text).matches() ->{
                this.isErrorEnabled = true
                this.error = R.string.err_weak_pw.toString()
                return false
            }
            else->{
                this.error=null
                this.isErrorEnabled = false
                return true
            }
        }
    }
}