// code from: https://www.geeksforgeeks.org/implementation-linkedlist-javascript/#
class Node {
	// constructor
	constructor(element) {
		this.element = element;
		this.next = null
	}
}
// linkedlist class
class LinkedList {
	constructor() {
		this.head = null;
		this.size = 0;
	}

	// adds an element at the end of list
	add(element) {
		var node = new Node(element);
		// to store current node
		var current;
		if (this.head == null)
			this.head = node;
		else {
			current = this.head;
			while (current.next) {
				current = current.next;
			}
            current.next = node;
		}
		this.size++;
	}
	// finds the index of element
	indexOf(element) {
		var count = 0;
		var current = this.head;
		while (current != null) {
			if (current.element === element)
				return count;
			count++;
			current = current.next;
		}
        // not found
		return -1;
	}
	size_of_list() {
		return this.size;
	}
}


var ll = new LinkedList();



