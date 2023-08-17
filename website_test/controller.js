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
  else if (x < 0.20) fetchConversation(); //0.25
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
  inventory["doubloons"] = 75;
  extraInventory.length = 0;
  rudeness[0],rudeness[1] = 1;
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
                                                       
  if(x < 0.10) grid[4][side] = new Island();            // 10% chance of island
  if(x >= 0.10 && x < 0.25) grid[4][side] = new RA();   // 15% chance of RA
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

const inventory = {medicine:10,rope:10,wood:10,doubloons:75};
const extraInventory = [];
const resourceTypes = ["medicine","rope","wood","doubloons"];
const rudeness = [1,1];
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
  useInventory(raType,10);
}

// Updates inventory value and re-displays it OR returns false if there's not enough
function useInventory(type,amt) {
  if (inventory[type] + amt < 0) return false;
  inventory[type] += amt;
  highlightResource(type); 
  paintInventory();
  return true;
}
// Updates inventory value and re-displays it (if not enough, goes to 0)
function dropInventory(type,amt) {
  if (inventory[type] + amt < 0) inventory[type] = 0;
  else inventory[type] += amt;
  highlightResource(type); 
  paintInventory();
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
    if(useInventory("doubloons",-item["cost"])) {
      extraInventory.push(item);
      $('#invMode2').prepend(`<img class="invMode2Pics" src=${item["pic"]} />`);
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
    dropInventory(type,-10);
  }
}

function generateSale() {
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

// Tells obstacle handler which option the player picked
function performSolutionA() {performSolution(obstacle.actionA,obstacle.outcomeGd);}
function performSolutionB() {performSolution(obstacle.actionB,obstacle.outcomeBd);}

/* Refers to global obstacle field & params to figure out what this solution does
   (e.g. reduces health or consumes resource)
   If they try to use a resource they don't have, it docks health and sends a message explaining why
   Obstacles w/ amt of 10 are consuming resources; any other means the resource is under attack (paying = false)
*/
function performSolution(action,outcome) {
  // Obstacle affects health
  if(action === "health") updateHealth(-25);

  // Obstacle affects resources
  else if(resourceTypes.includes(action)) {
    // Player is trying to use a resource, so if they don't have enough of it they lose health
    if(obstacle.amt === "-10") {
      let hadEnough = useInventory(action,Number(obstacle.amt));
      if (!hadEnough) {
          updateHealth(-25);
          displayObstacleResult("Turns out we didn't have much of that. Whoops!");
          return;
      }
    }
    // Player's resources are attacked by obstacle, so they'll lose whatever small amount they have
    else dropInventory(action,Number(obstacle.amt));
  }

  // Effects are complete, if there were any
  displayObstacleResult(outcome);
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
  if(islandObj["effectTypeGd"]==="branch") branchIsland();
  else if (choseGood) executeOtherIsland(islandObj["effectTypeGd"],true);
  else executeOtherIsland(islandObj["effectTypeBd"],false);

  if (choseGood) closeIsland(islandObj["outcomeGd"]);
  else closeIsland(islandObj["outcomeBd"]);
  gameOver();
}

function executeOtherIsland(effectType,choseGood) {
  switch (effectType) {
    case "gainInv": invIsland(10,10,10,-30); break;
    case "loseInv": invIsland(-10,-10,-10,0); break;
    case "gainMed": invIsland(40,0,0,0); break;
    case "loseHealth": updateHealth(-25); break;
    case "heroism": 
      if(choseGood) {heroism[0] += 1;console.log("gained some heroism");}
      else {heroism[1] += 1; console.log("lost some heroism");}break;
    case "": 

  }
}

function branchIsland() {
  if(choseGood) {
    heroism[0] += 1;
    console.log("gained some heroism");
    nextIslandType = true;
  }
  else {
    heroism[1] += 1;
    console.log("lost some heroism");
    nextIslandType = false;
  }
  console.log(`heroism: ${heroism[0]}g:${heroism[1]}b`);
}

function invIsland(m,r,w,d){
  console.log("inside inv island");
  dropInventory("medicine",m);
  dropInventory("rope",r);
  dropInventory("wood",w);
  dropInventory("doubloons",d);
}

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




