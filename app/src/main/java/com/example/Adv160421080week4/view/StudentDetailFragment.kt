package com.example.adv160421080week4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.adv160421080week4.R
import com.example.adv160421080week4.databinding.FragmentStudentDetailBinding
import com.example.adv160421080week4.viewModel.DetailViewModel
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment(), StudentDetailClickListener {
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var binding:FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null)
        {
            detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            detailViewModel.fetch(StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId)
            binding.detailListener = this

            observeViewModel()
        }
    }

    fun observeViewModel(){
        detailViewModel.studentLD.observe(viewLifecycleOwner, Observer {

            binding.studentDetail = it

//            binding.btnUpdate.setOnClickListener {
//                Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe{
//                        Log.d("Message", "five seconds")
//                        MainActivity.showNotification(student.name.toString(),
//                            "A new notification created", R.drawable.baseline_person_2_24)
//                    }
//            }

//            if(it!=null){
//                binding.txtID.setText(it.id)
//                binding.txtName.setText(it.name)
//                binding.txtBod.setText(it.dob)
//                binding.txtPhone.setText(it.phone)
//                val picasso = Picasso.Builder(binding.root.context)
//                picasso.listener { picasso, uri, exception ->  exception.printStackTrace()}
//                picasso.build().load(it.photoUrl).into(binding.imageStudent)
//            }
        })
    }

    override fun onStudentDetailClick(v: View) {
        val action = StudentDetailFragmentDirections.actionStudentDetailSelf(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }

}