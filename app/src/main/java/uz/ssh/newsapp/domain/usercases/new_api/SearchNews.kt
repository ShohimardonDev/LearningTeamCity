package uz.ssh.newsapp.domain.usercases.new_api

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.ssh.newsapp.domain.model.Article
import uz.ssh.newsapp.domain.repo.NewsRepo

class SearchNews(
    private val newsRepo: NewsRepo,
) {

    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> =
        newsRepo.searchNews(searchQuery, sources)
}