# Interact with Surrounding

### Priority:
Medium
### Level:
User goal
### Primary Actor:
User

### Stakeholders and Interests:
<p>
User: Wants to be able to encounter resources or islands and
make decisions regarding what to do with them.</p>

### Preconditions:

<ul>
<li>Must have started or resumed the game. </li>
<li>The ship must be positioned at an unvisited resource or unreached location.</li>
</ul>

### Postconditions:

<ul>
<li>The screen must be returned to the grid.</li>
<li>If the user has reached an island, then interact with story pop up executes. If the user
has reached a resource area, then interact with inventory executes.</li>
</ul>

### Workflow
```PlantUML
@startuml
title Interact with Surrounding
|#LightSkyBlue|User|
|#Wheat|System|

|User|
start
:moves forward;
|System|
if(surrounding exists) then (yes)
    |System|
        if (resource_area) then (yes)
            :execute Manage_Inventory;
        end
        else (island)
            :execute Complete_StoryScene;
        end
    endif
else (no)
    end
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