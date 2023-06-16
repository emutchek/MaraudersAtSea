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
let health = 100;
let healthPics = [
    "https://dsm01pap001files.storage.live.com/y4mLxWGC9fL6uSCFV2kXaeR6NgxuRJCL0JGEzHXIUG33RHYzpSY2jowwc9aUYdw66h7EuZ5TIOY2T30omGTtPiVKYH83CMopc-5ZjyKKGG3t2gKf4r9zwU50Qyr3PJXzxIyqoDUmnpPzF2vqCU1ZnczolKMfGsW0CBZ3Y-xO_nDqkxC7cXxa3qQRxt3TkRSCs1N2wR97WXECvTG4c_2vFDamDQmR8H-nwAsgi9lvQDwleM?encodeFailures=1&width=272&height=881",
    "https://dsm01pap001files.storage.live.com/y4mpk_wexqvLiiAuKPMs_vlY_Q7ErzB-npTbz6di7c9x6B2ehFu7luHKHaxS6z5uCZFyviWdtb9tFAGQgzekC66FtWroJn1eK4wx6N7cbSP4pZ06Ga5sdFPM_MdHeUDdgefEmhcZfGU7aGQcBzAfpy49wHBE85Lsdu9GJZq_LxHoJxrjC7jb_wEbbte10gTRcVVSbfCyAFG3ZhbYcFAbbniWcrJAoOkfnM2GIJ-RZlFsuY?encodeFailures=1&width=273&height=881",
    "https://dsm01pap001files.storage.live.com/y4mJN-JT0wxhTCAjd0gcVuD9ej1U_dNmwDXPvjI-vrFwHQup3fjHNnFV4vr0R8oSlXotLMsu3boACHOGhIG6ZyUBhZd9GL4F8OgEHv1KQuGgo9hVUBncd5FQabvb9OHEKTja7Z1YbKTmdyk_vPLmRM4TXmlp0S3fozpyJE-79qaXPWF5VkwP-S9dFh0s4ZJdKZ5IWpheqjeV1Xr3qW9ciN0eCuByL1Gm9kiDd2mYVbiOVw?encodeFailures=1&width=272&height=881",
    "https://dsm01pap001files.storage.live.com/y4mkBYvZvDZ31OlwktBq8RTYjMM5wLRAXxmL9wyKvQJUQgQwyRXlF3jkRQOIGiBaAwQjqrpdto6hRFSZxFHUvG7BAS5XNGUpCam0NmmaNnFsZ3iUDYiZNvRmQciFGrM5L9tjRfBIJGRmwx2kjM_e6QYrghl5khnvBLp5bem32PB5Mc4fPTRLTk8RfgoXXeV2z4BBr52_e5nX1Dbyk-cPqFtkoHMasdKEkWJuzBKot1vtbc?encodeFailures=1&width=272&height=881"
]

function healthDisplay() {
    health -= 25;
    switch (health){
        case 100: document.getElementById("healthBar").src = healthPics[0]; break;
        case 75: document.getElementById("healthBar").src = healthPics[1]; break;
        case 50: document.getElementById("healthBar").src = healthPics[2]; break;
        default: document.getElementById("healthBar").src = healthPics[3]; 
    }
}

function eraseBorders() {
    const boxes = document.getElementsByClassName("grid");
    for(let i = 0; i < boxes.length; i++) {
        let box = boxes[i];
        let tag = box.id;
        if (tag.substring(0,1)=="l") {
            box.style.borderLeft = "0px";
        }
        else {
            box.style.borderRight = "0px";
        }
        if (tag.substring(1)=="0") {
            box.style.borderBottom = "0px";
        }
        else if (tag.substring(1)=="4") {
            box.style.borderTop = "0px";
        }
    }
}


