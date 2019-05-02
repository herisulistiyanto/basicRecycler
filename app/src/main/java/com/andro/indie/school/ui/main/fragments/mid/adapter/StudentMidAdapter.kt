package com.andro.indie.school.ui.main.fragments.mid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.andro.indie.school.R
import com.andro.indie.school.data.model.StudentModel
import com.andro.indie.school.ui.main.fragments.StudentViewHolder

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

class StudentMidAdapter(private val listener: (StudentModel) -> Unit) :
    ListAdapter<StudentModel, StudentViewHolder>(StudentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bindItem(getItem(holder.adapterPosition), listener)
    }
}