package com.mw.example.feature_list.impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.mw.example.feature_list.R
import com.mw.example.feature_list.impl.di.ListComponentHolder
import com.mw.example.injector.findComponentDependencies
import javax.inject.Inject

class ListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ListViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ListComponentHolder.init(findComponentDependencies())
        ListComponentHolder.getComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.listTextView).text = viewModel.listPerson()
        view.findViewById<Button>(R.id.toDetailButton).setOnClickListener {
            val request = NavDeepLinkRequest.Builder
                .fromUri("android-app://com.mw.example/action_global_detailFragment".toUri())
                .build()
            findNavController().navigate(request)
        }
    }
}