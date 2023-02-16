# Interact with Encounter

### Priority:
Medium
### Level:
User goal
### Primary Actor:
User

### Stakeholders and Interests:
<p>
User: Wants to be able to encounter resources or critical places on the map and
make decisions regarding what to do with them.</p>

### Preconditions:

<ul>
<li>Must have started or resumed the game. </li>
<li>The ship must be positioned at an unvisited resource or unmapped location.</li>
</ul>

### Postconditions:

<ul>
<li>If the user doesn't use the encounter, the screen must be returned to the grid.</li>
<li>If the user decides to use the encounter, execute Resource or execute Map.</li>
</ul>

### Workflow
```PlantUML
@startuml
title Interact Encounter
|#LightSkyBlue|User|
|#Wheat|System|

|User|
start
:select location;
|System|
if(encounter exists) then (yes)
    |User|
    if(choice?) then (yes)
    |System|
        if (resource) then (yes)
        :Add item in Interact_With_Inventory;
        end
        else if (map landmark) then (yes)
        :Add item in Interact_With_Map;
        end
 
    endif
else (no)
    end
endif
    
@enduml
```

### Non-Functional requirements:
<ul>
<li>Usability: The encounter must be clearly visible on the grid. The buttons 
to make choices in the pop-up should be large and easy to press.</li>
<li>Performance: The user must be able to refer to the inventory, health, or map 
quickly to check their progress before or while making the choice.</li>
<li>Reliability: The system must always display the most recently saved 
inventory or map data.</li>
<li>Supportability: Not-applicable. </li>
</ul>