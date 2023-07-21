// BinaryTree class
class Tree {
	curIsland = null;
	constructor() {
		this.head = null;
		this.size = 0;
	}
	addToEnd(left,node) { // navigates to end of tree to add on left, or starts at 9 to add on right
		var current = this.head;
		if(left) {
			while (current.baseLeft) current = current.baseLeft;
            current.baseLeft = node;
		}
		else {
			while (current.baseLeft && current.tag != '9') current = current.baseLeft;
			while (current.baseRight) current = current.baseRight;
            current.baseRight = node;
		}
	}
	add(node, attachTo = '') {
		if (this.head == null) { // edge case: inserting first node
			this.head = node;
		}
		else if (attachTo == '' && tag.slice(-1)=='b') { // adding onto end of tree (right side)
			this.addToEnd(false,node);
		}
		else if (attachTo == '') { // adding onto end of tree (left side)
			this.addToEnd(true,node);
		}
		else { // inserting a right-side node into the middle of the tree
			var current = this.head;
			while (current.baseLeft && current.tag != attachTo) {
				current = current.baseLeft;
			}
			node.baseLeft = current.baseLeft.baseLeft; 
			current.baseRight = node; 
		}
		this.size++;
	}
	
	getNextIsland(aOrDefault = true) { // moves pointer, then returns value
		if (this.curIsland.tag == '9') aOrDefault = earnedGoodEnding();
		// return very first island
		if (this.curIsland == null) this.curIsland = this.head;
		// either there's no branch, or they're going to 'a' version
		else if (aOrDefault) this.curIsland = this.curIsland.baseLeft;
		else this.curIsland = this.curIsland.baseRight; // going to 'b' version
		return this.curIsland;
	}
}

class IslandNode {
	constructor(){
		this.baseLeft = null;
		this.right = null;
	}
}

const filledIslands = []; // array of island objects
//array of chunks of text

$.get('./islandText.txt',{},function(content){
	saveValue(content.split('|'));
});
function saveValue(list) {return list;}

console.log(islandText.length);

function fillIslands () {
	for(let x = 0; x < 1; x++) {
		let fieldTexts = islandText[0].split(':');
		const obj = new IslandNode();
		obj["tag"] = fieldTexts[0];
		obj["text"] = fieldTexts[1];
		obj["opA"] = fieldTexts[2];
		obj["opB"] = fieldTexts[3];
		obj["outcomeA"] = fieldTexts[4];
		obj["outcomeB"] = fieldTexts[5];
		obj["effectType"] = fieldTexts[6];
		filledIslands.push(obj);
	}
}

fillIslands()

var tree = new Tree();
tree.add(filledIslands[0]); //1
tree.add(filledIslands[1]); //2a
tree.add(filledIslands[3]); //3
tree.add(filledIslands[4]); //4a
tree.add(filledIslands[6]); //5
tree.add(filledIslands[7]); //6a
tree.add(filledIslands[9]); //7
tree.add(filledIslands[10]); //8a
tree.add(filledIslands[12]); //9
tree.add(filledIslands[13]); //10a
tree.add(filledIslands[15]); //11a
tree.add(filledIslands[14]); //10b
tree.add(filledIslands[16]); //11b
tree.add(filledIslands[2],'1'); //2b
tree.add(filledIslands[5],'3'); //4b
tree.add(filledIslands[8],'5'); //6b
tree.add(filledIslands[11],'7'); //8b
//1, 2a, 3, 4a, 5, 6a, 7, 8a, 9, 10a, 11a, 10b, 11b, (2b,'1'), (4b,'3'), (6b, '5'), (8b,'7')