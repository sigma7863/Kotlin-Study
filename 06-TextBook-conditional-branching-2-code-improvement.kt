// コードを改善しよう
// ランダムな数字の生成
// Kotlinでは乱数(ランダムな数字)を、以下のコードで簡単に生成できる
// (開始..終了).random()

// おみくじアプリでは0から100の範囲で乱数を生成したいので
(0..100).random()
// と書く
// 0と100も含まれるのがポイントで、この書き方を Range(レンジ) と言う(あとで詳しく紹介します)

// Tips いろいろな使い方
// random 関数は Int, Long, Char 型にも使うことができるので、ランダムなアルファベットやひらがなも生成できる
val alphabet = ('a'..'z').random()
println(alphabet)

val hiragana = ('あ'..'ん').random()
println(hiragana)

// 数字の確認
// 本当にランダムな数字になっているのか、println 関数を使って確認してみましょう。
// 以下のコードを追加します。
package com.example.kotlinproject
fun main() {
+   println((0..100).random())
+   println((0..100).random())
+   println((0..100).random())
+   println((0..100).random())
+   println((0..100).random())

    val score = 100
    //以下省略
}

// 変数 score を乱数にする
// この random 関数を使って、変数 score を乱数にします。
// 条件判定が正しく行われるかを確認したいので、println 関数で変数 score を出力しておきましょう。
fun main() {
-    println((0..100).random())
-    println((0..100).random())
-    println((0..100).random())
-    println((0..100).random())
-    println((0..100).random())
    
-    val score = 100
+    val score = (0..100).random()
+    println(score)

     if (score == 100) {
        println("大吉")

// 何回かコードを実行して、おみくじの結果を確認してみましょう。
// 毎回結果が変わっていれば成功です!
