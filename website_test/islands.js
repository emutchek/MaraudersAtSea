class IslandNode {
	// constructor
	constructor(element) {
		this.element = element;
		this.baseLeft = null;
		this.right = null;
	}
}
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
			while (current.baseLeft && current.element != '9') current = current.baseLeft;
			while (current.baseRight) current = current.baseRight;
            current.baseRight = node;
		}
	}
	add(element, attachTo = '') {
		var node = new IslandNode(element);
		if (this.head == null) { // edge case: inserting first node
			this.head = node;
		}
		else if (attachTo == '' && element.slice(-1)=='b') { // adding onto end of tree (right side)
			this.addToEnd(false,node);
		}
		else if (attachTo == '') { // adding onto end of tree (left side)
			this.addToEnd(true,node);
		}
		else { // inserting a right-side node into the middle of the tree
			var current = this.head;
			while (current.baseLeft && current.element != attachTo) {
				current = current.baseLeft;
			}
			node.baseLeft = current.baseLeft.baseLeft; 
			current.baseRight = node; 
		}
		this.size++;
	}
	
	getNextIsland(aOrDefault = true) { // moves pointer, then returns value
		if (this.curIsland.element == '9') aOrDefault = earnedGoodEnding();
		// return very first island
		if (this.curIsland == null) this.curIsland = this.head;
		// either there's no branch, or they're going to 'a' version
		else if (aOrDefault) this.curIsland = this.curIsland.baseLeft;
		else this.curIsland = this.curIsland.baseRight; // going to 'b' version
		return this.curIsland.element;
	}
}

var tree = new Tree();
tree.add('0');
tree.add('1');
tree.add('2a');
tree.add('3');
tree.add('4a');
tree.add('5');
tree.add('6a');
tree.add('7');
tree.add('8a');
tree.add('9');
tree.add('10a');
tree.add('11a');
tree.add('10b');
tree.add('11b');
tree.add('2b','1');
tree.add('4b','3');
tree.add('6b','5');
tree.add('8b','7');

const filledIslands = []; // array of json objects
const islandsTexts = []; //array of chunks of text
import emptyIsland from './islands.json' assert { type: 'json' };
$.get('./islandText.txt',{},function(content){
	islandsTexts=content.split('|');
});

// code from: https://stackoverflow.com/questions/38600545/how-to-import-a-text-file-content-to-javascript
function fillIslands () {
	for(let x=0; x < 1; x++) {
		let islandTexts=islandsTexts[0].split(':');
			

			let temp = emptyIsland["islands"][0];
			console.log(temp["text"]);
			emptyIsland["text"] = islandText[0];
			filledIslands.push(emptyIsland);
		
	}
}
fillIslands()
//console.log(filledIslands[0]["text"]);


