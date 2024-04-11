package com.example.Adv160421080week4.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.Adv160421080week4.R
import com.example.Adv160421080week4.databinding.StudentListItemBinding
import com.example.Adv160421080week4.model.Student
import com.squareup.picasso.Picasso
import com.squareup.picasso.Callback
import java.lang.Exception


class StudentListAdapter(val studenList:ArrayList<Student>) :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
{
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)
    private lateinit var binding: StudentListItemBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studenList.size

    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        var txtID = holder.view.findViewById<TextView>(R.id.txtID)
        var txtName = holder.view.findViewById<TextView>(R.id.txtName)
        var btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)

        txtID.text = studenList[position].id
        txtName.text = studenList[position].name
        btnDetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }

        val picasso = Picasso.Builder(holder.itemView.context)
        picasso.listener { picasso, uri, exception ->
            exception.printStackTrace()
        }
        picasso.build().load(studenList[position].photoUrl).into(binding.imageView)
        picasso.build().load(studenList[position].photoUrl)
            .into(binding.imageView, object:Callback {
                override fun onSuccess() {
                    binding.progressImage.visibility = View.INVISIBLE
                    binding.progressImage.visibility = View.VISIBLE
                }

                override fun onError(e: Exception?) {
                    Log.e("picasso_error", e.toString())
                }

            })


    }

    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }


}