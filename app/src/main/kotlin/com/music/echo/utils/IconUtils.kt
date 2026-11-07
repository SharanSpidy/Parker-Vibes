package echo.music.iad1tya.utils

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager

enum class AppIconType(val value: Int) {
  DEFAULT(0),
  LEGACY(1),
  STATIC(2),
  CAT(3),
  CRAZY_BLUE(4),
  POOKIE(5),
  SKY(6),
  ECHO_CAT(7),
  BILLIE_EILISH(13),
  SABRINA_CARPENTER(14),
  SABRINA_CARPENTER_2(15),
  CRAFT(16),
  SADIE(17),
  NEON_GLASS(18),
  MILLIE_BOBBY_BROWN(19),
  CAPTAIN_AMERICA(20), ARC_REACTOR(21), STARK_TECH(22), HULK(23),
  BLACK_WIDOW(24), HAWKEYE(25), SCARLET_WITCH(26), LOKI(27),
  SPIDER_MAN(28), BLACK_PANTHER(29), WEB_SLINGER(30), GUARDIANS(31),
  CAPTAIN_MARVEL(32), ANT_MAN(33), WINTER_SOLDIER(34), SHIELD(35),
  X_MEN(36), PUNISHER(37), DEADPOOL(38), AVENGERS(39)
}

object IconUtils {
  fun setIcon(context: Context, iconType: AppIconType) {
    val pm = context.packageManager

    val dynamic = ComponentName(context, "${context.packageName}.MainActivityAlias")
    val legacy = ComponentName(context, "${context.packageName}.MainActivityLegacy")
    val static = ComponentName(context, "${context.packageName}.MainActivityStatic")
    val cat = ComponentName(context, "${context.packageName}.MainActivityCat")
    val crazyBlue = ComponentName(context, "${context.packageName}.MainActivityCrazyBlue")
    val pookie = ComponentName(context, "${context.packageName}.MainActivityPookie")
    val sky = ComponentName(context, "${context.packageName}.MainActivitySky")
    val echoCat = ComponentName(context, "${context.packageName}.MainActivityEchoCat")
    val billieEilish = ComponentName(context, "${context.packageName}.MainActivityBillieEilish")
    val sabrina = ComponentName(context, "${context.packageName}.MainActivitySabrina")
    val sabrina2 = ComponentName(context, "${context.packageName}.MainActivitySabrina2")
    val craft = ComponentName(context, "${context.packageName}.MainActivityCraft")
    val sadie = ComponentName(context, "${context.packageName}.MainActivitySadie")
    val neonGlass = ComponentName(context, "${context.packageName}.MainActivityNeonGlass")
    val millie = ComponentName(context, "${context.packageName}.MainActivityMillie")
    val captainAmerica = ComponentName(context, "${context.packageName}.MainActivityCaptainAmerica")
    val arcReactor = ComponentName(context, "${context.packageName}.MainActivityArcReactor")
    val starkTech = ComponentName(context, "${context.packageName}.MainActivityStarkTech")
    val hulk = ComponentName(context, "${context.packageName}.MainActivityHulk")
    val blackWidow = ComponentName(context, "${context.packageName}.MainActivityBlackWidow")
    val hawkeye = ComponentName(context, "${context.packageName}.MainActivityHawkeye")
    val scarletWitch = ComponentName(context, "${context.packageName}.MainActivityScarletWitch")
    val loki = ComponentName(context, "${context.packageName}.MainActivityLoki")
    val spiderMan = ComponentName(context, "${context.packageName}.MainActivitySpiderMan")
    val blackPanther = ComponentName(context, "${context.packageName}.MainActivityBlackPanther")
    val webSlinger = ComponentName(context, "${context.packageName}.MainActivityWebSlinger")
    val guardians = ComponentName(context, "${context.packageName}.MainActivityGuardians")
    val captainMarvel = ComponentName(context, "${context.packageName}.MainActivityCaptainMarvel")
    val antMan = ComponentName(context, "${context.packageName}.MainActivityAntMan")
    val winterSoldier = ComponentName(context, "${context.packageName}.MainActivityWinterSoldier")
    val shield = ComponentName(context, "${context.packageName}.MainActivityShield")
    val xMen = ComponentName(context, "${context.packageName}.MainActivityXMen")
    val punisher = ComponentName(context, "${context.packageName}.MainActivityPunisher")
    val deadpool = ComponentName(context, "${context.packageName}.MainActivityDeadpool")
    val avengers = ComponentName(context, "${context.packageName}.MainActivityAvengers")

    pm.setComponentEnabledSetting(
      dynamic,
      if (iconType == AppIconType.DEFAULT) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      legacy,
      if (iconType == AppIconType.LEGACY) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      static,
      if (iconType == AppIconType.STATIC) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      cat,
      if (iconType == AppIconType.CAT) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      crazyBlue,
      if (iconType == AppIconType.CRAZY_BLUE) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      pookie,
      if (iconType == AppIconType.POOKIE) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      sky,
      if (iconType == AppIconType.SKY) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      echoCat,
      if (iconType == AppIconType.ECHO_CAT) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      billieEilish,
      if (iconType == AppIconType.BILLIE_EILISH) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      sabrina,
      if (iconType == AppIconType.SABRINA_CARPENTER) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      sabrina2,
      if (iconType == AppIconType.SABRINA_CARPENTER_2)
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      craft,
      if (iconType == AppIconType.CRAFT) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      sadie,
      if (iconType == AppIconType.SADIE) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      neonGlass,
      if (iconType == AppIconType.NEON_GLASS) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      millie,
      if (iconType == AppIconType.MILLIE_BOBBY_BROWN) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      captainAmerica,
      if (iconType == AppIconType.CAPTAIN_AMERICA) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      arcReactor,
      if (iconType == AppIconType.ARC_REACTOR) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      starkTech,
      if (iconType == AppIconType.STARK_TECH) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      hulk,
      if (iconType == AppIconType.HULK) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      blackWidow,
      if (iconType == AppIconType.BLACK_WIDOW) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      hawkeye,
      if (iconType == AppIconType.HAWKEYE) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      scarletWitch,
      if (iconType == AppIconType.SCARLET_WITCH) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      loki,
      if (iconType == AppIconType.LOKI) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      spiderMan,
      if (iconType == AppIconType.SPIDER_MAN) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      blackPanther,
      if (iconType == AppIconType.BLACK_PANTHER) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      webSlinger,
      if (iconType == AppIconType.WEB_SLINGER) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      guardians,
      if (iconType == AppIconType.GUARDIANS) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      captainMarvel,
      if (iconType == AppIconType.CAPTAIN_MARVEL) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      antMan,
      if (iconType == AppIconType.ANT_MAN) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      winterSoldier,
      if (iconType == AppIconType.WINTER_SOLDIER) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      shield,
      if (iconType == AppIconType.SHIELD) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      xMen,
      if (iconType == AppIconType.X_MEN) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      punisher,
      if (iconType == AppIconType.PUNISHER) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      deadpool,
      if (iconType == AppIconType.DEADPOOL) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
    pm.setComponentEnabledSetting(
      avengers,
      if (iconType == AppIconType.AVENGERS) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
      else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
      PackageManager.DONT_KILL_APP
    )
  }
}
