### Problems Staring us in the Face

<ul>
<li>They need to be able to launch the inventory/map/pause screen while they're reading an obstacle card or else how will
they know if they have the stuff</li>
<li>Add rubber/steel-like resource to glossary and give name</li>
<li>Move Ship use case is entangled with add inventory- 
low key the same thing-- fix?? change??</li>
<li>If they refuse to put something on the map, we still need to know they got there</li>
<li>The choice to do the right thing comes 50-75% of the way through, not the very end, but it will end the game early</li>
<li>Make an encounters use case to deal with obstacles, resources, etc. and then subfunctions</li>
</ul>

### Domain model conceptual classes:
<ul>
<li>MAP (array of surroundings objects)</li>
<li>GAME (progress)</li>
<li>GRID (environment, ship_location</li>
<li>SHIP (health)</li>
<li>SURROUNDINGS (location, description)</li>
<li>STORYSCENE (chronology, text)</li>
<li>ISLAND</li>
<li>DEBRIS</li>
<li>LANDMASS</li>
</ul>

### Domain model relationships:
<ul>
<li>surroundings prompt Map</li>
<li>Ship is located on Grid</li>
<li>Island contains StoryScene</li>
<li>Surroundings are located on Grid (0..10)</li>

</ul>