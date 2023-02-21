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

### Game Class
<ul>
<li>Call newGame, which initializes a new Grid object and then saves it as a field</li>
    <ul>
        <li>Initializes a new grid object (isle of pirates Island second row)</li>
        <li>Initializes a new Ship, inventory, and map</li>
    </ul>
 <li>Print welcome message</li>
<li>Loop</li>
    <ul>
    <li>Input Loop</li>
        <ul>
        <li>Scanner to take in input and parse it</li>
        <li>check if valid input (M, W, H, I, Q) using trycatch else continue</li>
        </ul>
    <li>switch case:</li>
        <ul>
        <li>if M, call map.toString()</li>
        <li>if W, call grid.move()</li>
        <li>if H, call Ship.toString()</li>
        <li>if I, call Inventory.toString()</li>
        <li>else (Q)</li>
        </ul>
    <li>turn off while loop</li>
    </ul>
<li>Print exit message</li>
</ul>