// Name: Anish Acharya
// Student Number: A00263391
// Program: Lab 1 — Variables and Logic
// using arrays

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

    val conversionFactors = arrayOf(
        // 1 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(1.0, 100000.0, 3280.8, 0.621371, 1000000.0, 1000000000.0, 39370.1, 1093.61),
        // 2 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(0.00001, 1.0, 0.003048, 0.00000621371, 0.1, 100.0, 0.0254, 0.0009144),
        // 3 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(0.0003048, 30.48, 1.0, 0.0003048, 304.8, 304800.0, 12.0, 3.0),
        // 4 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(1.60934, 160934.0, 5280.0, 1.0, 1609344.0, 1609000000.0, 63360.0, 1760.0),
        // 5 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(0.000001, 10.0, 0.0030480, 0.000000621371, 1.0, 1000.0, 0.0254, 0.0009144),
        // 6 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(0.000000001, 10000.0, 0.0003048, 0.00000000621371, 0.001, 1.0, 0.0000254, 0.0000009144),
        // 7 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(0.0000254, 254.0, 0.083333, 0.0000157828, 2.54, 25400.0, 1.0, 0.0277778),
        // 8 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(0.0009144, 9144.0, 3.0, 0.000568182, 914.4, 914400.0, 36.0, 1.0)
    )
    
    val result = inputValue * conversionFactors[inputUnit - 1][outputUnit - 1]
    

    // formating the result to have a maximum of three decimal places
    val formatter = DecimalFormat("#,###.###")

    // printing the final result with proper formatting and unit
    println("The converted value is: ${formatter.format(result)} ${units[outputUnit - 1]}")
}
