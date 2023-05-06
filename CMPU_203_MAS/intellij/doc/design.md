
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

### General helper frame
```PlantUML
@startuml
hide footbox
mainframe sd OnSceneDone

participant ": Old GridViewFragment" as ogvf
participant ": MainActivity" as ma
participant ": GridViewFragment" as gvf
participant ": HomeViewFragment" as hvf

ma -> ogvf : makeArgsBundle(ship location)
ma -->> gvf **: create(this)
gvf -> gvf : setArguments(bundle)
ma -> gvf : displayFragment(GridViewFragment, true, name)
ma -> ma : updateInfoBar()
ma -> ma : gameOver()
alt gameOver
ma -->> hvf **: create(this)
ma -> hvf : displayFragment(HomeViewFragment, false, name)
ma -> ma : removeInfoBar()
end

@enduml
```


### Helper frame 1 for move
```PlantUML
@startuml
hide footbox
mainframe sd MakeMove
participant ": MainActivity" as ma
participant ": Grid" as grid

ma -> ma : adjustStories()
ma -> grid : executeMove()
ma <<-- grid **: Grid
@enduml
```

### Helper frame 2 for move
```PlantUML
@startuml
hide footbox
mainframe sd AddressAdjacent
participant ": MainActivity" as ma

alt instanceOfIsland
ref over ma
EncounterIsland
end ref
else instanceOfRA
ref over ma
EncounterRA
end ref
else instanceOfObstacle
ref over ma
GenerateObstacle
end ref
end

@enduml
```

### Move
```PlantUML
@startuml
hide footbox
actor User as user
participant ": GridViewFragment" as gvf
participant ": MainActivity" as ma
participant ": Grid" as grid

user -> gvf : presses sail button
gvf -> ma : onMove
ref over ma
MakeMove
end ref
grid <<-- ma **: create()
gvf -> gvf : updateGridView(Grid)
gvf -> ma : addressAdjacent()
ref over ma
AddressAdjacent
end ref

@enduml
```

### Open Map
```PlantUML
@startuml
hide footbox
actor User as user
participant ": GridViewFragment" as gvf
participant ": MainActivity" as ma
participant ": MapViewFragment" as mvf

user -> gvf : presses map button
gvf -> ma : openMap()
ma -->> mvf** : create (Map, this)
ma -> ma : displayFragment (MapViewFragment, true, name)
mvf -> ma : getGrid()
mvf <-- ma : location
mvf -> mvf : update binding
user -> mvf : presses exit button
mvf -> ma : onSceneDone()
ref over ma
OnSceneDone
end ref

@enduml
```

### Encounter Island
```PlantUML
@startuml
mainframe sd EncounterIsland
hide footbox

participant ": MainActivity" as ma
participant ": Island" as island
participant ": StoryViewFragment" as svf
participant ": Map" as map

ma -->> island ** : create ()
alt notAtEnd
ma -> map : addIsland(islandsMet)
end
ma -->> svf ** : create (StoryScene, this)
ma -> svf : displayFragment(StoryViewFragment, this, name)
ref over svf
EncounterStory
end ref

@enduml
```

### Helper frame 1 for Encounter Story
```PlantUML
@startuml
mainframe sd QuestionButtons
hide footbox
participant ": StoryViewFragment" as svf
participant ": StoryScene" as ss
ss -> ss : getQuestion()
alt noQuestion
svf -> svf : update binding
end
@enduml
```

### Helper frame 2 for Encounter Story
```PlantUML
@startuml
mainframe sd ExecuteStoryChoice
hide footbox
actor User as user
participant ": StoryViewFragment" as svf
participant ": StoryScene" as ss
participant ": MainActivity" as ma
alt A
user -> svf : presses A
svf -> ss : getEnding()
svf <-- ss : ending
svf -> svf : update binding
else B
user -> svf : presses B
svf -> ss : getEnding()
svf <-- ss : ending
svf -> svf : update binding
end
svf -> ma : addressIsland()
ma -> ma : adjusts plot variables
@enduml
```

### Encounter Story
```PlantUML
@startuml
mainframe sd EncounterStory
hide footbox
actor User as user
participant ": StoryViewFragment" as svf
participant ": StoryScene" as ss
participant ": MainActivity" as ma


svf -> svf : update binding
user -> svf : press next button
alt moreScenes
svf -> ss : getText2()
svf <-- ss : text2
svf -> svf : update binding
ref over svf
QuestionButtons
end ref
else !moreScenes
ref over svf
QuestionButtons
end ref
svf -> ss : getQuestion()
svf <-- ss : question
svf -> svf : update binding
end
ref over svf
ExecuteStoryChoice
end ref
user -> svf : presses exit button
svf -> ma : onSceneDone()
ref over ma
OnSceneDone
end ref


@endUML
```

### Encounter Resource Area
```PlantUML
@startuml
mainframe sd EncounterRA
hide footbox
participant ": MainActivity" as ma
participant ": ResourceArea" as ra
participant ": Inventory" as inv
participant ": ResourceAreaFragment" as raf

actor User as user


ma -->> ra **: create()
ma -->> raf **: create(ResourceArea, this)
ma -> raf : displayFragment(ResourceAreaFragment, true, name)
user -> raf : press pickup button
alt inventoryFull
raf -> raf : update binding
raf -> ma : getInv()
raf <-- ma : Inventory
raf -> raf : showOptions(Inventory)
user -> raf : presses item button
raf -> inv : removeInventory (item)
raf -> inv : addToInventory (ResourceArea)
raf -> ma : updateInfoBar()
end
user -> raf : presses exit button
raf -> ma : onSceneDone()
ref over ma
OnSceneDone
end ref
@enduml
```

### Generate Obstacle
```PlantUML
@startuml
hide footbox

participant ": Library" as lib
participant ": MainActivity" as ma
participant ": Obstacle" as o
participant ": ObstacleViewFragment" as ovf
actor User as user

alt 1/4 chance
ma -> lib : get obstacle
ma -->> ovf **: create(Obstacle, this)
ma -> ovf : displayFragment(ObstacleAreaFragment, true, name)

alt A
user -> ovf : press option A
ovf -> o : returnObsEnding('A')
ovf <-- o : ending A
ovf -> ovf : update binding
ovf -> ma : performSolutionA()
end
alt B
user -> ovf : press option B
ovf -> o : returnObsEnding('B')
ovf <-- o : ending B
ovf -> ovf : update binding
ovf -> ma : performSolutionB()
end
user -> ovf : presses exit button
ovf -> ma : onSceneDone()
ref over ma
OnSceneDone
end ref
end
@enduml
```