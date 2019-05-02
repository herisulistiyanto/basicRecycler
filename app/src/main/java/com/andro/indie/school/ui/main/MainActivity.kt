package com.andro.indie.school.ui.main

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.andro.indie.school.R
import com.andro.indie.school.common.base.BaseActivity
import com.andro.indie.school.ui.main.fragments.latest.LatestFragment
import com.andro.indie.school.ui.main.fragments.mid.MidFragment
import com.andro.indie.school.ui.main.fragments.old.OldFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()

    private val navSections: Map<Int, Fragment> = mapOf(
        R.id.navOld to OldFragment(),
        R.id.navMidterm to MidFragment(),
        R.id.navLatest to LatestFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavProperties()
    }

    private fun setupBottomNavProperties() {
        viewModel.getSelectedNavigationId().onResult { selectFragment(it) }

        bottomNavMain.setOnNavigationItemSelectedListener {
            if (navSections.containsKey(it.itemId)) {
                viewModel.setSelectedNavigationId(it.itemId)
                return@setOnNavigationItemSelectedListener true
            }
            false
        }
    }

    private fun selectFragment(@IdRes navId: Int) {
        navSections[navId]?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, it)
                .commit()
        }
    }
}
