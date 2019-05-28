package com.example.yalandogruapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProviders
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LieFragment : Fragment() {
    private lateinit var viewModel: LieTruthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(LieTruthViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lie, container, false)
        val  fab = view.findViewById(R.id.lie_fab) as FloatingActionButton
        val lieEditText = view.findViewById(R.id.lieEditText) as EditText
        fab.setOnClickListener{view: View  ->
            val lie = lieEditText.text.toString()
            viewModel.setLie(lie)
            view.findNavController().navigate(R.id.action_lieFragment_to_truthFragment)
        }
        return view
    }

}
