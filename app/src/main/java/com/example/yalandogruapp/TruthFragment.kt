package com.example.yalandogruapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TruthFragment : Fragment() {
    private lateinit var viewModel: LieTruthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(LieTruthViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_truth, container, false)
        val  fab = view.findViewById(R.id.truth_fab) as FloatingActionButton
        val truthEditText = view.findViewById(R.id.truthEditText) as EditText
        fab.setOnClickListener{view: View  ->
            val truth = truthEditText.text.toString()
            viewModel.setTruth(truth)
            view.findNavController().navigate(R.id.action_truthFragment_to_resultFragment)
        }
        return view
    }

}
