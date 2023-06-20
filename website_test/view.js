
const gridImages = ["./website_pics/barrel.png","./website_pics/island.png"];

// toggles map when user presses 'map' button
function workMap() {
    if ($("#map").css("display")=="none") {
        $("#map").show();
    }
    else $("#map").hide();
  }

// turns 'sail' and 'map' buttons black when you hover over them
function buttonAnimation(button,back,text) {
    document.getElementById(button).style.backgroundColor=back;
    document.getElementById(button).style.color=text;
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

// Prints text to the screen if the ship is beside an RA or island
function displayEncounterText () {
    $("#asurroundingText").text(""); // clear out any old message from last click
    adj = shipBesideWhat();
    console.log(adj);
    if(typeof adj === "number") {
        $("#asurroundingText").text("You've reached an island! Here is a fun little anecdote, or \
        a very serious decision to make you may (definitely) regret!")
    }
    else if(typeof adj === "string") {
        $("#asurroundingText").text(`Oh look, a free resource! It sure is lucky that somebody \
        happened to leave this ${adj} just floating around out here!`)
    }
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



