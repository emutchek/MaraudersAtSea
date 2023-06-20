//Each inner array represents a single row of 2 objects, left and right
const grid = [[{},{}],[{},{}],[{},{}],[{},{}],[{},{}]];

//Represents the next plot island to be put on grid, NOT how many user has read
var islandsPut = 0; 

const resourceTypes = ["wood","rope","medicine"];

var health = 100;

// Helper function to describe what's next to ship - returns the island number, resource type, or false
function shipBesideWhat() {
    if(grid[0][0] instanceof Island) return grid[0][0].number
    if(grid[0][1] instanceof Island) return grid[0][1].number
    if(grid[0][0] instanceof RA) return grid[0][0].type
    if(grid[0][1] instanceof RA) return grid[0][1].type
    return false
}

// Fills the top row of the grid (subarray 4) w/ islands, RAs, or nothing
function generateRow () {
    let side = Math.round(Math.random());                 // picks 0 (left) or 1 (right)
    let x = Math.random();
                                                         
    if(x < 0.20) grid[4][side] = new Island();            // 20% chance of island
    if(x >= 0.20 && x < 0.50) grid[4][side] = new RA();   // 30% chance of RA 
}

// Updates grid array to shift everything down, leaves top row blank
function shiftRows() {
    for(let i = 0; i < 4; i++) {
        temp = grid[i+1]
        grid[i] = temp;
    }
    grid[4] = [{},{}];
}

function sail () {
    shiftRows();
    generateRow();
    paintGrid();
    displayEncounterText();
    gameOver();
}

/*
Island:
 - if the 'number' field is -1, it's a filler island and can go anywhere in the game;
   the other 50% of the time, a number is assigned to indicate its position in the story 
   (ex. island 0 corresponds to story scene 0)
*/
class Island {
    constructor() {
      let isFiller = Math.round(Math.random()); 
      if(isFiller === 0) {                              
        this.number = islandsPut;                    
        islandsPut++;
      }
      else this.number = -1;
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

/* console.log(`
[${grid[4][0]},${grid[4][1]}],
[${grid[3][0]},${grid[3][1]}],
[${grid[2][0]},${grid[2][1]}],
[${grid[1][0]},${grid[1][1]}],
[${grid[0][0]},${grid[0][1]}],
`) */