package edu.quinnipiac.workouttracker

import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.quinnipiac.workouttracker.databinding.FragmentIntervalTimerBinding


class IntervalTimerFragment : Fragment() {

    private lateinit var binding: FragmentIntervalTimerBinding

    var warmUpTime = 10000;
    var highIntensityTime = 0;
    var lowIntensityTime = 0;
    var coolDownTime = 0;
    var numSets = 0;
    var setCount = 0;
    var state = 0
    var lastPaused: Long = 0;
    var isRunning: Boolean = false;

    // Add key ints for interval state
    val WARM_UP = 0
    val HIGH_INTENSITY = 1
    val LOW_INTENSITY = 2
    val COOL_DOWN = 3
    val COMPLETE = 4

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentIntervalTimerBinding.inflate(inflater, container, false)
        val view = binding.root

        var coolDownTimer = object : CountDownTimer(50000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Used for formatting digit to be in 2 digits only
                val f: NumberFormat = DecimalFormat("00")
                val hour = millisUntilFinished / 3600000 % 24
                val min = millisUntilFinished / 60000 % 60
                val sec = millisUntilFinished / 1000 % 60
                if (state == COOL_DOWN) {
                    binding.intervalTime.setText((f.format(hour) + ":" + f.format(min)).toString() + ":" + f.format(sec))
                }
            }
            override fun onFinish() {
                binding.intervalTime.setText("00:00")
                //state = COMPLETE
                binding.intervalState.text = "Workout Complete!"
            }
        }

        var highIntensityTimer = object : CountDownTimer(50000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Used for formatting digit to be in 2 digits only
                val f: NumberFormat = DecimalFormat("00")
                val hour = millisUntilFinished / 3600000 % 24
                val min = millisUntilFinished / 60000 % 60
                val sec = millisUntilFinished / 1000 % 60
                if (state == HIGH_INTENSITY) {
                    binding.intervalTime.setText((f.format(hour) + ":" + f.format(min)).toString() + ":" + f.format(sec))
                }
            }
            override fun onFinish() {
                binding.intervalTime.setText("00:00")
                //lowIntensityTimer.start()
                state = LOW_INTENSITY
            }
        }

        var lowIntensityTimer = object : CountDownTimer(50000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Used for formatting digit to be in 2 digits only
                val f: NumberFormat = DecimalFormat("00")
                val hour = millisUntilFinished / 3600000 % 24
                val min = millisUntilFinished / 60000 % 60
                val sec = millisUntilFinished / 1000 % 60
                if (state == LOW_INTENSITY) {
                    binding.intervalTime.setText((f.format(hour) + ":" + f.format(min)).toString() + ":" + f.format(sec))
                }
            }
            override fun onFinish() {
                binding.intervalTime.setText("00:00")
                setCount += 1
                if (setCount >= numSets) {
                    state = COOL_DOWN
                    coolDownTimer.start()
                    binding.intervalState.text = "Cool Down"
                } else {
                    state = HIGH_INTENSITY
                    highIntensityTimer.start()
                    binding.intervalState.text = "High Intensity"
                }
            }
        }

        var warmUpTimer = object : CountDownTimer(50000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Used for formatting digit to be in 2 digits only
                val f: NumberFormat = DecimalFormat("00")
                val hour = millisUntilFinished / 3600000 % 24
                val min = millisUntilFinished / 60000 % 60
                val sec = millisUntilFinished / 1000 % 60
                if (state == WARM_UP) {
                    binding.intervalTime.setText((f.format(hour) + ":" + f.format(min)).toString() + ":" + f.format(sec))
                }
            }
            override fun onFinish() {
                binding.intervalTime.setText("00:00")
                highIntensityTimer.start()
                state = HIGH_INTENSITY
            }
        }

        var intervalTimer = object : CountDownTimer(50000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Used for formatting digit to be in 2 digits only
                val f: NumberFormat = DecimalFormat("00")
                val hour = millisUntilFinished / 3600000 % 24
                val min = millisUntilFinished / 60000 % 60
                val sec = millisUntilFinished / 1000 % 60
                binding.intervalTime.setText((f.format(hour) + ":" + f.format(min)).toString() + ":" + f.format(sec))
            }
            override fun onFinish() {
                binding.intervalTime.setText("00:00")
            }
        }

        binding.startButton.setOnClickListener {
            intervalTimer.start()
            if (state == WARM_UP) {
                warmUpTimer.start()
                //isRunning = true
            } else if (state == HIGH_INTENSITY) {
                highIntensityTimer.start()
            } else if (state == LOW_INTENSITY) {
                lowIntensityTimer.start()
            } else if (state == COOL_DOWN) {
                coolDownTimer.start()
            }
            binding.startButton.setEnabled(false);
            binding.stopButton.setEnabled(true);
        }

        binding.stopButton.setOnClickListener {

            binding.stopButton.setEnabled(false);
            binding.startButton.setEnabled(true);
        }

        // The reset button sets the offset and stopwatch to 0
        binding.resetButton.setOnClickListener {
        }

        return view
    }

}