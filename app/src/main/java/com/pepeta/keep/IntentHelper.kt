package com.pepeta.keep

import android.content.Context
import android.content.Intent

object IntentHelper {
    fun openIntent(context: Context, order: String?, passTo: Class<*>?) {
        //declare intent with context and class to pass the value to
        val i = Intent(context, passTo)
        //pass through string value with key"order"
        i.putExtra("order", order)

        //start Activity
        context.startActivity(i)
    }
}