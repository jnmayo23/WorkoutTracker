package edu.quinnipiac.workouttracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import edu.quinnipiac.workouttracker.IntervalWorkout
import edu.quinnipiac.workouttracker.IntervalWorkoutDao
import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope


class IntervalWorkoutViewModel(private val intervalWorkoutDao: IntervalWorkoutDao) : ViewModel() {

    val allIntervalWorkouts : LiveData<List<IntervalWorkout>> = intervalWorkoutDao.getAllIntervalWorkouts().asLiveData()

    fun addNewIntervalWorkout(name: String, sets: String, warmUpTime: String, highIntensityTime: String, lowIntensityTime: String, coolDownTime: String) {
        val newIntervalWorkout = getNewIntervalWorkoutEntry(name, sets, warmUpTime, highIntensityTime, lowIntensityTime, coolDownTime)
        insertIntervalWorkout(newIntervalWorkout)
    }

    private fun insertIntervalWorkout(newIntervalWorkout: IntervalWorkout) {
        viewModelScope.launch {
            intervalWorkoutDao.addIntervalWorkout(newIntervalWorkout)
        }
    }

    fun retrieveIntervalWorkout(id: Int): LiveData<IntervalWorkout> {
        return intervalWorkoutDao.getIntervalWorkout(id).asLiveData()
    }

    private fun getNewIntervalWorkoutEntry(name: String, sets: String, warmUpTime: String, highIntensityTime: String, lowIntensityTime: String, coolDownTime: String): IntervalWorkout {
        return(
                IntervalWorkout(
                    name = name,
                    sets = sets.toInt(),
                    warmUpTime = warmUpTime.toInt(),
                    highIntensityTime = highIntensityTime.toInt(),
                    lowIntensityTime = lowIntensityTime.toInt(),
                    coolDownTime = coolDownTime.toInt()
                ))
    }

    fun isEntryValid(name: String, sets: String, warmUpTime: String, highIntensityTime: String, lowIntensityTime: String, coolDownTime: String): Boolean{
        if (name.isBlank() || sets.isBlank() || warmUpTime.isBlank() || highIntensityTime.isBlank() || lowIntensityTime.isBlank() || coolDownTime.isBlank()){
            return false
        }
        return true
    }
}
class IntervalWorkoutViewModelFactory (private  val intervalWorkoutDao: IntervalWorkoutDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IntervalWorkoutViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return IntervalWorkoutViewModel(intervalWorkoutDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


