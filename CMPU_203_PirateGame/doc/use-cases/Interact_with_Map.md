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
<li></li>
</ul>

## Postconditions:

<ul>
<li>The ship must look as if it has moved, so the surroundings must have changed. </li>
<li>If the move interacted with anything on the side, the correct prompt must appear/the correct event must be
set in motion</li>
<li>The user's progress must be auto saved.</li>
</ul>

## Workflow


```PlantUML
@startuml 

skin rose
title Move Ship
|User|
|System|

|User|
start
:Give movement command;

|System|
if (invalid_move) then (do_nothing)
else (
if (forward) then (yes)
:Move ship forward;

endif
stop

@enduml
```
## Non-Functional requirements:
<ul>
<li>Usability: Grid is large enough that movement commands ar easily recognizable. </li>
<li>Performance: Must move the ship fast enough so that the movement looks smooth.</li>
<li>Reliability: Data, such as ship's progress, must be saved at least up to a recent checkpoint</li>
<li>Supportability: Not-applicable</li>
</ul>