package com.example.dogspersonal.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.dogspersonal.Model.DogBreed
import com.example.dogspersonal.R
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(val dogsList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {

    //We will eventually get some data from backend and need to update this list when info is displayed on screen
    fun updateDogList(newDogsList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogsList)
        //Special method resets everything and have system recreate the list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        //We set variable inflater to bring out parent
        val inflater = LayoutInflater.from(parent.context)
        //We set variable view to bring the view of item_dog
        val view = inflater.inflate(R.layout.item_dog, parent, false)
        //Return the viewholder containing constructor of view
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogsList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.name.text = dogsList[position].dogBreed
        holder.view.lifespan.text = dogsList[position].lifeSpan
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(ListFragmentDirections.actionToDetailFrag())
        }
    }

    class DogViewHolder(var view: View) : RecyclerView.ViewHolder(view)

}