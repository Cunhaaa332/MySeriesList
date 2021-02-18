package com.cunha.myserieslist.ui.episodio.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cunha.myserieslist.R

class FormEpisodioFragment : Fragment() {

    companion object {
        fun newInstance() = FormEpisodioFragment()
    }

    private lateinit var viewModel: FormEpisodioViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.form_episodio_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormEpisodioViewModel::class.java)
        // TODO: Use the ViewModel
    }

}