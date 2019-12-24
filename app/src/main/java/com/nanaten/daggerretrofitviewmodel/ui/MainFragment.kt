package com.nanaten.daggerretrofitviewmodel.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.nanaten.daggerretrofitviewmodel.R
import com.nanaten.daggerretrofitviewmodel.di.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class MainFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getRepos()

        // getRepos()で取得したデータをobserveする
        viewModel.data.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "${it.name}", Toast.LENGTH_SHORT).show()
        })
    }
}
