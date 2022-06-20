package com.example.cryptocurrencyapp.domain.repository

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow


interface CoinRepository {

    //suspend fun getCoins(): List<Coin>

    //suspend fun getCoinById(coinId: String): CoinDetail

    suspend fun getCoinsList(): Flow<Resource<List<Coin>>>

    suspend fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>
}
