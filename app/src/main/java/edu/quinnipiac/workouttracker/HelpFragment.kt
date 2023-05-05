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

    private val rules = listOf(
        "How do you change the background of the app: Go to settings",
        "How do you save a workout: Go to the workout log",
        "What is a stopwatch: stopwatch is a simple timekeeping device that measures elapsed time in hours, minutes, and seconds",
        "What is an interval timer: allows you to program different time intervals for work and rest periods"

    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rules, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  rulesList.layoutManager = LinearLayoutManager(context)
        // rulesList.adapter = RulesAdapter(rules)
    }

    private class RulesAdapter(private val rules: List<String>) :
        RecyclerView.Adapter<RulesAdapter.RuleViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RuleViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rule, parent, false)
            return RuleViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: RuleViewHolder, position: Int) {
            //        holder.itemView.ruleText.text = rules[position]
        }

        override fun getItemCount() = rules.size

        class RuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    }
}