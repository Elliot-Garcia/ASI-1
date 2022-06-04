# Requêtes envoyées par transaction

## Requêtes à cards
- getCard (body contient **templateId** + ...)
  - Type `GET`
  - Chemin `/cards/{cardId}`
- deleteCard
  - Type`DELETE`
  - Chemin `/cards/{cardId}`
- createCard
  - Type `POST` 
  - Chemin `/cards` 
  - Body: `templateId`, `userId`

## Requêtes à account
- getUser (body contient **solde** + ...)
  - Type `GET`
  - Chemin `/account/{userId}`
- balanceAdd
  - Type `PUT`
  - Chemin `/account/{userId}/balance/{sommeAjoutée}`

## Requêtes à template
- getTemplate (body contient **buyPrice** + **sellPrice** + ...)
  - Type `GET`
  - Chemin `/template/{templateId}`