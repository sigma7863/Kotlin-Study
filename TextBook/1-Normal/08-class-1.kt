// クラスの基本ルール①
// プログラムが大きくなると使用する変数と関数が増えるので、どこに何が書いてあるのか分かりづらくなり、コードの管理が難しくなります。

// 例えばスマホアプリでは１つの画面に「テキスト・ボタン・画像が３つずつ」ということがよくありますが、全てのコードを１つのファイルに書いてしまうと、ゴチャゴチャしたプログラムになってしまいます。

// そこで役立つのが 「クラス」 です。

// クラスとは簡単に言うと 「関連する変数や関数をまとめたもの」 です。

// 「テキストに関するコードはテキストクラスに書く、ボタンに関するコードはボタンクラスに書く」というように役割ごとにクラス分けすることでプログラムを整理できます。

// クラスを使ったプログラム開発を 「オブジェクト指向プログラミング」 といって、現在もっとも一般的な手法になっています。

// 「オブジェクト」といってもイメージが湧きにくいので、簡単なコードを書きながらクラスについて学んでいきましょう。

// もくじ
// 基本的な書き方
// クラスの仕組み
// ロボットクラスの作成
// ロボットの設計
// ３つのプロパティ
// info メソッド
// walk メソッド
// stop メソッド
// ロボット第１号が完成
// オブジェクトの作成
// 名前をつける
// メソッドの呼び出し
// コードの実行
// ロボットのカスタマイズ①（コンストラクタ）
// ロボットのカスタマイズ②（初期化ブロック）
// ロボットを増産
// ここまでのコード
// 新バージョンの開発（継承）
// お掃除ロボットクラスの用意
// Robot クラスの継承
// オブジェクトの作成
// お掃除メソッドの追加
// メソッドの上書き
// まとめ
// ここまでのコード

// 基本的な書き方
// クラスの書き方は class クラス名 と書いて {} を付けるだけです。

class Sample {
    //ここにコードを書いていきます。
}

// ここでのポイントは、クラス名の最初の文字は大文字にすることです。

// 例） Sample, Person, Dog

// 複数の単語を組み合わせる場合は、区切り文字も大文字にします。この書き方を 「パスカルケース」 と呼びます。

// 例） MySample, MainActivity

// クラスの仕組み
// クラスについて理解するために、ロボットを例にして考えてみましょう。

// 優秀なプログラマであるAさんは、ある日突然、社長から新しいロボットの開発を任されることになりました。

// Robot を作ろう

// ロボットクラスの作成
// さっそくAさんはロボットの設計図を書くために Robot クラスの作成に取り掛かります。

// パッケージ名（com.example.kotlinproject）の上で右クリックして、[New] → [Kotlin Class/File] をクリックします。

// New → Kotlin Class/File
// Robot と入力して [Class] を選択した状態で Enter キーを押します。

// Robot と入力
// Robot クラスを作成できました。

// Robot クラス

// ロボットの設計
// 次にAさんはロボットに必要な機能を考え始めます。

// ロボットには「名前・バージョン番号・動いた距離」といった情報があると便利ですし、「自己紹介する・歩く・止まる」という機能が必要になりそうです。

// どんな機能が必要？

// Aさんはこれらを Robot クラスに追加することにしました。

// このとき「名前・バージョン番号・動いた距離」といったロボットの特徴や状態のことをプロパティ、「自己紹介する・歩く・止まる」といった機能のことをメソッドと言います。

class Robot {
  // 【プロパティ】
  // 名前
  // バージョン番号
  // 動いた距離

  // 【メソッド】
  // 自己紹介する
  // 歩く
  // 止まる
}

// 実際にコードで書いてみましょう。

// プロパティの書き方は変数と同じで、メソッドの書き方は関数と同じです。

package com.example.kotlinproject

class Robot {
    var name = ""
    val version = 1
    var distance = 0

    fun info() {
        println("----------")
        println("こんにちは、私の名前は${name}です。")
        println("バージョン: ${version}\n歩いた距離: ${distance}メートル")
        println("----------")
    }

    fun walk() {
        distance++
        println("${name}は歩いた！")
    }

    fun stop() {
        println("${name}は止まった！")
    }
}

// ３つのプロパティ
// name はロボットの名前です。名前はあとで決めるので var にしておきます。

// version はロボットのバージョン番号です。現時点では第１号としておき、変更する予定がないので val にしています。

// distance はロボットが歩いた距離です。walk メソッドを呼ぶたびに数値を足していくので var にしています。

// info メソッド
// 自己紹介をするメソッドです。

// バージョンと歩いた距離の間に書いている \n は改行コードです。複数の println 関数を使わなくても改行を入れることができます。

// walk メソッド
// ロボットを歩かせるときに呼ぶメソッドです。

// distance++ は distance に１を加算するコードです。

// stop メソッド
// ロボットを停止させるときに呼ぶメソッドです。

// ロボット第１号が完成
// ロボット第１号が完成
// オブジェクトの作成
// 設計図が出来たのでAさんはロボット第１号を作ることにしました。

// Robot クラスの下に、プログラムの入り口になる main 関数を追加して、ロボットを作成します。

 package com.example.kotlinproject

 class Robot {
     // 省略
 }

 fun main() {
     val robot = Robot()
 }

// val robot = Robot() という書き方を 「オブジェクトを作成する」 と言います。

// オブジェクトを作成することで、そのクラス（Robot クラス）のプロパティやメソッドを使えるようになります。

// 名前をつける
// オブジェクトを用意できたので、ロボットに名前をつけましょう。

// ロボットの名前は Robot クラスの name プロパティを使います。

// オブジェクト.プロパティ名 でプロパティに値を代入できます。

fun main() {
    val robot = Robot()
    robot.name = "アルファ"
}

// メソッドの呼び出し
// ３つのメソッドも呼び出してみましょう。

// メソッドを使うにはオブジェクト.メソッド名()と書きます。

fun main() {
    val robot = Robot()
    robot.name = "アルファ"

    robot.info()
    robot.walk()
    robot.stop()
}

// コードの実行
// ここでコードを実行してみましょう。

// ロボット名が「アルファ」になっていて、それぞれのメソッドが実行されていれば成功です！

// コードの実行

// 歩いた距離 distance が更新されるかどうかを確認するために、walk メソッドを 3 回実行してから info メソッドを呼んでみましょう。

fun main() {
   val robot = Robot()
    robot.name = "アルファ"

    robot.info()
    robot.walk()
    robot.walk()
    robot.walk()
    robot.stop()
    robot.info()
}

// コードを実行すると、walk メソッドを実行した回数に合わせて歩いた距離も更新されていることが分かります。

// コードの実行

// ロボットのカスタマイズ①（コンストラクタ）
// ロボット第１号を社長に見せると 「名前とバージョン番号はオブジェクトを作成する時に決めたい」 と言われたので、Aさんは設計図を修正することにしました。

// 名前とバージョン番号を決めたい！

// クラスには 「コンストラクタ」 という初期化を行うための機能が用意されています。

// コンストラクタを使うとオブジェクト作成時に値を設定できるので、これを使ってロボットの名前とバージョンを設定しましょう。

// コードを変更します。

package com.example.kotlinproject

 class Robot(val name: String, val version: Int) {
    var distance = 0

    fun info() {

// オブジェクト作成時に初期値を設定する必要があるので、main 関数に書いたコードも変更します。

fun main() {
    val robot = Robot("アルファ", 1)

    robot.info()

// コンストラクタの補足
// class Robot(val name: String, val version: Int) という書き方を 主コンストラクタ（プライマリコンストラクタ） と言って、実際は constructor キーワードが省略されています。
// class Robot constructor (val name: String, val version: Int) {

// 初期化の方法を複数用意したい場合は セカンダリコンストラクタ も追加できますが、現時点では必要がないので省略します。

// コードを実行してみましょう。

// オブジェクト作成時に名前とバージョンを設定できていることがわかります。

// コードの実行

// コンストラクタの初期値
// オブジェクト作成時に値が渡されなかった場合の初期値を設定できます。

class Robot(val name: String = "名無し", val version: Int) {

// オブジェクト作成時にバージョンだけ指定すると、このロボットの名前は「名無し」になります。

val robot = Robot(version = 1)

// ロボットのカスタマイズ②（初期化ブロック）
// 修正したロボット第１号を社長に見せると 「最初に必ず info メソッドを実行して欲しい」 と頼まれました。

// 最初に必ず自己紹介して！

// コンストラクタを使って初期値を設定できましたが、ここには「println 関数を実行する」といった処理を書くことはできません。

// オブジェクト作成時に処理を実行するには、初期化ブロック init を使います。

// initialize: 「初期化する」という意味。省略形が init です。

// Robot クラスに初期化ブロック init{} を追加して info メソッドを呼び出します。

// info メソッドは自動的に呼び出されるので、main 関数内に書いた info メソッドを呼び出すコードは削除します。

class Robot(val name: String, val version: Int) {
    var distance = 0

    init {
        info()
    }

    // 省略
}

fun main() {
    val robot = Robot("アルファ", 1)

    robot.walk()
    robot.stop()
}

// コードを実行してみましょう。

// main 関数内で info メソッドを呼び出していませんが、init ブロックによって実行されていることが分かります。

// コードの実行

// ロボットを増産
// ロボットを増産

// このロボットは大人気になって増産することになりましたが、もう一度 Robot クラスから作る必要はありません。

// クラスは基本設計書のようなものなので、Robot クラスを使ってロボット（オブジェクト）をいくつでも作ることができます。

// 複数のロボットを作ることができる
val robot = Robot("アルファ", 1)
val robot2 = Robot("ベータ", 1)
.
.
.
val robot100 = Robot("RobotX-100", 1)

// ここでは２つ目のロボットを作成して、コードを実行してみましょう。

fun main() {
    val robot = Robot("アルファ", 1)
    robot.walk()
    robot.stop()

    val robot2 = Robot("ベータ", 1)
    robot2.walk()
    robot2.stop()
}

// コードを実行すると、アルファとベータそれぞれのオブジェクトを作成できていることが分かります。

// ここまでのコード
package com.example.kotlinproject

class Robot(val name: String, val version: Int) {
    var distance = 0

    init {
        info()
    }

    fun info() {
        println("----------")
        println("こんにちは、私の名前は${name}です。")
        println("バージョン番号: ${version}\n歩いた距離: ${distance}メートル")
        println("----------")
    }

    fun walk() {
        distance++
        println("${name}は歩いた！")
    }

    fun stop() {
        println("${name}は止まった！")
    }
}

fun main() {
    val robot = Robot("アルファ", 1)
    robot.walk()
    robot.stop()
}

// 新バージョンの開発（継承）
// ロボットが人気商品となったので、Aさんは社長に 「お掃除ロボットを作って欲しい」 と頼まれました。

// お掃除ロボット

// 従来のロボットと基本的な機能は同じですが、お掃除ロボットには「掃く、磨く」という機能が必要になりそうです。

// もう一度 Robot クラスを作るのは面倒なので、Aさんは 「継承」 を使うことにしました。

// 継承とは 「プロパティやメソッドを引き継くことができる仕組み」 です。

// Robot クラスを継承することで、Robot クラスに書いたコードを使えるようになります。実際にコードを書きながら確認していきましょう。

// お掃除ロボットクラスの用意
// まずはお掃除ロボットのクラスを用意しましょう。

// コードが多くなるとクラスごとにファイルを作成しますが、今回は Robot.kt にまとめて書きます。

// Robot クラスと main 関数の間に CleaningRobot クラスを追加します。

class Robot(val name: String, val version: Int) {
    // 省略
}

 class CleaningRobot {
 }

fun main() {
    // 省略
}

// Robot クラスの継承
// CleaningRobot クラスでは Robot クラスを継承したいので、クラス名の後ろに : Robot() をつけます。

// また Robot クラスに name と version を渡す必要があるので変数も用意します。

 class CleaningRobot(name: String, version: Int) : Robot(name, version) {

// Robot() 部分に赤い波線が付いています。

// Robot部分に赤い波線が付く
// 継承元になるクラスには open キーワードをつける必要があるので、Robot クラスの先頭に open をつけます。

open class Robot(val name: String, val version: Int) {

// 赤い波線を消すことができましたね！

// 赤い波線が消えました

// スーパークラスとサブクラス
// 他のクラスに継承されるクラスをスーパークラス、スーパークラスを継承するクラスをサブクラスと言います。

// お掃除ロボットの場合は Robot クラスがスーパークラス、CleaningRobot クラスがサブクラスです。


// スーパークラスとサブクラス

// オブジェクトの作成
// CleaningRobot クラスを使ってオブジェクトを作成してみましょう。

// コードの書き方は Robot クラスのオブジェクト作成と同じです。

open class Robot(val name: String, val version: Int) {
    // 省略
}

class CleaningRobot(name: String, version: Int) : Robot(name, version) {
}

fun main() {
    val robot = Robot("アルファ", 1)
    robot.walk()
    robot.stop()

    val cleaningRobot = CleaningRobot("お掃除ロボ", 1)
    cleaningRobot.walk()
    cleaningRobot.stop()
}

// コードを実行してみましょう。

// CleaningRobot クラスには何もコードを書いていないのに、メソッドを実行できていますね。

// このように、継承元のクラス（Robot クラス）にあるプロパティやメソッドを簡単に使えるようになるのが継承です。

// コードの実行

// お掃除メソッドの追加
// お掃除ロボットなので「掃く、磨く」というメソッドを追加しましょう。

class CleaningRobot(name: String, version: Int) : Robot(name, version) {

    fun sweep() {
        println("${name}は床を掃いています。")
    }

    fun polish() {
        println("${name}は床を磨いています。")
    }
}

// メソッドの呼び出し方は、いつもと同じようにオブジェクト.メソッド名()と書きます。

fun main() {
    // 省略

    val cleaningRobot = CleaningRobot("お掃除ロボ", 1)
    cleaningRobot.sweep()
    cleaningRobot.polish()
}

// CleaningRobot クラスに書いたメソッドも実行できました。

// 実行結果

// メソッドの上書き
// サブクラス（CleaningRobot クラス）では、スーパークラス（Robot クラス）のメソッドに変更を加えることができます。

// ここでは Robot クラスに書いた stop メソッドを CleaningRobot クラスから書き換えてみましょう。

// まずは Robot クラスの stop メソッドに open キーワードをつけます。

open class Robot(val name: String, val version: Int) {
    // 省略

    open fun stop() {
        println("${name}は止まった！")
    }
}

// CleaningRobot クラスに stop メソッドを追加します。

// ここでのポイントは override キーワードをつけることです。

class CleaningRobot(name: String, version: Int) : Robot(name, version) {

    override fun stop() {
        println("---休憩中---")
    }

    fun sweep() {
        println("${name}は床を掃いています。")
    }

    fun polish() {
        println("${name}は床を磨いています。")
    }
}

// override: 一般的には「優先する、無効にする」という意味ですが、プログラミングでは「上書きする」という意味で使われます。

// cleaningRobot オブジェクトから stop メソッドを呼び出しましょう。

fun main() {
    // 省略
    val cleaningRobot = CleaningRobot("お掃除ロボ", 1)
    cleaningRobot.sweep()
    cleaningRobot.polish()
    cleaningRobot.stop()
}

// コードを実行すると 止まった！ は出力されずに 休憩中 だけ出力されました。

// コードの実行

// Robot クラスの stop メソッド内に書いた 止まった！ も出力したい場合はどうすれば良いでしょうか？

// このように継承元（スーパークラス）のコードも呼び出したいときは super.stop() と書きます。

class CleaningRobot(name: String, version: Int) : Robot(name, version) {

    override fun stop() {
        super.stop()
        println("---休憩中---")
    }

    // 省略
}

// コードを実行すると Robot クラスの stop メソッドに書いたコードも実行されていることを確認できます。

// まとめ
// クラス
// 関連する変数（プロパティ）や関数（メソッド）をまとめたもの
// プロパティ: 特徴や状態
// メソッド: 機能
// オブジェクトを作成して使う
// オブジェクト名.プロパティ名
// オブジェクト名.メソッド名()
// 初期設定
// コンストラクタ
// 初期化ブロック init {}
// 継承
// プロパティやメソッドを引き継ぐ仕組み
// open キーワード
// 継承されるクラス → スーパークラス
// スーパークラスを継承するクラス → サブクラス
// スーパークラスのメソッドを上書き
// スーパークラス側: open
// サブクラス側: override

// ここまでの復習問題は次のステップで用意しています。

// 実際にクラスがどのように使われているのか、MainActivity.kt のコードも確認していきましょう。

// ここまでのコード
package com.example.kotlinproject

open class Robot(val name: String, val version: Int) {
    var distance = 0

    init {
        info()
    }

    fun info() {
        println("----------")
        println("こんにちは、私の名前は${name}です。")
        println("バージョン番号: ${version}\n歩いた距離: ${distance}メートル")
        println("----------")
    }

    fun walk() {
        distance++
        println("${name}は歩いた！")
    }

    open fun stop() {
        println("${name}は止まった！")
    }
}

class CleaningRobot(name: String, version: Int) : Robot(name, version) {

    override fun stop() {
        super.stop()
        println("---休憩中---")
    }

    fun sweep() {
        println("${name}は床を掃いています。")
    }

    fun polish() {
        println("${name}は床を磨いています。")
    }
}

fun main() {
    val robot = Robot("アルファ", 1)
    robot.walk()
    robot.stop()

    val cleaningRobot = CleaningRobot("お掃除ロボ", 1)
    cleaningRobot.sweep()
    cleaningRobot.polish()
    cleaningRobot.stop()
}
