# Vision Document

## Target Audience
<ul>
<li>Players ages 10 and up.</li>
<li>Fans of popular fantasy franchises.</li>
<li>Players that prefer a more story-driven experience versus intense combat.</li>
</ul>

## Value Proposition
<p>Our app will:
<ul>
<li>Provide entertainment by placing the user in a compelling fantasy world.</li>
<li>Give the user an opportunity to explore the intricacies of a different society while confronting
their own role in systems of power</li>
<li>Provide humor and a moment of levity in the user's day.</li>
</ul>
</p>

## Main Features
<ul>
<li>A 3D grid upon which the user navigates a pirate ship.</li>
<li>A birds-eye view of everything the user passes on the ship (e.g. enemy ships, small islands, 
floating debris).</li>
<li>Pop-up dialogues with NPCs that will further the story and prompt decisions for the user
to make.</li>
<li>A larger mission that guides them through the story.</li>
<li>Automatic saves that preserves their progress and measures their health.</li>

</ul>


## Constraints
<ul>
<li>Must be able to implemented first as an entirely text-based app</li>
<li>Must be written in Java to run on Android devices</li>
</ul>

## Actors
### Primary Actor
<p>The user playing the game is the primary actor</p>

### Goals
<ul>
<li>To move the ship around</li>
<li>To interact with NPCs through dialogue</li>
<li>To encounter obstacles and make decisions about how to proceed</li>
<li>To view their progress on the map they're creating</li>
<li>To accumulate resources and treasure</li>
</ul>

## System Context Diagram
```PlantUML
@startuml
left to right direction
actor User as u
package Game{
    usecase "Game Management" as UC1
    usecase "Interact with Inventory" as UC2
    usecase "Interact with Map" as UC3
    usecase "Interact with NPCs" as UC4
    usecase "Move Ship" as UC5
    usecase "Respond to Story Pop-Up" as UC6
    usecase "Respond to Obstacles" as UC7
}

u --> UC1
u --> UC2
u --> UC3
u --> UC4
u --> UC5
u --> UC6
u --> UC7


@enduml
```