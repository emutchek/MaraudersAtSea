```PlantUML
@startuml

class Grid {
    ship_location : int
    --
    +toString() : String
    +populateGrid() : void
    +move() : void
    +identifyIslands() : void
}
Grid ->  "\nlist of surroundings\n{ordered}" ASurrounding : \t\t\t\t

abstract class ASurrounding {
    descr : String
    location : int 
    --
    +toString() : String
}
ASurrounding <|-- Island
ASurrounding <|-- Landmass
ASurrounding <|-- Debris

class Landmass {}
class Debris {}
class Island {
    discovered : boolean
}


class Map {
--
    +toString() : String
    +addItem() 

}
Map ->  "\nlist of islands" Island : \t\t\t\t

class StoryScene {
    text : String
    --
    -displayCards() : void
}

class Ship {
    health : int
    --
    -update_health(amount : int) : void
    +displayHealth() : void
}

class Inventory {
    debrisMaterial : int
    landmassMaterial : int 
    --
    +displayInventory() : void
    -update_inventory(debrisAmt : int, landmassAmt : int) : void
}
@enduml
```
### Sequence Diagram Ideas:

Display story:

grid calls identifyIslands whenever user moves --> tells island to bring up story scene -->
story class runs its display method

Moving:

scanner within the move method that verifies user's input , increments ship position, calls populate grid, 
and calls toString
