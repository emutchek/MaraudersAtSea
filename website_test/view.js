
let health = 100;
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

// takes in an object from grid, displays correct picture - island, barrel, or blank
function paintGridCell(cell, blockId) {
    $(blockId).empty();
    if(cell instanceof Island) $(blockId).append('<img src="./website_pics/island.png" class="gridImage">');
    else if(cell instanceof RA) $(blockId).append('<img src="./website_pics/barrel.png" class="gridImage">');
}

function paintGrid() {
    for(let i = 0; i < 5; i++) {
        paintGridCell(grid[i][0],`#l${i}`);
        paintGridCell(grid[i][1],`#r${i}`);
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



