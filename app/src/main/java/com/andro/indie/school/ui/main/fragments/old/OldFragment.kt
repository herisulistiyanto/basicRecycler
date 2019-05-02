package com.andro.indie.school.ui.main.fragments.old

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.andro.indie.school.R
import com.andro.indie.school.common.base.BaseFragment
import com.andro.indie.school.common.custom.DiffCallback
import com.andro.indie.school.extension.goneIf
import com.andro.indie.school.ui.main.fragments.old.adapter.StudentOldAdapter
import kotlinx.android.synthetic.main.fragment_old.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

class OldFragment : BaseFragment() {

    private val diffCallback by inject<DiffCallback>()
    private val oldAdapter by lazy {
        StudentOldAdapter(diffCallback) {
            Log.e("HERI", "Model : $it")
        }
    }
    private val viewModel by viewModel<OldViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_old, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvOld?.let {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.adapter = oldAdapter
        }

        viewModelInteraction()
    }

    private fun viewModelInteraction() {
        viewModel.observeError().onResult { setErrorVisibility(true) }
        viewModel.observeLoading().onResult { setLoadingVisibility(it) }
        viewModel.loadAllStudents {
            val students = it.getStudents()
            oldAdapter.setStudents(students)
        }
    }

    private fun setLoadingVisibility(isLoading: Boolean) {
        setErrorVisibility(false)
        layoutLoadingOld.goneIf(!isLoading)
        rvOld.goneIf(isLoading)
    }

    private fun setErrorVisibility(isError: Boolean) {
        layoutErrorOld.goneIf(!isError)
        rvOld.goneIf(isError)
    }

}