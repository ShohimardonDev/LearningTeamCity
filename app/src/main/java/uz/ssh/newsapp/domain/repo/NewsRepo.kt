package uz.ssh.newsapp.domain.repo

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.ssh.newsapp.domain.model.Article

interface NewsRepo {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>
}