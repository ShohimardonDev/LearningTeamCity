package uz.ssh.newsapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import uz.ssh.newsapp.data.remote.dto.NewsResponse
import uz.ssh.newsapp.utill.Constant.NEW_API_KEY

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = NEW_API_KEY,
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = NEW_API_KEY,
    ): NewsResponse
}