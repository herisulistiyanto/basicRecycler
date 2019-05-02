package com.andro.indie.school.ui.main.fragments.mid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.andro.indie.school.R
import com.andro.indie.school.common.base.BaseFragment
import com.andro.indie.school.ui.main.fragments.mid.adapter.StudentMidAdapter
import kotlinx.android.synthetic.main.fragment_mid.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

class MidFragment : BaseFragment() {

    private val midAdapter by lazy {
        StudentMidAdapter {
            Log.e("HERI", "CLICKED : $it")
        }
    }

    private val viewModel by viewModel<MidViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mid, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvMid?.let {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.adapter = midAdapter
        }

        viewModelInteraction()
    }

    private fun viewModelInteraction() {
        viewModel.observeLoading().onResult {  }
        viewModel.observeError().onResult {  }
        viewModel.loadAllStudents {
            val students = it.getStudents()
            midAdapter.submitList(students)
        }
    }

}