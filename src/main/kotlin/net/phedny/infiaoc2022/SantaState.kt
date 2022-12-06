package net.phedny.infiaoc2022

import kotlin.math.absoluteValue

data class SantaState(val x: Int, val y: Int, val dx: Int, val dy: Int, val steps: Set<Pair<Int, Int>>) {
    val manhattanDistance: Int
        get() = x.absoluteValue + y.absoluteValue
}
