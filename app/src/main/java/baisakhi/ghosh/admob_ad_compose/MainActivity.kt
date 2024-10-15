package baisakhi.ghosh.admob_ad_compose

import LazyColumnWithAds
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.ads.AdSize
import itemList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            )
            {
                LazyColumnWithAds(itemList)
                InterstitialAd()
                Spacer(modifier = Modifier.height(50.dp))
                ShowBanner()
            }
        }
    }
}

@Composable
fun ShowBanner() {
    Column(modifier = Modifier.fillMaxSize()) {

//                Dimensions: 320x50
//                Description: The standard ad banner size, commonly used.
        BannerAd(adUnitId = "ca-app-pub-3940256099942544/6300978111", adSize = AdSize.BANNER)
        Spacer(modifier = Modifier.height(10.dp))

//                Dimensions: 320x100
//                Description: A larger banner than the standard size.
        BannerAd(adUnitId = "ca-app-pub-3940256099942544/6300978111", adSize = AdSize.LARGE_BANNER)
        Spacer(modifier = Modifier.height(10.dp))

//                Dimensions: 468x60
//                Description: Wider than the standard banner, suitable for tablets.
        BannerAd(adUnitId = "ca-app-pub-3940256099942544/6300978111", adSize = AdSize.FULL_BANNER)
        Spacer(modifier = Modifier.height(10.dp))

//                Dimensions: 728x90
//                Description: A large banner, generally used on tablets or wide screens.
        BannerAd(adUnitId = "ca-app-pub-3940256099942544/6300978111", adSize = AdSize.LEADERBOARD)
        Spacer(modifier = Modifier.height(10.dp))

//                Dimensions: 300x250
//                Description: A medium-sized ad, generally used in more prominent positions.
        BannerAd(
            adUnitId = "ca-app-pub-3940256099942544/6300978111",
            adSize = AdSize.MEDIUM_RECTANGLE
        )
        Spacer(modifier = Modifier.height(10.dp))

//                Dimensions: Height is flexible, width matches the screen width.
//                Description: Adjusts to fill the available space in the app.
        BannerAd(adUnitId = "ca-app-pub-3940256099942544/6300978111", adSize = AdSize.FLUID)
    }
}

