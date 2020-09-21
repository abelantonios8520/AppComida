package com.abelsalcedo.appcomida.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abelsalcedo.appcomida.R
import com.abelsalcedo.appcomida.data.model.Eat

class ComidaDetallesFragment : Fragment() {

    private lateinit var eat: Eat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            eat = it.getParcelable("eat")!!
            Log.d("DETALLES_FRAG", "$eat")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comida_detalles, container, false)
    }


}