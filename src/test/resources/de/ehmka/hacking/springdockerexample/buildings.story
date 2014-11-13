Narrative:
 In order to quickly find out the sum of two numbers
 As a user
 I want to use a calculator to add two numbers

 Scenario: Show all buildings.

 Given There are <building>
 When I ask for all buildings
 Then I should see a list which have <number_of_buildings>

 Examples:
 |buildings    |number_of_buildings|
 |[Lipa, W200] |2|