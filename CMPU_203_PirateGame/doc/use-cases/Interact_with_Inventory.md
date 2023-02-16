# Interact with Inventory

### Priority:
low
### Level:
User goal
### Primary Actor:
User

### Stakeholders and Interests:
<p>
User: Wants to be able to view the resources on the ship (i.e. food, lumber, rope, etc.), pick up new items
on the journey, and "spend" items in order to get past obstacles.</p>

### Preconditions:

<ul>
<li>Must have started or resumed the game. </li>
<li>To add an item, the ship must be positioned on a predetermined resource location which they have
not yet visited.</li>
</ul>

### Postconditions:

<ul>
<li>After adding a resource to the inventory, that data should be saved and appear the next time
they view their items.</li>
<li>After closing the inventory, the regular grid view should reappear.</li>
<li>After using a resource in the inventory, it should disappear from the list going forward
and no longer be viewable by the user.</li>
</ul>

### Workflow
```PlantUML
@startuml
title Manage Inventory
|#LightSkyBlue|User|
|#Wheat|System|

|User|
start
:open inventory;
|System|
:display inventory;
|User|
if (remove an item?) then (yes)
|System|
:throw item overboard;
end
else (no)
end

@enduml
```
```PlantUML
@startuml
title Add item
|#LightSkyBlue|User|
|#Wheat|System|

|System|
start
:Interact_Surroundings;
if(room in inventory) then (yes)
:add item to inventory;
:remove item from world map;
end
else (no)
end
    
@enduml
```
```PlantUML
@startuml
title Remove item
|#LightSkyBlue|User|
|#Wheat|System|

|System|
start
if(involves resources) then (yes)
    |User|
    if(choose to spend item) then (yes)
    |System|
        :remove item from inventory;
        :execute solution;
        end
    else (no)
        end
    endif
else (no)
    end
endif
    
@enduml
```

### Non-Functional requirements:
<ul>
<li>Usability: The button to open the inventory must be easily identifiable not relying on color
contrast, the text must be large.</li>
<li>Performance: The user must be able to refer to the inventory quickly enough that it doesn't interfere
with other open dialogue prompts.</li>
<li>Reliability: The system must always display the most recently saved inventory data.</li>
<li>Supportability: Not-applicable. </li>
</ul>