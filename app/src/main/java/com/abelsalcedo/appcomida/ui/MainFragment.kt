package com.abelsalcedo.appcomida.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.abelsalcedo.appcomida.R
import com.abelsalcedo.appcomida.data.model.DataSource
import com.abelsalcedo.appcomida.data.model.Eat
import com.abelsalcedo.appcomida.domain.RepoImpl
import com.abelsalcedo.appcomida.ui.viewmodel.MainViewModel
import com.abelsalcedo.appcomida.ui.viewmodel.VMFactory
import com.abelsalcedo.appcomida.vo.Resource
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainAdapter.OnComidaClickListener {

    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSource()))}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.fetchComidasList.observe(viewLifecycleOwner, Observer {result ->
            when(result){
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                    rv_comidas.adapter = MainAdapter(requireContext(), result.data, this)
                }
                is Resource.Failure -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Ocurrio un erro al traer los datos ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setupRecyclerView(){
        rv_comidas.layoutManager = LinearLayoutManager(requireContext())
        rv_comidas.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    override fun onComidaClick(eat: Eat) {
        val bundle = Bundle()
        bundle.putParcelable("eat",eat)
        findNavController().navigate(R.id.comidaDetallesFragment,bundle)
    }

}