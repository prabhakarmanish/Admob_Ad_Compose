import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.*

@Composable
fun LazyColumnWithAds(itemList: List<String>) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        MobileAds.initialize(context) {}
    }

    LazyColumn {
        itemsIndexed(itemList) { index, item ->
            // Your normal list item composable
            ListItemContent(item)

            // Show an ad after every 5 items
            if ((index +1) % 5 == 0) {
                var isAdLoaded by remember { mutableStateOf(false) }

                BannerAdWithConditionalSpacing(
                    adUnitId = "ca-app-pub-3940256099942544/6300978111",
                    adSize = AdSize.BANNER,
                    isAdLoaded = { loaded -> isAdLoaded = loaded }
                )

                if (isAdLoaded) {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun BannerAdWithConditionalSpacing(adUnitId: String, adSize: AdSize, isAdLoaded: (Boolean) -> Unit) {
    val context = LocalContext.current
    val adView = remember {
        AdView(context).apply {
            setAdSize(AdSize.FLUID)
            this.adUnitId = adUnitId
        }
    }

    // Load the ad
    val adRequest = AdRequest.Builder().build()
    adView.loadAd(adRequest)

    // Handle ad load success or failure
    adView.adListener = object : AdListener() {
        override fun onAdLoaded() {
            isAdLoaded(true)
        }

        override fun onAdFailedToLoad(p0: LoadAdError) {
            isAdLoaded(false)
        }
    }

    // Only show the ad if it's loaded
    if (adView.isLoading || adView.hasWindowFocus()) {
        AndroidView(
            factory = { adView },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ListItemContent(item: String) {
    Column {
        Text(text = item)
    }
}

val itemList = listOf(
    "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
    "Item 6", "Item 7", "Item 8", "Item 9", "Item 10",
    "Item 11", "Item 12", "Item 13", "Item 14", "Item 15"
)
