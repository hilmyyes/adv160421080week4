package com.example.Adv160421080week4.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.Adv160421080week4.model.Student


class ListViewModel(application: Application): AndroidViewModel(application) {
    val studentsLD = MutableLiveData<ArrayList<Student>>()
    val studentLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()


    fun refresh() {
        val student1 =
            Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")

       val student2 =
            Student("13312","Rich","1994/12/14","3925444073","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff")

        val student3 =
            Student("11204","Dinny","1994/10/07","6827808747","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")

        val student4 =
            Student("16042","Ansa","2002/10/07","08432344","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")

        val studentList:ArrayList<Student> = arrayListOf<Student>(student1, student2, student3,student4)

        studentsLD.value = studentList
        studentLoadErrorLD.value = false
        loadingLD.value = false
    }

}