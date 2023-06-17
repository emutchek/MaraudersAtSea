
function workMap() {
    let map = $("#map");
    if(map.style.display == "none") {
        map.style.display="block";
    }
    else {map.style.display="none";}
  }

function buttonAnimation(button,back,text) {
    document.getElementById(button).style.backgroundColor=back;
    document.getElementById(button).style.color=text;
}

let health = 100;
/* function healthDisplay() {
    switch (health){
        case 100: document.getElementById("healthBar").src = ; break;
        case 75: document.getElementById("healthBar").src = ; break;
        case 50: document.getElementById("healthBar").src = ; break;
        default: document.getElementById("healthBar").src = ; 
    }
} */



