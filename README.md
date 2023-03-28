## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.
- [Dependency Injection](https://developer.android.com/training/dependency-injection) - 
  - [Koin](https://insert-koin.io/docs/reference/koin-core/dsl) - Koin is a dependency injection framework for Kotlin developers and it is written in pure Kotlin.
  
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Gson](https://github.com/google/gson) - Gson is a Java library that can be used to convert Java Objects into their JSON representation.
- [Gson Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) - A Converter which uses Gson for serialization to and from JSON.
- [Logging-Interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) - An OkHttp interceptor which logs HTTP request and response data.

- [Glide](https://github.com/bumptech/glide) - Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
- [Paging](https://developer.android.com/jetpack/androidx/releases/paging?hl=en) - The Paging Library makes it easier for you to load data gradually and gracefully within your app's RecyclerView.
- [Navigation](https://developer.android.com/guide/navigation?hl=en) - Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app.
- [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - For writing Gradle build scripts using Kotlin.

## Lint ✅
This project uses [***GitHub Super Linter***](https://github.com/github/super-linter) which is Combination of multiple linters to install as a GitHub Action.

Following Linters are used internally by super linter (enabled for this project):
- XML: [LibXML](http://xmlsoft.org/)
- Kotlin: [ktlint](https://github.com/pinterest/ktlint)


## [`Detekt`](https://detekt.dev/) 🗡️
Detekt helps you write cleaner Kotlin code so you can focus on what matters the most building amazing software.

[![Dagger2 Version](https://img.shields.io/static/v1?label=Foodium&message=Dagger2-DI&color=brightgreen&logo=android)](https://github.com/PatilShreyas/Foodium/tree/dev-hilt-android)


## [`Koin`](https://insert-koin.io/) DI Version 🗡️
If you want to use *Koin - Dependency Injection framework* in app then visit below repository.

[![Koin Version](https://img.shields.io/badge/PranayPatel512-Foodium-blue.svg?style=flat-square&logo=github)](https://github.com/pranaypatel512/Foodium)

**Contributed By:** [JohanForce](https://github.com/johanforce/)


# Package Structure
    .
    |                       # Base Recycleview/ DiffUtil
    │                       # Base UI: Activity/ Fragment/ Dialog
    ├── base                # Base ViewModel
    │  
    ├── data   
    │   ├── entity          # For data handling.
    │   ├── local           # Local Persistence Database. Room (SQLite) database
    |   │   ├── dao         # Data Access Object for Room   
    │   ├── remote          # Remote Data Handlers     
    |   │   ├── api         # Retrofit API for remote end point.
    │   └── repository      # Single source of data.
    |
    ├── domain             
    │   ├── mapper          # converter to model
    │   ├── model           # Model classes
    │   ├── repository      # interface repository from data layer
    │   └── usecase         # implement data flow logic
    │
    │
    ├── di                  # Dependency Injection             
    │   ├── builder         # Activity Builder
    │   ├── component       # DI Components       
    │   └── module          # DI Modules
    |
    ├── ui                  # Activity/View layer
    │   ├── base            # Base View
    │   ├── main            # Main Screen Activity & ViewModel
    |   │   ├── adapter     # Adapter for RecyclerView
    |   │   └── viewmodel   # ViewHolder for RecyclerView   
    │   └── details         # Detail Screen Activity and ViewModel
    |
    └── common/utils              # Utility Classes / Kotlin extensions


## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

## Contact
If you need any help, you can connect with me.

Visit:- [Johan Force](https://github.com/johanforce/)


# Android Architecture Blueprints - Use Cases/Interactors in Domain layer
### Summary
This sample is written in Kotlin which uses the following Architecture Components:
- ViewModel
- LiveData
- Navigation
- Room

The layer called `domain` where the Use Cases (also called Interactors) live. The
`domain` layer is where the business logic happens, which is the code that determines what
the app _does_ with the data coming from the repository before it's exposed to the UI for
display.

The TMDb app is too simple to showcase a complete representation of
[Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html),
but it adheres to some of its rules, which work well in a modern Android application: separation
of concerns, high level of abstraction and the dependency rule, which in our case means that layers
only know about what's directly underneath them:
- Presentation layer knows about use cases (domain layer).
- Domain layer knows about repository (data layer) but not the Presentation layer.
- Data layer doesn't know about domain or presentation layers.

This allows for easier testing and maintenance and recommended for bigger projects (alongside
modularization).

### Differences with master

- ViewModels don't receive a repository but a set of Use Cases, which are reused throughout the
  presentation layer.
- Business logic that was present in ViewModels is moved to Use Cases. This is important because
  ViewModels tend to grow quickly in size in real applications.


### Key files

The only relevant use case in this example is `GetFavoriteMoviesUseCase`. It contains some business logic
that used to be in the ViewModel. It's decoupled from the view so it can be thoroughly unit tested
in `GetFavoriteMoviesUseCaseTest`.
