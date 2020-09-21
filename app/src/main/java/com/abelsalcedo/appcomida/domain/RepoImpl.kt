package com.abelsalcedo.appcomida.domain

import com.abelsalcedo.appcomida.data.model.DataSource
import com.abelsalcedo.appcomida.data.model.Eat
import com.abelsalcedo.appcomida.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {

    override fun getComidasList(): Resource<List<Eat>>{
        return dataSource.generateComidaList
    }

    override fun getComidaList(): Resource<List<Eat>> {
        TODO("Not yet implemented")
    }

}