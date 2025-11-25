// 今回はプログラミングで欠かすことのできない 「関数」 について学んでいきます。

// 関数とは 「コードをまとめたもの」 で、必要なタイミングで呼び出して使います。

// 大きいプログラムになるとコードの行数が増えていきますが、どこに何が書いているのか分からないとコードのメンテナンスが難しくなります。

// 関数を使って役割ごとにコードをまとめておくことで、エラーが起きたときに原因を見つけやすくなりますし、他の人が見ても理解しやすいプログラムを作ることができます（このようなプログラムの作り方を「責務の分割」や「関心の分離」と言います）。

// Android アプリ開発では、あらかじめ用意されている関数を使いながら開発を進めていきます。もちろん自分で関数を作ることもできます。

// Kotlin の関数は書き方のバリエーションがたくさんあるので、まずは基本的なルールを学んでいきましょう。


// もくじ
// 関数の種類
// 1. 処理をするだけの関数
// 2. 処理をして結果を返す関数
// パラメータの書き方　
// 具体例を見てみよう
// println 関数
// random 関数
// 関数を作ってみよう
// 開始コード
// ステップ１：関数の作成
// ステップ２：関数を呼び出す
// ステップ３：パラメータ付の関数
// ステップ４：関数を呼び出す
// ステップ5：パラメータに初期値を設定する
// ステップ６：コードの簡略化
// ここまでのコード
// 便利な機能を使ってみよう
// 1. 入力補完機能
// 2. 関数の作成機能
// 省略した書き方
// 3. コードの整形機能
// ここまでのコード
// 復習問題
// 完成コード
// まとめ

// 関数の種類
// 関数は大きく分けて

// 処理をするだけの関数
// 処理をして結果を返す関数
// の２通りがあります。


// 1. 処理をするだけの関数
// 基本形は以下のようになります。

// main 関数を書いたときにも触れましたが、fun が 関数（function）であることの目印です。

fun startGame() {
    // 関数内で実行するコード
}

// 関数の名前は 「何をするための関数なのか」 が分かるものにしましょう。

// 例えば startGame という名前だと「ゲームを始める関数」ということが伝わりやすいと思います。


// 変数名と同じように、関数名もキャメル型（小文字で始めて区切り文字は大文字）で書きます。

// 例） main, println, startGame


// 2. 処理をして結果を返す関数
// 関数内で処理をして値を返すときは () の後ろに : 返す値の型 を書いて return で値を返します。

// 以下の例は Boolean 型の値（true または false）を返す関数です。

fun startGame(): Boolean {
    // 関数内で実行するコード
    return true;
}


return: 「返す、戻す」という意味。

// パラメータの書き方　
// 関数内で使いたい値があるときは () の中にパラメータを書くことができます。

// このあと実際にコードを書きながら使い方を学んでいきましょう。

fun 関数名(パラメータ１: 型, パラメータ２: 型) {
    // 関数内で実行するコード
}

// 具体例を見てみよう
// println 関数
// ここまで何度も使った println 関数のコードを調べてみましょう。

// Windows の方は Ctrl キー、Mac の方は command キーを押しながら、println 部分をクリックします。

// println をクリック
// println 関数のコードが書いてある Console.kt ファイルが開きました。

// まだ学んでいないコードが書いてありますが、戻り値の型と return がないので、処理をするだけの関数であることがわかります。

// println 関数
// 戻り値がない場合の Unit
// 処理をするだけの関数には「戻り値の型」を書きませんが、実は Unit 型が省略されています。Unit は「値を返さない関数」という意味です。

fun startGame(): Unit {
}

// random 関数
// random 関数のコードも調べてみましょう。

// 戻り値の型 :Int が書いてあって、値を return で返しているので、処理をして結果を返す関数であることがわかります。

// random 関数

// 関数を作ってみよう
// 今度は、自分で関数を作ってみましょう。

// 0〜100の範囲でランダムな数値を生成している、以下のコードを関数にします。

val score = (0..100).random()

// 開始コード
// 以下のコードになっていることを前提に始めていきます。

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

// ステップ１：関数の作成
// まずは Int 型の値を返す関数を generateRandomNumber という名前で作成します。

// 関数の名前は変えても良いですが、ランダムな数字を生成する関数であることが分かる名前にしましょう。

// generate: 「生成する」という意味。パスワードジェネレータなど何かを生成するときによく使う単語です。

// main 関数の下にコードを追加します。

fun main() {
    // 省略
}

 fun generateRandomNumber(): Int {
     return (0..100).random()
 }

// ランダムな数値を返す関数なので、戻り値の型 : Int を書いて return で乱数を返しています。

// generateRandomNumber 関数

// ステップ２：関数を呼び出す
// main 関数はプログラムの入り口なので自分で呼び出す必要はありませんが、その他の関数は呼び出さないと実行されません。

// 関数名() と書いて呼び出しましょう。


// 変数 score の値を変更したらコードを実行して、今までと同じように結果が表示されることを確認しましょう。

fun main() {
    val score = generateRandomNumber()

    // 以下省略


// ステップ３：パラメータ付の関数
// 次はパラメータを使ってみましょう。

// パラメータを使うと、関数内で使う値を渡すことができます。

// 現在は乱数の範囲を0〜100に固定しているので、パラメータを使って範囲を指定できるようにしましょう。

// generateRandomNumber 関数を変更します。

fun main() {
    // 省略
}

 fun generateRandomNumber(min: Int, max: Int): Int {
    return (min..max).random()
 }

// min が最小値、max が最大値を意味しています。
// 関数を呼び出すときに min と max の値を指定して、これをもとに乱数を生成できるようになります。

// ステップ４：関数を呼び出す
// パラメータ付きの関数を呼び出す時は () の中に値を書きます。これを 引数 と言います。

fun main() {
    val score = generateRandomNumber(1, 100)

    // 以下省略

// パラメータと引数は混同されることがありますが

// パラメータ → 関数で定義した変数
// 引数 → 関数を呼び出すときに渡す値
// のことを言います。

// 仮引数と実引数
// パラメータを 仮引数、引数を 実引数 と呼ぶこともあります。

// 関数を定義したときは仮の引数（仮引数・パラメータ）を用意しておき、関数を使うときに実際の値（実引数）を入れるというイメージです。

// 関数を呼び出すときにパラメータ名を付けることができます。

// 名前を書くことで何の値なのかが分かりやすくなりますし、引数を書く順番も気にする必要がなくなります。パラメータ数が多いときに便利な書き方です。

// どの書き方も同じ結果になります。
val score = generateRandomNumber(1, 100)
val score = generateRandomNumber(min = 1, max = 100)
val score = generateRandomNumber(max = 100, min = 1)

// 関数の多重定義
// パラメータが異なっていれば、同じ名前の関数を作ることができて、これを 多重定義（overload） と言います。

// 以下のサンプルでは、関数名がすべて sayHello になっていますが、パラメータが異なっているので問題なく実行できます。

// 関数を呼び出すときの引数によって、どの関数が使用されるかが決まります。

fun main() {
    sayHello()
    sayHello("山田")
    sayHello("山田", 123)
}

fun sayHello() {
    println("こんにちは")
}

fun sayHello(name: String) {
    println("こんにちは、${name}さん")
}

fun sayHello(name: String, score: Int) {
    println("こんにちは、${name}さん。現在のスコアは${score}です！")
}


// ステップ5：パラメータに初期値を設定する
// 引数が指定されなかった場合に使う初期値をパラメータに設定できます。

// 以下のコードの場合、関数を呼び出す時に引数 min を渡していないので、初期値の 0 が使用されます。

val score = generateRandomNumber(max = 100)

fun generateRandomNumber(min: Int = 0, max: Int): Int {
    return (min..max).random()
}

// ステップ６：コードの簡略化
// generateRandomNumber 関数では、関数内で実行しているコードが１行しかありません。

// このような場合は、戻り値の型, {}, return を省略して = で繋ぐことができます。

fun generateRandomNumber(min: Int, max: Int) = (min..max).random()

// ここまでのコード
fun main() {
    val score = generateRandomNumber(0, 100)

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

fun generateRandomNumber(min: Int, max: Int) = (min..max).random()

// 便利な機能を使ってみよう
// Android Studio で用意されている、関数を書くときに便利な機能を３つ紹介します。

// 入力補完機能
// 関数の作成機能
// コードの整形機能

// 1. 入力補完機能
// 関数のキーワード fun を入力すると、入力候補が４つ表示されます。

// fun0, fun1, fun2 を選んで Enter キーを押すと、関数の雛形が入力されます。

// fun と入力
// 例えば fun2 を選択すると、パラメータが２つある関数の雛形が入力されます。

// fun2 を選択
// 関数名を入力して TAB キーを押すと、パラメータ名 → 型と入力していくことができます。

// 入力して TAB キーで移動

// 2. 関数の作成機能
// すでに書いたコードを簡単に関数にできる Extract 機能 もあります。

// Extract: 「抽出する、取り出す」という意味。ここでは「コードを抽出して関数にする」という意味。


// おみくじの結果を判定しているコードを関数にしてみましょう。

// 関数にしたいコード（6〜13行目）を選択すると、コードの上下どちらかにツールバーが表示されるので [Extract] → [Function...] を選択します。

// Extract → Function
// 関数名 getResult と入力して Enter キーを押します。

// getResult と入力
// getResult 関数を作成できました！

// score によって判定をするのでパラメータ有り、"大吉" のように文字列を返すので、戻り値の型は String 型になっています。

// private についてはあとで紹介するので、今は削除しておきましょう。

// getResult 関数
// 省略した書き方
// getResult 関数では、判定結果を変数 result に入れてから return で返していますが、これだと二度手間になってしまいます。

fun getResult(score: Int): String {
    val result = when (score) {
        in 91..100 -> "大吉"
        in 71..90 -> "中吉"
        in 51..70 -> "小吉"
        in 31..50 -> "吉"
        in 11..30 -> "凶"
        else -> "大凶"
    }
    return result
}

// 変数 result を使わずに、when 式の結果をそのまま返すコードに書き換えてみましょう。

fun getResult(score: Int): String {
    return when (score) {
        in 91..100 -> "大吉"
        in 71..90 -> "中吉"
        in 51..70 -> "小吉"
        in 31..50 -> "吉"
        in 11..30 -> "凶"
        else -> "大凶"
    }
}

// そうすると、関数内で実行しているコードは１つだけになるので、戻り値の型, {}, return を省略して = で繋ぐことができます。

fun getResult(score: Int) = when (score) {
        in 91..100 -> "大吉"
        in 71..90 -> "中吉"
        in 51..70 -> "小吉"
        in 31..50 -> "吉"
        in 11..30 -> "凶"
        else -> "大凶"
    }

// 3. コードの整形機能
// getResult 関数に余計なスペースが入っているので、コードを整えておきましょう。

// getResult 関数（11〜18行目）を選択するとツールバーが表示されるので [Reformat Code] ボタンをクリックします。

// Reformat Code を選択
// 余計なスペースが削除されました。

// 整形前 → 整形後のコード

// ファイルをまるごと整形したい場合は Android Studio メニューから [Code] → [Reformat Code] を選択します。

// 一括整形

// Reformat: 「書式や形式を再設定する」という意味。

// ここまでのコード
package com.example.kotlinproject

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

// 復習問題
// 結果を表示しているコード

println("今日の運勢は${result}です。")

// を関数にしてみましょう。

// 関数名は displayResult、パラメータあり、戻り値なしで書いてください。

 package com.example.kotlinproject

 fun main() {
     // 省略
 }

 fun getResult(score: Int) = when (score) {
     // 省略
 }

 fun generateRandomNumber(min: Int, max: Int) = (min..max).random()

 // ここにコードを追加してください！

// display: 「表示する」という意味。関数名を displayResult にすると、結果を表示する関数であることが伝わりやすくなります。

// 【基本的な書き方】
fun displayResult(result: String) {
    println("今日の運勢は${result}です。")
}

// 【省略した書き方】
fun displayResult(result: String) = println("今日の運勢は${result}です。")

// 完成コード
package com.example.kotlinproject

fun main() {
    val score = generateRandomNumber(0, 100)
    val result = getResult(score)
    displayResult(result)
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

fun displayResult(result: String) = println("今日の運勢は${result}です。")

// まとめ
// 関数とは
// コードをまとめたもの
// 呼び出して使う
// 種類
// 処理をするだけの関数
// 処理をして結果を返す関数
// パラメータ
// 関数内で使う値を渡すことができる
// 初期値を書くことができる
// 便利な機能
// 入力補完機能
// 関数の作成機能
// コードの整形機能
