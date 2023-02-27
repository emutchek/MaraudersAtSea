# Respond to story pop-up

### Priority: 
high
### Level: 
user goal
### Primary Actor: 
User

### Stakeholders and Interests:
<p>
User: Wants to view an excerpt of the story, presented on a series of cards, and sometimes
choose between two courses of action on how to proceed. </p>

### Preconditions:

<ul>
<li>Must have started or resumed the game. </li>
<li>Must have reached an island. There is a story pop up associated with each and every
island, and it is automatically triggered when the ship moves into the island's range.</li>
</ul>

### Postconditions:

<ul>
<li>If the user makes a choice to spend less energy on the map a certain number of times,
then they will receive an alternate ending in the last few scenes of the game.</li>
<li>Any modifications that the user has made to the map has taken effect.</li>
<li>The user's progress in the story has been autosaved.</li>
<li>Screen has returned to the usual grid interface.</li>
</ul>

### Workflow
```PlantUML
@startuml
title Respond to Story Prompt
|#LightSkyBlue|User|
|#Wheat|System|

|System|
start
while (more cards?) is (yes)
    :display story card;
    |User|
    :swipe card;

|System|
if (action required) then (yes)
    :display options;
    |User|
    :pick option;

|System|
:trigger response;

endif
endwhile (no)
stop
@enduml
```

### Non-Functional requirements:
<ul>
<li>Usability: Large, readable text, big buttons that are easy to press. </li>
<li>Performance: Story cards transition in under 30 seconds and close promptly when finished.</li>
<li>Reliability: The system remembers which story cards have already been displayed and shows the appropriate ones.</li>
<li>Supportability: Not-applicable. </li>
</ul>