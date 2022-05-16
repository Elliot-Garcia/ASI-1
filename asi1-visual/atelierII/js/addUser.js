/**
* Function that POST new cards to the api
* @author   groupe2
* @param    none
* @return   none
*/
function POSTHTML(){
    const data = getInput();
    if (!checkData(data)){
        return;
    }

    delete data["re-password"];
    console.log(data);
    const GET_CHUCK_URL="";
    let context =   {
                        method: 'POST',
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                          },
                        body : JSON.stringify(data)
                    };
    fetch(GET_CHUCK_URL,context)
        .then(response => response)
            .then(response => callback(response))
            .catch(error => err_callback(error));
}


/**
* Function that gets all element entered by the newUser
* @author   groupe2
* @param    none
* @return   card under JSON format
*/
function getInput(){
    var data = {};
    var getInput = document.querySelectorAll(".field");
    getInput.forEach( element => data[ element.children[1].name ] = element.children[1].value)

    return(data);
}

/**
* Function that check the avalibility of a new user data
* if psw and repsw are the same
* @author   groupe2
* @param    data (Json:  {login: '', password: '', re-password: ''} )
* @return   boolan
*/
function checkData(data){

    // empty field
    if (data['login'].includes(" ") || data['login'] == "" ){
        setMessage("Login incorect")
        return false;
    }

    // differante pswd
    if (data['password'] != data['re-password']){
        setMessage("PasswordS incorect")
        return(false);
        //afficher message
    }
    return true;
}


/**
* Function that show to the user the result of there sining up
* @author   groupe2
* @param    message
* @return   none
*/
function setMessage(message){
    document.getElementById("messageInfo ").innerHTML = message;
}