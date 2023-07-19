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
	curIsland = null;
	constructor() {
		this.head = null;
		this.size = 0;
	}
	// adds a whole-number island to the end of list 
	add(element, attachTo = '', connect = true) {
		var node = new IslandNode(element);
		// edge case: inserting first node
		if (this.head == null) {
			this.head = node;
			
			console.log(node.element);
		}
		// adding onto end of tree (left side)
		else if (attachTo == '') {
			var current = this.head;
			while (current.baseLeft) {
				current = current.baseLeft;
			}
            current.baseLeft = node;
			console.log(`${current.element}->${node.element}`);
		}
		// inserting a right-side node into middle of tree
		else {
			var current = this.head;
			while (current.baseLeft && current.element != attachTo) {
				current = current.baseLeft;
			}
			node.baseLeft = current.baseLeft.baseLeft; 
			current.baseRight = node; 
			//console.log(`current is ${current.element}, current left left is ${current.baseLeft.baseLeft.element}`);
			
			console.log(`${current.element}->${node.element}->${node.baseLeft.element}`);

		}
		this.size++;
	}
	// moves pointer, then returns value
	getNextIsland(aOrDefault = true) {
		// return very first island
		if (this.curIsland == null) {
			this.curIsland = this.head;
			return this.curIsland.element;
		}
		// either there's no branch, or they're going to 'a' version
		if (aOrDefault) {
			  
			this.curIsland = this.curIsland.baseLeft;
			return this.curIsland.element;
		}
		// going to 'b' version
		this.curIsland = this.curIsland.baseRight;
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
tree.add('2b','1');
tree.add('4b','3');
tree.add('6b','5');
tree.add('8b','7');
tree.add('10b','9',false);
console.log('done adding');

console.log(tree.getNextIsland()); // null->0
console.log(tree.getNextIsland()); // 0->1
console.log(tree.getNextIsland(false)); // 1->2
console.log(tree.getNextIsland()); // 2->3
console.log(tree.getNextIsland(false)); // 3->4
console.log(tree.getNextIsland()); // 4->5
console.log(tree.getNextIsland()); // 5->6
console.log(tree.getNextIsland()); // 6->7
console.log(tree.getNextIsland(false)); // 7->8
console.log(tree.getNextIsland()); // 8->9
console.log(tree.getNextIsland()); // 9->10




// code from: https://stackoverflow.com/questions/38600545/how-to-import-a-text-file-content-to-javascript
$.get('./islandText.txt',{},function(content){
    let lines=content.split('n');
    //console.log(`"file.txt" contains ${lines.length} lines`)
    //console.log(`First line : ${lines[0]}`)
});


