
const gridImages = ["./website_pics/barrel.png","./website_pics/island.png"];

// Erases the island/RA stuff for the next move forward
function resetLeft() {
    $("#asurroundingText").text(""); 
    $("#pickupRAButton").css("display","none");
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
}

// Fills all 10 boxes with up-to-date icon
function paintGrid() {
    for(let i = 0; i < 5; i++) {
        paintGridCell(grid[i][0],`#l${i}`);
        paintGridCell(grid[i][1],`#r${i}`);
    }
}

function displayIsland() {
    $("#asurroundingText").text("You've reached an island! Here is a fun little anecdote, or \
    a very serious decision to make you may (definitely) regret!");
}
function displayRA(raType) {
    $("#asurroundingText").text(`Oh look, some ${raType}! It sure is lucky that somebody \
    happened to leave this just floating around out here...`);
    $("#pickupRAButton").css("display","block");
}

function paintInventory() {
    resetLeft(); // remove the question and button immediately so it's clear that they clicked it
    $('ul li').eq(0).text(`${inventory.medicine} vials of medicine`);
    $('ul li').eq(1).text(`${inventory.rope} spools of rope`);
    $('ul li').eq(2).text(`${inventory.wood} planks of wood`);
}

// Displays the red flag container with a description of the obstacle and the two options
function displayObstacle (descr, opA, opB) {
    // can't move forward or check your map while you're facing an obstacle
    $("#mapButton").prop("disabled",true);
    $("#sailButton").prop("disabled",true);

    $("#obstacleContainer").css("display","block");
    $("#obstacleXButton").css("display","none");
    $("#obstacleText").text(descr);
    $("#obstacleButtonA").text(opA);
    $("#obstacleButtonB").text(opB);
}

// Removes buttons from screen, shows outcome text, enables x button
function performSolutionA() {
    $("#obstacleText").text("Outcome A");
    $("#obstacleButtonA").css("display","none");
    $("#obstacleButtonB").css("display","none");
    $("#obstacleXButton").css("display","block");
}

// Puts the buttons back for next time, closes the container
function closeObstacle() {
    $("#obstacleButtonA").css("display","block");
    $("#obstacleButtonB").css("display","block");
    $("#obstacleContainer").css("display","none");

    // restores the sail and map button
    $("#mapButton").prop("disabled",false);
    $("#sailButton").prop("disabled",false);

}

// If game is over (you died or reached the ending), disable sail button and show end message
function gameOver() {
    if (shipBesideWhat() === 3 || health === 0) {
        $("#sailButton").prop("disabled",true);
        $("#asurroundingText").text("That's the end! You did... something, alright!");
    }
}

/* function healthDisplay() {
    switch (health){
        case 100: document.getElementById("healthBar").src = ; break;
        case 75: document.getElementById("healthBar").src = ; break;
        case 50: document.getElementById("healthBar").src = ; break;
        default: document.getElementById("healthBar").src = ; 
    }
} */



