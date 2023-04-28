package edu.quinnipiac.workouttracker

import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.quinnipiac.workouttracker.databinding.FragmentIntervalTimerBinding


class IntervalTimerFragment : Fragment() {

    private lateinit var binding: FragmentIntervalTimerBinding
    var running = false // Is the chronometer running?
    var offset: Long = 0 // The base offset for the chronometer

    var warmUpTime = 10000;
    var highIntensityTime = 0;
    var lowIntensityTime = 0;
    var coolDownTime = 0;
    var numSets = 0;
    var setCount = 0;
    var state = 0
    var lastPaused: Long = 0;

    // Add key Strings for use with the Bundle
    val OFFSET_KEY = "offset"
    val RUNNING_KEY = "running"
    val BASE_KEY = "base"

    // Add key ints for interval state
    val WARM_UP = 0
    val HIGH_INTENSITY = 1
    val LOW_INTENSITY = 2
    val COOL_DOWN = 3

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentIntervalTimerBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.intervalTimer.isCountDown = true

//        // Restore the previous state
//        if (savedInstanceState != null) {
//            offset = savedInstanceState.getLong(OFFSET_KEY)
//            running = savedInstanceState.getBoolean(RUNNING_KEY)
//            if (running) {
//                binding.intervalTimer.base = savedInstanceState.getLong(BASE_KEY)
//                binding.intervalTimer.start()
//            } else setBaseTime()
//        }

        binding.startButton.setOnClickListener {
            if (!lastPaused.equals(0)) {
                binding.intervalTimer.setBase(binding.intervalTimer.getBase() + SystemClock.elapsedRealtime() - lastPaused)
            } else {
                binding.intervalTimer.setBase(SystemClock.elapsedRealtime())
            }
        }

        binding.stopButton.setOnClickListener {
            lastPaused = SystemClock.elapsedRealtime()
            binding.intervalTimer.stop()
            binding.stopButton.setEnabled(false);
            binding.startButton.setEnabled(true);
        }

        // The reset button sets the offset and stopwatch to 0
        binding.resetButton.setOnClickListener {
            binding.intervalTimer.stop()
            binding.intervalTimer.setBase(SystemClock.elapsedRealtime())
            lastPaused = 0
            binding.startButton.setEnabled(true)
            binding.stopButton.setEnabled(false)
        }

        return view
    }

    override fun onPause() {
        super.onPause()
        if (running) {
            saveOffset()
            binding.intervalTimer.stop()
        }
    }

    override fun onResume() {
        super.onResume()
        if (running) {
            setBaseTime()
            binding.intervalTimer.start()
            offset = 0
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putLong(OFFSET_KEY, offset)
        savedInstanceState.putBoolean(RUNNING_KEY, running)
        savedInstanceState.putLong(BASE_KEY, binding.intervalTimer.base)
        super.onSaveInstanceState(savedInstanceState)
    }

    // Update the stopwatch.base time, allowing for any offset
    fun setBaseTime() {
        binding.intervalTimer.base = SystemClock.elapsedRealtime() - offset
    }

    // Record the offset
    fun saveOffset() {
        offset = SystemClock.elapsedRealtime() - binding.intervalTimer.base
    }

}