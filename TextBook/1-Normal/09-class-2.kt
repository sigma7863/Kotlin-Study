クラスの基本ルール②
前回クラスの基本ルールについて学びましたが、他にも知っておきたいポイントがいくつかあるので紹介します。

また最初に作成した My Application プロジェクトに MainActivity.kt ファイルがありました。

実際のアプリ開発でクラスとメソッドがどのように使われているのかも調べてみましょう。


もくじ
補足解説
アクセス修飾子
４種類のアクセス修飾子
Robot.kt の修正
set 関数と get 関数
メソッドと関数
MainActivity.kt を調べてみよう
MainActivity クラス
onCreate メソッド
復習問題
チャレンジ問題
まとめ

補足解説
アクセス修飾子
Robot.kt の3・4・10行目に黄色い波線がついています。

これは Warning といって、エラーではないけれど修正した方がいい箇所に付くものです。

黄色い波線
Warning: 「警告、注意」のこと。


画面右上に出ている [黄色い！マーク] をクリックすると、画面下部にメッセージが表示されます。

Warning メッセージ
どのメッセージにも could be private と書いてあります。

これは「private にできるかもしれません」という意味で、private のことをアクセス修飾子といいます。


４種類のアクセス修飾子
アクセス修飾子は、プロパティやメソッドの使用範囲を制限するものです。

アクセス修飾子	使用できる範囲
public	すべてのクラスからアクセス可。デフォルト。
private	現在のクラスでのみアクセス可。
protected	同じモジュール内のクラスからアクセス可。
internal	現在のクラスからのみアクセス可。

デフォルトではどこからでも使用できる public になっていますが、誰でも自由にアクセスしてコードを変更できてしまうと、予期せぬエラーに繋がる可能性が高くなります。

適切なアクセス修飾子を使って簡単に変更を加えられないようにすることで、より安全なプログラムを作ることができるというメリットがあります。

現時点では public と private だけ覚えておきましょう。


Robot.kt の修正
Robot.kt では version, distance, info() 部分に Warning がついていました。

この３つは Robot クラス内でしか使っていないので、どこからでもアクセスできる public にしておく必要はありません。

これが原因で Waring がついていたので、private にしておきましょう。

 open class Robot(val name: String, private val version: Int) {
    private var distance = 0

    init {
        info()
    }

    private fun info() {
       println("----------")


３つの Warning が消えて、画面右上のマークも緑色のチェックマークになりました。

Warning の解消

なぜ val name には Warning がつかない？
val name は CleaningRobot クラスの sweep() と polish() で使用しています。

private をつけると CleaningRobot クラスで使用できなくなってしまうので、Warning はつきません。


set 関数と get 関数
ロボット第１号を作ったときに robot.name と書くだけで値を代入できました。

fun main() {
    val robot = Robot()
    robot.name = "アルファ"
}


Kotlin ではプロパティを定義すると

値をセットする set 関数
値を取り出す get 関数
が自動的に生成されます。

この機能のおかげで、簡単に値をセットして取り出すことができます。

fun main() {
    val robot = Robot()
    robot.name = "アルファ"  // set関数で値を代入
    println(robot.name)     // get関数で値を取り出す
}


メモ
set 関数は var で宣言したプロパティにだけ作成されます。val の場合は変更できないので set 関数が必要ないからです。

また自分で set 関数と get 関数を作成する方法もありますが、現時点では必要ないので省略します。

Kotlin の仕組みとして何となく知っておきましょう。


メソッドと関数
メソッドと関数は書き方が同じなので混同されることが多いですが、クラスと紐づいているものをメソッド、クラスと紐づけなくても使えるものを関数と言います。


Hello.kt に書いたコードは関数だけで、メソッドは存在していません。

Robot.kt は main 関数と、クラスに紐づいたメソッドで構成されています。

Hello.kt
Robot.kt

Kotlin では、クラスはあってもなくても良いので、メソッドと関数が存在します。

一方 Java は「クラスを必ず１つ用意する」という決まりがあるので、関数は存在せずメソッドだけになります。

Kotlin	Java
クラス	任意	必要
メソッド	◯	◯
関数	◯	×


MainActivity.kt を調べてみよう
最初に作成した My Application プロジェクトを開いて、どんなコードが書かれているか確認してみましょう。

プロジェクトを閉じてしまった方は、左上のプロジェクト名をクリック → My Application から開くことができます。

プロジェクトを開く

[New Window（新しいウィンドウ）] と [This Window（現在のウィンドウ）] のどちらで開くかを選択してください。

ウィンドウを選択

MainActivity クラス
MainActivity.kt を開くと、９行目から MainActivity クラスが用意されています。

さらに AppCompatActivity クラスを継承していることがわかります。

MainActivityクラス

onCreate メソッド
10行目からは onCreate メソッドが作成されています。

戻り値の型と return が書かれていないので、onCreate メソッドは処理をするだけのメソッドです。

さらに override キーワードが付いているのでスーパークラスのメソッドを上書きしていることが分かります。

onCreateメソッド

onCreate メソッドでは何をしているのかというと、アプリ画面を表示するための準備をしています。

例えば13行目の setContentView(R.layout.activity_main) は activity_main.xml を画面にセットしています。このコードを書くことでアプリ画面にテキストやボタンが表示されるようになる仕組みです。


setContentView メソッドについて調べてみましょう。

Windows の方は Ctrl キーを、Mac の方は command キーを押しながら setContentView 部分をクリックします。


AppCompatActivity.java に書いていある setContentView メソッドのコードが表示されました。

Java で書かれているので少し形式が変わっていますが、Override が付いているのでこのメソッドもスーパークラスから継承されていることが分かります。

setContentViewメソッド

このようにアプリ開発に必要なクラスやメソッドがたくさん用意されいるので、これらを組み合わせながら開発を進めていきます。

気になるクラスやメソッドがあったときは、コードを確認しながら開発を進めていくと、仕組みを理解しやすくなるかもしれません。


復習問題
お料理ロボット
ここまでの復習として 「お料理ロボット」 を作成してみましょう。

Robot クラスの基本的な機能に加えて「切る・焼く」という２つの機能を追加してください。

クラス名: CookingRobot
切るメソッド: slice()
焼くメソッド: fry()

答えを隠す
package com.example.kotlinproject

open class Robot(val name: String, private val version: Int) {
    // 省略
}

class CleaningRobot(name: String, version: Int) : Robot(name, version) {
    // 省略
}

class CookingRobot(name: String, version: Int) : Robot(name, version) {
    fun slice() {
        println("${name}は野菜を切っています。")
    }

    fun fry() {
        println("${name}は野菜を焼いています。")
    }
}

fun main() {
    // 省略

    val cookingRobot = CookingRobot("お料理ロボ", 1)
    cookingRobot.slice()
    cookingRobot.fry()
}



チャレンジ問題
お料理ロボットは完成しましたが 「食材の名前を指定したい」 という依頼がきました。

オブジェクト作成時に３つ目の引数として「食材名」を渡せるようにコードを修正してください。

val cookingRobot = CookingRobot("お料理ロボ", 1, "人参")


また slice メソッドと fry メソッドの実行結果に食材名が表示されるようにしてください。

// 実行結果
お料理ロボは人参を切っています。
お料理ロボは人参を焼いています。


答えを隠す
open class Robot(val name: String, private val version: Int) {
    // 省略
}

class CleaningRobot(name: String, version: Int) : Robot(name, version) {
    // 省略
}

 class CookingRobot(name: String, version: Int, private val vegetable: String) : Robot(name, version) {

    fun slice() {
        println("${name}は${vegetable}を切っています。")
    }

    fun fry() {
        println("${name}は${vegetable}を焼いています。")
    }
}

fun main() {
    // 省略

    val cookingRobot = CookingRobot("お料理ロボ", 1, "人参")
    cookingRobot.slice()
    cookingRobot.fry()
}


まとめ
Warning
エラーではないけど修正した方がよいコード
アクセス修飾子
プロパティやメソッドを使える範囲を制限するもの
public: どこからでもアクセス可
private: 現在のクラスのみアクセス可
メソッドと関数の違いはクラスに紐づいているか

細かいルールばかりで難しく感じたかもしれませんが、現時点でしっかり理解できていなくても問題ありません。

Android 開発では何度も出てくる知識なので、実際にアプリを開発しながら慣れていきましょう。
