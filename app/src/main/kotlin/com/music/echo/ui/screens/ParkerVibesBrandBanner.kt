package echo.music.iad1tya.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import echo.music.iad1tya.R

/** Shared Parker Vibes identity banner. Content remains informational; navigation and playback
 * actions continue to be owned by the original screens and view models. */
@Composable
fun ParkerVibesBrandBanner(
  modifier: Modifier = Modifier,
  eyebrow: String = "YOUR MUSIC. YOUR UNIVERSE.",
  compact: Boolean = false,
) {
  val displayFont = FontFamily(Font(R.font.bbh_bartle_regular))
  Box(
    modifier =
      modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(if (compact) 20.dp else 26.dp))
        .background(
          Brush.linearGradient(
            listOf(Color(0xFF090D20), Color(0xFF21113C), Color(0xFF4B101B), Color(0xFF100B18))
          )
        )
        .border(1.dp, Color(0x66E51C2A), RoundedCornerShape(if (compact) 20.dp else 26.dp))
        .padding(horizontal = 18.dp, vertical = if (compact) 12.dp else 18.dp)
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text(
            "PARKER",
            fontFamily = displayFont,
            fontSize = if (compact) 23.sp else 29.sp,
            fontWeight = FontWeight.Black,
            color = Color.White,
            letterSpacing = 0.5.sp
          )
          Spacer(Modifier.width(5.dp))
          Text(
            "VIBES",
            fontFamily = displayFont,
            fontSize = if (compact) 23.sp else 29.sp,
            fontWeight = FontWeight.Black,
            color = Color(0xFFFF3348),
            letterSpacing = 0.5.sp
          )
        }
        Spacer(Modifier.height(4.dp))
        Text(
          eyebrow,
          color = Color(0xFFE5DDF7),
          style = MaterialTheme.typography.labelSmall,
          letterSpacing = 1.4.sp,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
        if (!compact) {
          Spacer(Modifier.height(7.dp))
          Text(
            "✦  SPIDER-VERSE FREQUENCY  ✦",
            color = Color(0xFFFFD166),
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.8.sp
          )
        }
      }
      Box(
        modifier = Modifier.size(if (compact) 48.dp else 66.dp).clip(CircleShape)
          .background(Color(0xFF17101D)).border(1.dp, Color(0x99FF4356), CircleShape),
        contentAlignment = Alignment.Center
      ) {
        Image(
          painter = painterResource(R.mipmap.spider_man_icon),
          contentDescription = "Spider-Man emblem",
          modifier = Modifier.size(if (compact) 39.dp else 54.dp).clip(CircleShape)
        )
      }
    }
  }
}
