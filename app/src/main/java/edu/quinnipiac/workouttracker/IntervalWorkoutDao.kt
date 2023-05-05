package edu.quinnipiac.workouttracker

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface IntervalWorkoutDao {

    @Insert
    suspend fun addIntervalWorkout(intervalWorkout: IntervalWorkout)

    @Delete
    suspend fun deleteIntervalWorkout(intervalWorkout: IntervalWorkout)

    @Query("SELECT * FROM interval_workout WHERE id =:id")
    fun getIntervalWorkout(id:Int) : Flow<IntervalWorkout>

    @Query("SELECT * FROM interval_workout ORDER BY name DESC")
    fun getAllIntervalWorkouts(): Flow<List<IntervalWorkout>>
}