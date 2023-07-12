/*
**************************GAME MECHANICS**************************
*/

// Calls appropriate function if ship is next to something; otherwise, returns false
function coordinateEncounter () {
  adj = shipBesideWhat();
  if(typeof adj === "number") {
      generateIsland();
      return true;
  }
  else if(typeof adj === "string") {
      displayRA(adj);
      return true;
  }
  return false;
}

/* 10% of the time, it retrieves description of an obstacle to send to UI
   10% of the time it summons the traveling salesman */
function generatePopUp() {
  let x = Math.random();
  if(x < 0.10) fetchObstacle();
  else if (x < 0.90) fetchConversation();
}

function sail () {
  resetLeft();
  shiftRows();
  generateRow();
  paintGrid();
  let inEncounter = coordinateEncounter();
  if(!inEncounter) generatePopUp();
  gameOver();
}

/*
**************************GRID**************************
*/

// Each inner array represents a single row of 2 objects, left and right
const grid = [[{},{}],[{},{}],[{},{}],[{},{}],[{},{}]];

// Represents the next plot island to be put on grid, NOT how many user has read
var islandsPut = 0; 

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
  if(x > 0.6) grid[4][side] = "mark"                   // 25% chance of wave picture
}

// Updates grid array to shift everything down, leaves top row blank
function shiftRows() {
  for(let i = 0; i < 4; i++) {
      temp = grid[i+1]
      grid[i] = temp;
  }
  grid[4] = [{},{}];
}

/*
**************************INVENTORY/RA**************************
*/

const inventory = {medicine:10,rope:10,wood:10};
const extraInventory = [];
const resourceTypes = ["medicine","rope","wood"];
const rudeness = [1,1];
var doubloons = 50;
var conversation;
var item;


/*
Resource Area:
 - type of resource (randomly 1 of 3 options)
*/
class RA {
  constructor() {
    let idx = Math.floor(Math.random()*3); 
    this.type = resourceTypes[idx];
  }
  toString() {return "RA"};
}

// Identifies what is inside the barrel we're next to, and updates inventory
function pickupRA() {
  let raType = shipBesideWhat();
  updateInventory(raType,10);
}

/* Updates inventory values and re-displays it on the screen
   If you try to consume a resource that's already at 0, it returns false
*/
function updateInventory(type,amt) {
  switch(type) {
    case("medicine"): 
      if(inventory.medicine === 0 && amt < 0) return false;
      inventory.medicine = inventory.medicine + amt; 
      highlightResource("medicine"); break;
    case("rope"): 
      if(inventory.rope === 0 && amt < 0) return false;
      inventory.rope = inventory.rope + amt; 
      highlightResource("rope"); break;
    case("wood"): 
      if(inventory.wood === 0 && amt < 0) return false;
      inventory.wood = inventory.wood + amt; 
      highlightResource("wood"); break;
    case("doubloons"):
      if(doubloons - amt < 0) return false;
      doubloons -= amt;
      highlightResource("doubloons"); break;
  }
  paintInventory();
  return true;
}

/*both option buttons are wired up to one control function
  looks at screen to see which question you're answering */
function salesmanButtons(aOrB) {
  if($("#salesmanPic").attr("src")=="./website_pics/pirate_flag.png") performConvoAnswer(aOrB);
  else performSale(aOrB);
}

//the user picks a conversation response, and it updates the gauge of your rudeness
function performConvoAnswer(aOrB){
  if (conversation["rudeOption"] == aOrB) rudeness[1] += 1;
  else rudeness[0] += 1;
  displayConvoResult(conversation[`outcome${aOrB}`]);
}

//a yes or no to buying the item he's selling
function performSale(aOrB) {
  //they clicked buy
  if(aOrB=='A') {
    if(updateInventory("doubloons",item["cost"])) {
      extraInventory.push(item);
      $('#invMode2').prepend(`<img class="invMode2Pics" src=${item["pic"]} />`);
      displaySaleOutcome(true);
    }
    //they can't afford the item
    else displayPenniless();
  }
  //they clicked don't buy
  else {
    displaySaleOutcome(false);
  }
}

function generateSale() {
  console.log(`ratio is ${rudeness[0]/rudeness[1]}`);
  if(rudeness[0]/rudeness[1] < 0.5) fetchItem("uselessItems");
  else if(rudeness[0]/rudeness[1] < 1) fetchItem("regularItems");
  else fetchItem("onSaleItems");
}



/*
**************************OBSTACLE/HEALTH**************************
*/

var health = 100;
// Temporary container for the current obstacle
var obstacle;

function updateHealth(amt) {
  health = health + amt;
  paintHealth();
}

/* Refers to obstacle field (top of file) to figure out what this solution does
   (e.g. reduces health or consumes resource)
   If they try to use a resource they don't have, it docks health and sends a message explaining why
*/
function performSolutionA() {
  if(obstacle.actionA === "health") updateHealth(-25);
  else if(resourceTypes.includes(obstacle.actionA)) {
    let hadEnough = updateInventory(obstacle.actionA,-10);
    if (!hadEnough) {
      updateHealth(-25);
      displayObstacleResult("Genius idea, but we don't actually have any of that :(");
      return;
    }
  }
  displayObstacleResult(obstacle.outcomeA);
}

function performSolutionB() {
  if(obstacle.actionB === "health") updateHealth(-25);
  else if(resourceTypes.includes(obstacle.actionB)) {
    let hadEnough = updateInventory(obstacle.actionB,-10);
    if (!hadEnough) {
      updateHealth(-25);
      displayObstacleResult("Genius idea, but we don't actually have any of that :(");
      return;
    }
  }
  displayObstacleResult(obstacle.outcomeB);
}

/*
**************************ISLAND**************************
*/

function generateIsland() {
  // load text
  displayIsland("You've reached an island! Here is a fun little anecdote, or \
  a very serious decision to make you may (definitely) regret!",
  "Cool, sounds fun", "That doesn't sound good");
}

function pickActionA() {
  // Log their decision, retrieve corresponding outcome
  closeIsland("That's the spirit, sailor");
}

function pickActionB() {
  // Log their decision, retrieve corresponding outcome
  closeIsland("Oh, a wise one, eh?");
}

/*
Island:
 - if the 'number' field is -1, it's a filler island and can go anywhere in the game;
   the other 70% of the time, a number is assigned to indicate its position in the story 
   (ex. island 0 corresponds to story scene 0)
*/
class Island {
    constructor() {
      let isFiller = Math.random(); 
      if(isFiller < 0.7) {                              
        this.number = islandsPut;                    
        islandsPut++;
      }
      else this.number = -1;
    }   
    toString() {return "island"};
}




