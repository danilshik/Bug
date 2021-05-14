package com.example.bugfix

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.peshkariki.newPesh.newTwoAuth.startScreen.StartScreenState

class StartScreenFragment : Fragment() {
    private lateinit var viewModel: StartScreenViewModel

    private lateinit var layout: MotionLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layout = view.findViewById(R.id.layout)
        viewModel =
            ViewModelProvider(this).get(StartScreenViewModel::class.java)

        initViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.start()
    }

    private fun initViewModel() {
        viewModel.state.observe(viewLifecycleOwner, {
            when (it) {
                is StartScreenState.START_ANIMATION -> {

                    layout.setTransition(R.id.invisibleAll, R.id.visibleOnlyLogo)
                    layout.setTransitionDuration(1000)
                    layout.transitionToEnd()
                    Log.d("State", "Start Animation")
                }
                is StartScreenState.LOADING -> {

                }
            }
        })
    }
}