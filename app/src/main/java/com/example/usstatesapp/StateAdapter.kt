package com.example.usstatesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usstatesapp.databinding.ItemStateBinding
import java.util.Locale

class StateAdapter(
    private var states: List<State>,
    private val onStateClick: (State) -> Unit
) : RecyclerView.Adapter<StateAdapter.StateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateViewHolder {
        val binding = ItemStateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StateViewHolder, position: Int) {
        holder.bind(states[position])
    }

    override fun getItemCount() = states.size

    fun updateStates(newStates: List<State>) {
        states = newStates
        notifyDataSetChanged()
    }

    inner class StateViewHolder(private val binding: ItemStateBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(state: State) {
            binding.stateName.text = state.stateName
            binding.statePopulation.text = "Population: ${state.population.toFormattedString()}"
            StateFlags.loadStateFlag(state.stateName, binding.stateFlag)
            itemView.setOnClickListener { onStateClick(state) }
        }
    }

    private fun Long.toFormattedString(): String {
        return String.format(Locale.US, "%,d", this)
    }
}
