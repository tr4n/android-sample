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
