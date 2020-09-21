package com.abelsalcedo.appcomida.domain

import com.abelsalcedo.appcomida.data.model.Eat
import com.abelsalcedo.appcomida.vo.Resource

interface Repo {
    fun getComidasList():Resource<List<Eat>>
    fun getComidaList(): Resource<List<Eat>>
}