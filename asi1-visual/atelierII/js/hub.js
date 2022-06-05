/**
* Function that GET info from user
* @author   groupe2
* @param    none
* @return   none
*/
function getUserInfo(){
    //const data = getInput();
    const id = getIdUser();

    return;
    console.log(data);
    const GET_CHUCK_URL="";
    let context =   {
                        method: 'GET',
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                          },
                        body : JSON.stringify(data)
                    };
    fetch(GET_CHUCK_URL,context)
        .then(response => response)
            .then(response => response)
            .catch(error => err_callback(error));
}


function getIdUser(){
    return document.getElementById("userID").innerHTML;
}