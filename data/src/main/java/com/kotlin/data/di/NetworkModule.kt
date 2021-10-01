package com.kotlin.data.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.kotlin.data.BuildConfig
import com.kotlin.data.api.LoginAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideLoginApiService(retrofit: Retrofit): LoginAPI =
        retrofit.create(LoginAPI::class.java)



    @Provides
    @Singleton
    fun provideGsonRetrofit(
        httpClient: OkHttpClient.Builder,
        convertFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://demo.com")
            .client(httpClient.build())
            .addConverterFactory(convertFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
        val httpClient = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(httpLoggingInterceptor)
        }
        httpClient.retryOnConnectionFailure(true)
        return httpClient

    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    /* @Provides
     @Singleton
     fun provideObjectMapper(): ObjectMapper = ObjectMapper()
         .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
         .enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)
         .registerModule(KotlinModule())
 */
    @Provides
    @Singleton
    fun provideJacksonConverterFactory(): JacksonConverterFactory =
        JacksonConverterFactory.create()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()


}