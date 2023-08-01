package com.example.amphibiansapp.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibiansapp.R
import com.example.amphibiansapp.data.AmphibiansPhotos

@Composable
fun LoadingScreen(modifier: Modifier) {

}

@Composable
fun ErrorScreen(modifier: Modifier) {

}

@Composable
fun HomeScreen(amphiUiState:AmphibiansUiState) {

    when (amphiUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        is AmphibiansUiState.Success -> PhotoGridScreen(photos = amphiUiState.photos)
        is AmphibiansUiState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())

    }
}

@Composable
fun AmphibiansBar(photo : AmphibiansPhotos, modifier: Modifier = Modifier){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp )
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(photo.imgSrc)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.amphibian_photo),
            contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth(),
            error = painterResource(id = R.drawable._0442962801658079186),
            placeholder = painterResource(id = R.drawable._0442962801658079186)

        )
    }
}
@Composable
fun PhotoGridScreen(photos: List<AmphibiansPhotos>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(4.dp),
        modifier = Modifier.fillMaxSize() )  {
        items(items = photos, key = { photo -> photo.id}) { photo ->
            AmphibiansBar(
                photo,
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
            )
        }

    }

}