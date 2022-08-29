package utils

object IOUtils {
    fun readInt(default: Int = 0): Int {
        return try {
            readLine()?.toInt() ?: default
        } catch (e: NumberFormatException) {
            default
        }
    }
    fun readDouble(default: Double = 0.0): Double {
        return try {
            readLine()?.toDouble() ?: default
        } catch (e: NumberFormatException) {
            default
        }
    }
}