プロジェクトを用意しよう
まずは Jetpack Compose のプロジェクトを作成していきます。

プロジェクトを用意して、デフォルトで追加される Jetpack Compose コードを確認してみましょう。


もくじ
プロジェクトを用意しよう
新しいプロジェクトの作成
画像の用意
文字列の用意
プロジェクトファイルを見てみよう
基本的なファイル
プレビュー画面の表示
MainActivity.kt のコード
① MainActivity クラス
Greeting 関数
GreetingPreview 関数
まとめ

プロジェクトを用意しよう
新しいプロジェクトの作成
まずは新しいプロジェクトを作成しましょう。

画面左上のプロジェクト名をクリックして [New Project...] を選択します。

プロジェクト名 → New Project
今回は Jetpack Compose プロジェクトなので [Empty Activity] を選択して [Next] を押します。

* Empty Views Activity ではないことに注意！

Empty Views Activity を選択
プロジェクト情報を入力します。

Name に Omikuji Compose と入力、その他の項目は変更せずに [Finish] をクリックします。

プロジェクト情報の入力
Minimum SDK について
Jetpack Compose による開発は API 21 以上にする必要があるので、それより小さいものは Minimum SDK 項目で選択できないようになっています。


画像の用意
プロジェクトが作成されたら、第２章 おみくじプロジェクトの作成 - 画像をプロジェクトに追加と同じ手順で７枚の画像を追加してください。

drawable フォルダに画像を追加できたら準備完了です。

画像の用意

文字列の用意
第２章 アプリ画面の作成 - strings.xml では、ボタンのテキストなどアプリ内で使用する文字列は strings.xml に用意していましたね。

プロジェクト構造から res → values → strings.xml を開いて、同じように文字列を用意しておきましょう。

<resources>
    <string name="app_name">Omikuji Compose</string>
    <string name="title">今日の運勢を占いましょう</string>
    <string name="img_desc">おみくじの結果</string>
    <string name="btn_text">占う</string>
    <string name="btn_text_again">もう一度</string>
</resources>


プロジェクトファイルを見てみよう
基本的なファイル
開発を始める前に Jetpack Compose プロジェクトについて簡単に紹介しておきます。

まず前章までのプロジェクトとの大きな違いは activity_main.xml が存在しないことです。

XML でコードを書いていたテキストやボタンは、すべて MainActivity.kt など Kotlin ファイルに書いていきます。


また画面左側のプロジェクト構造にある [com.example.omikujicompose] フォルダに [ui.theme] フォルダがあります。

ui.themeフォルダ
それぞれ

Color.kt → 色の用意
Theme.kt → 配色などテーマ
Type.kt → フォント
に関するファイルです。

このようなデザインに関する設定も Kotlin ファイルに書いていきます。

Type: 「書体、文字」という意味。


プレビュー画面の表示
Jetpack Compose でもプレビューを見ながらアプリ画面を作成できます。

画面右上に並んでいる３つのボタンから、真ん中の [Split] をクリックします。

Split モード
Build & Refresh をクリックします。

Build & Refresh
Hello Android! と表示されましたか？

XML のプレビューとは違って、このプレビュー画面ではボタンのクリックや簡単な操作もできます。

エミュレータを起動せずに動作を確認できるので、この機能も活用していきましょう。

プレビューの表示

MainActivity.kt のコード
次は MainActivity.kt に書いてあるコードを確認していきましょう。

大きく分けて

MainActivity クラス
Greeting コンポーザブル関数
GreetingPreview コンポーザブル関数
の３つに分かれています。


① MainActivity クラス
MainActivity.kt
16〜19行目
16〜19行目は、前章のプロジェクトとほとんど同じです。

MainActivity クラスは ComponentActivity クラスを継承していて、アプリの入り口になる onCreate メソッドが用意されています。


20行目
setContent {
    // 省略
}

setContent メソッドで、アプリ画面をセットしています。

今までメソッドを使うときは setContentView() と書いていましたが、ここでは setContent {} のように波括弧{}を使っています。

どちらもメソッドを呼び出す書き方ですが、Jetpack Compose では {} を使う書き方がほとんどです。次回以降で詳しく紹介します。


21行目
OmikujiComposeTheme {
    // 省略
}

OmikujiComposeTheme 関数は、色やフォントなどアプリのテーマを設定する関数です。

先ほど確認した ui.theme フォルダの Theme.kt に用意されています。


Theme.kt を開いてみると、OmikujiComposeTheme 関数 のコードを確認できます。

この関数名の上に @Composable と書いてあります。

Theme.kt
＠Composable のことをアノテーションといって、これが付いている関数をコンポーザブル関数と言います。

細かいルールは後ほど紹介しますが、コンポーザブル関数はテキストやボタンなど 「UI を作成する関数」 と覚えておきましょう。


アノテーションとは？
Kotlin コードを実行するには、コンピューターが読み取れる形式（バイトコード）にコードを変換する 「コンパイル」 が必要になります（参考：Kotlin 言語について）。

このコンパイル作業をしているのが 「コンパイラ」 と呼ばれるもので、アノテーションをつけることでコンパイラに追加情報を伝えることができます。

アノテーションは、クラス・変数・関数など様々なものに付けることができます。


アノテーションを付けることで、何をしているコードなのか分かりやすくなるという開発者にとってのメリットもあります。

たくさんの種類がありますが、まずは @Composable と @Preview（後述）を覚えておきましょう。


22・23行目
Scaffold や Greeting もコンポーザブル関数です。

これらについては開発をしながら学んでいきましょう。


いろいろなコンポーズ
今後 Compose, Component, Composable, Composer といった似たような言葉が出てきます。

それぞれの意味は以下にまとめていますが、現時点では 「すべて UI 作成に関すること」 という認識で問題ありません。


用語	意味
Compose（コンポーズ）	UI を作成するためのライブラリやツールの総称
Component（コンポーネント）	テキストやボタンなどの部品
Composable（コンポーザブル）	UI を作成する関数
Composer（コンポーザー）	UI の作成に関する内部の仕組み


Greeting 関数
次は34行目あたりにあるGreeting 関数です。

この関数にも @Composable アノテーション が付いているので、コンポーザブル関数であることが分かります。

Greeting関数
Greeting 関数内に書いてある Text() もコンポーザブル関数です。

受け取った値 name を使って Hello Android! という文字列を表示する関数です。


GreetingPreview 関数
43 行目あたりにあるGreetingPreview 関数もコンポーザブル関数です。

GreetingPreview関数
この関数には @Preview アノテーションもついています。

このアノテーションをつけたコンポーザブル関数は、画面右側のプレビューに表示される仕組みです。

(showBackground = true)のようにアノテーションにパラメータを付けることもできます。


試しに Greeting("Android") を Greeting("World") に変更してみましょう。

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OmikujiComposeTheme {
        Greeting("World")
    }
}


画面右側のプレビューが変更されましたか？

このように @Preview が付いた関数は、プレビュー画面に反映されます。

プレビューが更新された

まとめ
Jetpack Compose プロジェクト
プロジェクト作成時に Empty Activity を選択
activity_main.xml は存在しない
ui.theme フォルダ
Color.kt → 色の用意
Theme.kt → 配色などテーマ
Type.kt → フォント
コンポーザブル関数
UI を作成する関数
＠Composable アノテーションをつける
@Preview アノテーションはプレビュー用
