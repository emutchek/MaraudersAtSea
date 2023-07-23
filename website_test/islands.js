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
		else if (attachTo == '' && node.tag.slice(-1)=='b') { // adding onto end of tree (right side)
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
		if (this.curIsland == null) this.curIsland = this.head; // return very first island
		else {
			if (this.curIsland.tag == '9') aOrDefault = earnedGoodEnding(); // force decision at island 9
			if (aOrDefault) this.curIsland = this.curIsland.baseLeft; // no branch, or going to 'a'
			else this.curIsland = this.curIsland.baseRight; // going to 'b'
		}	
		return this.curIsland;
	}
	printTree() {
		var current = this.head;
		while(current.baseLeft) {
			if(current.baseRight) console.log(`${current.tag} - L: ${current.baseLeft.tag}, R: ${current.baseRight.tag}`);
			else console.log(`${current.tag} - L: ${current.baseLeft.tag}`);
			current = current.baseLeft;
		}
		// to see right side, add this line to the 'else of add fnc:
		// console.log(`- ${current.tag} - ${node.tag} - ${node.baseLeft.tag}`);
	}
}

class IslandNode {
	constructor(){
		this.baseLeft = null;
		this.right = null;
	}
}
const tree = new Tree();

function loadText(tree) {
	$.get('./islandText.txt',{},function(content){
		fillIslands(content.split('|'),tree);
	});
}
// takes in an array of text chunks, parses them into fields for each island
function fillIslands (islandText,tree) {
	const filledIslands = [];
	for(let x = 0; x < 18; x++) {
		let sanitizedText = islandText[x].replaceAll("\r\n","");
		let fieldTexts = sanitizedText.split(':');
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
	fillTree(filledIslands,tree);
}

loadText(tree);

function fillTree(filledIslands,tree) {
	tree.add(filledIslands[0]); 
	tree.add(filledIslands[1]); 
	tree.add(filledIslands[2]); 
	tree.add(filledIslands[4]); 
	tree.add(filledIslands[5]); 
	tree.add(filledIslands[7]); 
	tree.add(filledIslands[8]); 
	tree.add(filledIslands[10]);
	tree.add(filledIslands[11]); 
	tree.add(filledIslands[13]);
	tree.add(filledIslands[14]); 
	tree.add(filledIslands[15]); 
	tree.add(filledIslands[16]); 
	tree.add(filledIslands[17]); 
	tree.add(filledIslands[3],'1'); 
	tree.add(filledIslands[6],'3'); 
	tree.add(filledIslands[9],'5');
	tree.add(filledIslands[12],'7'); 
}
/*
	18 islands total (indices 0-17)
	12 islands per trip (indices 0-11)
		0: 0
		1: 1
		2: 2a
		3: 2b
		4: 3
		5: 4a
		6: 4b
		7: 5
		8: 6a
		9: 6b
		10: 7
		11: 8a
		12: 8b
		13: 9
		14: 10a
		15: 10b
		16: 11a
		17: 11b
*/

