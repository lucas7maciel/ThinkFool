# Thinkfool
### A social network made so you can share your thoughts with friends all over the world!

## Endpoints
* *Auth*: Handles authentication-related tasks;
* *Post*: Gives access and allows you to manipulate user records;
* *Thinker*: Handles user-related data access and functions;

_Once the endpoints are complete this list will be replaced by a more detailed graph_

## Technologies
* **Java**: JDK 17 (or compatible);
* **Spring Boot**: Spring Boot 3.1.0 (or compatible);
* **PostgreSQL**: For storing posts and user data;
* **Maven**: For build management;

## Building the Project

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/lucas7maciel/ThinkFool.git](https://www.google.com/search?q=https://github.com/lucas7maciel/ThinkFool.git)
   ```

2. **Navigate to the project directory:**
```
cd ThinkFool
```

3. **Setup Maven (Optional):**
```
# For Linux
sudo apt-get update
sudo apt-get install maven

# For MacOS
brew update
brew install maven

# For Windows, you can follow [this link](https://maven.apache.org/install.html)
```

4. **Run the Application using Maven:**
```
mvn spring-boot:run
```