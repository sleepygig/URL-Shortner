# URL Shortener

A simple and efficient URL Shortener developed using **Spring Boot**, **JPA**, and **Google's Guava Murmur3** hashing function. This application allows users to shorten long URLs, making sharing links easier and more manageable.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Postman Testing](#postman-testing)
- [License](#license)
- [Contact](#contact)

## Features

- **URL Shortening**: Transform long URLs into short, shareable links.
- **Hashing**: Utilizes Murmur3 hashing to generate unique shortened URLs.
- **Efficient Storage**: Stores URLs in an H2 SQL database for quick access.
- **RESTful API**: Provides endpoints for creating and retrieving shortened URLs.
- **User-Friendly**: Optimized for a seamless user experience.

## Technologies Used

- **Spring Boot**: Framework for building the application.
- **JPA**: For data persistence and interaction with the database.
- **Google Guava**: Utilized for the Murmur3 hashing function.
- **H2 Database**: In-memory SQL database for storing shortened URLs.
- **Postman**: For testing API endpoints.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- H2 Database

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/url-shortener.git
   cd url-shortener
