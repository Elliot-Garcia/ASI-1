
function testePost(){
    
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "https://asi2-backend-market.herokuapp.com/card");

    xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onload = () => console.log(xhr.responseText);

    let data = `{
        "name": "teste2-------------------------------->",
        "description": "description2-------------------------------->",
        "family": "family2-------------------------------->",
        "affinity": "affinity2-------------------------------->",
        "imgUrl": "http://medias.3dvf.com/news/sitegrab/gits2045.jpg",
        "smallImgUrl": "https://cdn.animenewsnetwork.com/thumbnails/fit600x1000/cms/feature/89858/05.jpg",
        "energy": 100,
        "hp": 81.19427,
        "defence": 69.24205,
        "attack": 3.1732023
    }`;

    xhr.send(data);
}

function getInput(){
    var data = {};

    var getInput = document.querySelectorAll(".field");
    var getSelect = document.querySelectorAll("select");


    console.log( getSelect );
    console.log( getInput );
    getInput.forEach( element => data[ element.children[1].name ] = element.children[1].value)

    console.log( data );
}

window.onload = console.log( getInput() );