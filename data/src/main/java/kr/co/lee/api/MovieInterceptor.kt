package kr.co.lee.api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class MovieInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return with(chain) {
            val newRequest = request().newBuilder()
                .addHeader("X-Naver-Client-Id", "LCnFzAWPnmeT2m1aFYyX")
                .addHeader("X-Naver-Client-Secret", "6GcGj2Emi0")
                .build()

            proceed(newRequest)
        }
    }
}