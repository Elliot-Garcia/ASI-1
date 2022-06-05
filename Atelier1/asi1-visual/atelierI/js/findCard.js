/**
* Function that GET every cards
* @author   groupe2
* @param    none
* @return   none
*/
function launchSearch(){

    const GET_CHUCK_URL="https://asi2-backend-market.herokuapp.com/cards"; 
    let context =   {
                        method: 'GET'
                    };
        
    fetch(GET_CHUCK_URL,context)
        .then(response => response.json())
            .then(response => findCard(response))
            .catch(error => err_callback(error));
}

/**
* Function that log errors
* @author   groupe2
* @param    error of the fetched api
* @return   none
*/
function err_callback(error){
    console.log(error);
}

/**
* Function that search the asked card
* @author   groupe2
* @param    response of the api = all cards
* @return   none
*/
function findCard(response){
    let search = document.getElementById("searchField").value.toLowerCase();

    for (const element of response) {

        if (element.name.toLowerCase() == search){
            dysplayCard(element);
            editMessage(search);
            return;
        }
    };
    //if no card is find
    editMessage("Nothing to display for " + search);
}

/**
* Function that edite the state of the search
* @author   groupe2
* @param    str = message to dysplay
* @return   none
*/
function editMessage(mess){
    document.getElementById("messageSearch").innerHTML = "Result for : "  + mess ;
}

/**
* Function that dysplay the card. INspired from searchCard.js
* @author   groupe2
* @param    the card to display in JSON format
* @return   none
*/
function dysplayCard(card){
    let template = document.querySelector("#selectedCard");
    let clone = document.importNode(template.content, true);

    newContent= clone.firstElementChild.innerHTML
                .replace(/{{family_src}}/g, card.smallImgUrl)
                .replace(/{{family_name}}/g, card.family_name)
                .replace(/{{img_src}}/g, card.img_src)
                .replace(/{{name}}/g, card.name)
                .replace(/{{description}}/g, card.description)
                .replace(/{{hp}}/g, card.hp)
                .replace(/{{energy}}/g, card.energy)
                .replace(/{{attack}}/g, card.attack)
                .replace(/{{defense}}/g, card.defense);
    clone.firstElementChild.innerHTML= newContent;

    let cardContainer= document.querySelector("#cardContainer");

    console.log(cardContainer);

    //remove the last search
    cardContainer.removeChild(cardContainer.children[1]);
    cardContainer.appendChild(clone);
}



/**
* Stop the form to realod the page en the user hit ENTER
* from : https://stackoverflow.com/questions/30384571/prevent-form-submission-on-hitting-enter-key-for-text
* @author   groupe2
* @param    none
* @return   none
*/
function stropEnter(){
    document.getElementById("mySearch").onkeypress = function(e) {
        var key = e.charCode || e.keyCode || 0;     
        if (key == 13) {
        e.preventDefault();
        launchSearch();
        }
    }
}


document.onload = stropEnter();