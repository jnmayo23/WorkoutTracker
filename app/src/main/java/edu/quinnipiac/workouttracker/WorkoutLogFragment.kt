package edu.quinnipiac.workouttracker

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast


class WorkoutLogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_workout_log, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameText = view.findViewById<EditText>(R.id.nameView)
        val dateText = view.findViewById<EditText>(R.id.dateView)
        val typeText =  view.findViewById<EditText>(R.id.typeView)
        val durationText = view.findViewById<EditText>(R.id.durationView)
        val descText = view.findViewById<EditText>(R.id.descView)
        val addButton = view.findViewById<Button>(R.id.addWorkout)

        val testText = view.findViewById<TextView>(R.id.testView)

        addButton.setOnClickListener{

            val workoutName = nameText.text.toString()
            val workoutDate = dateText.text.toString()
            val workoutType = typeText.text.toString()
            val workoutDuration = durationText.text.toString()
            val workoutDescription = descText.text.toString()

            if (workoutName.isNotEmpty()) {
                Toast.makeText(activity, "Added to the Workout Log", Toast.LENGTH_SHORT).show()
                val workout = WorkoutList(
                    date = workoutDate,
                    name = workoutName,
                    type = workoutType,
                    description = workoutDuration,
                    duration = workoutDescription
                )
                WorkoutLog.add(workout)
                addItem()
            }
        }

        val listButton = view.findViewById<Button>(R.id.displayWorkout)
        val parentLayout = view.findViewById<LinearLayout>(R.id.WorkoutLog)
        var length = getWSize()

        listButton.setOnClickListener {
            if (getWSize() != 0) {
                parentLayout.removeAllViews()

                val scrollView = ScrollView(requireContext())
                val linearLayout = LinearLayout(requireContext())
                linearLayout.orientation = LinearLayout.VERTICAL
                linearLayout.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

                for (i in 0 until WorkoutLog.size) {
                    val dateView = TextView(requireContext())
                    val nameView = TextView(requireContext())
                    val typeView = TextView(requireContext())
                    val descriptionView = TextView(requireContext())
                    val durationView = TextView(requireContext())

                    // Add horizontal line between items
                    val lineView = View(requireContext())
                    lineView.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        2
                    )
                    lineView.setBackgroundColor(Color.parseColor("#CCCCCC"))

                    dateView.text = "Date: " + getWDate(i)
                    nameView.text = "Name: " + getWName(i)
                    typeView.text = "Type: " +getWType(i)
                    descriptionView.text = "Description: " + getWDescription(i)
                    durationView.text = "Duration: " + getWDuration(i)

                    dateView.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    nameView.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    typeView.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    descriptionView.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    durationView.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )

                    linearLayout.addView(dateView)
                    linearLayout.addView(nameView)
                    linearLayout.addView(typeView)
                    linearLayout.addView(descriptionView)
                    linearLayout.addView(durationView)
                    linearLayout.addView(lineView) // Add line between items
                }

                scrollView.addView(linearLayout)
                parentLayout.addView(scrollView)
            }
        }
    }


    }