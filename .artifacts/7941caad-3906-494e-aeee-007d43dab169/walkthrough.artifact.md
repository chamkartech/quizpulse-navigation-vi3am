# Walkthrough - Launch Crash Fixed

I have resolved the crash that occurred when opening the app.

## The Issue
The app was crashing with a `java.lang.IllegalStateException` because the code was calling `setupActionBarWithNavController(...)` in `MainActivity`, but the activity did not have a `Toolbar` set as its action bar. Additionally, the theme being used (`Theme.Material3.DayNight.NoActionBar`) explicitly disabled the default system Action Bar.

## Changes Made

### 1. Layout Update
- **[activity_main.xml](file:///D:/Documents/Android Xml/quizpulse-navigation-vi3am/app/src/main/res/layout/activity_main.xml)**: Added a `MaterialToolbar` to the layout to serve as the app's top app bar.

```xml
<com.google.android.material.appbar.MaterialToolbar
    android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="?attr/colorPrimary"
    app:titleTextColor="?attr/colorOnPrimary" />
```

### 2. Activity Configuration
- **[MainActivity.kt](file:///D:/Documents/Android Xml/quizpulse-navigation-vi3am/app/src/main/java/com/example/quizpulse_navigation/MainActivity.kt)**: Added `setSupportActionBar(binding.toolbar)` before configuring navigation. This informs the system that our new `Toolbar` should act as the activity's Action Bar.

## Verification Results

### Manual Verification
- Deployed the app to the emulator.
- Verified that the app now opens without crashing.
- Confirmed that the `Toolbar` displays the correct title ("QuizPulse") and integrates with the `DrawerLayout`.

![App Running](file:///D:/Documents/Android Xml/quizpulse-navigation-vi3am/.artifacts/7941caad-3906-494e-aeee-007d43dab169/scratch/screenshot_fixed.png)

> [!NOTE]
> The app now correctly follows the Material 3 design guidelines by using a custom Toolbar while the theme remains `NoActionBar`.
