//each inner array represents a single row of 2 objects, left and right
const grid = [[{},{}],[{},{}],[{},{}],[{},{}],[{},{}]];

//Represents the next plot island to be put on grid, NOT how many user has read
var islandsPut = 0; 

const resourceTypes = ["Wood","Rope","Medicine"];

/*
Fills 2 spots w/ island, RA, or nothing
 - indicate somewhere that island is on board so that the correct story
    can be displayed
*/
function generateRow () {
    let side = Math.round(Math.random()); //picks 0 (left) or 1 (right)
    let x = Math.random();
    if(x < 0.15) {                        //15% chance of island
        grid[4][side] = new Island();
    }
    else if(x < 0.40) {                   //~1/3 chance of RA
        grid[4][side] = new RA();
    }
}

// update grid array to shift everything down
function shiftRows() {
    for(let i = 0; i < 4; i++) {
        grid[i] = grid[i+1];
    }
}

// generate new row for the top, move down others
function sail () {
    shiftRows();
    generateRow();
    updateGrid();
}
/*
Island:
 - empty field (50% of time) = filler island, can go anywhere in story
 - number assigned (50% of time) = position in the story 
*/
class Island {
    constructor() {
      let isFiller = Math.round(Math.random());
      if(isFiller === 0) {
        this.number = islandsPut;
        islandsPut++;
      }
    }   
}
/*
Resource Area:
 - type of resource (randomly 1 of 3 options)
*/
class RA {
    constructor() {
      let idx = Math.round(Math.random()*3); 
      this.type = resourceTypes[idx];
    }
}
