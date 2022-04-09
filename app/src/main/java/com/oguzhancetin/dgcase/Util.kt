package com.oguzhancetin.dgcase

import android.view.View
import kotlinx.coroutines.coroutineScope
import java.math.BigInteger
import java.security.MessageDigest

fun View.turnVisible(){
    this.visibility = View.VISIBLE
}
fun View.turnInVisible(){
    this.visibility = View.INVISIBLE
}



fun md5(input: String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}

fun solver(hashcode:String): String {

    val myEmail = "cetinnoguzhan@gmail.com"
    val hasList = hashcode.chunked(32)
    val charSet1 = CharRange('A', 'z').toMutableList()
    val charSet2 = IntRange(0, 9).toMutableList()
    val charSet3 = listOf('+', '-', '.', '_', '@')
    val charSet = charSet1 + charSet2 + charSet3

    print(charSet)
    var xSum = ""
    hasList.forEach loopHasList@{ element ->
        charSet.forEach { i ->
            charSet.forEach { j ->
                val y = i.toString() + j.toString()
                val hashed = md5(md5(myEmail) + xSum+y + md5(xSum+y))
                if (hashed == element) {
                    xSum += y
                    println(xSum)
                    return@loopHasList
                }
            }
        }
    }
   return xSum
}