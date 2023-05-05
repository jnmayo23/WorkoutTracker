package edu.quinnipiac.workouttracker

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //creating the buttons to change the theme of the app
        val view = inflater.inflate(R.layout.fragment_color, container, false)
        val redButton = view.findViewById<Button>(R.id.red)
        val greenButton = view.findViewById<Button>(R.id.green)
        val blueButton = view.findViewById<Button>(R.id.blue)


        //listeners for the buttons
        redButton.setOnClickListener { changeBackgroundColor(Color.RED) }
        greenButton.setOnClickListener { changeBackgroundColor(Color.GREEN) }
        blueButton.setOnClickListener { changeBackgroundColor(Color.BLUE) }

        return view
    }

    private fun changeBackgroundColor(color: Int) {
        //changes the background color
        activity?.window?.decorView?.setBackgroundColor(color)
    }
}