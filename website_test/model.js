
async function fetchObstacle() {
  const requestURL = "./obstacles.json";
  const request = new Request(requestURL);
  const response = await fetch(request);
  const obsObj = await response.json();

  let x = Math.floor(Math.random()*7);
  displayObstacle(obsObj["obstacles"][x])
}

