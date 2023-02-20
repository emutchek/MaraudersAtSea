```PlantUML
@startuml

class Grid {
    ship_location: int
}
Grid ->  "\nlist of surroundings\n{ordered}" ASurrounding : \t\t\t\t

abstract class ASurrounding {
    descr: String
    location : int 
}
ASurrounding <|-- Island
ASurrounding <|-- Landmass
ASurrounding <|-- Debris

class Landmass {}
class Debris {}
class Island {}

class Map {}
Map ->  "\nlist of islands" Island : \t\t\t\t

class StoryScene {
    text : String
}
Map ->  "\nlist of islands" Island : \t\t\t\t
@enduml
```

