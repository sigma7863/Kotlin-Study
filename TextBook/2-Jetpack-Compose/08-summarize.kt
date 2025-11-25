まとめ

完成おめでとう！
おめでとうございます！

Jetpack Compose を使ったはじめてのアプリが完成しました！


XML ファイルを使った従来の開発方法とは違って、Jetpack Compose はとてもスッキリとしたコードを書くことができましたね。

また Jetpack Compose には、動作確認もできるプレビュー機能があるので、開発スピードが速くなることがメリットです。


簡単にコードを書ける一方で、何をしているのか分かりにくいこともあります。

例えば、画像の回転アニメーションは、従来の開発方法のほうが簡潔で直感的に理解できるかもしれません。

img.animate().rotation(180f).setDuration(2000L).withEndAction {
    img.setImageResource(getResult(score))
    img.rotation = 0f
    btn.visibility = View.VISIBLE
}


一方 Jepack Compose では、倍以上のコードが必要でした。

val animatedRotation by animateFloatAsState(
    targetValue = imgRotation,
    animationSpec = tween(durationMillis = if (imgRotation == 180f) 2000 else 0)
)

LaunchedEffect(imgRotation) {
    if (imgRotation == 180f) {
        delay(1800)
        imgId = getResult()
        imgRotation = 0f
    }
}

Image(
    painter = painterResource(imgId),
    contentDescription = "画像",
    modifier = Modifier.size(300.dp).rotate(animatedRotation)
)


これを比較すると従来の方法が良さそうですが、Jetpack Compose は imgRotation の値を変えるだけで UI を更新できます。

従来の方法は「画像を回転させろ！」という命令によって動いていて、Jetpack Compose は「回転角度が変わったから、画像を回転させよう！」という状態に合わせて自ら動くというイメージです。

Jetpack Compose は

UI（見た目）と状態が連動する → ズレる余地がなくなる → エラーが減る

というメリットがあります。

現時点では Jetpack Compose の効果を実感するのは難しいですが、大規模なアプリになると「エラーが減る、メンテナンスが楽、再利用できる」というメリットを感じることができるはずです。


現時点で押さえておきたい、Jetpack Compose の一番のポイントは 「状態の保持」 です。

変数の値を保持するには by remember { mutableStateOf() } を使うことを覚えておきましょう。


ここからは Jetpack Compose を使って進めていきます。

まだまだ沢山の機能が用意されているので、色々なアプリを開発しながら慣れていきましょう！


完成コード
画像のダウンロード
おみくじ画像: https://github.com/progedu/android-omikuji/tree/images
アイコン画像: https://github.com/progedu/android-omikuji/blob/main/icon.png

strings.xml
<resources>
    <string name="app_name">Omikuji Compose</string>
    <string name="title">今日の運勢を占いましょう</string>
    <string name="img_desc">おみくじの結果</string>
    <string name="btn_text">占う</string>
    <string name="btn_text_again">もう一度</string>
</resources>
Copy

MainActivity.kt
package com.example.omikujicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.omikujicompose.ui.theme.OmikujiComposeTheme
import kotlinx.coroutines.delay

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
        var imgRotation by remember { mutableFloatStateOf(0f) }

        val animatedRotation by animateFloatAsState(
            targetValue = imgRotation,
            animationSpec = tween(durationMillis = if (imgRotation == 180f) 2000 else 0)
        )

        LaunchedEffect(imgRotation) {
            if (imgRotation == 180f) {
                delay(1800)
                imgId = getResult()
                imgRotation = 0f
            }
        }

        Text(
            text = stringResource(R.string.title),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(60.dp))

        Image(
            painter = painterResource(imgId),
            contentDescription = stringResource(R.string.img_desc),
            modifier = Modifier.size(300.dp).rotate(animatedRotation)
        )

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = {
                btnTextId = R.string.btn_text_again
                imgId = R.drawable.omikuji
                imgRotation = 180f
            },
            modifier = Modifier.alpha(if (imgRotation == 180f) 0f else 1f)
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
Copy
