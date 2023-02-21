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
ASurrounding <|-- ResourceArea

class ResourceArea {}
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
    +toString() : String 
}

class Inventory {
    rope : int
    wood : int 
    --
    +displayInventory() : void
    -update_inventory(rope : int, wood : int) : void
}

class Game {
    +run_game()
}
@enduml
```
## Sequence Diagram Ideas:

### Display story:

Story:
grid calls identifyIslands whenever user moves --> tells island to bring up story scene -->
story class runs its display method


Game:
scanner takes in input --> grid class handles the movement w/ multiple methods







