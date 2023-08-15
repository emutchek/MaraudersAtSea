
async function fetchObstacle() {
  const requestURL = "./obstacles.json";
  const request = new Request(requestURL);
  const response = await fetch(request);
  const obsObj = await response.json();
  let x = Math.floor(Math.random()*7);
  obstacle = obsObj["obstacles"][x];
  displayObstacle(obstacle);
}

async function fetchConversation() {
  const requestURL = "./items.json";
  const request = new Request(requestURL);
  const response = await fetch(request);
  const conv = await response.json();

  let x = Math.floor(Math.random()*2);
  conversation = conv["conversations"][x];
  displayConvo(conversation);
}

async function fetchItem(type) {
  const requestURL = "./items.json";
  const request = new Request(requestURL);
  const response = await fetch(request);
  const itemObj = await response.json();

  let x = Math.floor(Math.random()*5);
  item = itemObj[type][x];
  displaySale(item);
}

