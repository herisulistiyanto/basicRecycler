package com.andro.indie.school.ui.main.fragments

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.andro.indie.school.data.model.StudentModel
import kotlinx.android.synthetic.main.item_student.view.*

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bindItem(student: StudentModel, listener: (StudentModel) -> Unit) {
        val name = student.name ?: ""
        itemView.tvStudentName.text = name
        itemView.tvStudentEmail.text = student.email ?: ""
        itemView.tvStudentId.text = student.id.toString()

        itemView.tvInitial.text = if (name.isNotEmpty()) name.take(1).toUpperCase() else "~"

        itemView.setOnClickListener {
            listener.invoke(student)
        }
    }

}