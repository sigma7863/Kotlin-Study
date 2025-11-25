スタイルを調整しよう
基本的な UI を作成できたので、今回はスタイルの調整をします。

「サイズ・余白・揃え方」といった基本的な設定を学んでいきましょう。


スタイル調整前後

もくじ
スタイルの調整
画面サイズの設定
Modifier とは？
画面中央に表示
上下中央に移動
左右中央に移動
文字サイズの変更
画像のサイズ
余白の追加
エミュレータで実行
まとめ
今回書いたコード

スタイルの調整
画面サイズの設定
まずは画面サイズの調整です。

現在は「テキスト・画像・ボタン」にピッタリ合わせたサイズとなっているので、スマートフォンのサイズに設定します。

31行目あたりの Column にパラメータを追加します。

@Composable
fun AppScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
       Text(text = stringResource(R.string.title))

       Image(
           painter = painterResource(R.drawable.omikuji),


スマートフォン画面のサイズに変わりました。

fillMaxSizeを設定

Modifier とは？
Modifier はコンポーザブルの装飾や動作を設定するものです。

サイズ・枠線・余白といった見た目の設定から、クリックやドラッグなどの動作まで、幅広い設定項目が用意されています。

fillMaxSize() もよく使う設定の１つで、これによって最大限にサイズを広げることができます。


Modifiler.設定項目() のように書く決まりになっていて、Modifiler.設定1().設定2().設定3() のように繋げて書くこともあります。

その他の設定方法はアプリを開発しながら学んでいきましょう。

Modifier: 「修飾子」という意味。


画面中央に表示
UI が左上に配置されているので、画面中央に移動させましょう。

Column にカーソルを合わせてコードを確認すると、verticalArrangement と horizontalAlignment というパラメータが用意されていることがわかります。

このパラメータを使って配置を設定してみましょう。

verticalArrangementとhorizontalAlignment
上下中央に移動
まずは上下の配置を決める verticalArrangement パラメータを使います。

複数のパラメータ（引数）を書くので、fillMaxSize() の後ろに , を忘れずに付けましょう。

@Composable
fun AppScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(R.string.title))


UI が上下中央に移動しました。

ここでは Arrangement.Center で中央に配置しましたが、他にも Arrangement.Top（上）や Arrangement.Bottom（下）などの設定があります。

verticalArrangement
Vertical: 垂直の
Arrangement: 配置


左右中央に移動
次は左右中央に移動する設定です。

同じように horizontalAlignment パラメータを使いましょう。

@Composable
fun AppScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.title))


Alignment.CenterHorizontally は水平方向中央の設定ですが、他にも Alignment.Start（左）や Alignment.End（右）という設定もあります。

horizontalAlignment
Horizontal: 水平の
Alignment: 並び、整列


文字サイズの変更
次はテキストの文字サイズを大きくします。

40 行目あたりの Text にカーソルを合わせてコードを確認すると、fontSize パラメータがあるのでこれを使いましょう。

fontSizeパラメータ
41 行目あたりのコードを追加・変更します。

@Composable
fun AppScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.title),
            fontSize = 20.sp
        )

        Image(


文字サイズの単位は XML と同じように sp ですが、.sp のように . を忘れずに書きましょう。


.sp がエラーになってしまったら
.sp の部分に赤い波線が付いてしまうのは import 文が追加されていないことが原因です。

解決策①
.sp を消してから、もう一度 .sp と入力してみましょう。

解決策②
import 文を手動で追加しましょう。

.sp 部分にカーソルを合わせると、以下のようなメッセージが表示されるので、Windows の方は Alt と Enter キーを、Mac の方はoption と return キーを押します。

import を手動で追加
以下の import 文が追加されてエラーが消えます。

import androidx.compose.ui.unit.sp


画像のサイズ
次は画像サイズを変更します。

サイズや色を変更したいときは、まずコンポーザブル関数のパラメータを確認してみましょう。

Image にはサイズに関するパラメータがありません。この場合はコンポーザブルの装飾や動作を設定する Modifier を使います。

Imageコンポーザブル関数
contentDescription の後ろに , を追加して、modifer パラメータを追加します。

        Image(
            painter = painterResource(R.drawable.omikuji),
            contentDescription = stringResource(R.string.img_desc),
            modifier = Modifier.size(300.dp)
        )


size(size: Dp)を選択

違いが分かりにくいですが、サイズを変更できました。

.dp に赤い波線でエラーがつく場合は import 文が追加されていないことが原因なので、sp のエラーと同じ手順で解決しましょう。

追加される import 文 は１つです。

import androidx.compose.ui.unit.dp


余白の追加
次は画像の上下に余白（スペース）を追加します。

Text() と Image() の間（48 行目あたり）に Spacer と入力します。今回は候補が１つしかないので、そのまま Enter キーを押します。

Spacerを入力
Spacer コンポーザブルには modifier パラメータしかないので、これを使っていきましょう。

Spacerコンポーザブル
ここでは縦方向に余白を入れたいので、高さ height を設定します（横に余白を入れたいときは width を使います）。

       Spacer(modifier = Modifier.height(60.dp))


余白が追加されました。

スペースの追加

画像の下にも同じコードを追加します。

        Image(
            painter = painterResource(R.drawable.omikuji),
            contentDescription = stringResource(R.string.img_desc),
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = {


画像の下にも余白が入りました。

これでレイアウトは完成です！

スペースの追加

エミュレータで実行
ここまではプレビュー画面での確認だけだったので、エミュレータでも確認してみましょう。

しかし現時点でアプリを実行しても真っ白な画面が表示されるだけです。

エミュレータで実行
エミュレータで確認するには MainActivity クラスの onCreate メソッドから AppScreen コンポーザブル関数を呼び出す必要があります。

32 行目あたりにコードを追加します。

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


アプリを実行してみましょう。

ボタンをタップしても何も起きませんが、以下のような画面になっていれば成功です！

エミュレータで実行

まとめ
Modifier
コンポーザブルの装飾や動作を設定する
Modifiler.設定項目() と書く
fillMaxSize: 最大限にサイズを広げる
配置の設定
verticalArrangement: 垂直方向
Arrangement.Center: 中央
Arrangement.Top: 上
Arrangement.Bottom: 下
horizontalAlignment: 水平方向
Alignment.CenterHorizontally: 中央
Alignment.Start: 左
Alignment.End: 右
文字サイズ
fontSize パラメータ
単位は .sp
例）fontSize = 20.sp
画像サイズ
Modifier.size()
単位は .dp
例）Modifier.size(300.dp)
余白
Spacer()
縦方向: Modifier.height(60.dp)
横方向: Modifier.width(60.dp)

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
        Text(
            text = stringResource(R.string.title),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(60.dp))

        Image(
            painter = painterResource(R.drawable.omikuji),
            contentDescription = stringResource(R.string.img_desc),
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.height(60.dp))

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
