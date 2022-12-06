package net.phedny.infiaoc2022

interface OutputSet {
    val clear: String
    val footprint: String
    val santa: String
}

object AsciiOutputSet : OutputSet {
    override val clear: String
        get() = " "
    override val footprint: String
        get() = "#"
    override val santa: String
        get() = "%"
}

object UnicodeOutputSet : OutputSet {
    override val clear: String
        get() = "\u3000"
    override val footprint: String
        get() = "\uD83D\uDC63"
    override val santa: String
        get() = "\uD83C\uDF85"
}
