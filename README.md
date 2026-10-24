# Android Architecture

A sample Android application built to explore **Clean Architecture, MVVM, and modern Android development practices** using Kotlin and Jetpack Compose.

The project demonstrates how to separate UI, business logic, and data operations to make an application easier to maintain, test, and extend.

## ✨ Features

- Fetch person data from a remote REST API.
- Store and retrieve data locally using Room.
- Display data using Jetpack Compose.
- Manage UI state with ViewModel.
- Separate application logic into distinct architectural layers.
- Use repositories to abstract data sources.
- Implement dependency injection with Hilt.
- Support offline data access through local persistence.

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Kotlin | Programming language |
| Jetpack Compose | Declarative UI |
| MVVM | Presentation architecture |
| Clean Architecture | Separation of concerns |
| ViewModel | UI state management |
| Kotlin Coroutines | Asynchronous operations |
| Room | Local database |
| Retrofit | REST API communication |
| Hilt | Dependency injection |
| Navigation Compose | Screen navigation |

## 🏗️ Architecture

The application follows a layered architecture to separate responsibilities.

```text
app/
├── presentation/
│   ├── screen/
│   └── viewmodel/
│
├── domain/
│   ├── model/
│   ├── repository/
│   └── usecase/
│
└── data/
    ├── local/
    ├── remote/
    ├── mapper/
    └── repository/
```

*The directory structure above illustrates the intended organization; adapt it to match the actual project.*

### Presentation Layer
- Displays application UI using Jetpack Compose.
- Observes UI state from ViewModel.
- Handles user interactions.

### Domain Layer
- Contains business logic and use cases.
- Defines repository contracts.
- Remains independent of Android framework and data-source implementations.

### Data Layer
- Fetches data from the remote API.
- Persists data using Room.
- Implements repository contracts.
- Maps data models between layers.

## 🔄 Data Flow

```text
Jetpack Compose UI
        ↓
    ViewModel
        ↓
     Use Case
        ↓
    Repository
        ↓
Remote API / Room Database
```

This separation helps keep business logic independent of UI implementation and data-source details.

## 🎯 Learning Objectives

This project is intended to practise:

- Applying Clean Architecture principles in Android.
- Understanding the relationship between MVVM and Clean Architecture.
- Separating responsibilities across application layers.
- Managing asynchronous operations with Kotlin Coroutines.
- Integrating REST APIs with local persistence.
- Using dependency injection to manage dependencies.
- Writing maintainable and reusable Android code.

## 🚀 Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/paulpolash/Android-Architecture.git
   ```

2. Open the project in Android Studio.
3. Allow Gradle to sync.
4. Configure any required API settings or credentials.
5. Run the application on an emulator or Android device.

## 📌 Project Status

This is a learning project focused on understanding and practising modern Android application architecture.

## 👨‍💻 Author

**Paul Polash**

- GitHub: [@paulpolash](https://github.com/paulpolash)

---

*Built with Kotlin and Jetpack Compose.*
