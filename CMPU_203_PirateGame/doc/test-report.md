# Test Report

### Grid
<ul>
<li>User input: 'W'</li>
<li>Result:</li>
|X| | |
| | | |
| | | |
| | | |
| |Δ| |
<li>Correctness: The grid printed as expected.</li>

<li>User input: 'W'</li>
<li>Result:</li>
| | | |
|X| | |
| | | |
| | | |
| |Δ| |
<li>Correctness: The grid printed as expected. Surrounding objects have moved down one row since previous move.</li>
</ul>


### Inventory
<ul>
<li>User input: 'I' then 'C'</li>
<li>Result:</li>
INVENTORY:
Rope: 50 ft
Wood: 50 logs
Medicine: 50 oz
Do you want to remove something from inventory? (R) for rope, (W) for wood, (M) for medicine, or (C) for cancel
<li>Correctness: The inventory printed as expected. The current totals for each resource were displayed, as well
as the option to remove.</li>
</ul>

<ul>
<li>User input: 'I' then 'R'</li>
<li>Result:</li>
Updated inventory:
INVENTORY:
Rope: 40 ft
Wood: 50 logs
Medicine: 50 oz
<li>Correctness: The updated inventory printed as expected. The amount of rope decreased.</li>
</ul>

### Story
<ul>
<li>User input: 'W' (stories are automatically triggered when the user moves next to an island")</li>
<li>Result:</li>
"After a week of sailing, the crew reached...(Island)""
<li>Correctness: The story scene associated with this island successfully printed.</li>
</ul>

<ul>
<li>User input: 'W' then 'A'</li>
<li>Result:</li>
[story text]..."What is your choice?"(Q)
A: We understand, but we'd still like to stay
or
B: Nothing gets between me and my coffer - we don't need your food anyway
Choose action A or B
A
The man nods gravely. “Very well“
<li>Correctness: The story scene printed correctly, followed by the associated question. The user chose A, which
in this case was the affirmative option, and the corresponding response appeared. </li>
</ul>

### Resource Areas
<ul>
<li>User input: 'W' then 'A' (Resource areas automatically pop up when the user moves next to one)</li>
<li>Result:</li>
|X|Δ| |
Oh look! Some wood. Do you want to grab it? A for yes, B for no (Q)
Choose action A or B
A
Updated inventory:
INVENTORY:
Rope: 40 ft
Wood: 60 logs
Medicine: 50 oz
<li>Correctness: The modification to the inventory was successful. The amount of wood increased.</li>
</ul>

<ul>
<li>User input: 'W' then 'B'</li>
<li>Result:</li>
Oh look! Some wood. Do you want to grab it? A for yes, B for no (Q)
Choose action A or B
B
Updated inventory:
INVENTORY:
Rope: 40 ft
Wood: 70 logs
Medicine: 50 oz
<li>Correctness: The interaction was successful; the inventory values remained the same as before the question as asked.</li>
</ul>


### Obstacle
<ul>
<li>User input: 'A' (Obstacles occur at random intervals without user input, but they are asked which solution to implement)/li>
<li>Result:</li>
A: Give Meels a vial of medicine and keep her quarantined
or
B: People get sick all the time! Let's play limbo on the deck
A
Good call - she's feeling much better.
<li>Correctness: The correct message was printed given the user's choice, A, to give the medicine.</li>
</ul>

### Map
<ul>
<li>User input: M</li>
<li>Result:</li>
MAP OF THE EASTERN ISLANDS
Island 0
Island 1
Island 2
Island 3
<li>Correctness: The map printed correctly; only islands which the user had reached at this point were displayed</li>
</ul>

<ul>
<li>User input: Y (The user is automatically prompted to add an island to the map after they have reached it)</li>
<li>Result:</li>
Do you want to add this island to the map? Y or N
Y
MAP OF THE EASTERN ISLANDS
Island 0
Island 1
Island 2
Island 3
Island 4
<li>Correctness: The map printed correctly; island 4 was added to the end.</li>
</ul>

<ul>
<li>User input: N (The user is automatically prompted to add an island to the map after they have reached it)</li>
<li>Result:</li>
Do you want to add this island to the map? Y or N

<li>Correctness: If the user selects no, the map view does not appear. Therefore, this feature is performing as expected.</li>
</ul>
