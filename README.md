# Crud Character Crusher
###### There is a sql file included in this repo, to build the databases and include the default data that I generate every run through. 
###### This being the User with ID 1 called System Generated. 
###### This also including 100 generated users.
###### This also including 2 leaderboard entries.
## How to use;
 - [ ] First start by creating a user, with
`Post localhost:8081/user/create `

The body should contain `{"name":  "<Name Here>"}` 
You should receive a user Id and the name back out from this.
 - [ ] From here you can now create your fighter,
 `Post localhost:8081/char/create`
 `{"intel":5,`
 `"str":5,`
 `"dex":10`
 `"con":5,`
 `"users":{`
 `"userid":  <User ID here>,`
 `"name":"<Name here>"}`
 `}`
 The rules of creating a fighter are simple, just enter in stats totalling to 25.
 So ; $Intel + Str + Dex + Con$ =25
 Your health, attack damage and speed will be calculated for you.
 Following the Formula;
 $Health = ((Con * 2) + (Str * 1.25)) * 10$
 $Damage = ((Str * 2.5) + Dex / 3) * 1.5$
 $Speed = Dex*1.5$ 
 
 - [ ] Once you've got the fighter, generate a random assortment of fighters to put yourself up again. In this instance we'll do 100, but you can change this number.
 `Post localhost:8081/char/generate/100`
 
 - [ ] Now all that is left is to use a get request, with your Character ID, to see how they will perform in a fight versus every character. Don't worry this will always be generated for you.
 `Get localhost:8081/leaderboard/getByChar/<Your id here>`

### Why are we doing this
This project is designed to show my understanding of Java and my ability to use Spring as a framework to make a working API to be able to interact with a database and pull out information based off of the input. In this case, the input will be a character that the user creates, with stats totalling to 25
Once a character has been created it will then go through a fighting simulation on the backend to see how it ranks versus the computers pre-generated fighters, and any other fighters that have been entered into the system.
// Stretch goal for myself is adding in passive skills to also be generated with the character creation.
### How I expected the challenge to go
I am expecting this challenge to go well, being able to create everything I'm wanting to, as-well as being able to give myself further stretch tasks to help round out the project.
### What went well
Throughout the challenge I found the the use of data transfer objects very useful in getting data back out of my API, as it helped prevent the recursive nature of using a one to many mapping in the relations. 
I enjoyed the use of Jira and the smart commits to sync up my workflow with the plan I designed from the beginning. Additionally, I feel I made effective use of a feature branch model of my Git, although there is room for improvement of when commits are made and when to merge a branch in and create a new one.

### What didn't go as planned
To begin the project I over estimated how much I could get done in the set amount of time, with testing and creating of documentation as well; this has lead to several features I wanted to implement not being included in the final result.

Some of the testing became more complex due to having to readjust the tests based on what I implemented next. In the instance of implementing DTO's I had to rewrite all my tests using a ModelMapper to convert my current entity into the DTO of that entity. 

### Improvements for future revisions.
I have many ideas for improvements for future revisions of this, they are as follows.

 - Fighting
	 - Implementing status'
	 - Giving fighters Weapons
	 - Giving fighters Armour
- Status
	- Stun
	- Fire over time
	- Poison damage
	- slow
- Weapons
	- Create weapons with Stats, e.g +4 str
	- Create weapons with passive abilities, e.g ability to burn target for x turns.
	- Give weapons their own damage modifier/algorithm
- Armour
	- Create armour with Stats, e.g +5 dex
	- Create weapons with passive abilities, e.g Take 25% of total fire-damage. 

### Screenshots
All screenshots can be found through the folder Screenshots
### Test results and coverage report
Screenshots of test results can be found in the Screenshots folder.
### Jira Board link
 [Here](https://jce123.atlassian.net/jira/software/projects/DJC/boards/1) is a link to my Jira Board. 
