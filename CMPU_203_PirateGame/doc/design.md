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

```PlantUML
@startuml

class Grid {
    ship_location : int
    islands_met : int
    --
    +toString() : String
    +toStringHelper(ASurrounding x) : String
    +addResourceArea(): void
    +move() : String
}
Grid ->  "\nlist of surroundings\n{ordered}" ASurrounding : \t\t\t\t
Grid -> "\nlist of islands\n{ordered}" Island : \t\t\t\t

abstract class ASurrounding {
    description: String
    symbol : String
    --
    +getSymbol() : String
}
ASurrounding <|-- Island
ASurrounding <|-- ResourceArea

class ResourceArea {
    +getSymbol() : String
    +displayCards(): String
}

class Island {
    onMap : boolean
    found: boolean
    name : String
    --
    +setStory(StoryScene s) : void
    +toString() : String
    +displayCards() : String
    +displayEnding(char c) : String
    +getSymbol() : String
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
    medicine : int
    --
    +addToInventory(ResourceArea r) : void
    +removeInventory(char c) : void
    +isFull(): Boolean
    +toString() : String
}

class Obstacle {
    text : String
    options : String []
    results : String []
    code : int
    --
    +toString(): String
    +returnObsEnding(char x) : String
}

class Library {
    --
    +getIslands() : Island
    +getScenes(): StoryScene []
}

Library -> "\nlist of all StoryScenes" StoryScene : \t\t\t\t
Library -> "\nlist of all Obstacles" Obstacle : \t\t\t\t
Library -> "\nlist of all Islands" Island : \t\t\t\t

class UserInterface {
    +run_game()
}

class Controller {
    --
    +isValid() : boolean
    +respondInput() : String
    +makeMove(): String
    +addressResource(char choice): boolean
    +callRemoveInventory(char c): void
    +addressIsland(char choice): String
    +addToMap(): void
    +generateObstacle: String
    +performSolutionA(int x): void
    +performSolutionB(int x): void
    +addressObstacle(char c): String
}
UserInterface -> Controller
Controller -> UserInterface
Controller -> "\ncontains" Library : \t\t\t\t
Controller -> "\ncontains" Ship : \t\t\t\t
Controller -> "\ncontains" Inventory : \t\t\t\t
Controller -> "\ncontains" Map : \t\t\t\t
Controller -> "\ncontains" Grid : \t\t\t\t


@enduml
```

## Sequence Diagrams:

### Movement
```PlantUML
@startuml
hide footbox
actor User as user
participant ": UserInterface" as UI
participant ": Controller" as controller
participant ": Grid" as grid
participant ": Island" as island
user -->> UI **: enters move
UI ->> controller **: isValid()
UI ->> controller **: respondInput()
controller ->> grid **: move()
ref over grid
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







