# Move Ship

### Priority: 
high
### Level: 
User goal
### Primary Actor: 
User

### Stakeholders and Interests: 
<p>
User: Wants to be able to move the ship quickly and intuitively as they navigate the islands. Should be able to interact 
with the islands around the ship as well as move the ship forwards and back with minimal effort.
</p>

### Preconditions:

<ul>
<li>Must have started or resumed the game. </li>
<li>The position of the ship must be autosaved so the user can pick up where they
left off.</li>
</ul>

### Postconditions:

<ul>
<li>The ship must look as if it has moved, so the surroundings must have changed. </li>
<li>If the move interacted with anything on the side, the correct prompt must appear/the correct event must be
set in motion</li>
<li>The user's progress must be autosaved.</li>
</ul>

### Workflow 
```PlantUML
@startuml
title Move Ship
|#LightSkyBlue|User|
|#Wheat|System|

|User|
start
:Give movement command;

|System|
if (valid move?) then (no)
end
else (yes)
if (at a landmark?) then (yes)
:interact;

endif
:move ship;

stop

@enduml
```

### Non-Functional requirements:
<ul>
<li>Usability: Grid is large enough that movement commands ar easily recognizable. </li>
<li>Performance: Must move the ship fast enough so that the movement looks smooth.</li>
<li>Reliability: Data, such as ship's progress, must be saved at least up to a recent checkpoint</li>
<li>Supportability: Not-applicable</li>
</ul>