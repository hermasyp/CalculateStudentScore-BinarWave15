package utils

object ScoreValidationUtils {
    fun checkIfStudentPassed(score: Double): String {
        return if (score > 75) {
            "PASSED"
        } else {
            "FAILED"
        }
    }

    fun checkScoreIsValid(score: Double): Boolean {
        return score in 0.0..100.0
    }
}