// Name: Anish Acharya
// Student Number: A00263391
// Program: Lab 1 — Variables and Logic
// Using switch (when)

import java.text.DecimalFormat

fun main() {
    // Array of units for user to select from
    val units =
            arrayOf(
                    "Kilometers",
                    "Centimeters",
                    "Feet",
                    "Miles",
                    "Millimeters",
                    "Micrometers",
                    "Inches",
                    "Yards"
            )

    // Prompt user for input value
    println("Enter the input value:")

    // Read input value from user
    val inputValueString = readLine()

    // Validate the input value to ensure it's a number
    if (inputValueString == null ||
                    inputValueString.isEmpty() ||
                    !inputValueString.matches("-?\\d+(\\.\\d+)?".toRegex())
    ) {
        println("Please enter a valid input value")
        return
    }

    // Convert the input value string to a double
    val inputValue = inputValueString.toDouble()

    // Prompt user to select input unit
    println("Select input unit:")
    for (i in units.indices) {
        println("${i + 1}. ${units[i]}")
    }

    // Read input unit from user
    val inputUnitString = readLine()

    // Validate the input unit to ensure it's a number
    if (inputUnitString == null ||
                    inputUnitString.isEmpty() ||
                    !inputUnitString.matches("\\d+".toRegex())
    ) {
        println("Please enter a valid input unit")
        return
    }

    // Convert the input unit string to an int
    val inputUnit = inputUnitString.toInt()

    // Validate the input unit to ensure it's within the range of available units
    if (inputUnit < 1 || inputUnit > units.size) {
        println("Input unit is out of range. Please enter a valid unit")
        return
    }

    // Prompt user to select output unit
    println("Select output unit:")
    for (i in units.indices) {
        println("${i + 1}. ${units[i]}")
    }

    // Read output unit from user
    val outputUnitString = readLine()

    // Validate the output unit to ensure it's a number
    if (outputUnitString == null ||
                    outputUnitString.isEmpty() ||
                    !outputUnitString.matches("\\d+".toRegex())
    ) {
        println("Please enter a valid output unit")
        return
    }

    // Convert the output unit string to an int
    val outputUnit = outputUnitString.toInt()

    // Validate the output unit to ensure it's within the range of available units
    if (outputUnit < 1 || outputUnit > units.size) {
        println("Output unit is out of range. Please enter a valid unit")
        return
    }

    // Use a when expression to convert the input value from one unit to another

    val result =
            when (inputUnit) {
                1 ->
                        when (outputUnit) {
                            1 -> inputValue
                            2 -> inputValue * 100000
                            3 -> inputValue * 3280.8
                            4 -> inputValue * 0.621371
                            5 -> inputValue * 1000000
                            6 -> inputValue * 1000000000
                            7 -> inputValue * 39370.1
                            8 -> inputValue * 1093.61
                            else -> 0.0
                        }
                2 ->
                        when (outputUnit) {
                            1 -> inputValue / 100000
                            2 -> inputValue
                            3 -> inputValue / 30.48
                            4 -> inputValue / 160934
                            5 -> inputValue / 10
                            6 -> inputValue / 10000
                            7 -> inputValue / 2.54
                            8 -> inputValue / 91.44
                            else -> 0.0
                        }
                3 ->
                        when (outputUnit) {
                            1 -> inputValue / 3280.8
                            2 -> inputValue * 30.48
                            3 -> inputValue
                            4 -> inputValue / 5280
                            5 -> inputValue * 304.8
                            6 -> inputValue * 304800
                            7 -> inputValue * 12
                            8 -> inputValue / 3
                            else -> 0.0
                        }
                4 ->
                        when (outputUnit) {
                            1 -> inputValue / 0.621371
                            2 -> inputValue * 160934
                            3 -> inputValue * 5280
                            4 -> inputValue
                            5 -> inputValue * 1609344
                            6 -> inputValue * 1609000000
                            7 -> inputValue * 63360
                            8 -> inputValue * 1760
                            else -> 0.0
                        }
                5 ->
                        when (outputUnit) {
                            1 -> inputValue / 1000000
                            2 -> inputValue * 10
                            3 -> inputValue / 304.8
                            4 -> inputValue / 1609344
                            5 -> inputValue
                            6 -> inputValue * 1000
                            7 -> inputValue / 25.4
                            8 -> inputValue / 914.4
                            else -> 0.0
                        }
                6 ->
                        when (outputUnit) {
                            1 -> inputValue / 1000000000
                            2 -> inputValue * 10000
                            3 -> inputValue / 304800
                            4 -> inputValue / 1609000000
                            5 -> inputValue / 1000
                            6 -> inputValue
                            7 -> inputValue / 25400
                            8 -> inputValue / 914400
                            else -> 0.0
                        }
                7 ->
                        when (outputUnit) {
                            1 -> inputValue / 39370.1
                            2 -> inputValue * 2.54
                            3 -> inputValue / 12
                            4 -> inputValue / 63360
                            5 -> inputValue * 25.4
                            6 -> inputValue * 25400
                            7 -> inputValue
                            8 -> inputValue / 36
                            else -> 0.0
                        }
                8 ->
                        when (outputUnit) {
                            1 -> inputValue / 1093.61
                            2 -> inputValue * 91.44
                            3 -> inputValue * 3
                            4 -> inputValue / 1760
                            5 -> inputValue * 914.4
                            6 -> inputValue * 914400
                            7 -> inputValue * 36
                            8 -> inputValue
                            else -> 0.0
                        }
                else -> 0.0
            }

    // formating the result to have a maximum of three decimal places
    val formatter = DecimalFormat("#,###.###")

    // printing the final result with proper formatting and unit
    println("The converted value is: ${formatter.format(result)} ${units[outputUnit - 1]}")
}
