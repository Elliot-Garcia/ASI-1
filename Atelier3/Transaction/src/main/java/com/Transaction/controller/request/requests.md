# Requêtes envoyées par transaction

## Requêtes à cards
- getCard (body contient **templateId** + ...)
  - Type `GET`
  - Chemin `/cards/card/{cardId}`
- deleteCard
  - Type`DELETE`
  - Chemin `/cards/card/{cardId}`
- createCard
  - Type `POST`
  - Chemin `/cards/card` 
  - Body `templateId`, `userId`
- findCard
  - Type `GET`
  - Chemin `/find/{userId}/{templateId}`

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