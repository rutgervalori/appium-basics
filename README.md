# Instructions (work in progress)

This is an Appium demo projects with a basic test setup.
It is for Android apps only (for iOS you'll need a Mac, see requirements: https://appium.io/)

## Before you can get started

Make sure Appium is installed \
See instructions at:
https://appium.io/

You'll need an Android device or emulator (you can create an emulator using android studio)

You'll need to have adb installed: \
https://developer.android.com/studio/command-line/adb \
adb comes with Android Studio or can be installed separately: \
https://developer.android.com/studio/releases/platform-tools

Download this project to your device (if you haven't already)

## Check if the project works
Start Appium: \
run 'appium &' from the command line

###Configure this project to connect to your Android device (or emulator)
Open the 'BaseTest' class
You'll need to change the value for 'deviceAndroidVersion' to the Android version of your device
You'll need to change the value for 'deviceName' to the name of your device \
To find out what your device name is, you can run 'adb devices' from the commandline

###Run a test
Go to the 'LoginTest' class in this project and press the green play button. \
This will run a couple of tests using an Android App that's provided in this project

## Use your own app and add tests

To use a different Android app copy your APK file to the 'Apps' folder in this project.\
Open the 'BaseTest' class and replace 'demo-app-debug.apk' with the name of your app.

### Find Elements:
https://appium.io/docs/en/writing-running-appium/finding-elements/#using-appium-desktop-to-locate-elements