const url = 'http://localhost:8080/P1-TheAznul/'





//login functionality below-------------------------------------

//add an event listener to the login button
document.getElementById("loginButton").addEventListener('click', loginFunc);


//this function will send the user-inputted login credentials to the server
async function loginFunc() {

    //get the user inputs for the login
    let usern = document.getElementById("username").value; // usern stands for username
    let userp = document.getElementById("password").value; // userp stands for password
 
    //we want to send the user/passs as JSON, so what I need to do first is make a JS object
    let user = {
        username:usern,
        password:userp
    }

    console.log(user);

    //now I'm going to set up my fetch request to the server
    //rememeber the second parameter a fetch() can take? 
    //a configuration object!! Essentially the settings of a fetch request
    //if you don't include a second param, it'll just send a GET request to the URL.
    let response = await fetch(url + "login", {

        method: "POST", //send as a POST request
        body: JSON.stringify(user), //turn into JSON
       // credentials: "include" //this will ensure that the cookie is captured
                              //future fetches will also require this value to send the cookie back
        //BTW we won't be using HTML forms anymore... it's too annoying to turn them into JSON
        //Don't worry too much, we will learn Angular and life will be grand
    });

    console.log(response.status);
    let data = await response.json();
    console.log(data);
    //control flow based on success or failed login
    if(response.status === 200) {
        //this will wipe our login row, and welcome the user
        let theID;
       
        theID = data.userRoleID;

     
     console.log(theID);
        if( theID == 1){
        location.replace('http://127.0.0.1:5500/Manager.html')
        }
        else if(theID == 2){
            location.replace('http://127.0.0.1:5500/Employee.html')
        }
        else{
            document.getElementById("login-row").innerText="Login Succeeded! Redirect failed! Reload the page!"
        }

    

    } else {
        document.getElementById("login-row").innerText="Login Failed! Refresh the page!";
    }

}
