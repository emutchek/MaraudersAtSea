//Each inner array represents a single row of 2 objects, left and right
const grid = [[{},{}],[{},{}],[{},{}],[{},{}],[{},{}]];

//Represents the next plot island to be put on grid, NOT how many user has read
var islandsPut = 0; 

const resourceTypes = ["medicine","rope","wood"];

var health = 100;

const inventory = {medicine:10,rope:10,wood:10};


// Helper function to describe what's next to ship - returns the island number, resource type, or false
function shipBesideWhat() {
    if(grid[0][0] instanceof Island) return grid[0][0].number
    if(grid[0][1] instanceof Island) return grid[0][1].number
    if(grid[0][0] instanceof RA) return grid[0][0].type
    if(grid[0][1] instanceof RA) return grid[0][1].type
    return false
}

// Calls appropriate function if ship is next to something; otherwise, returns false
function coordinateEncounter () {
  adj = shipBesideWhat();
  if(typeof adj === "number") {
      displayIsland();
      return true;
  }
  else if(typeof adj === "string") {
      displayRA(adj);
      return true;
  }
  return false;
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

// Retrieves description of an obstacle to send to UI, 10% of the time
function generateObstacle() {
    let x = Math.random();
    console.log(x);
    if(x < 0.10) {
      displayObstacle("Meels woke up this morning covered in boils. We must have incurred \
      the wrath of an angry spirit... or maybe it was the brownish drinking water. What do you do?",
      "People get sick all the time! Let's play limbo on the deck",
      "Give Meels medicine and keep her quarantined [10 vials of medicine]");
    }
}

// Updates inventory and re-displays it on the screen
function pickupRA() {
  let raType = shipBesideWhat();
  switch (raType) {
      case("medicine"): inventory.medicine = inventory.medicine + 10; break;
      case("rope"): inventory.rope = inventory.rope + 10; break;
      case("wood"): inventory.wood = inventory.wood + 10; break;
  }
  paintInventory();
}

function sail () {
    resetLeft();
    shiftRows();
    generateRow();
    paintGrid();
    let inEncounter = coordinateEncounter();
    if(!inEncounter) generateObstacle();
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