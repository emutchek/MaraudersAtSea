
async function populate() {
  const requestURL = "./obstacles.json";
  const request = new Request(requestURL);

  const response = await fetch(request);
  const obsObj = await response.json();
  return obsObj;
}

const obsObj = populate();

console.log("hi");

console.log(obsObj["obstacles"][0]["descr"]);