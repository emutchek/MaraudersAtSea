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

// toggles map when user presses 'map' button
function workMap() {
    if ($("#map").css("display")=="none") {
        $("#map").show();
    }
    else $("#map").hide();
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
    $('.units').eq(0).text(`${inventory.medicine} vials`);
    $('.units').eq(1).text(`${inventory.rope} spools`);
    $('.units').eq(2).text(`${inventory.wood} planks`);
}

// When you lose or gain a resource, the text gets bigger and changes color for a second
function highlightResource (type) {
    var item = $('.units').eq(resourceTypes.indexOf(type));
    item.animate({color: "#b58d30",fontSize: "1.6em"},"slow");
    item.animate({color: "white",fontSize: "1.4em"},"medium");
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
        default: $("#healthBar").attr("src","./website_pics/health4.png"); break;; 
    }
} 

/* Displays the red flag container with a description of the obstacle and the two options
    Also saves the obstacle in a global variable so we know what the question was 
*/
function displayObstacle (obs) {
    obstacle = obs;
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





