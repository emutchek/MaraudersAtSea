# Respond to obstacle

### Priority:
low
### Level:
User goal
### Primary Actor:
User

### Stakeholders and Interests:
<p>
User: Wants to address the random obstacles in a way that allow them to use their 
skills and inventory to fix the problem swiftly.</p>

### Preconditions:

<ul>
<li>Must have started or resumed the game, but not be at the end of the story. </li>
<li>Must be on the regular grid view.</li>
</ul>

### Postconditions:

<ul>
<li>The obstacle card has closed and been replaced with the regular grid interface.</li>
<li>Any resources that were used have been permanently removed from the inventory.</li>
<li>The function to launch obstacles at random times has been reset.</li>
<li>The obstacle card has been marked as used and removed from the deck.</li>
</ul>

### Workflow
```PlantUML
@startuml
title Respond to Obstacle
|#LightSkyBlue|User|
|#Wheat|System|

|System|
start
:display obstacle card;
|User|
:selects from options;
|System|
:execute solution;
if (health depleted) then (yes)
    |User|
    :end game;
    end
else (no)
|System|
:close card;
endif

stop
@enduml
```

### Non-Functional requirements:
<ul>
<li>Usability: Readable text, big buttons that are easy to press, ability to open inventory view
while considering the obstacle card. </li>
<li>Performance: Obstacle card opens and closes in under thirty seconds.</li>
<li>Reliability: The system remembers which obstacles cards have already been displayed to avoid any repeats.</li>
<li>Supportability: Not-applicable. </li>
</ul>