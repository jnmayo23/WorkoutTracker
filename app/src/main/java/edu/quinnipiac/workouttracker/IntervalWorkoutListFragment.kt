package edu.quinnipiac.workouttracker
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.opencsv.CSVParser
import com.opencsv.CSVReader
import edu.quinnipiac.workouttracker.R
import kotlinx.android.synthetic.clearFindViewByIdCache
import kotlinx.android.synthetic.main.fragment_interval_workout_list.name
import kotlinx.android.synthetic.main.fragment_interval_workout_list.sets
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.file.Paths
import edu.quinnipiac.workouttracker.finalList
import org.w3c.dom.Text


class IntervalWorkoutListFragment : Fragment() {

    // Define the list of workouts


    public

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_interval_workout_list, container, false)
        // Inflate the layout for this fragment
        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener { displayWorkouts() }
        val button1 = view.findViewById<Button>(R.id.Ibutton1)

        return view
    }

    private fun Button.onClick(encryptFragment: IntervalWorkoutListFragment) {


        //button to reset the game if the game ends
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val nameText = view.findViewById<EditText>(R.id.name)
        val setsText = view.findViewById<EditText>(R.id.sets)
        val highIntensityText = view.findViewById<EditText>(R.id.high)
        val lowIntensityText = view.findViewById<EditText>(R.id.low)
        val cooldownText = view.findViewById<EditText>(R.id.cool)
        val button2 = view.findViewById<Button>(R.id.button2)



        button2.setOnClickListener {
            val workoutName = nameText.text.toString()
            val workoutSets = setsText.text.toString()
            val workoutHighIntensityTime = highIntensityText.text.toString()
            val workoutLowIntensityTime = lowIntensityText.text.toString()
            val workoutCooldownTime = cooldownText.text.toString()

            if (workoutName.isNotEmpty()) {
                val inteval = FinalIntervalList(
                    name = workoutName,
                    sets = workoutSets,
                    highIntensity = workoutHighIntensityTime,
                    lowIntensity = workoutLowIntensityTime,
                    coolDown = workoutCooldownTime
                )
                finalList.add(inteval)
            }
        }

        val generateButton = view.findViewById<Button>(R.id.button)

        val text1 = view.findViewById<TextView>(R.id.interval1)
        val ibutton1 = view.findViewById<Button>(R.id.Ibutton1)

        val text2 = view.findViewById<TextView>(R.id.interval2)
        val ibutton2 = view.findViewById<Button>(R.id.Ibutton2)

        val text3 = view.findViewById<TextView>(R.id.interval3)
        val ibutton3 = view.findViewById<Button>(R.id.Ibutton3)

        val text4 = view.findViewById<TextView>(R.id.interval4)
        val ibutton4 = view.findViewById<Button>(R.id.Ibutton4)

        val text5 = view.findViewById<TextView>(R.id.interval5)
        val ibutton5 = view.findViewById<Button>(R.id.Ibutton5)

        generateButton.setOnClickListener{
                text1.setText("Name: " + getFinalName(0) + " Sets: " + getFinalSets(0) + " High Int: " + getHigh(0) + " low int "
                + getFinalLow(0) + " cooldown " + getFinalCool(0))
                ibutton1.visibility = View.VISIBLE

            text2.setText("Name: " + getFinalName(1) + " Sets: " + getFinalSets(1) + " High Int: " + getHigh(1) + " low int "
                    + getFinalLow(1) + " cooldown " + getFinalCool(1))
            ibutton2.visibility = View.VISIBLE


            text3.setText("Name: " + getFinalName(2) + " Sets: " + getFinalSets(2) + " High Int: " + getHigh(2) + " low int "
                    + getFinalLow(2) + " cooldown " + getFinalCool(2))
            ibutton3.visibility = View.VISIBLE

            text4.setText("Name: " + getFinalName(3) + " Sets: " + getFinalSets(3) + " High Int: " + getHigh(3) + " low int "
                    + getFinalLow(3) + " cooldown " + getFinalCool(3))
            ibutton4.visibility = View.VISIBLE

            text5.setText("Name: " + getFinalName(4) + " Sets: " + getFinalSets(4) + " High Int: " + getHigh(4) + " low int "
                    + getFinalLow(4) + " cooldown " + getFinalCool(4))
            ibutton5.visibility = View.VISIBLE

        }

        if (ibutton1 != null) {
            ibutton1.setOnClickListener() {
                Toast.makeText(activity, "Added to the Interval List", Toast.LENGTH_SHORT).show()

                val name = getName(0)
                val sets = getSets(0)
                val high = getHigh(0)
                val low = getLow(0)
                val cool = getCool(0)

                val interval = FinalIntervalList(name = name, sets = sets, highIntensity = high, lowIntensity = low,
                    coolDown = cool
                )

                finalList.add(interval)
            }
        }

        if (ibutton2 != null) {
            ibutton2.setOnClickListener() {
                Toast.makeText(activity, "Added to the Interval List", Toast.LENGTH_SHORT).show()

                val name = getName(1)
                val sets = getSets(1)
                val high = getHigh(1)
                val low = getLow(1)
                val cool = getCool(1)

                val interval = FinalIntervalList(name = name, sets = sets, highIntensity = high, lowIntensity = low,
                    coolDown = cool
                )

                finalList.add(interval)
            }
        }

        if (ibutton3 != null) {
            ibutton3.setOnClickListener() {
                Toast.makeText(activity, "Added to the Interval List", Toast.LENGTH_SHORT).show()

                val name = getName(2)
                val sets = getSets(2)
                val high = getHigh(2)
                val low = getLow(2)
                val cool = getCool(2)

                val interval = FinalIntervalList(name = name, sets = sets, highIntensity = high, lowIntensity = low,
                    coolDown = cool
                )

                finalList.add(interval)
            }
        }

        if (ibutton4 != null) {
            ibutton4.setOnClickListener() {
                Toast.makeText(activity, "Added to the Interval List", Toast.LENGTH_SHORT).show()

                val name = getName(3)
                val sets = getSets(3)
                val high = getHigh(3)
                val low = getLow(3)
                val cool = getCool(3)

                val interval = FinalIntervalList(name = name, sets = sets, highIntensity = high, lowIntensity = low,
                    coolDown = cool
                )

                finalList.add(interval)
            }
        }

        if (ibutton5 != null) {
            ibutton5.setOnClickListener() {
                Toast.makeText(activity, "Added to the Interval List", Toast.LENGTH_SHORT).show()

                val name = getName(4)
                val sets = getSets(4)
                val high = getHigh(4)
                val low = getLow(4)
                val cool = getCool(4)

                val interval = FinalIntervalList(name = name, sets = sets, highIntensity = high, lowIntensity = low,
                    coolDown = cool
                )

                finalList.add(interval)
            }
        }


    }


    private fun displayWorkouts() {
        // Get the TextView that will hold the workout list
    }
}
