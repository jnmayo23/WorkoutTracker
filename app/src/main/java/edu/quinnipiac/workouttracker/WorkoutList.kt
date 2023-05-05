package edu.quinnipiac.workouttracker

import java.time.Duration

//list for the workout log some of the functions are not necessary
data class WorkoutList(
    val date: String,
    val name: String,
    val type: String,
    val description: String,
    val duration: String
)

val WorkoutLog = mutableListOf<WorkoutList>()
var size = 0

fun getWDate(number: Int): String{
    return WorkoutLog[number].date
}

fun getWName(number: Int): String{
    return WorkoutLog[number].name
}

fun getWType(number: Int): String{
    return WorkoutLog[number].type
}

fun getWDescription(number: Int): String{
    return WorkoutLog[number].description
}

fun getWDuration(number: Int): String{
    return WorkoutLog[number].duration
}

fun addItem(){
    size = size + 1
}

fun getWSize(): Int{
    return size
}

