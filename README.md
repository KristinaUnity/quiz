# quiz

Project demonstrates database REST API common patterns.    

## Description

The only one project logical entity is quiz blank form. It consists of
questions, question consists of answers. Blank forms stored in relation
database and may be created/readed/updated by REST API.

Blank form JSON representation is

```json
{
  "name": "Blank form name",
  "description": "Blank form description",
  "questions": [{
      "num": 0,
      "text": "Question 1",
      "answers": [{
          "num": 0, "text": "Answer 1"
        }, {
          "num": 1, "text": "Answer 2"
        }]
    }, {
      "num": 1,
      "text": "Question 2",
      "answers": [{
          "num": 0, "text": "Answer 1"
        }]
    }]
}
```

To build project use
```
./gradlew build
```

To start application
```
java -jar build/lib/quiz-{version}.jar
```

Application has REST methods, for example

| Method                                   | Description       |
| ---------------------------------------- |:-----------------:|
| `GET localhost:8080/api/blank-form/{id}` | read blank form   |
| `POST localhost:8080/api/blank-form `    | create blank form |
| `PUT localhost:8080/api/blank-form/{id}` | update blank form |

H2 in-memory database used for storing data. There's one test blank form
(with id 1) in database after start.

You can use H2 console `localhost:8080/console` to view and modify data. 

