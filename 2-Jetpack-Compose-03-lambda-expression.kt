// 文字列を代入
val message = "こんにちは"

// 関数を代入
val sayHello = { println("こんにちは") }

fun main() {
    val sayHello = { println("こんにちは") }
    sayHello()
}

fun main() {
    val generateRandomNumber: (Int, Int) -> Int = { min, max ->
    	(min, max)..random()
    }
    println(generateRandomNumbr(0, 100))
}

fun printMessage(message: String, action: () -> Unit) {
    println(massage)
    action() // 渡された関数を実行
}


fun main() {
    // printMessage("こんにちは", { print("山田さん") })
    printMessage("こんにちは") {
        print("山田さん")
    }
}

fun printMessage(message: String, action: () -> Unit) {
    println(massage)
    action() // 渡された関数を実行
}
