package day1

import java.io.File
import java.util.Dictionary


fun main() {
    //part1()
    part2()
}

fun part1() {
    var total = 0;
    File("${System.getProperty("user.dir")}/src/main/resources/day1/input.txt").forEachLine { str ->
        val trimmed = str.trim { it.isLetter() }
        total += Integer.parseInt("${trimmed[0]}${trimmed[trimmed.length - 1]}")
    }
    println(total)
}

fun part2() {
    var total = 0;

    val wordToIntDict = hashMapOf<String, Int>(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    File("${System.getProperty("user.dir")}/src/main/resources/day1/input.txt").forEachLine { str ->
        val firstCapture = Regex("\\d|one|two|three|four|five|six|seven|eight|nine").find(str)

        val lastCapture = Regex("(?:.*)(\\d|one|two|three|four|five|six|seven|eight|nine)(?:.*?)\$").find(str)
        val firstDigit = if (firstCapture!!.value.length == 1) Integer.parseInt(firstCapture.value) else wordToIntDict[firstCapture.value]!!
        val lastDigit = if (lastCapture!!.groupValues.last().length == 1) Integer.parseInt(lastCapture.groupValues.last()) else wordToIntDict[lastCapture.groupValues.last()]!!
        total +=  firstDigit * 10 + lastDigit
    }
    println(total)
}


