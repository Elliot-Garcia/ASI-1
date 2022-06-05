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
    
}
