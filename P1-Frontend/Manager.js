const url = 'http://localhost:8080/P1-TheAznul/'

document.getElementById('getReimbButton').addEventListener('click', assembleFunc);
document.getElementById('getApprovedReimbButton').addEventListener('click', approvedTickets);
document.getElementById('getPendingReimbButton').addEventListener('click', pendingTickets);
document.getElementById('getDeniedReimbButton').addEventListener('click', deniedTickets);

document.getElementById('approveButton').addEventListener('click', approval);
document.getElementById('denyButton').addEventListener('click', denial);






async function assembleFunc() { //async returns a promise (which fetch returns)

    //we will send a fetch request to get our avenger data
    //await makes the async functions wait until the promise returns with the fetched data
    let response = await fetch(url + 'alltickets');

    console.log(response);

    if(response.status === 200) { //if the request is successful...
        console.log(response); //just to see what comes back for debug

        let data = await response.json(); //get the JSON data from the response, turn it into JS object


        //now, I want to put each avenger into my table
        for(let reimb of data) { //for every avenger in the data variable/object

            console.log(reimb); //just for debug, print the avenger in the console

            let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = reimb.reimb_id; //fill the cell with avenger data
            row.appendChild(cell) //this row now has the first cell (av_id)

            //the we'll do this^ for each field in the avenger model
            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.reimb_amount;
            row.appendChild(cell2);

                        //if the avenger has a home, just fill the cell with the home name
                        if(reimb.reimb_submitted != null){
                            console.log("time came through")
                            let cell3 = document.createElement("td");
                            cell3.innerHTML = reimb.reimb_submitted;
                            row.appendChild(cell3);
                        } else { //otherwise, still append the cell but leave it empty
                            let cell3 = document.createElement("td");
                            row.appendChild(cell3);
                        }
                        if(reimb.reimb_resolved != null){
                            console.log("time came through")
                            let cell4 = document.createElement("td");
                            cell4.innerHTML = reimb.reimb_resolved;
                            row.appendChild(cell4);
                        } else { //otherwise, still append the cell but leave it empty
                            let cell4 = document.createElement("td");
                            row.appendChild(cell4);
                        }
                        

   //         let cell3 = document.createElement("td");
     //       cell3.innerHTML = reimb.reimb_submitted;
       //     row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = reimb.reimb_description;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimb.reimb_author;
            row.appendChild(cell6);

            if(reimb.reimb_resolver != null){
                console.log("resolver came through")
                let cell7 = document.createElement("td");
                cell7.innerHTML = reimb.reimb_resolver;
                row.appendChild(cell7);
            } else { //otherwise, still append the cell but leave it empty
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }
            

      //      let cell7 = document.createElement("td");
       //     cell7.innerHTML = reimb.reimb_resolver;
        //    row.appendChild(cell7);

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimb.reimb_status_id;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimb.reimb_type_id;
            row.appendChild(cell9);





            document.getElementById("reimbBody").appendChild(row);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML

        }

    }

}

async function approvedTickets() { //async returns a promise (which fetch returns)

    //we will send a fetch request to get our avenger data
    //await makes the async functions wait until the promise returns with the fetched data
    let response = await fetch(url + 'approved');

    console.log(response);

    if(response.status === 200) { //if the request is successful...
        console.log(response); //just to see what comes back for debug

        let data = await response.json(); //get the JSON data from the response, turn it into JS object


        //now, I want to put each avenger into my table
        for(let reimb of data) { //for every avenger in the data variable/object

            console.log(reimb); //just for debug, print the avenger in the console

            let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = reimb.reimb_id; //fill the cell with avenger data
            row.appendChild(cell) //this row now has the first cell (av_id)

            //the we'll do this^ for each field in the avenger model
            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.reimb_amount;
            row.appendChild(cell2);

                        //if the avenger has a home, just fill the cell with the home name
                        if(reimb.reimb_submitted != null){
                            console.log("time came through")
                            let cell3 = document.createElement("td");
                            cell3.innerHTML = reimb.reimb_submitted;
                            row.appendChild(cell3);
                        } else { //otherwise, still append the cell but leave it empty
                            let cell3 = document.createElement("td");
                            row.appendChild(cell3);
                        }
                        if(reimb.reimb_resolved != null){
                            console.log("time came through")
                            let cell4 = document.createElement("td");
                            cell4.innerHTML = reimb.reimb_resolved;
                            row.appendChild(cell4);
                        } else { //otherwise, still append the cell but leave it empty
                            let cell4 = document.createElement("td");
                            row.appendChild(cell4);
                        }
                        

   //         let cell3 = document.createElement("td");
     //       cell3.innerHTML = reimb.reimb_submitted;
       //     row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = reimb.reimb_description;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimb.reimb_author;
            row.appendChild(cell6);

            if(reimb.reimb_resolver != null){
                console.log("resolver came through")
                let cell7 = document.createElement("td");
                cell7.innerHTML = reimb.reimb_resolver;
                row.appendChild(cell7);
            } else { //otherwise, still append the cell but leave it empty
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }
            

      //      let cell7 = document.createElement("td");
       //     cell7.innerHTML = reimb.reimb_resolver;
        //    row.appendChild(cell7);

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimb.reimb_status_id;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimb.reimb_type_id;
            row.appendChild(cell9);





            document.getElementById("reimbBody").appendChild(row);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML

        }

    }

}

async function pendingTickets() { //async returns a promise (which fetch returns)

    //we will send a fetch request to get our avenger data
    //await makes the async functions wait until the promise returns with the fetched data
    let response = await fetch(url + 'pending');

    console.log(response);

    if(response.status === 200) { //if the request is successful...
        console.log(response); //just to see what comes back for debug

        let data = await response.json(); //get the JSON data from the response, turn it into JS object


        //now, I want to put each avenger into my table
        for(let reimb of data) { //for every avenger in the data variable/object

            console.log(reimb); //just for debug, print the avenger in the console

            let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = reimb.reimb_id; //fill the cell with avenger data
            row.appendChild(cell) //this row now has the first cell (av_id)

            //the we'll do this^ for each field in the avenger model
            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.reimb_amount;
            row.appendChild(cell2);

                        //if the avenger has a home, just fill the cell with the home name
                        if(reimb.reimb_submitted != null){
                            console.log("time came through")
                            let cell3 = document.createElement("td");
                            cell3.innerHTML = reimb.reimb_submitted;
                            row.appendChild(cell3);
                        } else { //otherwise, still append the cell but leave it empty
                            let cell3 = document.createElement("td");
                            row.appendChild(cell3);
                        }
                        if(reimb.reimb_resolved != null){
                            console.log("time came through")
                            let cell4 = document.createElement("td");
                            cell4.innerHTML = reimb.reimb_resolved;
                            row.appendChild(cell4);
                        } else { //otherwise, still append the cell but leave it empty
                            let cell4 = document.createElement("td");
                            row.appendChild(cell4);
                        }
                        

   //         let cell3 = document.createElement("td");
     //       cell3.innerHTML = reimb.reimb_submitted;
       //     row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = reimb.reimb_description;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimb.reimb_author;
            row.appendChild(cell6);

            if(reimb.reimb_resolver != null){
                console.log("resolver came through")
                let cell7 = document.createElement("td");
                cell7.innerHTML = reimb.reimb_resolver;
                row.appendChild(cell7);
            } else { //otherwise, still append the cell but leave it empty
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }
            

      //      let cell7 = document.createElement("td");
       //     cell7.innerHTML = reimb.reimb_resolver;
        //    row.appendChild(cell7);

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimb.reimb_status_id;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimb.reimb_type_id;
            row.appendChild(cell9);





            document.getElementById("reimbBody").appendChild(row);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML

        }

    }

}

async function deniedTickets() { //async returns a promise (which fetch returns)

    //we will send a fetch request to get our avenger data
    //await makes the async functions wait until the promise returns with the fetched data
    let response = await fetch(url + 'denied');

    console.log(response);

    if(response.status === 200) { //if the request is successful...
        console.log(response); //just to see what comes back for debug

        let data = await response.json(); //get the JSON data from the response, turn it into JS object


        //now, I want to put each avenger into my table
        for(let reimb of data) { //for every avenger in the data variable/object

            console.log(reimb); //just for debug, print the avenger in the console

            let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = reimb.reimb_id; //fill the cell with avenger data
            row.appendChild(cell) //this row now has the first cell (av_id)

            //the we'll do this^ for each field in the avenger model
            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.reimb_amount;
            row.appendChild(cell2);

                        //if the avenger has a home, just fill the cell with the home name
                        if(reimb.reimb_submitted != null){
                            console.log("time came through")
                            let cell3 = document.createElement("td");
                            cell3.innerHTML = reimb.reimb_submitted;
                            row.appendChild(cell3);
                        } else { //otherwise, still append the cell but leave it empty
                            let cell3 = document.createElement("td");
                            row.appendChild(cell3);
                        }
                        if(reimb.reimb_resolved != null){
                            console.log("time came through")
                            let cell4 = document.createElement("td");
                            cell4.innerHTML = reimb.reimb_resolved;
                            row.appendChild(cell4);
                        } else { //otherwise, still append the cell but leave it empty
                            let cell4 = document.createElement("td");
                            row.appendChild(cell4);
                        }
                        

   //         let cell3 = document.createElement("td");
     //       cell3.innerHTML = reimb.reimb_submitted;
       //     row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = reimb.reimb_description;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimb.reimb_author;
            row.appendChild(cell6);

            if(reimb.reimb_resolver != null){
                console.log("resolver came through")
                let cell7 = document.createElement("td");
                cell7.innerHTML = reimb.reimb_resolver;
                row.appendChild(cell7);
            } else { //otherwise, still append the cell but leave it empty
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }
            

      //      let cell7 = document.createElement("td");
       //     cell7.innerHTML = reimb.reimb_resolver;
        //    row.appendChild(cell7);

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimb.reimb_status_id;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimb.reimb_type_id;
            row.appendChild(cell9);





            document.getElementById("reimbBody").appendChild(row);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML

        }

    }

}

async function approval() { //async returns a promise (which fetch returns)
 

    let reimb_id = document.getElementById("reimb_id").value;
    //we will send a fetch request to get our avenger data
    //await makes the async functions wait until the promise returns with the fetched data
    let response = await fetch(url + 'approve', {
        method:"POST",
        body: JSON.stringify(reimb_id)

    });


}

async function denial() { //async returns a promise (which fetch returns)
 

    let reimb_id = document.getElementById("reimb_id").value;
    //we will send a fetch request to get our avenger data
    //await makes the async functions wait until the promise returns with the fetched data
    let response = await fetch(url + 'deny', {
        method:"POST",
        body: JSON.stringify(reimb_id)

    });
    

}