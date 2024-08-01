import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import uz.ssh.newsapp.presentation.Dimens
import uz.ssh.newsapp.presentation.common.shimmerEffect
import uz.ssh.newsapp.utill.Constant

@Composable
fun ArticleCardShimmerEffect(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Row(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(Constant.ARTICLE_CARD_SIZE)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = Constant.EXTRA_SMALL_PADDING)
                .height(Constant.ARTICLE_CARD_SIZE)
        ) {
            Box(
                modifier = Modifier
                    .height(30.dp)
                    .fillMaxSize()
                    .padding(horizontal = Dimens.MediumPadding)
                    .shimmerEffect()
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                        .height(15.dp)
                        .padding(horizontal = Dimens.MediumPadding)
                        .shimmerEffect()
                )
            }

        }
    }
}