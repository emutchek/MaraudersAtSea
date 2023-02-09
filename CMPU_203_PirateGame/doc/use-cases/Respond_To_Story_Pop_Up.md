# Respond to story pop-up

## Priority: high
## Level: 
<p>
User goal.
</p>

## Primary Actor: User

## Stakeholders and Interests:
<p>
User: Wants to be able to navigate through a series of story cards and then choose between a few courses of action. p>

## Preconditions:

<ul>
<li>Must have started or resumed the game. </li>
<li>Must have progressed far enough through the world to trigger this particular event.</li>
</ul>

## Postconditions:

<ul>
<li>Any inventory or map decision that the user made has taken effect.</li>
<li>Their progress in the story has been autosaved.</li>
<li>Screen has returned to the usual grid interface.</li>
</ul>

## Workflow
@startuml
skin rose
title Respond to Story Prompt
|User|
|System|

|System|
start
while (more cards?) is (yes)
    :display story card;
    |User|
    :passes card;
endwhile (no)
|System|
if (action required) then (yes)
    :display options;
endif
|User|
;pick option:
|System|
if (pick option 1) then (yes)
    :trigger option 1;
else
    :trigger option 2;
endif

stop
@enduml

## Non-Functional requirements:
<ul>
<li>Usability: Large, readable text, big buttons that are easy to press. </li>
<li>Performance: Story cards transition in under 30 seconds and close promptly when finished.</li>
<li>Reliability: The system remembers which story cards have already been displayed and shows the appropriate ones.</li>
<li>Supportability: Not-applicable. </li>
</ul>