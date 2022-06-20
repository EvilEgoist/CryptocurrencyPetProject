package com.example.cryptocurrencyapp.domain.use_cases.get_coins

import android.util.Log
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

     operator fun invoke(vmScope: CoroutineScope): Flow<Resource<List<Coin>>> = flow {
         Log.d("LOG", "CoinListVM_GETCOINSUSECASE")
         emit(Resource.Loading<List<Coin>>())
         val result = repository.getCoinsList()
         emit(result)
     }
}