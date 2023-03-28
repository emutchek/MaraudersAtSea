
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
Grid ->  "\nlist of surroundings 'grid'\n{ordered}" ASurrounding : \t\t\t\t
Grid -> "\nlist of islands 'all_islands'\n{ordered}" Island : \t\t\t\t

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

Island -> "Contains 'story'" StoryScene : \t\t\t\t

class Map {
    +toString() : String
    +addIsland() : void 
}
Map ->  "\nlist of islands 'all_islands'" Island : \t\t\t\t

class StoryScene {
    text : String
    question : String
    options : String[]
    endings : String[]
    --
    +toString() : String
    +returnEnding(char x) : String
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

Library -> "\nlist 'all_stories'" StoryScene : \t\t\t\t
Library -> "\nlist 'all_obstacles'" Obstacle : \t\t\t\t
Library -> "\nlist 'all_islands'" Island : \t\t\t\t

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
Controller -> "\ncontains 'lib''" Library : \t\t\t\t
Controller -> "\ncontains 's'" Ship : \t\t\t\t
Controller -> "\ncontains 'inv'" Inventory : \t\t\t\t
Controller -> "\ncontains 'm'" Map : \t\t\t\t
Controller -> "\ncontains 'g'" Grid : \t\t\t\t


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
user -->> UI **: enters move
UI ->> controller **: isValid()
UI ->> controller : respondInput()
UI ->> controller : makeMove()
controller ->> grid **: move()
grid ->> grid : addResourceArea()
ref over controller
Encounter Island
Encounter Resource Area
endref
ref over UI 
Encounter Obstacle
endref
UI ->> controller : gameOver()
@enduml
```

### Encounter Island
```PlantUML
@startuml
mainframe sd Encounter Island
hide footbox
actor User as user
participant ": UserInterface" as UI
participant ": Controller" as controller
participant ": Island" as island
participant ": Map" as map
participant ": StoryScene" as SS
controller ->> island : displayCards()
island ->> SS : toString()
SS ->> UI : print story()
UI ->> user : print question
user ->> UI : enters response
UI ->> controller : addressIsland()
controller ->> island : displayEnding()
user ->> UI : choose to add island to map
UI ->> controller : addtoMap()
controller ->> map : addIsland()

@enduml
```
### Encounter Resource Area
```PlantUML
@startuml
mainframe sd Encounter Resource Area
hide footbox
actor User as user
participant ": UserInterface" as UI
participant ": Controller" as controller
participant ": Inventory" as inv
UI ->> controller : addressResource()
alt isFull
controller ->> UI : ask user to remove
UI ->> controller : callRemoveInventory()
controller ->> inv : removeInventory()
else !isFull
controller ->> inv : addtoInventory()

end

@enduml
```

### Encounter Obstacle
```PlantUML
@startuml
mainframe sd Encounter Obstacle
hide footbox
actor User as user
participant ": UserInterface" as UI
participant ": Controller" as controller
participant ": Inventory" as inv
participant ": Ship" as ship
participant ": Obstacle" as obs
UI ->> controller : generateObstacle()
user ->> UI : respond to Obstacle
UI ->> controller : addressObstacle()
controller ->> controller : performSolutionA()
controller ->> controller : performSolutionB()
controller ->> inv : removeInventory()
controller ->> ship : updateHealth()
controller ->> obs : returnObsEnding()
@enduml
```



