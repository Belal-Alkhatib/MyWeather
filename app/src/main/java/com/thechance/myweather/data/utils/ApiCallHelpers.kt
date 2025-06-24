package com.thechance.myweather.data.utils

import android.util.Log
import android.util.Log.e
import com.thechance.myweather.domain.exception.MyWeatherException
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLException

inline fun safeApiCall(apiCall: () -> HttpResponse): HttpResponse {
    return try {
        apiCall()
    } catch (_: UnknownHostException) {
        throw MyWeatherException.NetworkException.NoInternetException
    } catch (_: SocketTimeoutException) {
        throw MyWeatherException.NetworkException.TimeoutException
    } catch (_: SSLException) {
        throw MyWeatherException.NetworkException.ServerException
    }  catch (_: Exception) {
        throw MyWeatherException.NetworkException.UnknownNetworkException
    }
}

suspend inline fun <reified T> getClassByResponse(response: HttpResponse, json: Json): T {
    return json.decodeFromString<T>(response.bodyAsText())
}