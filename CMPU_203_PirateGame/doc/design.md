```PlantUML
@startuml

class Grid {
    ship_location : int
    islands_met : int
    grid : String [][]
    --
    +toString() : String
    +populateGrid() : void
    +move() : String
    +atSurrounding() : Boolean
}
Grid ->  "\nlist of surroundings\n{ordered}" ASurrounding : \t\t\t\t

abstract class ASurrounding {
    symbol : String
    --
    +getSymbol() : String
}
ASurrounding <|-- Island
ASurrounding <|-- ResourceArea

class ResourceArea {
    +toString() : String
}

class Island {
    onMap : boolean
    found: boolean
    --
    +setStory() : void
    +toString() : String
    +displayCards() : String
}

Island -> "Contains a single" StoryScene : \t\t\t\t

class Map {
    +toString() : String
    +addIsland() : void 
}
Map ->  "\nlist of islands" Island : \t\t\t\t

class StoryScene {
    text : String
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

class UserInterface {
    +run_game()
}

class Controller {
    +isValid() : boolean
    +respondInput() : String
}
@enduml
```
## Sequence Diagrams:

### Movement
```PlantUML
@startuml
hide footbox
actor User as user
participant ": UserInterface" as game
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







