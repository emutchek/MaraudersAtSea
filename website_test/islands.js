// code from: https://www.geeksforgeeks.org/implementation-linkedlist-javascript/#
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
	curIsland;
	constructor() {
		this.head = null;
		this.size = 0;
	}
	// adds a whole-number island to the end of list 
	add1(element) {
		var node = new IslandNode(element);
		// to store current node
		var current;
		if (this.head == null) {
			this.head = node;
			this.curIsland = node;
		}
		else {
			current = this.head;
			while (current.baseLeft) {
				current = current.baseLeft;
			}
            current.baseLeft = node;
		}
		this.size++;
	}
	// adds two branch islands to the end of list
	add2(el1,el2) {
		var node1 = new IslandNode(el1);		
		var node2 = new IslandNode(el2);
		var current = this.head;
		while (current.baseLeft) {
			current = current.baseLeft;
		}
		current.baseLeft = node1;
		current.right = node2;
		this.size += 2;
	}
	// updates 
	getNextIsland(aOrDefault) {
		// either there's no branch, or they're going to 'a' version
		if (aOrDefault) { 
			let ans = this.curIsland.baseLeft.element;
			this.curIsland = this.curIsland.baseLeft;
			return ans;
		}
		// going to 'b' version
		let ans = this.curIsland.right.element;
		this.curIsland = this.curIsland.right;
		return ans;
	}
}

var tree = new Tree();
tree.add1('0');
tree.add1('1');
tree.add2('2a','2b');
tree.add1('3');
tree.add2('4a','4b');
tree.add1('5');
tree.add2('6a','6b');
tree.add1('7');
tree.add2('8a','8b');
tree.add1('9');
tree.add2('10a','10b');

console.log(tree.getNextIsland(true));
console.log(tree.getNextIsland(true));
console.log(tree.getNextIsland(true));
console.log(tree.getNextIsland(true));
console.log(tree.getNextIsland(true));
console.log(tree.getNextIsland(true));
console.log(tree.getNextIsland(true));
console.log(tree.getNextIsland(true));
console.log(tree.getNextIsland(true));
console.log(tree.getNextIsland(true));
console.log(tree.getNextIsland(true));



// code from: https://stackoverflow.com/questions/38600545/how-to-import-a-text-file-content-to-javascript
$.get('./islandText.txt',{},function(content){
    let lines=content.split('n');
    //console.log(`"file.txt" contains ${lines.length} lines`)
    //console.log(`First line : ${lines[0]}`)
});


