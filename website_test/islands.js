// BinaryTree class
class Tree {
	curIsland = null;
	constructor() {
		this.head = null;
		this.size = 0;
	}
	add(node, attachTo = '', onLeft = false, middleNode = false) {
		var current = this.head;
		if (this.head == null) {   // edge case: inserting first node
			this.head = node;
		}
		else if (attachTo == '') { // adding onto end of tree (left side)
			while (current.baseLeft) current = current.baseLeft;
            current.baseLeft = node;
		}
		else {                      // attaching onto a specific node
			if (attachTo.slice(-1)=='b') { // attaching to a node that's on the right 
				while (current.baseLeft && current.tag != attachTo) {
					if(current.baseRight) current = current.baseRight;
					else current = current.baseLeft;
				}
			}
			else {
				while (current.baseLeft && current.tag != attachTo) current = current.baseLeft;		
			}
			if (onLeft) current.baseLeft = node;
			else {
				if (middleNode) node.baseLeft = current.baseLeft.baseLeft;  // in the middle of the tree; must connect at bottom
				current.baseRight = node;
			}
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
		// round 1:
		var current = this.head;
		while(current.baseLeft) {
			if(current.baseRight) console.log(`${current.tag}: L(${current.baseLeft.tag}),R(${current.baseRight.tag})`);
			else console.log(`${current.tag}: L(${current.baseLeft.tag})`);
			current = current.baseLeft;
		}
		current = this.head;
		//round 2:
		while(current.baseLeft) {
			if(current.tag.slice(-1)=='b') console.log(`${current.tag}: L(${current.baseLeft.tag})`);
			if(current.baseRight) current = current.baseRight;
			else current = current.baseLeft;
		}
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
		//tree.printTree();
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
		obj["opGd"] = fieldTexts[2];
		obj["opBd"] = fieldTexts[3];
		obj["outcomeGd"] = fieldTexts[4];
		obj["outcomeBd"] = fieldTexts[5];
		obj["effectTypeGd"] = fieldTexts[6];
		obj["effectTypeBd"] = fieldTexts[7];
		filledIslands.push(obj);
	}
	fillTree(filledIslands,tree);
}

loadText(tree);
//node, attach to, on left, middle node
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
	tree.add(filledIslands[16]); // done with left side
	tree.add(filledIslands[15],'9',false);
	tree.add(filledIslands[17], '10b',true); // done with 10b and 11b
	tree.add(filledIslands[3],'1',false,true); 
	tree.add(filledIslands[6],'3',false,true); 
	tree.add(filledIslands[9],'5',false,true);
	tree.add(filledIslands[12],'7',false,true); 
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

