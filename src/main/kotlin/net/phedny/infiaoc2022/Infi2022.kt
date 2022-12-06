package net.phedny.infiaoc2022

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val outputSet: OutputSet = when (args.toList()) {
        listOf("--ascii"), listOf("-a"), emptyList<String>() -> AsciiOutputSet
        listOf("--unicode"), listOf("-u") -> UnicodeOutputSet
        else -> printUsage()
    }

    val santa = Commands.readInput()
        .fold(SantaState(0, 0, 1, 0, emptySet())) { state, command -> command.apply(state) }

    println("Deel 1.")
    println("Manhattan afstand is: ${santa.manhattanDistance}")
    println()

    println("Deel 2.")
    (santa.steps.maxOf(Pair<Int, Int>::first) downTo 0).forEach { row ->
        (0 .. santa.steps.maxOf(Pair<Int, Int>::second)).forEach { col ->
            when {
                row == santa.x && col == santa.y -> outputSet.santa
                santa.steps.contains(Pair(row, col)) -> outputSet.footprint
                else -> outputSet.clear
            }.also(::print)
        }
        println()
    }
}

fun printUsage(): Nothing {
    println("Start de applicatie met een van de volgende argumenten:")
    println("-a / --ascii voor een resultaat die op elke terminal werkt")
    println("-u / --unicode voor een mooier resultaat dat werkt op sommige terminals")
    exitProcess(1)
}
