ボタンのクリックイベント
今回はボタンのクリックイベントです。

コードはシンプルですが Jetpack Compose 特有のルールが出てきます。

まずはボタンのテキストと画像を切り替えるところからはじめましょう。


もくじ
ボタンのテキストを変えてみよう
変数を使うと？
再コンポーズに注意
state と remember の使い方
コードを書いてみよう
コードの流れ
Interactive Mode（インテラクティブ モード）
復習問題（画像の変更）
画像をランダムに表示しよう
getResult 関数の追加
getResult 関数の呼び出し
動作確認
まとめ
今回書いたコード

ボタンのテキストを変えてみよう
まずは [占う] ボタンをタップしたら、ボタンのテキストを [もう一度] に変更するコードを書いてみましょう。

XML を使った従来のアプリ開発では「ボタンをタップしたらテキストを変える」という文字通りのコードを書くことができました。

btn.setOnClickListener {
    btn.text = getText(R.string.btn_text_again)
}


一方 Jetpack Compose では、ボタンが押されたときの処理を書く onClick = {} とボタンに表示するテキスト Text() を分けて書いています。

onClick = {} 部分に Text コンポーザブルを置くことはできないので、Text() 内の R.string.btn_text を変更する必要があります。

onClickパラメータ
変数を使うと？
ボタンの文字列 R.string.btn_text を変数にしておくという方法を思いつくかもしれません。

実際にコードを書いてみましょう。

@Composable
fun AppScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var btnTextId = R.string.btn_text

        // 省略

        Button(
            onClick = {
                btnTextId = R.string.btn_text_again
            }
        ) {
            Text(text = stringResource(btnTextId))
        }
    }
}


最初は変数 btnTextId の値を 占う にしておいて、ボタンがタップされたら onClick = {} で もう一度 に変更するというコードを書いています。

この変数 btnTextId を使って Text() に文字列をセットしておけば、ボタンのテキストを切り替えることができそうです。


エミュレータでアプリを実行してみましょう。

ボタンをタップしても何も変化が起きません。

ボタンをタップ

再コンポーズに注意
通常の関数との大きな違いとして 「コンポーザブル関数は変更が起きると自動的に再実行される」 という特徴があります。

ボタンをタップしたときに変数 btnTextId の値が変わるという変更が起きたので AppScreen コンポーザブル関数が再実行されます。

再実行されると、変数 btnTextId の値も R.string.btn_text に戻ってしまうので、ボタンの文字列は変更されずに [占う] のままになってしまったという仕組みです。

コンポーザブル関数の仕組み

このようにコンポーズ関数が再実行されることを再コンポーズと言います。

再コンポーズされても値が変わらないようにするには、変数の書き方を少しアレンジする必要があります。


state と remember の使い方
再コンポーズに影響されない値を保持するために state と remember という仕組みが用意されています。


state は「状態」という意味で、画面の見た目（UI）の状態を管理します。

Jetpack Compose では、state によって UI を変更するかどうかが決まります。「state が変わる → UI　が更新される」 という仕組みです。


しかし state だけで値を保持しようとすると、再コンポーズのたびに値がリセットされてしまいます。

再コンポーズされても state の値が初期化されないように、値を覚えておくのが remember です。


state と remember を一緒に使うことで、一度設定した値が再コンポーズ後も保持されるようになります。

現時点ではイメージしにくいかもしれませんが 「state と remember はセットで使う」 と覚えておきましょう。


state: 「状態」という意味。
remember: 「覚えておく、思い出す」という意味。


コードを書いてみよう
実際にコードを書いてみましょう。

45 行目あたりに書いた変数 btnTextId の = 以降のコードを変更します。

by remember と入力すると候補が出てくるので remember{} を選択して Enter キーを押します。

remember{}を選択
{} の中に mutable と入力すると、保持する値の型ごとに関数が用意されていることがわかります。

ボタンのテキスト R.string.btn_text は Int 型なので、mutableIntStateOf を選択して Enter キーを押します。

mutableIntStateOfを選択
mutableIntStateOf() の中に初期値を書いて完了です。

@Composable
fun AppScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var btnTextId by remember { mutableIntStateOf(R.string.btn_text) }

        Text(
            text = stringResource(R.string.title),



エラーが出てしまったら
import 文が追加されているか確認してみましょう。

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember



コードの流れ
ボタンに表示する文字列 btnText を state（状態） として持っておいて、その state（状態） を使ってボタンに文字列をセットするという仕組みです。

一緒に remember を使うことで、btnText を変更して再コンポーズが起こっても、初期化されずに値を維持することが できます。

remember と state

by remember とは？
by というキーワードを使った書き方をプロパティ委譲と言います

現時点では難易度が高いので説明は省略しますが、名前のとおり「プロパティの振る舞いを他のオブジェクトに委ねる、任せる」という仕組みです。

変数 btnTextId の管理を remember に任せることで、再コンポーズに影響されない変数を用意することができます。



Interactive Mode（インテラクティブ モード）
先ほどはエミュレータでボタンの動作を確認しましたが、Jetpack Compose のプレビューには、エミュレータを起動しないで操作できる機能が用意されています。

とても便利な機能なので使い方を覚えておきましょう。


プレビュー画面の右上にあるボタンをクリックして、[Start Interactive Mode] をクリックします。

Start Interactive Modeをクリック
[占う] ボタンをタップして、テキストが [もう一度] に変われば成功です！

ボタンをタップ
確認が終わったら [Stop Interactive Mode] をクリックして、通常のプレビューに戻しておきましょう。

Stop Interactive Modeをクリック
Interactive: 「相互の、双方向の」という意味。


復習問題（画像の変更）
ここまでの復習として、ボタンをタップしたら画像を変更するコードを書いてみましょう。

ボタンのテキストを変更するコードとほとんど同じなので、答えをみる前にぜひ挑戦してみてください！

【手順】

再コンポーズされない変数 imgId を用意、型は Int、初期値は R.drawable.omikuji
変数 imgId を使って画像をセット
ボタンをタップしたら、画像を R.drawable.daikichi に変更

答えを隠す
コードを追加・変更するのは３箇所です。

画像の ID R.drawable.omikuji も Int 型なので mutableIntStateOf() を使用します。

@Composable
fun AppScreen() {
    Column(
        // 省略
    ) {
        var btnTextId by remember { mutableIntStateOf(R.string.btn_text) }
        var imgId by remember { mutableIntStateOf(R.drawable.omikuji) }

        // 省略

        Image(
            painter = painterResource(imgId),
            contentDescription = stringResource(R.string.img_desc),
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = {
                btnTextId = R.string.btn_text_again
                imgId = R.drawable.daikichi
           }
        ) {
            Text(text = stringResource(btnTextId))
        }
    }
}


プレビューの Interactive Mode を使って確認してみましょう。

画像が切り替わる

画像をランダムに表示しよう
最後に、おみくじの結果画像がランダムなるようにしましょう。

XML を使った従来のアプリ開発では「ランダムな数値を score を用意して、getResult 関数 で画像を取得する」という２ステップでコードを書きました。

// 乱数を生成
val score = generateRandomNumber()

// 画像を取得して表示
img.setImageResource(getResult(score))


今回も getResult 関数を使いますが、同じように２ステップに分けてコードを書くと imgId に加えて score も remember で保持しなくてはなりません。

一時的にしか使わない score も保持しておくのは無駄なので、getResult 関数でランダムな数値も生成します。


getResult 関数の追加
AppScreen コンポーザブル関数の下に getResult 関数を追加します。

 @Composable
 fun AppScreen() {
     // 省略
 }

 private fun getResult() = when ((0..100).random()) {
     in 91..100 -> R.drawable.daikichi
     in 71..90 -> R.drawable.chukichi
     in 51..70 -> R.drawable.shoukichi
     in 31..50 -> R.drawable.kichi
     in 11..30 -> R.drawable.kyou
     else -> R.drawable.daikyo
 }

 @Preview(showBackground = true)
 @Composable
 fun AppScreenPreview() {
     OmikujiComposeTheme {
         AppScreen()
     }
 }


通常の関数なので @Composable をつけないことがポイントです。

また以前はパラメータ score: Int を使っていましたが、when ((0..100).random()) で直接ランダムな数値を生成してます。

// 修正前
private fun getResult(score: Int) = when (score) {

// 修正後
private fun getResult() = when ((0..100).random()) {


getResult 関数の呼び出し
70行目あたり imgId のコードを変更します。

        Button(
            onClick = {
                btnTextId = R.string.btn_text_again
                imgId = getResult()
            }
        ) {
            Text(text = stringResource(btnTextId))
        }


getResult 関数 を呼び出して画像を取得しています。

引数なしの関数なので getResult() と書くだけです。


動作確認
Interactive Mode を使って動作確認してみましょう。

ボタンを押すたびに画像が切り替われば成功です！

画像が切り替わる

まとめ
再コンポーズに注意
コンポーザブル関数は変更が起きると自動的に再実行される
再コンポーズを防ぐには？
state → 値の保持、変更の有無をチェック
remember → 再コンポーズで値の変更を防ぐ
例）var btnTextId by remember { mutableIntStateOf(R.string.btn_text) }
Interactive Mode
エミュレータを使わずに動作確認ができる

今回書いたコード
package com.example.omikujicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.omikujicompose.ui.theme.OmikujiComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OmikujiComposeTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var btnTextId by remember { mutableIntStateOf(R.string.btn_text) }
        var imgId by remember { mutableIntStateOf(R.drawable.omikuji) }

        Text(
            text = stringResource(R.string.title),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(60.dp))

        Image(
            painter = painterResource(imgId),
            contentDescription = stringResource(R.string.img_desc),
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = {
                btnTextId = R.string.btn_text_again
                imgId = getResult()
            }
        ) {
            Text(text = stringResource(btnTextId))
        }
    }
}

private fun getResult() = when ((0..100).random()) {
    in 91..100 -> R.drawable.daikichi
    in 71..90 -> R.drawable.chukichi
    in 51..70 -> R.drawable.shoukichi
    in 31..50 -> R.drawable.kichi
    in 11..30 -> R.drawable.kyou
    else -> R.drawable.daikyo
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview() {
    OmikujiComposeTheme {
        AppScreen()
    }
}
