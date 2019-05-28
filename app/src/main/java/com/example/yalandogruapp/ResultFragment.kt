package com.example.yalandogruapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders

class ResultFragment : Fragment() {
    private lateinit var viewModel: LieTruthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(LieTruthViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        val litT = view.findViewById(R.id.result_lie_textView) as TextView
        val truT = view.findViewById(R.id.result_truth_textView) as TextView
        truT.text = viewModel.lastTruthValue()
        litT.text = viewModel.lastLieValue()
        return view
    }
}
