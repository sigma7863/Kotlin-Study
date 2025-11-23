package com.example.kotlinproject

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {
    val score = generateRandomNumber(0, 100)
    
    val result = getResult(score)
    
    println("今日の運勢は${result}です。")
}

fun getResult(score: Int) = when (score) {
    in 91..100 -> "大吉"
    in 71..90 -> "中吉"
    in 51..70 -> "小吉"
    in 31..50 -> "吉"
    in 11..30 -> "凶"
    else -> "大凶"
}

fun generateRandomNumber(min: Int, max: Int) = (min..max).random()

fun displayResult(result: String) = println("今日の運勢は${result}です")
