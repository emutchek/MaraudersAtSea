function openClose(id,display) {
    if ($(id).css("display")=="none") {
        $(id).css("display",display);
    }
    else $(id).hide();
}
/*
**************************GRID/NAVIGATION**************************
*/

const gridImages = ["./website_pics/barrel.png","./website_pics/island.png"];

// Erases the island/RA stuff for the next move forward
function resetLeft() {
    $("#asurroundingText").text(" "); 
    $("#pickupRAButton").css("display","none");
}

// Disables map and sail buttons, forcing the user to deal with whatever's happening before moving on
function freezeShip() {
    $("#mapButton").prop("disabled",true);
    $("#sailButton").prop("disabled",true);
}

function freeShip() {
    $("#mapButton").prop("disabled",false);
    $("#sailButton").prop("disabled",false);
}

// Takes in an object and displays the correct picture - island, barrel, or blank
function paintGridCell(cell, blockId) {
    $(blockId).empty();
    if(cell instanceof Island) $(blockId).append('<img src="./website_pics/island.png" class="gridImage">');
    else if(cell instanceof RA) $(blockId).append('<img src="./website_pics/barrel.png" class="gridImage">');
    else if(cell === "mark") $(blockId).append('<img src="./website_pics/wave.png" width="50">');
}

// Fills all 10 boxes with up-to-date icon
function paintGrid() {
    for(let i = 0; i < 5; i++) {
        paintGridCell(grid[i][0],`#l${i}`);
        paintGridCell(grid[i][1],`#r${i}`);
    }
}

/*
**************************INVENTORY/RA**************************
*/
function displayRA(raType) {
    $("#asurroundingText").text(`Oh look, some ${raType}! It sure is lucky that somebody \
    happened to leave this just floating around out here...`);
    $("#pickupRAButton").css("display","block");
}

function paintInventory() {
    resetLeft(); // remove the question and button immediately so it's clear that they clicked it
    $('#medicineLabel').text(`${inventory.medicine} vials`);
    $('#ropeLabel').text(`${inventory.rope} spools`);
    $('#woodLabel').text(`${inventory.wood} planks`);
    $("#doubloonsText").text(`$${doubloons}`);
}

// When you lose or gain a resource, the text gets bigger and changes color for a second
function highlightResource (type) {
    var item;
    switch(type){
        case "medicine": item = $("#medicineLabel"); break;
        case "rope": item = $("#ropeLabel"); break;
        case "wood": item = $("#woodLabel"); break;
        case "doubloons": item = $("#doubloonsText"); break;
    }
    item.animate({color: "#b58d30",fontSize: "1.6em"},"slow");
    item.animate({color: "black",fontSize: "1.4em"},"slow");
}

//Fills in text of the salesman pop-up: his greeting and the 2 possible responses the user has
function displayConvo(convo) {
    freezeShip();
    $("#salesmanContainer").css("display","block");
    $("#salesmanXButton").css("display","none");
    $("#salesmanTitle").text("Oh look! A wandering salesman");
    $("#salesmanText").text(convo["greeting"]);
    $("#salesmanButtonA").text(convo["opA"]);
    $("#salesmanButtonB").text(convo["opB"]);
}

//Displays the salesman's reaction to your response
function displayConvoResult(message) {
    $("#salesmanText").text(message);
    $("#salesmanTitle").text("");
    generateSale();
}

//Salesman describes the item he's offering you, you have the choice whether to buy
function displaySale(item) {
    response = $("#salesmanText").text();
    $("#salesmanText").text(response+(item["descr"]));
    $("#priceText").text("$"+item["cost"]);
    $("#salesmanPic").attr("src",item["pic"]);
    $("#salesmanButtonA").text("I'll take it");
    $("#salesmanButtonB").text("No thanks");
}

//Repeated code to remove buttons and price, add x button
function clearSaleScreen() {
    $("#priceText").text("");
    $("#salesmanButtonA").css("display","none");
    $("#salesmanButtonB").css("display","none");
    $("#salesmanXButton").css("display","block");
}

//User tried to buy something they can't afford - say no, let user close the screen
function displayPenniless() {
    $("#salesmanText").text("What are you trying to pay me in, seashells?");
    let item = $("#doubloonsText");
    item.animate({color: "red",fontSize: "1.7em"},"slow");
    item.animate({color: "black",fontSize: "1.4em"},"slow");
    clearSaleScreen();
}

//User successfully bought an item
function displaySaleOutcome(bought) {
    if (bought) $("#salesmanText").text(item["yes"]);
    else $("#salesmanText").text(item["no"]);
    clearSaleScreen();
}

// Puts the buttons & pic back for next time, closes the container (almost same as closeObstacle())
function closeSale() {
    $("#salesmanButtonA").css("display","block");
    $("#salesmanButtonB").css("display","block");
    $("#salesmanPic").attr("src","./website_pics/pirate_flag.png");
    $("#salesmanContainer").css("display","none");
    freeShip();
}


/*
**************************OBSTACLE/HEALTH TEXT**************************
*/
// Updates photo to reflect which level of health the crew is on
function paintHealth() {
    switch (health){
        case 100: $("#healthBar").attr("src","./website_pics/health1.png"); break;
        case 75: $("#healthBar").attr("src","./website_pics/health2.png"); break;
        case 50: $("#healthBar").attr("src","./website_pics/health3.png"); break;
        default: $("#healthBar").attr("src","./website_pics/health4.png"); break; 
    }
} 

/* Displays the red flag container with a description of the obstacle and the two options
    Also saves the obstacle in a global variable so we know what the question was 
*/
function displayObstacle (obs) {
    freezeShip();
    $("#obstacleContainer").css("display","block");
    $("#obstacleXButton").css("display","none");
    $("#obstacleTitle").text(obs["title"]);
    $("#obstacleText").text(obs["descr"]);
    $("#obstacleButtonA").text(obs["opA"]);
    $("#obstacleButtonB").text(obs["opB"]);
}

// Remove buttons from screen, shows outcome text, and enables x button
function displayObstacleResult(message) {
    $("#obstacleText").text(message);
    $("#obstacleTitle").text("");
    $("#obstacleButtonA").css("display","none");
    $("#obstacleButtonB").css("display","none");
    $("#obstacleXButton").css("display","block");
}

// Puts the buttons back for next time, closes the container
function closeObstacle() {
    $("#obstacleButtonA").css("display","block");
    $("#obstacleButtonB").css("display","block");
    $("#obstacleContainer").css("display","none");
    freeShip();
}
/*
**************************ISLAND TEXT**************************
*/

function displayIsland(descr,opA,opB) {
    freezeShip();
    $(".storyButtons").css("display","inline");
    $("#asurroundingText").text(descr);
    $("#storyButtonA").text(opA);
    $("#storyButtonB").text(opB);
}

function closeIsland(outcome) {
    $("#asurroundingText").text(outcome);
    $(".storyButtons").css("display","none");
    freeShip();
}

/*
**************************RANDOM**************************
*/
/* If game is over (you died or reached the ending), disable sail button and show end message
   Right now the game ends when you reach the 8th plot island (for no real reason)
*/
function gameOver() {
    if (shipBesideWhat() === 8 || health === 0) {
        $("#sailButton").prop("disabled",true);
        $("#asurroundingText").text("That's the end! You did... something, alright!");
    }
}





