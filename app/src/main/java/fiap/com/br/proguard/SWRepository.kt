package fiap.com.br.proguard

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level

private val api by lazy {
    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = Level.BODY
        })
        .build()
    return@lazy Retrofit.Builder()
        .baseUrl("https://swapi.co")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(SWAPI::class.java)
}

interface SWAPI {
    @GET("api/people/{people}")
    fun getPeople(@Path("people") people: Int): Call<SWPeople>
}

object SWRepository {
    fun getPeople(people: SWPeoples, onComplete: (SWPeople?) -> Unit) {
        api.getPeople(people.id).enqueue(object : Callback<SWPeople> {
            override fun onResponse(call: Call<SWPeople>?, response: Response<SWPeople>?) {
                onComplete(response?.body())
            }

            override fun onFailure(call: Call<SWPeople>?, t: Throwable?) {
                onComplete(null)
            }
        })
    }
}