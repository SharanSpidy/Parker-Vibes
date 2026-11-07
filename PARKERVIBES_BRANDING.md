# parkervibes branding pass

This source tree is a fan-made personal rebrand of Echo Music.

## Applied in this pass
- Android launcher label changed to `parkervibes`.
- Launcher icon assets replaced with the Peter Parker / collectible-inspired concept artwork.
- Default Compose theme seed changed to a Spider-Man-inspired red (`#E51C2A`) and system dynamic colors are no longer forced over the brand palette.
- Music widget accent colors changed to red / dark-red tones.
- Adaptive launcher icon background changed to near-black.

## Intentionally preserved
- Original Android application ID (`echo.music.iad1tya`) to avoid changing the package identity unnecessarily.
- Original music playback, downloads, search, library, lyrics, and service implementation.
- Existing project modules, dependencies, and licensing files.

## Important status
This is the first branding pass, not a complete screen-by-screen Marvel redesign. The home, explore, library, and full player layouts still use the existing Echo Music Compose components. Their full visual redesign needs targeted work in the relevant screens and should be reviewed on an Android emulator/device.

The generated artwork is a fan-made concept asset. This is not an official Marvel product or endorsement.

## Second implementation milestone (source update)
- Added a PARKER VIBES / MARVEL EDITION brand header to the existing Home feed, using the bundled decorative BBH Bartle display font for the wordmark and readable typography for supporting text.
- Added a selectable 3-column Marvel emblem collection in Settings > App Icon. The 20 emblems are cropped from the user's supplied reference sheet and bundled at Android launcher densities.
- Added 20 Android `activity-alias` launcher entries and wired them to the existing icon preference and icon switching utility. Selection is previewed in the grid and applied with an explicit button; the default icon can be restored.
- Updated launcher labels to `Parker Vibes` and added the supplied Avengers cosmic artwork as an in-app drawable resource for subsequent theme work.

## Verification status
- AndroidManifest.xml parses successfully.
- All 20 launcher image resources exist in all five density folders.
- APK build was attempted with `:app:assembleUniversalFossDebug`; it could not start because this environment cannot resolve `services.gradle.org` to download the project's Gradle 9.8.2 distribution. No APK build or runtime test is claimed.
- The broader Explore, Library, Now Playing and theme-specific redesign remains future work; current upstream playback/navigation architecture is retained.

## UI milestone update (2026-11-08)
- Added a reusable `ParkerVibesBrandBanner` Compose component using the existing decorative display font, a cosmic dark gradient, red accent border, and the already-bundled Spider-Man emblem.
- Replaced the earlier plain text-only Home branding row with the shared banner.
- Added the same branded banner to Explore and to both list and grid modes of the Library mix screen.
- Kept the existing Home/Explore/Library view models, song/playlist item composables, click handlers, queue operations, navigation routes, and playback connection intact.
- The Now Playing screen still uses the original fully functional Echo Music player controls and existing artwork/seek/queue/audio-output implementations. It has not yet received a dedicated Parker Vibes layout pass.

## Current milestone limits
- This is a partial UI pass, not completion of the requested full redesign.
- No emulator/device screenshots are available from this environment; generated concept images are design references, not runtime screenshots.
- Gradle build remains blocked by DNS/network resolution in this environment (`services.gradle.org`, `dl.google.com`, and `repo.maven.apache.org` all fail name resolution). The repository requests Gradle 9.8.2, AGP 9.0.0, Kotlin 2.3.10, and Java 21. No APK or runtime playback test is claimed.
