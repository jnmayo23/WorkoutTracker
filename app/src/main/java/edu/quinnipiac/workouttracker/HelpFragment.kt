package edu.quinnipiac.workouttracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.fragment_rules.*
//import kotlinx.android.synthetic.main.item_rule.view.*

class HelpFragment : Fragment() {

   //this fragment is extremely basic and only displays text to help the user

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_help, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  rulesList.layoutManager = LinearLayoutManager(context)
        // rulesList.adapter = RulesAdapter(rules)
    }

}