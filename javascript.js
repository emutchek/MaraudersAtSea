function workMap() {
    let map = document.getElementById("map");
    if(map.style.display == "none") {
        map.style.display="block";
    }
    else {map.style.display="none";}
  }

function animation(button,back,text) {
    document.getElementById(button).style.backgroundColor=back;
    document.getElementById(button).style.color=text;
}


