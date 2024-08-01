package uz.ssh.newsapp.data.remote.dto

import uz.ssh.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)