package uz.ssh.newsapp.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.ssh.newsapp.data.remote.NewsApi
import uz.ssh.newsapp.data.remote.NewsPagingSource
import uz.ssh.newsapp.data.remote.SearchNewsPagingSource
import uz.ssh.newsapp.domain.model.Article
import uz.ssh.newsapp.domain.repo.NewsRepo

class NewsRepoImpl(
    private val _newsApi: NewsApi,
) : NewsRepo {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(_newsApi, sources.joinToString(","))
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(_newsApi, searchQuery, sources.joinToString(","))
            }
        ).flow
    }
}