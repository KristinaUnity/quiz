# quiz

Demo project illustrates database REST API common patterns.    

## Use-case

There's quiz blank forms. Blank form consists of questions, question
consists of answers. Blank forms stored in relation database. There's
REST API for working with blank forms.

Blank form JSON representation is

```json
{
  "name": "Blank form name",
  "description": "Blank form description",
  "questions": [
    {
      "num": 0,
      "text": "Question 1",
      "answers": [
        {
          "num": 0,
          "text": "Answer 1"
        },
        {
          "num": 1,
          "text": "Answer 2"
        }
      ]
    },
    {
      "num": 1,
      "text": "Question 2",
      "answers": [
        {
          "num": 0,
          "text": "Answer 1"
        }
      ]
    }
  ]
}
```


