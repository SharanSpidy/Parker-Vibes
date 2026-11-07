@file:OptIn(ExperimentalMaterial3Api::class)

package echo.music.iad1tya.ui.screens.settings

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavController
import echo.music.iad1tya.LocalPlayerAwareWindowInsets
import echo.music.iad1tya.R
import echo.music.iad1tya.constants.AppIconTypeKey
import echo.music.iad1tya.utils.AppIconType
import echo.music.iad1tya.utils.IconUtils
import echo.music.iad1tya.utils.rememberEnumPreference
import kotlinx.coroutines.launch

@Composable
fun AppIconSettingsScreen(
  navController: NavController,
  activity: Activity,
  snackbarHostState: SnackbarHostState
) {
  val (appIconType, onAppIconTypeChange) =
    rememberEnumPreference(AppIconTypeKey, defaultValue = AppIconType.DEFAULT)
  val coroutineScope = rememberCoroutineScope()
  var pendingIconType by remember { mutableStateOf(appIconType) }

  fun handleIconChange(iconType: AppIconType) {
    if (appIconType == iconType) return
    onAppIconTypeChange(iconType)
    IconUtils.setIcon(activity, iconType)
    coroutineScope.launch {
      val result =
        snackbarHostState.showSnackbar(
          message = "Icon updated, restart to apply",
          actionLabel = "Restart"
        )
      if (result == SnackbarResult.ActionPerformed) {
        val packageManager = activity.packageManager
        val intent = packageManager.getLaunchIntentForPackage(activity.packageName)
        if (intent != null) {
          val componentName = intent.component
          val mainIntent = android.content.Intent.makeRestartActivityTask(componentName)
          activity.startActivity(mainIntent)
          Runtime.getRuntime().exit(0)
        }
      }
    }
  }

  Scaffold(
    containerColor = MaterialTheme.colorScheme.surface,
    topBar = {
      TopAppBar(
        title = { Text("App Icon", fontWeight = FontWeight.Bold) },
        navigationIcon = {
          IconButton(onClick = { navController.navigateUp() }) {
            Icon(painter = painterResource(R.drawable.arrow_back), contentDescription = "Back")
          }
        },
        colors =
          TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
      )
    }
  ) { innerPadding ->
    val icons =
      listOf(
        AppIconOption(AppIconType.CRAFT, "Craft", "Craft icon by CR3TO_", R.mipmap.ic_launcher_craft),
        AppIconOption(AppIconType.SADIE, "Sadie Sink", "Sadie Sink on community demand", R.mipmap.ic_launcher_sadie),
        AppIconOption(
          AppIconType.BILLIE_EILISH,
          "Billie Eilish",
          "billie eilish suggested by Lalo salamanca",
          R.mipmap.billie_eilish_icon
        ),
        AppIconOption(AppIconType.CAT, "Cat Icon", "A Pinkish cat-themed icon", R.mipmap.cat_icon),
        AppIconOption(
          AppIconType.CRAZY_BLUE,
          "Crazy Blue Icon",
          "A vibrant crazy blue icon",
          R.mipmap.crazy_blue_icon
        ),
        AppIconOption(
          AppIconType.ECHO_CAT,
          "Echo Cat",
          "A playful cat by Alarp_Svc",
          R.mipmap.echo_cat_icon
        ),
        AppIconOption(
          AppIconType.LEGACY,
          "Legacy Icon",
          "The OG Monochrome Icon",
          R.mipmap.legacy_icon
        ),
        AppIconOption(
          AppIconType.DEFAULT,
          "New Icon",
          "The standard vibrant icon",
          R.mipmap.ic_launcher
        ),
        AppIconOption(AppIconType.POOKIE, "Pookie Icon", "A Cute Pink icon", R.mipmap.pookie_icon),
        AppIconOption(
          AppIconType.SABRINA_CARPENTER,
          "Sabrina Carpenter",
          "Suggested by notdieinganymore",
          R.mipmap.ic_launcher_sabrina
        ),
        AppIconOption(
          AppIconType.SABRINA_CARPENTER_2,
          "Sabrina Carpenter 2",
          "Suggested by Falvik",
          R.mipmap.ic_launcher_sabrina2
        ),
        AppIconOption(AppIconType.SKY, "Sky Icon", "A beautiful sky-themed icon", R.mipmap.sky_icon),
        AppIconOption(
          AppIconType.NEON_GLASS,
          "Neon Glass",
          "A futuristic glowing neon glass icon",
          R.mipmap.ic_launcher_neon_glass
        ),
        AppIconOption(
          AppIconType.MILLIE_BOBBY_BROWN,
          "Millie Bobby Brown",
          "Millie Bobby Brown on community demand",
          R.mipmap.ic_launcher_millie
        ),
        AppIconOption(AppIconType.CAPTAIN_AMERICA, "Captain America", "Marvel collection", R.mipmap.captain_america_icon),
        AppIconOption(AppIconType.ARC_REACTOR, "Arc Reactor", "Marvel collection", R.mipmap.arc_reactor_icon),
        AppIconOption(AppIconType.STARK_TECH, "Stark Tech", "Marvel collection", R.mipmap.stark_tech_icon),
        AppIconOption(AppIconType.HULK, "Hulk", "Marvel collection", R.mipmap.hulk_icon),
        AppIconOption(AppIconType.BLACK_WIDOW, "Black Widow", "Marvel collection", R.mipmap.black_widow_icon),
        AppIconOption(AppIconType.HAWKEYE, "Hawkeye", "Marvel collection", R.mipmap.hawkeye_icon),
        AppIconOption(AppIconType.SCARLET_WITCH, "Scarlet Witch", "Marvel collection", R.mipmap.scarlet_witch_icon),
        AppIconOption(AppIconType.LOKI, "Loki", "Marvel collection", R.mipmap.loki_icon),
        AppIconOption(AppIconType.SPIDER_MAN, "Spider-Man", "Marvel collection", R.mipmap.spider_man_icon),
        AppIconOption(AppIconType.BLACK_PANTHER, "Black Panther", "Marvel collection", R.mipmap.black_panther_icon),
        AppIconOption(AppIconType.WEB_SLINGER, "Web Slinger", "Marvel collection", R.mipmap.web_slinger_icon),
        AppIconOption(AppIconType.GUARDIANS, "Guardians", "Marvel collection", R.mipmap.guardians_icon),
        AppIconOption(AppIconType.CAPTAIN_MARVEL, "Captain Marvel", "Marvel collection", R.mipmap.captain_marvel_icon),
        AppIconOption(AppIconType.ANT_MAN, "Ant-Man", "Marvel collection", R.mipmap.ant_man_icon),
        AppIconOption(AppIconType.WINTER_SOLDIER, "Winter Soldier", "Marvel collection", R.mipmap.winter_soldier_icon),
        AppIconOption(AppIconType.SHIELD, "S.H.I.E.L.D.", "Marvel collection", R.mipmap.shield_icon),
        AppIconOption(AppIconType.X_MEN, "X-Men", "Marvel collection", R.mipmap.x_men_icon),
        AppIconOption(AppIconType.PUNISHER, "Punisher", "Marvel collection", R.mipmap.punisher_icon),
        AppIconOption(AppIconType.DEADPOOL, "Deadpool", "Marvel collection", R.mipmap.deadpool_icon),
        AppIconOption(AppIconType.AVENGERS, "Avengers", "Marvel collection", R.mipmap.avengers_icon),
      ).sortedBy { it.title.lowercase() }

    Column(
      modifier =
        Modifier.fillMaxSize()
          .background(MaterialTheme.colorScheme.surface)
          .verticalScroll(rememberScrollState())
          .windowInsetsPadding(
            LocalPlayerAwareWindowInsets.current.only(WindowInsetsSides.Horizontal)
          )
          .padding(innerPadding)
          .padding(horizontal = 16.dp)
    ) {
      Spacer(modifier = Modifier.height(8.dp))

      Text(
        text = "Choose your launcher icon",
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 12.dp, start = 4.dp)
      )

      Column(modifier = Modifier.fillMaxWidth()) {
        Text(
          text = "MARVEL COLLECTION",
          style = MaterialTheme.typography.labelLarge,
          color = MaterialTheme.colorScheme.primary,
          fontWeight = FontWeight.ExtraBold,
          modifier = Modifier.padding(start = 4.dp, top = 12.dp, bottom = 10.dp)
        )
        icons.chunked(3).forEach { rowOptions ->
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(10.dp)
          ) {
            rowOptions.forEach { option ->
              val selected = pendingIconType == option.type
              Card(
                modifier = Modifier.weight(1f).padding(bottom = 10.dp).clickable { pendingIconType = option.type },
                shape = RoundedCornerShape(18.dp),
                border = if (selected) androidx.compose.foundation.BorderStroke(2.dp, MaterialTheme.colorScheme.primary) else null,
                colors = CardDefaults.cardColors(
                  containerColor = if (selected) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f) else MaterialTheme.colorScheme.surfaceContainerHigh
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = if (selected) 3.dp else 0.dp)
              ) {
                Column(
                  modifier = Modifier.fillMaxWidth().padding(horizontal = 6.dp, vertical = 12.dp),
                  horizontalAlignment = Alignment.CenterHorizontally
                ) {
                  Image(
                    painter = painterResource(option.iconRes),
                    contentDescription = option.title,
                    modifier = Modifier.size(62.dp).clip(RoundedCornerShape(16.dp))
                  )
                  Spacer(Modifier.height(8.dp))
                  Text(
                    text = option.title,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                    maxLines = 1,
                    color = MaterialTheme.colorScheme.onSurface
                  )
                  if (selected) {
                    Text("SELECTED", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                  }
                }
              }
            }
            repeat(3 - rowOptions.size) { Spacer(Modifier.weight(1f)) }
          }
        }
      }

      Button(
        onClick = { handleIconChange(pendingIconType) },
        enabled = pendingIconType != appIconType,
        modifier = Modifier.fillMaxWidth().padding(top = 6.dp, bottom = 12.dp)
      ) {
        Text(if (pendingIconType == AppIconType.DEFAULT) "Restore default icon" else "Apply selected icon")
      }

      Spacer(
        modifier =
          Modifier.windowInsetsPadding(
            LocalPlayerAwareWindowInsets.current.only(WindowInsetsSides.Bottom)
          )
      )
      Spacer(modifier = Modifier.height(16.dp))
    }
  }
}

data class AppIconOption(
  val type: AppIconType,
  val title: String,
  val description: String,
  val iconRes: Int
)

@Composable
fun AppIconRow(option: AppIconOption, isSelected: Boolean, onClick: () -> Unit) {
  Row(
    modifier =
      Modifier.fillMaxWidth()
        .clickable(onClick = onClick)
        .padding(horizontal = 20.dp, vertical = 16.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    val context = LocalContext.current
    val bitmap =
      remember(option.iconRes) {
        val drawable = ContextCompat.getDrawable(context, option.iconRes)
        drawable?.toBitmap(width = 192, height = 192)?.asImageBitmap()
      }

    Box(
      modifier = Modifier.size(40.dp).clip(RoundedCornerShape(12.dp)),
      contentAlignment = Alignment.Center
    ) {
      if (bitmap != null) {
        Image(
          bitmap = bitmap,
          contentDescription = null,
          modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(12.dp))
        )
      }
    }

    Spacer(modifier = Modifier.width(20.dp))

    Column(modifier = Modifier.weight(1f)) {
      Text(
        text = option.title,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onSurface
      )
      Spacer(modifier = Modifier.height(2.dp))
      Text(
        text = option.description,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
      )
    }

    Spacer(modifier = Modifier.width(8.dp))
    RadioButton(selected = isSelected, onClick = onClick)
  }
}
