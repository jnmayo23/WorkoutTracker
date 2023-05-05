package edu.quinnipiac.workouttracker

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "interval_workout")
data class IntervalWorkout(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name : String="",
    var sets : Int=0,
    var warmUpTime: Int=0,
    var highIntensityTime: Int=0,
    var lowIntensityTime: Int=0,
    var coolDownTime: Int=0
)