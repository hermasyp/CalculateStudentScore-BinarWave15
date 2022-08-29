import model.Student
import utils.IOUtils
import utils.ScoreValidationUtils

class App {

    private val students = mutableListOf<Student>()

    private fun printHeader() {
        println("=====================================")
        println("Siswa Score App")
        println("=====================================")
    }

    private fun inputUserData() {
        println("Masukkan Total Siswa : ")
        val totalStudent = IOUtils.readInt()
        println("=====================================")
        for (idx in 1..totalStudent) {
            println("Masukkan Siswa ke - $idx")
            val name = inputStudentName()
            val score = inputStudentScore()
            students.add(Student(name, score))
            println("--------------------------------")
        }
        println("=====================================")
    }

    private fun inputStudentName(): String {
        println("Nama Siswa : ")
        return readLine().orEmpty()
    }

    private fun inputStudentScore(): Double {
        var score = 0.0
        while (score == 0.0) {
            println("Score Siswa : ")
            val tempScore = IOUtils.readDouble()
            if (ScoreValidationUtils.checkScoreIsValid(tempScore)) {
                score = tempScore
            } else {
                println("--------------------------------")
                println("Score must between 0 .. 100")
                println("--------------------------------")
            }
        }
        return score
    }

    private fun printResult() {
        println("=====================================")
        println("Hasil Ujian Adalah : ")
        println("=====================================")
        students.forEach {
            println("Nama Siswa : ${it.name}")
            println("Score Siswa : ${it.score}")
            println("Hasil Kelulusan : ${ScoreValidationUtils.checkIfStudentPassed(it.score)}")
            println("--------------------------------")
        }
        println("=====================================")
    }

    fun run() {
        printHeader()
        inputUserData()
        printResult()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}
