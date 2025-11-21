package com.example.kotlinproject

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {
    val message: String = "こんにちは"
    message = "Hello" // valは再代入出来ないので値を変更しようとするとエラー
    println("Hello World!")
}

fun main() {
    var message: String = "こんにちは" // 変更していないのにvarを使っているのでメッセージが付く
    println(message)
}

// val: value の省略形。「値」という意味。
// var: variable の省略形。「変数、可変の」という意味。

// 型が異なっていたとしても同じ変数名を使うことはできない
val age: String = "30"
val age: Int = 30

// 変数名の先頭に数字をつけることはできない
val name1: String = "山田"
val 1name: String = "佐藤"

// 予約語は使うことができない
val fun: String = "関数"
val as: Int = 1
val null: String = "空っぽ"

// 型には以下のようなものがあります。

// 型	    値	                   例
// String	文字列	                  "こんにちは"
// Boolean	真 または 偽	             true または false
// Char	    ２バイトの文字（Unicode）  'あ', 'X', 12354
// Byte	    １バイトの整数	           -128〜127
// Short	２バイトの整数	           -32768〜32767
// Int	    ４バイトの整数			   -2147483648〜2147483647
// Long	    ８バイトの整数			   -9223372036854775808〜9223372036854775807
// Float	４バイトの浮動小数点	     6〜7桁
// Double	８バイトの浮動小数点	     15〜16桁

// 使いながら覚えていけば良いので、まずは以下の３つの型を少しだけ意識しておいてください。

// ・String: 文字列
// ・Int: ４バイトの整数
// ・Boolean: true または false

val stringText: String = "あいうえお"
val status: Boolean = true
val charText: Char = 'あ'
val byteNum: Byte = 127
val shortNum: Short = 32767
val intNum: Int = 2147483647
val longNum: Long = 1234567899999
val floatNum: Float = 123.45F
val doubleNum: Double = 12345.6789

// String型は文字列、Char型は1文字だけ代入できる
// また String 型は "（ダブルクォーテーション）で囲みますが、Char 型は '（シングルクォーテーション）で囲む
val stringText: String = "あいうえお"
val charText: Char = 'あ'

// Float型の値は最後にFまたはfをつける
val floatNum: Float = 123.45F

// 指定した型以外の値は入れることができない
var age: String = "25"
age = 25

// 型推論: 変数の宣言時に値を代入すると型を省略できる
val stringText = "あいうえお"
val status = true
val charText = 'あ'
val byteNum = 127
val shortNum = 32767
val intNum = 2147483647
val longNum = 1234567899999
val floatNum = 123.45F
val doubleNum = 12345.6789
