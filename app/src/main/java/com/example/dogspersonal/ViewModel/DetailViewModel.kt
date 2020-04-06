package com.example.dogspersonal.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogspersonal.Model.DogBreed

class DetailViewModel : ViewModel() {

    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch() {
        val dog = DogBreed("1", "Corgi", "20 Years", "breedGroup", "bredFor", "temperament", "")
        dogLiveData.value = dog
    }

}