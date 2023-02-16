# Interact with NPC

### Priority:
Medium
### Level:
User goal
### Primary Actor:
User

### Stakeholders and Interests:
<p>
User: Wants to be able to choose to speak to an NPC as well as be able
to choose between response options whilst conversing with the
NPC. 
</p>

### Preconditions:

<ul>
<li>Must have started or resumed the game. </li>
<li>Must be at landmark and/or be presented with a story pop-up</li>
</ul>

### Postconditions:

<ul>
<li>Any information learned must be autosaved.</li>
<li>The user must be returned to a any story cards that
were playing out, or returned to the grid and prompted to
make the next move. </li>
</ul>

### Workflow
```PlantUML
@startuml
title Interact with NPC
|#LightSkyBlue|User|
|#Wheat|System|

|System|
start
if (interact with npc?) then (yes)

while (more conversation cards?) is (yes)
    :display conversation prompt card;

|System|
if (response required) then (yes)
    :display response options;
    |User|
    :pick option;

|System|
:display appropriate response;

endif
endwhile (no)
stop
@enduml
```

### Non-Functional requirements:
<ul>
<li>Usability: Large, readable text, big buttons that are easy to press. </li>
<li>Performance: Conversation cards transition quickly
and smoothly.</li>
<li>Reliability: The conversation cards are appropriate
responses to the options the user picks. The system also
saves the progress throughout the conversation so nothing
is skipped or repeated.</li>
<li>Supportability: Not-applicable. </li>
</ul>