# Contributing to Selenium Data Driven Project

Thank you for your interest in contributing! This document provides guidelines for contributing to the project.

## Getting Started

1. Fork the repository
2. Clone your fork locally
3. Create a new branch for your feature or fix
4. Make your changes
5. Test your changes locally
6. Submit a pull request

## Development Setup

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher
- Chrome browser

### Installation
```bash
git clone https://github.com/YOUR_USERNAME/SeleniumDataDrivenProject.git
cd SeleniumDataDrivenProject
mvn clean install -DskipTests
```

## Running Tests

### Run all tests
```bash
mvn test
```

### Run specific test
```bash
mvn test -Dtest=GoogleSearchTest
```

## Code Style

- Follow Java naming conventions
- Use meaningful variable and method names
- Add comments for complex logic
- Keep methods focused and concise

## Adding New Tests

1. Create test class extending `BaseTest`
2. Add test methods with `@Test` annotation
3. Use `@DataProvider` for data-driven tests
4. Update `testng.xml` if needed
5. Add test data to `src/test/resources/testdata/`

## Pull Request Guidelines

1. **Branch naming**: Use descriptive names (e.g., `feature/add-login-test`, `fix/timeout-issue`)
2. **Commit messages**: Write clear, concise commit messages
3. **Testing**: Ensure all tests pass before submitting
4. **Documentation**: Update README if you add new features
5. **One feature per PR**: Keep pull requests focused

## Reporting Issues

When reporting issues, please include:
- Clear description of the problem
- Steps to reproduce
- Expected vs actual behavior
- Browser and OS information
- Screenshots if applicable

## Code Review Process

1. All submissions require review
2. GitHub Actions will automatically run tests
3. Address review comments promptly
4. Once approved, maintainers will merge

## Questions?

Feel free to open an issue for questions or discussions.

Thank you for contributing! 🎉
