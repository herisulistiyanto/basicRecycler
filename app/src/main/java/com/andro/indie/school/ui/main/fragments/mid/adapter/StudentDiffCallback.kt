package com.andro.indie.school.ui.main.fragments.mid.adapter

import androidx.recyclerview.widget.DiffUtil
import com.andro.indie.school.data.model.StudentModel

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

class StudentDiffCallback : DiffUtil.ItemCallback<StudentModel>() {

    override fun areItemsTheSame(oldItem: StudentModel, newItem: StudentModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: StudentModel, newItem: StudentModel): Boolean {
        return oldItem == newItem
    }
}