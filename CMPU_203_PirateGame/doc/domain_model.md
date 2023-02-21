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
class ResourceArea{}

' associations
Surroundings "1-10" -- "1" Grid : \tLocated on \t\t
Surroundings "1" -- "1" ResourceArea : \tAppear as \t\t
Surroundings "1" -- "1" Island : \tAppear as \t\t
Ship "1" -- "1" Grid : \tLocated on \t\t
StoryScene "1" -- "1" Island : \tTake place on \t\t
Map "1" -- "1-10" Island : \tContains \t\t

@enduml
```