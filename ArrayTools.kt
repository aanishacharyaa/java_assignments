// Name: Anish Acharya
// Student Number: A00263391
// Program: Lab 2 - Functions and Arrays

fun main() {
    println("\n")
    println("-> " + arrayAvg(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
    println("-> " + arrayContains(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 5))
    println("-> " + reverse(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)).joinToString(", "))

    var str: String
    var shiftValue: Int

    println("Enter a string to encrypt")
    while (true) {
        str = readLine()?.trim() ?: ""
        if (str.isEmpty()) {
            println("Error: Invalid string input. Please try again.")
            continue
        }
        break
    }

    println("Enter a shift value")
    while (true) {
        val input = readLine()?.trim() ?: ""
        if (input.isEmpty() || !input.matches(Regex("[0-9]+"))) {
            println("Error: Invalid shift value input. Please try again.")
            continue
        }
        shiftValue = input.toInt()
        break
    }

    println("-> " + caesarCipher(str, shiftValue))
}

// This function calculates the average of a given array of numbers
fun arrayAvg(numArray: Array<Number>): Int {

    println("Average of numbers " + numArray.joinToString(", "))

    var sum = 0 // Variable to store the sum of all numbers

    numArray.forEach { // Loop through each number in the input array
        sum += it.toInt()
    }

    val avg = sum / numArray.size // Calculate the average by dividing the sum by the number of elements in the
    // array

    return avg // Return the average
}

// This function performs a Caesar Cipher encryption on a given string using a specified shift value
fun caesarCipher(str: String, shift: Int): String {

    println("Basic encrypted string for " + str + " with shift value " + shift)

    val encrypted =
        str.map { // Variable to store the encrypted string
            val asciiValue = it.code // Get the ASCII code of the current character

            // Perform the encryption based on the ASCII code of the character
            when {
                asciiValue in '0'.code..'9'.code ->
                    (asciiValue + shift).toChar() // If the character is a digit (0-9), shift it by the specified
                // shift value
                asciiValue in 'a'.code..'z'.code ->
                    (((asciiValue - 'a'.code + shift) % 26) + 'a'.code)
                        .toChar() // If the character is a lowercase letter (a-z), shift it by the
                // specified shift value
                asciiValue in 'A'.code..'Z'.code ->
                    (((asciiValue - 'A'.code + shift) % 26) + 'A'.code)
                        .toChar() // If the character is an uppercase letter (A-Z), shift it by the
                // specified shift value
                else -> it // If the character is not a letter or a digit, keep it as is
            }
        }

    // Return the encrypted string
    return encrypted.joinToString("")
}

// This function checks if a given array of numbers contains a specified value
fun arrayContains(numArray: Array<Number>, value: Number): Boolean {
    println("Do this num array " + numArray.joinToString(", ") + " contains " + value)

    var contains = false // Variable to store the result of the check

    numArray.forEach { // Loop through each number in the input array
        if (it.toInt() == value.toInt()) { // Check if the current number is equal to the specified value
            contains = true
        }
    }

    return contains // Return the result of the check
}

// This function reverses array of integers
fun reverse(inputArray: Array<Int>): Array<Int> {
    println("Reverse of " + inputArray.joinToString(", ")) // Print the original array before reversing
    val reversedArray = Array(inputArray.size) { 0 } // Create an array with the same size as inputArray
    for (i in 0 until inputArray.size) {
        reversedArray[i] = inputArray[inputArray.size - 1 - i] // Reverse the inputArray
    }
    return reversedArray // Return the reversed array
}
