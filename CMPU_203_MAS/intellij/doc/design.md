
## Model/Controller Design Class Diagram:

```PlantUML
@startuml

class Grid {
    ship_location : int
    islands_met : int
    --
    +executeMove() : ASurrounding
    +isBlank(a1 : ASurrounding) : Boolean
    +addRA() : void
    +getShipLocation() : int
}
Grid ->  "\nlist of surroundings 'grid'\n{ordered}" ASurrounding : \t\t\t\t
Grid -> "\nlist of islands 'all_islands'\n{ordered}" Island : \t\t\t\t

abstract class ASurrounding {
    description: String
    symbol : int
    --
    +getSymbol() : int
}
ASurrounding <|-- Island
ASurrounding <|-- ResourceArea

class ResourceArea {
    +getSymbol() : int
    +getResourceSymbol() : int
    +displayCards(): String
}

class Island {
    onMap : boolean
    found: boolean
    name : String
    --
    +setStory(s : StoryScene ) : void
    +toString() : String
    +getSymbol() : int
    +getStoryScene() : StoryScene
}

Island -> "Contains 'story'" StoryScene : \t\t\t\t

class Map {
    +addIsland(int x) : void
}
Map ->  "\nlist of islands 'all_islands'" Island : \t\t\t\t

class StoryScene {
    text1 : String
    text2 : String
    question : String
    options : String[]
    endings : String[]
    --
    +getText1() : String
    +getText2() : String
    +getQuestion() : String
    +returnEnding(x : char) : String
}

class Inventory {
    rope : int
    wood : int
    medicine : int
    {static}max : int
    --
    +addToInventory(r : ResourceArea) : void
    +removeInventory(c : char) : void
    +isFull(): Boolean
    +toString() : String
    +yesRope() : Boolean
    +yesWood() : Boolean
    +yesMedicine() : Boolean
}

class Obstacle {
    text : String
    options : String []
    results : String []
    code : int
    --
    +toString(): String
    +returnObsEnding(x : char) : String
    +getText() : String
    +getOptions() : String[]
}

class Library {
    --
    +getIslands() : Island
    +getScenes(): StoryScene []
}

Library -> "\nlist 'all_stories'" StoryScene : \t\t\t\t
Library -> "\nlist 'all_obstacles'" Obstacle : \t\t\t\t
Library -> "\nlist 'all_islands'" Island : \t\t\t\t


class MainActivity {
    doubt : int
    health : int
    --
    #onCreate(savedInstanceState : Bundle) : void
    #onSaveInstanceState(outstate : Bundle) : void
    +updateHealth(amt : int) : void
    +shipString() : String
    +onMove() : Grid
    +getGrid() : Grid
    +getInv() : Inventory
    +adjustStories() : void
    +addressAdjacent() : void
    +addressIsland() : void
    +openMap() : void
    +generateObstacle() : void
    +guaranteeObstacle() : void
    +performSolutionA(x : int) : void
    +performSolutionB(x : int) : void\
    +updateInfoBar() : void
    +onSceneDone() : void
    +gameOver() : String
    +restart() : void
}

MainActivity -> "\ncontains 'lib''" Library : \t\t\t\t
MainActivity -> "\ncontains 'inv'" Inventory : \t\t\t\t
MainActivity -> "\ncontains 'm'" Map : \t\t\t\t
MainActivity -> "\ncontains 'g'" Grid : \t\t\t\t
MainActivity -> "\ncontains 'tempObs'" Obstacle : \t\t\t\t
MainActivity -> "\ncontains 'adj'" ASurrounding : \t\t\t\t


@enduml
```

## View Design Class Diagram:

```PlantUML
@startuml

class GridViewFragment {
    FragmentGridViewBinding : binding
    listener : Listener
    {static}LOCATION : int
    {static}LOCATION_STR : String
    --
    +onSaveInstanceState(outstate : Bundle) : void
    +onViewStateRestored(saveInstanceState : Bundle) : void
    +makeArgsBundle(location : int) : {static}Bundle
    +onCreateView(inflater : LayoutInflater, container : ViewGroup, savedInstanceState : Bundle) : View
    +onViewCreated(view : View, savedInstanceState : Bundle) : void
    +updateGridView(grid : Grid) : void

}
class HomeViewFragment {
    +binding : FragmentHomeViewBinding
    listener : Listener
    --
    +onCreateView(inflater : LayoutInflater, container : ViewGroup, savedInstanceState : Bundle) : View
    +onViewCreated(view : View, savedInstanceState : Bundle) : void
    +endGame(message : String) : void
}
class MainView {
    fmanager : FragmentManager
    binding : ActivityMainBinding
    --
    +getRootView() : View
    +displayFragment(fragment : Fragment, reversible : Boolean, name : String) : void
    +refreshStats(inv : String, ship : String) : void
    +removeInfoBar() : void
}
class MapViewFragment {
    +binding : FragmentMapViewBinding
    listener : Listener
    map : Map
    --
    +onCreateView(inflater : LayoutInflater, container : ViewGroup, savedInstanceState : Bundle) : View
    +onViewCreated(view : View, savedInstanceState : Bundle) : void
    +displayMap() : void
}
class ObstacleViewFragment {
    +binding : FragmentObstacleViewBinding
    listener : Listener
    obs : Obstacle
    --
    +onCreateView(inflater : LayoutInflater, container : ViewGroup, savedInstanceState : Bundle) : View
    +onViewCreated(view : View, savedInstanceState : Bundle) : void
    +optionButtons(flip : Boolean) : void
    +flipButton(b : ImageButton, flip : Boolean) : void
}
class ResourceAreaFragment {
    +binding : FragmentRaViewBinding
    listener : Listener
    RA : ResourceArea
    --
    +flipButton(b : ImageButton, flip : Boolean) : void
    +throwResource(c : char) : void
    +showOptions(inv : Inventory) : void
    +onCreateView(inflater : LayoutInflater, container : ViewGroup, savedInstanceState : Bundle) : View
    +onViewCreated(view : View, savedInstanceState : Bundle) : void
}
class StoryViewFragment {
    +binding : FragmentStoryViewBinding
    listener : Listener
    scene : StoryScene
    curScene : int
    --
    +optionButtons(flip : Boolean) : void
    +flipButton(b : ImageButton, flip : Boolean) : void
    +onCreateView(inflater : LayoutInflater, container : ViewGroup, savedInstanceState : Bundle) : View
    +onViewCreated(view : View, savedInstanceState : Bundle) : void
}
class MaraudersFragFactory {
    {static}VIEW_PACKAGE : String
    controller : MainActivity
    --
    instantiate(classLoader : ClassLoader, className : String) : Fragment
}

interface IGridView {
    Listener : interface
}
interface IHomeView {
    Listener : interface
}
interface IMainView {
    Listener : interface
}
interface IMapView {
    Listener : interface
}
interface IObstacleView {
    Listener : interface
}
interface IResourceAreaView {
    Listener : interface
}
interface IStoryView {
    Listener : interface
}
IGridView <|.. GridViewFragment
IHomeView <|.. HomeViewFragment
IMainView <|.. MainView
IMapView <|.. MapViewFragment
IObstacleView <|.. ObstacleViewFragment
IResourceAreaView <|.. ResourceAreaFragment
IStoryView <|.. StoryViewFragment

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