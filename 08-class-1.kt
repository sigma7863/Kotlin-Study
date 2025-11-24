package com.example.kotlinproject

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

open class Robot(val name: String, val version: Int) {
    var distance = 0
    
    init {
        info()
    }
    
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

    val robot2 = Robot("ベータ", 1)
    robot2.walk()
    robot2.stop()
    
    val cleaningRobot = CleaningRobot("お掃除ロボ", 1)
    // cleaningRobot.walk()
    // cleaningRobot.stop()
    cleaningRobot.sweep()
    cleaningRobot.polish()
    cleaningRobot.stop()
}
