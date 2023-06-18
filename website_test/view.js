
let health = 100;
const gridImages = ["./website_pics/barrel.png","./website_pics/island.png"];

function workMap() {
    if ($("#map").css("display")=="none") {
        $("#map").show();
    }
    else {
        $("#map").hide();
    }
  }

function buttonAnimation(button,back,text) {
    document.getElementById(button).style.backgroundColor=back;
    document.getElementById(button).style.color=text;
}

function displayNewRow(row) {
    if(row[0] instanceof Island) {
        $('#l4').append('<img src="./website_pics/island.png" class="gridImage">');
    }
    else if(row[1] instanceof Island) {
        $('#r4').append('<img src="./website_pics/island.png" class="gridImage">');
    }
    else if(row[0] instanceof RA) {
        $('#l4').append('<img src="./website_pics/barrel.png" class="gridImage">');
    }
    else if(row[1] instanceof RA) {
        $('#r4').append('<img src="./website_pics/barrel.png" class="gridImage">');
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



