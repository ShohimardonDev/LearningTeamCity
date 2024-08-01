package uz.ssh.newsapp.domain.usercases.new_api

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.ssh.newsapp.domain.model.Article
import uz.ssh.newsapp.domain.repo.NewsRepo

class GetNews(
    private val newsRepo: NewsRepo
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> =
        newsRepo.getNews(sources)
}