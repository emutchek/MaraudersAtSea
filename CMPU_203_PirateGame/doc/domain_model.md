```PlantUML
@startuml
hide circle
hide empty methods
' classes
class Map{
landmarks
}
class Surroundings{
location
description
}
class Grid {
environment
ship location
}
class Ship {
health
}
class StoryScene {
chronology
text
}
class Game {
progress
}
class Island {}
class Debris {}
class Landmass {}

' associations
Surroundings "1-10" -- "1" Grid : \tLocated on \t\t
Surroundings "1" -- "1" Map : \tPrompts\t\t
Surroundings "1" -- "1" Landmass : \tDescribes \t\t
Surroundings "1" -- "1" Debris : \tDescribes \t\t
Surroundings "1" -- "1" Island : \tDescribes \t\t
Ship "1" -- "1" Grid : \tLocated on \t\t
Island "1" -- "1" StoryScene : \tContains \t\t

@enduml
```