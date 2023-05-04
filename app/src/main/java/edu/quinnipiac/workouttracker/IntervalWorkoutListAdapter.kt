package edu.quinnipiac.workouttracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.quinnipiac.workouttracker.IntervalWorkout

import edu.quinnipiac.workouttracker.databinding.IntervalWorkoutRvItemBinding


class IntervalWorkoutListAdapter(private val onItemClicked: (IntervalWorkout) -> Unit):
    ListAdapter<IntervalWorkout, IntervalWorkoutListAdapter.IntervalWorkoutViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntervalWorkoutViewHolder {
        return IntervalWorkoutViewHolder(
            IntervalWorkoutRvItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: IntervalWorkoutViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }

    class IntervalWorkoutViewHolder(private var binding: IntervalWorkoutRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(intervalWorkout: IntervalWorkout) {
            binding.apply {
                itemName.text = intervalWorkout.name
                itemSets.text = intervalWorkout.sets.toString()
                itemWarmUpTime.text = intervalWorkout.warmUpTime.toString()
                itemHighIntensityTime.text = intervalWorkout.highIntensityTime.toString()
                itemLowIntensityTime.text = intervalWorkout.lowIntensityTime.toString()
                itemCoolDownTime.text = intervalWorkout.coolDownTime.toString()
            }
        }
    }

    companion object {
        private  val DiffCallback = object : DiffUtil.ItemCallback<IntervalWorkout>(){
            override fun areItemsTheSame(oldIntervalWorkout: IntervalWorkout, newIntervalWorkout: IntervalWorkout): Boolean {
                return oldIntervalWorkout == newIntervalWorkout
            }

            override fun areContentsTheSame(oldIntervalWorkout: IntervalWorkout, newIntervalWorkout: IntervalWorkout): Boolean {
                return oldIntervalWorkout.name == newIntervalWorkout.name
            }

        }
    }
}