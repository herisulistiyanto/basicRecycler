package com.andro.indie.school.ui.main.fragments.latest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.andro.indie.school.R
import com.andro.indie.school.common.base.BaseFragment
import com.andro.indie.school.common.custom.DiffCallback
import com.andro.indie.school.common.custom.GenericRecyclerAdapter
import com.andro.indie.school.data.model.StudentModelContoh
import kotlinx.android.synthetic.main.fragment_old.*
import kotlinx.android.synthetic.main.item_student.view.*
import org.koin.android.ext.android.inject

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

class LatestFragment : BaseFragment() {

    private val diffCallback by inject<DiffCallback>()
    private val genericRecyclerAdapter by lazy {
        GenericRecyclerAdapter<StudentModelContoh>(
            diffCallback,
            R.layout.item_student,
            onBind = { student, view ->
                val name = student.name ?: ""
                with(view) {
                    tvStudentName.text = name
                    tvStudentEmail.text = student.email ?: ""
                    tvStudentId.text = student.id.toString()

                    tvInitial.text = if (name.isNotEmpty()) name.take(1).toUpperCase() else "~"
                }
            },
            itemListener = { student, _, _ ->
                student.listener.invoke()
            }
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_old, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvOld?.let {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.adapter = genericRecyclerAdapter
        }
        genericRecyclerAdapter.setData(generateMockData())
    }

    private fun generateMockData(): List<StudentModelContoh> {
        val ret = mutableListOf<StudentModelContoh>()
        ret.add(
            StudentModelContoh(
                1,
                "heri",
                "heri@email.com"
            )
            { showMessage("Halo") }
        )
        ret.add(
            StudentModelContoh(
                2,
                "nico",
                "nico@email.com"
            )
        )
        ret.add(
            StudentModelContoh(
                3,
                "ipon",
                "ipon@email.com"
            )
            { showMessage("Mambu") }
        )

        return ret
    }

    private fun showMessage(msg: String = "") {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}