package com.example.bank

import com.example.bank.api.ApiService
import com.example.bank.api.model.Info
import com.example.bank.database.BinEntity
import com.example.bank.database.dto.BinDao


class Repository(
    private val binApiService: ApiService,
    private val binDao: BinDao,
) {

    suspend fun getBin(bin: String): Info {
        return binApiService.getBin(bin = bin)
    }

    suspend fun insertBin(entity: BinEntity) {
        binDao.insertBin(entity)
    }

     suspend fun getBins(): List<BinEntity> = binDao.getAll()
}
