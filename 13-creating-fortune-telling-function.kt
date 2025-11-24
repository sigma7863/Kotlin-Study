おみくじ機能をつくろう
今回はアプリのメインであるおみくじ機能を実装します。

「占う」ボタンをタップしたらおみくじの画像を切り替えて、簡単なアニメーションを実装してみましょう。


完成イメージ

もくじ
オブジェクトの用意
ボタンのクリックイベント
イベントリスナとは？
アプリの実行
画像を切り替えよう
関数の用意
コードの修正
おみくじ結果の表示
ランダムな数値の生成
画像のセット
ボタンのテキストを変更
アプリの実行
回転アニメーションをつけよう
ボタンを押したとき
① 画像をおみくじ箱にする
② ボタンを非表示にする
③ 回転アニメーション
回転が終わったとき
① 結果画像をセット
② 画像の回転を戻す
③ ボタンの表示
アプリの実行
復習問題
補足
まとめ
今回書いたコード

オブジェクトの用意
activity_main.xml では、id 属性を使って ImageView と Button に名前をつけました。

MainActivity.kt からこの２つを操作するために、id を使って ImageView と Button のオブジェクトを用意します。

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // 省略
        }

        val img: ImageView = findViewById(R.id.img)
        val btn: Button = findViewById(R.id.btn)
    }
}


変数と型で学んだ基本ルールにしたがって、ImageView 型と Button 型の変数を用意しています。

このコードを書くために ImageView クラスと Button クラスのファイルが必要になるので、４・５行目に import 文も追加されます。

追加されたimport文
findViewById メソッドは、名前のとおり id から ビューを見つけるメソッドです。

このコードを書くことで MainActivity.kt から画像を変更したり、ボタン押したときの処理を書くことができるようになります。


ボタンのクリックイベント
イベントリスナとは？
次はボタンをタップしたときに実行するコードを書いていきましょう。

タップや入力といったユーザの操作を検知するために イベントリスナ という機能が用意されています。

ボタンのタップ（クリック）の場合は OnClickListener というイベントリスナを使って、以下のようにコードを書くことができます。

オブジェクト名.setOnClickListener {
    // ボタンがタップされたら実行するコード
}


まずはボタンをタップしたら、ボタンのラベルを タップされた！ に変更するコードを書いてみましょう。

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 省略
        val img: ImageView = findViewById(R.id.img)
        val btn: Button = findViewById(R.id.btn)

        btn.setOnClickListener {
            btn.text = "タップされた！"
        }
    }
}



イベントリスナの種類
長押しを検知する OnLongClickListener、押されたキーを検知する OnKeyListener、画面のタッチを検知する OnTouchListener などがあります。



アプリの実行
ここでアプリを実行してみましょう。

実行するエミュレータを確認して ▶︎ ボタンを押します。

アプリの実行
ボタンをタップして、ラベルが タップされた！ に変わることを確認しましょう。

ボタンをタップ

確認が終わったら ■ ボタンを押して、アプリの実行を停止しておきます。

アプリの停止

画像を切り替えよう
関数の用意
関数の基本ルールでは、ランダムな数値を生成しておみくじ結果を表示するコードを書きました。

せっかくなので、このコードをコピー&ペーストして使いましょう（参考：関数の基本ルール - 完成コード）。


KotlinProject の Hello.kt に書いた getResult 関数と generateRandomNumber 関数をコピーします。

関数のコピー
MainActivity クラス内にコードを貼り付けます。

関数の貼り付け

コードの修正
getResult 関数では score に基づいて 大吉 という文字列を返していました。

今回は画像を表示するので、R.drawable.画像名 のように画像の id を返すコードに変更しましょう。

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 省略
    }

    fun getResult(score: Int) = when (score) {
        in 91..100 -> R.drawable.daikichi
        in 71..90 -> R.drawable.chukichi
        in 51..70 -> R.drawable.shoukichi
        in 31..50 -> R.drawable.kichi
        in 11..30 -> R.drawable.kyou
        else -> R.drawable.daikyo
    }

    fun generateRandomNumber(min: Int, max: Int) = (min..max).random()
}


R.drawable.画像名 は文字列のように見えますが、R クラスという場所に用意されている id を使うための書き方です。

以下のように id は 16 進数の数値（Int 型）で用意されています。

Rクラス

おみくじ結果の表示
getResult 関数と generateRandomNumber 関数を使って、結果を表示するコードを書きましょう。

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 省略
        val img: ImageView = findViewById(R.id.img)
        val btn: Button = findViewById(R.id.btn)

        btn.setOnClickListener {
            val score = generateRandomNumber(0, 100)
            img.setImageResource(getResult(score))
            btn.text = getText(R.string.btn_text_again)
        }
    }


ランダムな数値の生成
val score = generateRandomNumber(0, 100)

コピー&ペーストした generateRandomNumber 関数（MainActivity クラス内に書いているのでメソッドと呼ぶのが正確）を使って、0〜100 の範囲でランダムな数値を生成しています。


画像のセット
img.setImageResource(getResult(score))

ImageView の画像を変更するには オブジェクト名.setImageResource(R.drawable.画像名) のように書きます。

R.drawable.画像名 部分は getResult メソッドを使って取得しています。


ボタンのテキストを変更
btn.text = getText(R.string.btn_text_again)

strings.xml に「もう一度」という文字列を用意しました。

この文字列は getText(R.string.名前) と書いて使うことができます。


アプリの実行
ここでアプリを実行します。

ボタンをタップして結果が変わることを確認しましょう。

アプリの実行

回転アニメーションをつけよう
最後の仕上げとして、おみくじ箱に回転アニメーションをつけてみましょう。


完成イメージ

ボタンを押したとき
まずは「占う」ボタンを押したときの処理を書きます。

必要なのは

画像をおみくじ箱にする
ボタンを非表示にする
回転アニメーションを始める
の３つです。


コードを追加していきましょう。

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 省略

        btn.setOnClickListener {
            val score = generateRandomNumber(0, 100)
            img.setImageResource(R.drawable.omikuji)
            btn.visibility = View.INVISIBLE

            // 回転アニメーション
            img.animate().rotation(180f).setDuration(2000L).withEndAction {
            }

            btn.text = getText(R.string.btn_text_again)
        }
    }


① 画像をおみくじ箱にする
img.setImageResource(R.drawable.omikuji)

２回目以降に占うときは結果画像が表示されている状態なので、おみくじ箱に戻しておきます。


② ボタンを非表示にする
btn.visibility = View.INVISIBLE

Visibility は可視性（見えるかどうか）を指定するもので、表示・非表示の切り替えに使います。

ここでは非表示にするので INVISIBLE としています。View.INVISIBLE と書いてあるのは View クラスに用意されている値だからです。

Visibility: 可視性
Visible: 見える
Invisible: 見えない


③ 回転アニメーション
img.animate().rotation(180f).setDuration(2000L).withEndAction {
}


ここでは 「画像を180度回転させるアニメーションを２秒間かけて実行する」 というコードを書いています。

４つのメソッド

animate（アニメーション開始）
rotation（回転）
setDuration（継続時間）
withEndAction（終了時アクション）
を . で繋げて書いていて、この書き方をメソッドチェーンと言います。

複数の処理を１行にまとめることができるので、簡潔なコードを書くことができます。


■ animate メソッド

アニメーションを開始するために呼び出します。


■ rotation メソッド

回転させるメソッドで、() 内に回転角度を Float 型で指定します。

rotation(180f) にすると180度回転するアニメーションになります。

rotation: 「回転」という意味。


■ setDuration メソッド

アニメーションの継続時間を設定するメソッドです。

() 内にミリ秒を Long 型で指定します（Long 型は数値の最後に L をつけます）。

１秒は1000ミリ秒なので、setDuration(2000L) は2000ミリ秒（２秒間）かけてアニメーションが実行されます。

duration: 「継続、持続期間」という意味。


■ withEndAction メソッド

アニメーションが完了したら実行するコードを書くためのメソッドです。このあと {} 内にコードを書いていきます。


回転が終わったとき
アニメーションが終わったときに必要なのは

結果画像をセット
画像の回転を戻す
ボタンの表示
の３つです。

withEndAction メソッドの {} 内にコードを追加しましょう。

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 省略

        btn.setOnClickListener {
            val score = generateRandomNumber(0, 100)
            img.setImageResource(R.drawable.omikuji)
            btn.visibility = View.INVISIBLE

            img.animate().rotation(180f).setDuration(2000L).withEndAction {
                img.setImageResource(getResult(score))
                img.rotation = 0f
                btn.visibility = View.VISIBLE
            }

            btn.text = getText(R.string.btn_text_again)
        }
    }


① 結果画像をセット
img.setImageResource(getResult(score))

getResult メソッドで画像 id を取得して画像をセットします。


② 画像の回転を戻す
img.rotation = 0f

画像を回転していない状態 0f に戻します。


③ ボタンの表示
btn.visibility = View.VISIBLE

INVISIBLE（非表示）にしていたボタンを VISIBLE にして表示します。


アプリの実行
以上で完成です！

アニメーションが正しく動作するか確認してみましょう。


完成イメージ

復習問題
getResukt メソッドと generateRandomNumber メソッドに黄色い波線が付いています。

黄色い！マーク
黄色い波線が消えるようにコードを修正してください。

ヒントはクラスの基本ルール②で学んだ知識を使います。


答えを隠す
黄色い！マークをクリックすると、画面下部にメッセージが表示されます。

Warningの表示
ここには「getResukt メソッドと generateRandomNumber メソッドは private にできます」と書いてあります。

private 修飾子は、現在のクラスでのみアクセスできるようにするものでした。

この２つのメソッドは MainActivity クラスでしか使用していないので、private をつけておきましょう。

privateをつける

補足
generateRandomNumber メソッドの max, min 部分に黄色い波線がついています。

黄色い波線
このメソッドは１度しか使っていないので「0 と 100 に固定して良いのでは？」という提案です。

提案通り、範囲を 0 から 100 に固定して、パラメータなしのメソッドに変更しましょう。

 private fun generateRandomNumber() = (0..100).random()


27行目あたりのメソッドを呼び出しているコードも修正します。

 val score = generateRandomNumber()


画面右上に緑色のチェックマークが付いたら完成です！

緑色のチェックマーク

まとめ
findViewById メソッド
id からビューを見つけて返すメソッド
オブジェクトを作成
イベントリスナ
タップや入力といったユーザの操作を検知
OnClickListener: ボタンのタップ（クリック）を検知
回転アニメーション
animate(): アニメーション開始
rotation(): 回転させる。回転角度を Float 型で指定。
setDuration(): アニメーションの継続時間。 Long 型で指定。
withEndAction(): アニメーション終了時に実行するコード
画像の変更
オブジェクト名.setImageResource(R.drawable.画像名)
文字列の変更
getText(R.string.名前)
メソッドチェーン
メソッドを . で繋げて１行で書くこと

今回書いたコード
package com.example.omikuji

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val img: ImageView = findViewById(R.id.img)
        val btn: Button = findViewById(R.id.btn)

        btn.setOnClickListener {
            val score = generateRandomNumber()
            img.setImageResource(R.drawable.omikuji)
            btn.visibility = View.INVISIBLE

            img.animate().rotation(180f).setDuration(2000L).withEndAction {
                img.setImageResource(getResult(score))
                img.rotation = 0f
                btn.visibility = View.VISIBLE
            }

            btn.text = getText(R.string.btn_text_again)
        }
    }

    private fun getResult(score: Int) = when (score) {
        in 91..100 -> R.drawable.daikichi
        in 71..90 -> R.drawable.chukichi
        in 51..70 -> R.drawable.shoukichi
        in 31..50 -> R.drawable.kichi
        in 11..30 -> R.drawable.kyou
        else -> R.drawable.daikyo
    }

    private fun generateRandomNumber() = (0..100).random()
}
