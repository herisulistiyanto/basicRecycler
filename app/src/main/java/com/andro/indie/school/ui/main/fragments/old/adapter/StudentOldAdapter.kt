package com.andro.indie.school.ui.main.fragments.old.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.andro.indie.school.R
import com.andro.indie.school.common.custom.DiffCallback
import com.andro.indie.school.data.model.StudentModel
import com.andro.indie.school.ui.main.fragments.StudentViewHolder

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

class StudentOldAdapter(val diffCallback: DiffCallback,
                        private val listener: (StudentModel) -> Unit) : RecyclerView.Adapter<StudentViewHolder>() {

    private val listStudent = mutableListOf<StudentModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bindItem(listStudent[holder.adapterPosition], listener)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    fun setStudents(students: List<StudentModel>) {
        calculateDiff(students)
    }

    fun addStudents(newStudents: List<StudentModel>) {
        val list = ArrayList(this.listStudent)
        list.addAll(newStudents)
        calculateDiff(list)
    }

    fun clearTeams() {
        calculateDiff(emptyList())
    }

    private fun calculateDiff(newStudents: List<StudentModel>) {
        diffCallback.setList(listStudent, newStudents)
        val result = DiffUtil.calculateDiff(diffCallback)
        with(listStudent) {
            clear()
            addAll(newStudents)
        }
        result.dispatchUpdatesTo(this)
    }

}