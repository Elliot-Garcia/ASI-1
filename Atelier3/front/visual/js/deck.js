function getCardList(){

    let URL="";
    let context =   {
                        method: 'GET',
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                          }
                    };
    fetch(URL,context)
        .then(response => response)
            .then(response => editList(response))
            .catch(error => err_callback(error));
}


function editList(cardList){
    let template = document.querySelector("#row");

    for(const card of cardList){
        let clone = document.importNode(template.content, true);

        newContent= clone.firstElementChild.innerHTML
                    .replace(/{{family_src}}/g, card.family_src)
                    .replace(/{{family_name}}/g, card.famille)
                    .replace(/{{img_src}}/g, card.img_src)
                    .replace(/{{name}}/g, card.name)
                    .replace(/{{description}}/g, card.description)
                    .replace(/{{hp}}/g, card.hp)
                    .replace(/{{energy}}/g, card.energy)
                    .replace(/{{attack}}/g, card.attack)
                    .replace(/{{defense}}/g, card.defense)
                    .replace(/{{price}}/g, card.BuyPrice);

        clone.firstElementChild.innerHTML= newContent;
        let cardContainer= document.querySelector("#tableContent");
        cardContainer.appendChild(clone);
    }
}

function buyCard(idCard){
    const userId = getIdUser();
    const GET_CHUCK_URL="" + userId + "/" + idCard;
    let context =   {
                        method: 'POST',
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                          }
                    };
    fetch(GET_CHUCK_URL,context)
        .then(response => response)
            .then(response => success(response) )
            .catch(error => err_callback(error));
}


function success(response){
    if (response == null){
        alert("Achat echouer");
        return;
    }
    alert("Achat réussit");
}


/**
* Function that GET info from user
* @author   groupe2
* @param    none
* @return   none
*/
function getUserInfo(){
    //const data = getInput();
    const id = getIdUser();
   
    if (id == null){
        location.replace("userChoice.html")
        return;
    }
    let URL="" + "/" + id;
    let context =   {
                        method: 'GET',
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                          }
                    };
    fetch(URL,context)
        .then(response => response)
            .then(response => editUserInfo(response))
            .catch(error => err_callback(error));
}

function getIdUser(){
    return localStorage.getItem('userId');
}

function editUserInfo(userInfo){
    document.getElementById("account").innerHTML = userInfo.login;
    document.getElementById("userName").innerHTML = userInfo.balance;
}

function err_callback(error){
    console.log(error);
}

getUserInfo();
getCardList();