# Respond to story pop-up

### Priority: 
high
### Level: 
user goal
### Primary Actor: 
User

### Stakeholders and Interests:
<p>
User: Wants to be able to navigate through a series of story cards and then choose between a few courses of action. </p>

### Preconditions:

<ul>
<li>Must have started or resumed the game. </li>
<li>Must have progressed far enough through the world to trigger this particular event.</li>
</ul>

### Postconditions:

<ul>
<li>Any inventory or map decision that the user made has taken effect.</li>
<li>Their progress in the story has been autosaved.</li>
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