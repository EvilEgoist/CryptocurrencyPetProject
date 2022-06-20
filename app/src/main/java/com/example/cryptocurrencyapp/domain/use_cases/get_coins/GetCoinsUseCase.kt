package com.example.cryptocurrencyapp.domain.use_cases.get_coins

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

     operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
         repository.getCoinsList()
     }
}