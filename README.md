# 📰 News App (Jetpack Compose)

A modern Android News Application built using **Jetpack Compose** that fetches and displays real-time news articles from an external API.  
This project focuses on strong **Android fundamentals**, clean UI, and proper state handling — suitable for **Android internship and entry-level roles**.

---

## ✨ Features
- 🗞️ Fetch latest news articles
- 📂 Browse news by categories
- 🔍 Search news articles
- 📄 Read full news details
- 🔄 Loading & error state handling
- 🎨 Fully built with Jetpack Compose
- 📱 Smooth and responsive UI

---

## 🛠 Tech Stack
- **Language:** Kotlin
- **UI:** Jetpack Compose
- **Architecture:** MVVM (simple)
- **Networking:** Retrofit
- **Async:** Kotlin Coroutines
- **State Management:** StateFlow

> ⚠️ This project does **not** use Dependency Injection or Clean Architecture.  
> The goal was to strengthen core Android + Jetpack Compose concepts.

---

## 🧠 Architecture Overview (MVVM)

UI (Compose Screens)
↓
ViewModel
↓
Repository
↓
Retrofit API


- UI observes state from ViewModel
- ViewModel handles business logic
- Repository manages API calls

---

## 📸 Screenshots

| Home | Categories | Search |
|-----|------------|--------|
| ![Home](screenshots/Home.jpeg) | ![Categories](screenshots/NewsCategoryScreen.jpeg) | ![Search](screenshots/SearchScreen.jpeg) |

| News List | News Details |
|----------|--------------|
| ![List](screenshots/Home.jpeg) | ![Details](screenshots/DetailedNews.jpeg) |

---

## 🎥 Demo Video
👉 [Watch Demo Video](demo/Demo.mp4)

---

## 🚀 How to Run the Project

1. Clone the repository:

2. Open the project in Android Studio

3. Add your News API key
(Recommended using local.properties or BuildConfig)

4. Run the app on emulator or physical device
