
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

// takes in an array of surrounding objects (row), displays them in row 'num'
function displayNewRow(row, num) {
    let left = `#l${num}`;
    let right = `#r${num}`;
    if(row[0] instanceof Island) {
        $(left).append('<img src="./website_pics/island.png" class="gridImage">');
    }
    else if(row[1] instanceof Island) {
        $(right).append('<img src="./website_pics/island.png" class="gridImage">');
    }
    else if(row[0] instanceof RA) {
        $(left).append('<img src="./website_pics/barrel.png" class="gridImage">');
    }
    else if(row[1] instanceof RA) {
        $(right).append('<img src="./website_pics/barrel.png" class="gridImage">');
    }
}

function updateGrid() {
    $(".gridImage").not("#ship").remove(); // clear everything off
    for(let i = 1; i < 5; i++) {
        displayNewRow(grid[i],i);
    }
}

/*
0 -> 1
1 -> 2
2 -> 3
3 -> 4
4 -> n/a


*/


/* function healthDisplay() {
    switch (health){
        case 100: document.getElementById("healthBar").src = ; break;
        case 75: document.getElementById("healthBar").src = ; break;
        case 50: document.getElementById("healthBar").src = ; break;
        default: document.getElementById("healthBar").src = ; 
    }
} */



