# Game Management

### Priority:
high
### Level:
Subfunction
### Primary Actor:
User

### Stakeholders and Interests:
<p>
User: Wants to be able to start the game, pause, resume, and exit with their data automatically saved.</p>

### Preconditions:

<ul>
<li>User launches the app on their device </li>
</ul>

### Postconditions:

<ul>
<li>When they start or resume, the grid view is launched to the last location the user reached while 
playing the game, or the beginning if it's the first time.</li>
<li>When they pause or end, the game automatically saves and the welcome menu is displayed.</li>
</ul>

### Workflow
```PlantUML
@startuml
title Start/resume game
|#LightSkyBlue|User|
|#Wheat|System|

|User|
start
if (presses go) then (start)
    |System|
    :open beginning;
    end
else (resume)
    :open recent save point;
    end
endif
@enduml
```
```PlantUML
@startuml
title End/pause game
|#LightSkyBlue|User|
|#Wheat|System|

|User|
start
:presses pause button;
|System|
:auto save progress;
:display controls;
|User|
if (presses quit) then (yes)
    |System|
    :close game;
    end
else (no)
    :wait;
    break;
endif
@enduml
```

### Non-Functional requirements:
<ul>
<li>Usability: Menu button is easily identifiable on main grid screen, does not rely on contrasting colors. </li>
<li>Performance: Saves and launches menu before any other game features try to launch or update.</li>
<li>Reliability: When the user resumes after pause, the ship, inventory, and story progress are in the
exact same place they were left; if a dialogue prompt was open, it is reopened on that view.</li>
<li>Supportability: Not-applicable. </li>
</ul>

