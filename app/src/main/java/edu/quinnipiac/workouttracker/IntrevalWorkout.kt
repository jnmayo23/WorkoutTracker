package edu.quinnipiac.workouttracker

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "interval_workout")
data class IntervalWorkout(
    var name : String="",
    var sets : Int=0,
    var warmUpTime: Int=0,
    var highIntensityTime: Int=0,
    var lowIntensityTime: Int=0,
    var coolDownTime: Int=0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int=0

    @JvmName("getIdFunctionOfKotlin")
    fun getId(): Int {
        return id
    }

    @JvmName("setIdFunctionOfKotlin")
    fun setId(id: Int) {
        this.id = id
    }

    @JvmName("getNameFunctionOfKotlin")
    fun getName(): String? {
        return name
    }

    @JvmName("setNameFunctionOfKotlin")
    fun setName(newName: String) {
        name = newName
    }

    @JvmName("getSetsFunctionOfKotlin")
    fun getSets(): Int? {
        return sets
    }

    @JvmName("setSetsFunctionOfKotlin")
    fun setSets(newSets: Int) {
        sets = newSets
    }

    @JvmName("getWarmUpFunctionOfKotlin")
    fun getWarmUpTime(): Int? {
        return warmUpTime
    }

    @JvmName("setWarmUpFunctionOfKotlin")
    fun setWarmUpTime(newWarmUpTime: Int) {
        warmUpTime = newWarmUpTime
    }

    @JvmName("getHITimeFunctionOfKotlin")
    fun getHighIntensityTime(): Int? {
        return highIntensityTime
    }

    @JvmName("setHITimeFunctionOfKotlin")
    fun setHighIntensityTime(newHighIntensityTime: Int) {
        highIntensityTime = newHighIntensityTime
    }

    @JvmName("getLITimeFunctionOfKotlin")
    fun getLowIntensityTime(): Int? {
        return lowIntensityTime
    }

    @JvmName("setLITimeFunctionOfKotlin")
    fun setLowIntensityTime(newLowIntensityTime: Int) {
        lowIntensityTime = newLowIntensityTime
    }

    @JvmName("getCoolDownFunctionOfKotlin")
    fun getCoolDownTime(): Int? {
        return coolDownTime
    }

    @JvmName("setCoolDownFunctionOfKotlin")
    fun setCoolDownTime(newCoolDownTime: Int) {
        coolDownTime = newCoolDownTime
    }

}