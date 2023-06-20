//Each inner array represents a single row of 2 objects, left and right
const grid = [[{},{}],[{},{}],[{},{}],[{},{}],[{},{}]];

//Represents the next plot island to be put on grid, NOT how many user has read
var islandsPut = 0; 

const resourceTypes = ["Wood","Rope","Medicine"];

// Fills the top row of the grid (subarray 4) w/ islands, RAs, or nothing
function generateRow () {
    let side = Math.round(Math.random()); // picks 0 (left) or 1 (right)
    let x = Math.random();
    if(x < 0.20) {                        // 20% chance of island
        grid[4][side] = new Island();
        console.log(`added ${grid[4][side]}`);
    }
    if(x > 0.10 && x < 0.40) {            // 30% chance of RA (10% chance of both)
        grid[4][side] = new RA();
        console.log(`added ${grid[4][side]}`);
    }
}

// Updates grid array to shift everything down, clear out top row
function shiftRows() {
    for(let i = 0; i < 4; i++) {
        temp = grid[i+1]
        grid[i] = temp;
    }
    grid[4] = [{},{}];
}

// generate new row for the top, move down others
function sail () {
    shiftRows();
    generateRow();
    paintGrid();
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
    toString() {return "island"};
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
    toString() {return "RA"};

}

/*  */