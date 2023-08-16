/*
**************************GAME MECHANICS**************************
*/

// Calls appropriate function if ship is next to something; otherwise, returns false
function coordinateEncounter () {
  adj = shipBesideWhat();
  if(adj instanceof Island && adj.isFiller) {
      //generateFillerIsland();
      return true;
  }
  else if(adj instanceof Island) {
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
  if(x < 0.15) fetchObstacle(); //0.15
  else if (x < 0.25) fetchConversation(); //0.25
}

function sail () {
  resetLeft();
  shiftRows();
  generateRow();
  paintGrid();
  if(died()) return;
  let inEncounter = coordinateEncounter();
  if(!inEncounter) generatePopUp();
}

function gameOver() {
  if (islandObj["tag"]==='11a' || islandObj["tag"]==='11b'){
    $("#sailButton").prop("disabled",true);
    $("#restartButton").css("display","block");
  }
}

function restart() {
  health = 100;
  inventory["medicine"] = 10;
  inventory["rope"] = 10;
  inventory["wood"] = 10;
  extraInventory.length = 0;
  rudeness[0],rudeness[1] = 1;
  doubloons = 50;
  islandObj = [];
  nextIslandType = true;
  window.location.replace('./welcome.html');
}

/*
**************************GRID**************************
*/

// Each inner array represents a single row of 2 objects, left and right
const grid = [[{},{}],[{},{}],[{},{}],[{},{}],[{},{}]];

// Helper function to describe what's next to ship - returns the island number, resource type, or false
function shipBesideWhat() {
  if(grid[0][0] instanceof Island) return grid[0][0]
  if(grid[0][1] instanceof Island) return grid[0][1]
  if(grid[0][0] instanceof RA) return grid[0][0].type
  if(grid[0][1] instanceof RA) return grid[0][1].type
  return false
}

// Fills the top row of the grid (subarray 4) w/ islands, RAs, or nothing
function generateRow () {
  let side = Math.round(Math.random());                 // picks 0 (left) or 1 (right)
  let x = Math.random();
                                                       
  if(x < 0.20) grid[4][side] = new Island();            // 20% chance of island
  if(x >= 0.20 && x < 0.40) grid[4][side] = new RA();   // 20% chance of RA
  if(x > 0.65) grid[4][side] = "mark"                   // 25% chance of wave picture
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
const resourceTypes = ["medicine","rope","wood","doubloons"];
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
  updateInventory(raType,10,false);
}

/* Updates inventory values and re-displays it on the screen
   If you try to consume a resource that's already at 0, it returns false
   But if that resource is under attack (e.g. paying = false), you'll lose
      whatever small bit you had left
*/
function updateInventory(type,amt,paying) {
  switch(type) {
    case("medicine"): 
      if(inventory.medicine + amt < 0) {
        if(paying) return false;
        else inventory.medicine = 0;
      }
      inventory.medicine += amt; 
      highlightResource("medicine"); break;

    case("rope"): 
    if(inventory.rope + amt < 0) {
      if(paying) return false;
      else inventory.rope = 0;
    }
      inventory.rope += amt; 
      highlightResource("rope"); break;

    case("wood"): 
    if(inventory.wood + amt < 0) {
      if(paying) return false;
      else inventory.wood = 0;
    }
      inventory.wood += amt; 
      highlightResource("wood"); break;

    case("doubloons"):
    if(inventory.doubloons + amt < 0) {
      if(paying) return false;
      else inventory.doubloons = 0;
    }
      doubloons += amt;
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
    if(updateInventory("doubloons",-item["cost"],true)) {
      extraInventory.push(item);
      $('#invMode2').prepend(`<img class="invMode2Pics" src=${item["pic"]} />`);
      console.log(`new items: ${extraInventory.length}`);
      displaySaleOutcome(true);
    }
    //they can't afford the item
    else displayPenniless();
  }
  //they clicked don't buy
  else {
    securityBreach();
    displaySaleOutcome(false);
  }
}

//if the user has been rude to the salesman and rejects their item, he will steal from them
function securityBreach() {
  if(rudeness[0]/rudeness[1] < 0.5) {
    let idx = Math.floor(Math.random()*3); 
    let type = resourceTypes[idx];
    updateInventory(type,-10,false);
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

/* Refers to global obstacle field to figure out what this solution does
   (e.g. reduces health or consumes resource)
   If they try to use a resource they don't have, it docks health and sends a message explaining why
   Obstacles w/ amt of 10 are consuming resources; any other means the resource is under attack (paying = false)
*/
function performSolutionA() {
  if(obstacle.actionA === "health") updateHealth(-25);
  else if(resourceTypes.includes(obstacle.actionA)) {
    // Player is trying to use a resource, so if they don't have enough of it they lose health
    if(obstacle.amt === 10) {
      let hadEnough = updateInventory(obstacle.actionA,Number(obstacle.amt),true);
      if (!hadEnough) {
        updateHealth(-25);
        displayObstacleResult("Turns out we didn't have any of that anyway. Whoops!");
        return;
    }}
    // Player's resources are attacked by obstacle, so they'll lose whatever small amount they have
    updateInventory(obstacle.actionA,Number(obstacle.amt),false);
  }
  displayObstacleResult(obstacle.outcomeGd);
}

function performSolutionB() {
  if(obstacle.actionB === "health") updateHealth(-25);
  else if(resourceTypes.includes(obstacle.actionB)) {
    // Player is trying to use a resource, so if they don't have enough of it they lose health
    if(obstacle.amt === 10) {
      let hadEnough = updateInventory(obstacle.actionB,Number(obstacle.amt),true);
      if (!hadEnough) {
        updateHealth(-25);
        displayObstacleResult("Turns out we didn't have any of that anyway. Whoops!");
        return;
    }}
    // Player's resources are attacked by obstacle, so they'll lose whatever small amount they have
    updateInventory(obstacle.actionB,Number(obstacle.amt),false);
  }
  displayObstacleResult(obstacle.outcomeBd);
}

/*
**************************ISLAND**************************
*/
const heroism = [0,0];
var nextIslandType = true;
var latestTag;
var islandObj;
var choseGood;

function generateIsland() {
  islandObj = tree.getNextIsland(nextIslandType);
  nextIslandType = true;
  latestTag = Number(islandObj["tag"].replaceAll("b","").replaceAll("a",""));
  displayIsland(islandObj["text"],islandObj["opGd"],islandObj["opBd"]);
}
function pickedIsland(aOrB) {
  choseGood = (aOrB=='A' && gdOnLeft) || (aOrB=='B' && !gdOnLeft);
  if(islandObj["outcomeGd"]==="branch") { 
    branchIsland();
  }
  else if (choseGood) {
    executeOtherIsland(islandObj["outcomeGd"]);
  }
  else executeOtherIsland(islandObj["effectTypeBd"]);
  if (choseGood) closeIsland(islandObj["outcomeGd"]);
  else closeIsland(islandObj["outcomeBd"]);
  gameOver();
}
function executeOtherIsland(effectType) {
  switch (effectType) {
    case "inv": invIsland(); break;
    
  }
}
function branchIsland() {
  if(choseGood) {
    morality[0] += 1;
    nextIslandType = true;
  }
  else {
    heroism[1] += 1;
    nextIslandType = false;
  }
  console.log(`heroism: ${heroism[0]}g:${heroism[1]}b`);
}
function invIsland(){}

function earnedGoodEnding() {
  console.log(`getting good ending: ${heroism[0]>=3} because it's ${heroism[0]}g:${heroism[1]}b`)
	return heroism[0]>=3;
}

/*
Island:
 - 30% chance of filler island
*/
class Island {
    constructor() {
      let temp = Math.random(); 
      if(temp<0.0) this.isFiller = true; // put this back to 0.33                         
    }   
    toString() {return "island"};
}




