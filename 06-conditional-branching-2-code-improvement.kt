package com.example.kotlinproject

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {
    val score = (0..100).random()

    val result = when (score) {
        in 91..100 -> "大吉"
        in 71..90 -> "中吉"
        in 51..70 -> "小吉"
        in 31..50 -> "吉"
        in 11..30 -> "凶"
        else -> "大凶"
    }

    println("今日の運勢は${result}です。")
}

// 復習問題
fun main() {
    val randomNumber = (1..3).random()
    println(randomNumber)
    
    val result = when (randomNumber) {
        1 -> "グー"
        2 -> "チョキ"
        else -> "パー"
    }
    
    println("コンピューターは${result}を出しました。")
    
}


