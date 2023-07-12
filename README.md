# AmphibianExplorerApp

Amphibian Explorer App
The Amphibian Explorer App is a mobile application built with Jetpack Compose, utilizing Retrofit for networking, Kotlin serialization for JSON parsing, and Coil for image loading. The app displays a list of amphibians along with their details and images. The data is retrieved from the internet by making a network request to a JSON API. Each amphibian's information includes its name, type, description, and image URL.

Features
The app offers the following features:

Displaying a list of amphibians: The app fetches data from the provided JSON API using Retrofit and displays a list of amphibians using Jetpack Compose's UI components.

Showing amphibian details: When a user selects an amphibian from the list, the app presents detailed information about the selected amphibian, including its type, description, and an image loaded with Coil.

Getting Started
To run the Amphibian Explorer App locally, follow these steps:

Clone the repository.

Open the project in  Android Studio.


API Integration
The app retrieves amphibian data from the following JSON API: Amphibian JSON Data. This API provides a list of amphibians with their relevant information, such as name, type, description, and image URL.

To integrate the API into the app, Retrofit is used as the HTTP client. It handles the network request and JSON parsing using Kotlin serialization.

Dependencies
The Amphibian Explorer App relies on the following dependencies:

Retrofit: A type-safe HTTP client for making network requests and parsing JSON responses.

Jetpack Compose: A modern toolkit for building native UIs in Android using a declarative approach.

Kotlin serialization: A library for converting Kotlin objects to and from JSON representation.

Coil: An image loading library for efficiently displaying amphibian images.

Future Enhancements
Here are some potential enhancements that can be made to the app:

Implementing search functionality: Allow users to search for specific amphibians by name or type.

Adding favorite functionality: Enable users to mark specific amphibians as favorites for quick access.

Implementing caching mechanism: Introduce a caching mechanism to store previously fetched amphibian data, reducing network requests.

Improving UI/UX: Enhance the app's visual design and user experience to make it more intuitive and appealing.

Contributing
Contributions to the Amphibian Explorer App are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue on the repository. Feel free to fork the repository and submit pull requests with your proposed changes.
