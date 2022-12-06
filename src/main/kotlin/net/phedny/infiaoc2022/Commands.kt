package net.phedny.infiaoc2022

interface Command {
    fun apply(santa: SantaState): SantaState
}

object Commands {
    private fun parse(line: CharSequence): Command? =
        "(\\w+) (-?\\d+)".toRegex()
            .matchEntire(line)
            ?.groupValues
            ?.let { (_, command, argument) ->
                when (command) {
                    "draai" -> TurnCommand(argument.toInt())
                    "loop" -> WalkCommand(argument.toInt())
                    "spring" -> JumpCommand(argument.toInt())
                    else -> null
                }
            }

    fun readInput(): List<Command> =
        this.javaClass.getResource("instructions.txt")!!
            .readText()
            .split(System.lineSeparator())
            .mapNotNull(::parse)
}

data class TurnCommand(val degrees: Int) : Command {
    private fun turnOnce(santa: SantaState): SantaState =
        when {
            santa.dx == santa.dy -> santa.copy(dx = 0)
            santa.dx == -santa.dy -> santa.copy(dy = 0)
            santa.dx == 0 -> santa.copy(dx = -santa.dy)
            santa.dy == 0 -> santa.copy (dy = santa.dx)
            else -> throw IllegalStateException("invalid dx,dy")
        }

    override fun apply(santa: SantaState): SantaState =
        (0 until (degrees / 45 + 8) % 8).fold(santa) { state, _ -> turnOnce(state) }
}

data class WalkCommand(val distance: Int) : Command {
    override fun apply(santa: SantaState): SantaState =
        (0 until distance).fold(santa.copy(
            x = santa.x + distance * santa.dx,
            y = santa.y + distance * santa.dy
        )) { state, i ->
            state.copy(steps = state.steps + Pair(santa.x + i * santa.dx, santa.y + i * santa.dy))
        }
}

data class JumpCommand(val distance: Int) : Command {
    override fun apply(santa: SantaState): SantaState =
        santa.copy(
            x = santa.x + distance * santa.dx,
            y = santa.y + distance * santa.dy,
            steps = santa.steps + Pair(santa.x, santa.y)
        )
}
