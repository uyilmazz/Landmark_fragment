package com.example.task1_landmarkbook_fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.task1_landmarkbook_fragment.databinding.RecyclerRowBinding

class LandmarkAdapter(private val landmarkList : ArrayList<Landmark>) : RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>() {
    class LandmarkHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarkHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.recycleImageView.setImageResource(landmarkList[position].image)
        holder.binding.recycleTextview.text = landmarkList[position].name

        holder.itemView.setOnClickListener {
            val action : NavDirections = LandmarkListFragmentDirections.actionLandmarkListFragmentToLandmarkDetailFragment(landmarkList[position])
            holder.itemView.findNavController().navigate(action)
        }
    }


    override fun getItemCount(): Int {
        return landmarkList.size
    }
}