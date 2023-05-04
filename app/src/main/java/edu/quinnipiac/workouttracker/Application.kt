package edu.quinnipiac.workouttracker

import android.app.Application
import edu.quinnipiac.workouttracker.IntervalWorkoutDatabase

class Application : Application(){
    val intervalWorkoutDatabase : IntervalWorkoutDatabase by lazy {IntervalWorkoutDatabase.getDatabase(this)}
}