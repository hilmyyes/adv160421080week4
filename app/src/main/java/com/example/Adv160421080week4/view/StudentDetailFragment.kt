package com.example.Adv160421080week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.Adv160421080week4.R
import com.example.Adv160421080week4.viewmodel.DetailViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel =ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer { studentLD->
            val txtID = view?.findViewById<TextView>(R.id.txtID)
            val txtName = view?.findViewById<TextView>(R.id.txtName)
            val txtbod = view?.findViewById<TextView>(R.id.txtBod)
            val txtPhone = view?.findViewById<TextView>(R.id.txtPhone)

            txtID?.text = viewModel.studentLD.value?.id
            txtName?.text = viewModel.studentLD.value?.name
            txtbod?.text = viewModel.studentLD.value?.dob
            txtPhone?.text = viewModel.studentLD.value?.phone
        })
    }
}