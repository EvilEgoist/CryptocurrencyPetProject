package com.example.cryptocurrencyapp.data.repository

import android.util.Log
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.example.cryptocurrencyapp.data.remote.dto.toCoin
import com.example.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.model.CoinDetail
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {

//    override suspend fun getCoins(): List<Coin> {
//        return api.getCoins().map { it.toCoin() }
//    }

//    override suspend fun getCoinById(coinId: String): CoinDetail {
//        return api.getCoinById(coinId).toCoinDetail()
//    }

    override suspend fun getCoinsList(): Resource<List<Coin>>  {
        try {
            Log.d("LOG", "Repository_Impl_getCoinsList")
            val coins = api.getCoins().map { it.toCoin() }
            return Resource.Success<List<Coin>>(coins)
        } catch (e: HttpException){
            return Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured")
        } catch (e: IOException){
            return Resource.Error<List<Coin>>("Couldn't connect to server. Check Internet connection.")
        }
    }

    override suspend fun getCoinById(coinId: String): Resource<CoinDetail> {
        try {
            val coin = api.getCoinById(coinId).toCoinDetail()
            return Resource.Success<CoinDetail>(coin)
        } catch (e: HttpException){
            return Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured")
        } catch (e: IOException){
            return Resource.Error<CoinDetail>("Couldn't connect to server. Check Internet connection.")
        }
    }

}