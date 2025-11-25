アプリ画面を作成しよう
今回から２回に分けておみくじアプリの画面を作っていきます。

まずは「テキスト・画像・ボタン」といった UI コンポーザブル関数と、UI の配置を決めるレイアウトコンポーザブル関数を使ってみましょう。


もくじ
コンポーザブル関数を用意しよう
コードの削除
メインのコンポーザブル関数
プレビューを表示する関数
アプリ画面を作成しよう
テキストの追加　
プレビューの表示
画像の追加
UI を縦に並べる　
レイアウトコンポーザブルの種類
Column の追加
ボタンの追加
まとめ
今回書いたコード

コンポーザブル関数を用意しよう
Greeting 関数 と GreetingPreview 関数はプロジェクトを作成すると必ず追加されますが、ほとんど使用することはありません。

まずは不要なコードを削除して、おみくじアプリ用のコンポーザブル関数を作成しましょう。


コードの削除
33〜47行目の Greeting 関数と GreetingPreview 関数 のコードを削除します。

コードを削除
21行目あたりから始まる OmikujiComposeTheme 関数 の {} 内にあるコードを削除します。

コードを削除
以下のような状態から始めていきましょう。

開始コード
開始コードが同じにならないときは？
不要なコードを削除したので、必要なくなった import 文がグレーになって残っているかもしれません。

手動でコードを削除するか、または、自動 import 設定で Optimize imports on the fly にチェックを入れてください。

コードがグレーになっている

メインのコンポーザブル関数
まずメインとなるコンポーザブル関数を作成しましょう。

21 行目あたりに comp と入力すると候補が出てくるので Enter キーを押します。

compを選択
コンポーザブル関数の雛形が追加されたら、以下のようにコードを変更します。

@Composable
fun AppScreen() {

}


アプリ画面が複雑になってくると、パーツごとにコンポーザブル関数を作成したり、ファイルを分けたりといった工夫が必要になりますが、おみくじアプリのようにシンプルな画面の場合はメインの関数が１つあれば開発できます。

ここでは AppScreen という名前にしましたが MainScreen, GameScreen, SettingScreen のように 名前+Screen という書き方が便利です。


プレビューを表示する関数
次は画面右側にプレビューを表示するための関数です。

プレビュー関数は作成しなくても良いですが、エミュレータを起動せずにアプリ画面を確認できるので用意しておくと便利です。


プレビュー関数の名前は「プレビューを表示したい関数名のうしろに Preview を付ける」のが一般的です。

ここでは AppScreen 関数のプレビューを表示するので、AppScreenPreview という名前にします。


AppScreen 関数の下にコードを追加します。

 @Composable
 fun AppScreen() {

 }

 @Preview
 @Composable
 fun AppScreenPreview() {

 }


@Preview アノテーションを付けるのがポイントです。

その他のコードはアプリ画面を作りながら追加していきましょう。


アプリ画面を作成しよう
ここからはアプリ画面を作っていきましょう。

Jetpack Compose では import 文がたくさん追加されますが、似ているけど異なる import 文が追加されてしまうことがあります。

コードを書いている途中に赤い波線が付いてしまう場合は、正しい import 文が追加されているかを確認してみましょう。

作成するアプリ画面

テキストの追加　
まずは「今日の運勢を占いましょう」というテキストを表示します。

AppScreen 関数内に Text と入力すると、いくつか候補が出てきます。

Textの入力候補
このように、同じ名前でパラメータが異なる関数が用意されていることがよくあって、どれを選ぶかで追加される import 文が変わってしまうことがあります。

ここではパラメータが text: String, ... の関数を選んで Enter キーを押します。

Text(text: String, ...)を選択
Text コンポーザブル が追加されましたが、赤い波線がついています。

赤い波線がつく
Text 部分にカーソルを合わせて、コードを確認してみましょう。

text パラメータには初期値が書いていないので、Text() を呼び出すときに必ず書かなくてはなりません。

title パラメータ
プロジェクト作成時に strings.xml に用意したテキストを設定しましょう。

@Composable
fun AppScreen() {
    Text(text = stringResource(R.string.title))
}


パラメータ名 text = は省略できますが、コンポーザブル関数に慣れるまでは明記しておきましょう。

Text コンポーザブルを使うために追加された import 文は２つです。

import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource


プレビューの表示
テキストの表示をプレビューで確認してみましょう。

プレビューを表示するには AppScreenPreview 関数 から AppScreen 関数 を呼ぶ必要があります。

@Preview
@Composable
fun AppScreenPreview() {
    OmikujiComposeTheme {
        AppScreen()
    }
}


テーマを反映させるために OmikujiComposeTheme {} で囲んでいます。

プロジェクトを用意しようで少し紹介しましたが OmikujiComposeTheme 関数 は Theme.kt に用意されている関数です。


プレビュー画面が開いてない場合は、画面右上に並んでいる３つのボタンの真ん中 [Split] をクリックします。

[Out of Date] と表示されていたら [更新アイコン] をクリックしてください。

Out of Date: 「期限切れ」という意味。

プレビュー画面を開く
プレビューが表示されましたが、文字が読みにくい状態になっています。

プレビュー画面
プレビューに背景をつける設定を追加しましょう。

 @Preview(showBackground = true)
 @Composable
 fun AppScreenPreview() {
     OmikujiComposeTheme {
         AppScreen()
     }
 }


背景色が付いて文字が読みやすくなりましたね。

ここでは、背景の表示を設定する showBackground パラメータの値を true にしています。

設定に関する値には Boolean 型の true と false を使うことが多く

true → オン、有効にする
false → オフ、無効にする
という意味になるのが一般的です。


右下のボタンから表示サイズも変更できます。

プレビュー画面
@Preview に書けること
showBackground 以外にも name（名前）、backgroundColor（背景色）、widthDp（幅）、heightDp（高さ）などを設定できます。

@Preview(showBackground = true, backgroundColor = 0xFF03DAC5, name = "おみくじ画面", widthDp = 100)
@Composable
fun AppScreenPreview() {


プレビュー画面

画像の追加
次は Image コンポーザブルを使って画像を表示しましょう。

Text コンポーザブルの下に Image と入力すると、また複数の候補が出てきます。

Imageの入力候補
ここではパラメータが painter: Painter, ... の関数を選んで Enter キーを押します（その他の関数については使用時に紹介します）。

Image(painter: Painter, ...)を選択
Image コンポーザブルの必須パラメータは painter と contentDescription の２つです。

@Composable
fun AppScreen() {
    Text(text = stringResource(R.string.title))

    Image(
        painter = painterResource(R.drawable.omikuji),
        contentDescription = stringResource(R.string.img_desc)
    )
}


painter では、drawable フォルダにある omikuji.png ファイルを指定しています。

contentDescription は画像の説明文です。XMLを使ったアプリ画面の作成でも同じ名前の属性を使っていましたね。


Image コンポーザブルを使うために追加された import 文は２つです。

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource


UI を縦に並べる　
プレビューを確認すると Text と Image が重なって表示されています。

XML と同じようにレイアウトを使って、縦方向に並ぶように設定しましょう。

テキストと画像が重なっている
レイアウトコンポーザブルの種類
XML では LinearLayout を使って UI を縦方向に並べました。

コンポーザブルでは、①UI を重ねる Box, ②縦方向に並べる Column, ③横方向に並べる Row の３種類を使います。


レイアウトコンポーザブル
column:列
row: 行
テーブル（表）やデータベースを扱うときにも使う英単語なので覚えておきましょう。


Column の追加
おみくじアプリでは UI を縦に並べるので、Column で Text() と Image() を囲みます。

コードを直接書かなくてもレイアウトを適用する機能があるので、これを使ってみましょう。


Text() と Image() のコードを選択して、[黄色い豆電球マーク] → [Surround with widget] をクリックします。

コードの選択
[Surround with Column] をクリックします。

[Surround with Column] を選択
Surround: 「〜を囲む」という意味。


Text() と Image() が Column{} で囲まれて、縦並びになりました。

アプリのデザインによっては Column の中に Column を置いたり、Row の中に Column を置いたり、レイアウトを組み合わせながらアプリ画面を作っていきます。

テキストと画像が縦に並ぶ
また Column{} という書き方になっていますが、これが前回紹介した後置ラムダ構文です。

後置ラムダ構文は 「最後の引数が関数の場合は、その関数を()の外に出すことができる」 というルールでした。

唯一書いている引数 content の値が関数なので、これを () の外に出すことができて、content = も省略できます。

後置ラムダ構文

Column コンポーザブルを使うために追加された import 文は１つです。

import androidx.compose.foundation.layout.Column


ボタンの追加
最後の UI 要素であるボタンを追加しましょう。

Image() の下にコードを追加します。

Button と入力して Button(onClick: () -> Unit,...) を選択します。

Button(onClick: () -> Unit,...)を選択
Button() の必須パラメータは onClick と content の２つで、どちらも関数型になっています。

必須のパラメータ
後置ラムダ構文で () の外に出せるのは最後の１つだけなので、まずは最初のパラメータ onClick を () の中に書きましょう。

@Composable
fun AppScreen() {

    Column {
        Text(text = stringResource(R.string.title))

        Image(
            painter = painterResource(R.drawable.omikuji),
            contentDescription = stringResource(R.string.img_desc)
        )

        Button(
            onClick = {
                // ボタンをタップしたら実行するコード
            }
        ) { }
    }
}


次はボタンに表示するテキストですが、これはすでに使った Text() を使います。

２つ目のパラメータ content は後置ラムダ構文で書くことができるので、{} の中にコードを追加します。

@Composable
fun AppScreen() {

    Column {
        // 省略

        Button(
            onClick = {
                // ボタンをタップしたら実行するコード
            }
        ) {
            Text(text = stringResource(R.string.btn_text))
        }
    }
}


プレビュー画面に「占う」ボタンが追加できました。

プレビュー画面

Button コンポーザブルを使うために追加された import 文は１つです。

import androidx.compose.material3.Button


まとめ
基本的な UI は用意できたので、次回はスタイルを調整していきます。

UI が左揃いになっていたり、余白がなかったりという部分を修正していきましょう。


レイアウトコンポーザブル
Box: 重ねる
Column: 行
Row: 列
UI コンポーザブル
Text: テキスト
Image: 画像
Button: ボタン
Preview 関数
@Preview: アノテーションが必要
showBackground = true: 背景色をつける

今回書いたコード
package com.example.omikujicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.omikujicompose.ui.theme.OmikujiComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OmikujiComposeTheme {

            }
        }
    }
}

@Composable
fun AppScreen() {
    Column {
        Text(text = stringResource(R.string.title))

        Image(
            painter = painterResource(R.drawable.omikuji),
            contentDescription = stringResource(R.string.img_desc)
        )

        Button(
            onClick = {
                // ボタンをタップしたら実行するコード
            }
        ) {
            Text(text = stringResource(R.string.btn_text))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview() {
    OmikujiComposeTheme {
        AppScreen()
    }
}
