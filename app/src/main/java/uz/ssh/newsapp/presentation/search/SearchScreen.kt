package uz.ssh.newsapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import uz.ssh.newsapp.presentation.Dimens.MediumPadding
import uz.ssh.newsapp.presentation.common.ArticlesList
import uz.ssh.newsapp.presentation.common.SearchBar
import uz.ssh.newsapp.presentation.nvgraph.Route

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigate: (String) -> Unit,
) {

    Column(
        modifier = Modifier
            .padding(
                top = MediumPadding,
                start = MediumPadding,
                end = MediumPadding
            )
            .fillMaxSize()
            .statusBarsPadding(),

        ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { event(SearchEvent.SearchNews) })

        Spacer(modifier = Modifier.height(MediumPadding))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(articles = articles, onClick = { Route.DetailsScreen.route })
        }
    }

}