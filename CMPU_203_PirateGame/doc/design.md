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
    --
    +callStoryScene() : String
}

Island -> "Contains a single" StoryScene : \t\t\t\t

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
## Sequence Diagrams:

### Movement
```PlantUML
@startuml
hide footbox
actor User as user
participant ": Game" as game
participant ": Grid" as grid
participant ": Island" as island
user -->> game **: enters move
game ->> grid **: parseInput()
grid -->> island **: IdentifyIslands()
ref over island
Display Story
endref
@enduml
```

### Display Story
```PlantUML
@startuml
mainframe sd Display Story
hide footbox
participant ": Island" as island
alt IsIsland
    island -> storyscene: callStoryScene
else !IsIsland
end
@enduml
```







