### Problems Staring us in the Face

<ul>
<li>It runs fine if we store the story scenes in game, pass them into map so that they end up as a field in map,
and then use them within map to initialize all the islands with a story scene each. After we've done that,
when we make our grid object, we can pass it this list of islands by digging into the map's field. Grid uses the
islands to make the big world map. BUT the move method needs to alert us if we're next to an island so
we can carry that out. As it stands, the grid is made up of strings - there are no island objects present
in the grid class. This makes it difficult/impossible(?) to identify/act on islands we encounter on the world map.</li>
<li>They need to be able to launch the inventory/map/pause screen while they're reading an obstacle card or else how will
they know if they have the stuff</li>
<li>If they refuse to put something on the map, we still need to know they got there</li>
<li>The choice to do the right thing comes 50-75% of the way through, not the very end, but it WILL end the game early</li>
</ul>

### Random to dos
<li>Add rubber/steel-like resource to glossary and give name</li>


