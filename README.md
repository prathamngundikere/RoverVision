# RoverVision

RoverVision is an Android application that fetches high-quality images captured by NASA's Curiosity rover from the [NASA Mars Rover Photos API](https://api.nasa.gov/). The app organizes images by Martian days (sols), allowing users to browse and explore stunning views of the Martian surface.

## Features
- 📸 **View Mars Rover Images** - Browse high-quality images taken by the Curiosity rover.
- 🗂️ **Organized by Sols (Martian Days)** - Images are categorized by the specific sol (day) they were captured on Mars.
- 🔍 **Image Zoom Feature** - Zoom into images for a detailed look at the Martian surface.
- ⬇️ **Download Images** - Save images directly to your device.
- 🔄 **Offline Caching** - View previously loaded images without an internet connection.
- 🔍 **Search by Camera Type** - Filter images based on different rover cameras.
- 🛠 **Material 3 UI Design** - Modern and smooth UI following Google's Material 3 guidelines.
- ⚡ **Optimized Performance** - Efficient image loading and caching for a seamless experience.

## Download

[Download the latest version of the app](https://github.com/prathamngundikere/RoverVision/releases/latest)

## Screenshots

<div style="display: flex; flex-direction: row; flex-wrap: wrap; justify-content: center; gap: 10px">
<img src="https://github.com/prathamngundikere/RoverVision/blob/master/resources/home.png" alt="screenshot" width="30%">
<img src="https://github.com/prathamngundikere/RoverVision/blob/master/resources/imageScreen.png" alt="screenshot" width="30%">
</div>

## Demo

![App Screenshot](https://github.com/prathamngundikere/RoverVision/blob/master/resources/RoverVision.gif)

## Tech Stack
The app is built using the following technologies:
- **Kotlin** - Primary programming language.
- **Jetpack Compose** - Modern UI toolkit for Android.
- **Dagger Hilt** - Dependency injection framework.
- **Retrofit** - API client for fetching data from NASA's API.
- **Coil** - Image loading library for Jetpack Compose.
- **Room Database** - Local storage for caching images and metadata.
- **Firebase** - Backend support for authentication (Google Sign-In only).
- **MVVM Architecture** - Ensuring clean and maintainable code.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/prathamngundikere/RoverVision
   ```
2. Open the project in Android Studio.
3. Build and run the application on an emulator or physical device.

## API Key Setup
1. Get a free API key from [NASA Open APIs](https://api.nasa.gov/).
2. Add the API key in your `local.properties` file:
   ```properties
   NASA_API_KEY=your_api_key_here
   ```
3. Modify the `build.gradle` (Module) file to access the key:
   ```gradle
   buildConfigField "String", "NASA_API_KEY", "\"${NASA_API_KEY}\""
   ```
## Find a Bug?

If you find any bugs or have feature suggestions, feel free to open an issue or submit a pull request. Make sure to adhere to the following:
- Write clear and concise issue descriptions.
- Follow coding conventions and standards when submitting pull requests.

Contributions are always welcome!

## 🌐 Socials:
[![Instagram](https://img.shields.io/badge/Instagram-%23E4405F.svg?logo=Instagram&logoColor=white)](https://instagram.com/https://www.instagram.com/prathamngundikere?igsh=Z3E5ZTNxOGxoZ28=)  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-%230077B5.svg?logo=linkedin&logoColor=white)](https://linkedin.com/in/https://www.linkedin.com/in/prathamngundikere/)  
[![X](https://img.shields.io/badge/X-black.svg?logo=X&logoColor=white)](https://x.com/https://x.com/prathamng?t=IN1JcGFCc-4PWQkFSTKiOA&s=09)  
[![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?logo=YouTube&logoColor=white)](https://youtube.com/@https://youtube.com/@prathamngundikere?si=X5CQBQyWeVeNP8aV) 
