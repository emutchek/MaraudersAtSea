# Interact with Map

## Priority: high
## Level:
<p>
User goal.
</p>

## Primary Actor: User

## Stakeholders and Interests:
<p>
User: Wants to be able to easily tell which landmarks they've added to the map and how many are remaining.
Should be able to launch map view from the main screen and choose to add their current location if they've
found something new.
</p>

## Preconditions:

<ul>
<li>Must have started or resumed the game. </li>
<li>To add something, the ship must currently be positioned next to one of the pre-identified landmarks.</li>
<li>To view a landmark on the map, the user must have already discovered and added it.</li>
</ul>

## Postconditions:

<ul>
<li>If the user adds something to the map, from then on it must appear whenever they open it.</li>
<li>When the user exits the map view, the regular grid screen should appear.</li>
</ul>

## Workflow
```PlantUML
@startuml 

skin rose
title Interact with Map
|User|
|System|

|User|
start
:Select map view;
|System|
:open map;
if (at landmark) then (yes)
    |User|
    if(add place?) then (yes)
    |System|
    :add to map;
    else(no)
    end
    endif
else (no)
endif
stop

@enduml
```
## Non-Functional requirements:
<ul>
<li>Usability: Map has easily-readable text and shows a straightforward sequence. </li>
<li>Performance: Must launch the most up-to-date map view in less than 30 seconds</li>
<li>Reliability: Whenever the map is launched, it should display the most up-to-date save data.</li>
<li>Supportability: Not-applicable</li>
</ul>