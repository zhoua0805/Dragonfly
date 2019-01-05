/* Log:
 
 May 25
 Designed base engine on which game is built - 30min (Zack Lee & Alex Ka.)
 Created a prototype - 15min - Alex Ka & Zack Lee
 Experimenting with available swift platforms - 30min - (Zack Lee & Alex Ka.)
 Tested by Rylan L.
 May 28
 Created base engine - 30min (Zack Lee & Alex Ka.)
 Created player setup and board initialization - 45min (Zack Lee & Alex Ka.)
 Tested by Betty Guo and Alex Ka.
 May 29
 Basic player movement and player detection created - Full period (Zack Lee & Alex Ka.)
 Tested by Betty Guo and Alex Ka.
 May 30
 Mosquito movement - 1hr (Zack Lee & Alex Ka.)
 Mosquitos getting eaten algorithm- 15min (Zack Lee & Alex Ka.)
 Tested by Betty Guo and Alex Ka.
 May 31
 Mosquitos getting eaten polished and complete - 45min (Zack Lee & Alex Ka.)
 Player speed adjustment from eating mosquitos - 30min (Zack Lee & Alex Ka.)
 Tested by Betty Guo and Alex Ka.
 June 1
 Game end conditions - 15min (Zack Lee & Alex Ka.)
 Design wind turns, determining movement algorithm - 60min (Zack Lee & Alex Ka.)
 Tested by Betty Guo and Alex Ka.
 June 4
 Wind implementation - Full period (Zack Lee & Alex Ka.)  (Wind algorithm inspired by Lucas M.)
 Tested by Lucas M.
 June 5
 Mosquito ëscoringí - 30min (Zack Lee & Alex Ka.)
 Wind generation algorithm - 45min (Zack Lee & Alex Ka. & Rylan L. & Betty G.)
 June 7
 Code was commented, functions created for ease of use (Zack Lee & Alex Ka.)
 June 8
 Refined random generator (Betty G. & Zack Lee & Alex Ka. & Jack B.)
 */


////////////NOTES:

// Random numbers use current time, which is problematic for randomizing maosquitoes: change to 'true' randomness when dropped into xcode
// no parameters preventing players from moving off the board. Should be irrelevant when GUI mouse click elements are added


import Foundation;  // Imports various important commands

var players : [[Int]] = Array(repeating: Array(repeating: 0, count: 10), count: 10) // declares a two-dimentional array of size 10 by 10 and every element is initialized as zero (Values in this array represent players)
var evenMosquitos : [[Int]] = Array(repeating: Array(repeating: 0, count: 10), count: 10) // declares a two-dimentional array of size 10 by 10 and every element is initialized as zero (Values in this array represent even numbered mosquitoes)
var oddMosquitos : [[Int]] = Array(repeating: Array(repeating: 0, count: 10), count: 10) // declares a two-dimentional array of size 10 by 10 and every element is initialized as zero (Values in this array represent odd numbered mosquitoes)


var bulletProofer = "-1" // ensures that input for number of players is valid. initialized as if input was invalid

func boardDisplay() {
    print("\n")
    for j in 0...9 {//for each column on 'board'
        for i in 0...9{//for each row on 'board'
            print(players[i][j], terminator:"")//print player index at position
            print(evenMosquitos[i][j], terminator:"")//print even mosquito index at position
            print(oddMosquitos[i][j],"-", terminator:"")//print odd mosquito index at position
        }
        print("\n")//new line
    }
}

while (bulletProofer == "-1") { // while input isn't valid...
    print("Enter number of players:")//prompt user to enter number of players
    bulletProofer = ((readLine())!) // variable that contains user input
    if (bulletProofer != "1" && bulletProofer != "2" && bulletProofer != "3" && bulletProofer != "4") { // only 1 to 4 players are acceptable
        bulletProofer = "-1" // input is considered valid
    }
    
}


struct Wind { // Creates a structure called 'Wind'
    var directionX: Int //wind direction in the horizontal
    var directionY: Int //wind direction in the vertical
    var strength: Int //magnitude of wind
}

var windCycle = 2 //variable that cycles through wind "deck"
var generatedX: Int = 0 //temporary horizontal value for generating wind deck
var generatedY: Int = 0 //temporary vertical value for generating wind deck
var generatedStrength: Int = 0 //temporary magnitude for generating wind deck


var windList : [Wind] = [] // create an empty array of type 'Item'
windList.append (Wind(directionX: 0, directionY: 0, strength: 1)) //add two 'avoided' values to array
windList.append (Wind(directionX: 0, directionY: 0, strength: 2))
var accepted = false //temporary value to test if generated deck card is legal
for _ in 0...9 {//for each wind card
    
    let arrayLength = windList.count - 1 //change applied array length
    
    while accepted == false {//while the card generated is not a duplicate
        generatedX = Int(arc4random_uniform(UInt32(3)))-2 // randomize new x
        generatedY = Int(arc4random_uniform(UInt32(2)))-1 // randomize new y
        generatedStrength = Int(arc4random_uniform(UInt32(2))) // randomize new magnitude
        
        accepted = true//set accepted to true
        
        for i in 0...arrayLength {
            if ( (windList [i]).directionX == generatedX && (windList [i]).directionY == generatedY && (windList [i]).strength == generatedStrength ) { //if the wind card generated is already in the array
                accepted = false //set accepted to false
            }
        }
        
    }
    windList.append (Wind(directionX: generatedX, directionY: generatedY, strength: generatedStrength)) // adds the number as an Item to the array, categorized as an integer
    accepted = false//reset accepted clause
}


let numPlayers = (Int(bulletProofer))! // converts the string input for number of players to an integer

var evenNum = 0 // declares a variable for the number of even numbered mosquitoes on the field and initializes it as zero
var oddNum = 0 // declares a variable for the number of mosquitoes on the field and initializes it as zero
var playerMax = 0 // declares a variable for the maximum number of players in currently playing

switch numPlayers { // depending on the number of players playing...
case 1 : // if there is one player playing...
    playerMax = 1 //set player max to 1
    players[1][5] = 1 //initialize player position
    for i in 0...4 {//create mosquitos at respective positions, randomize mosquito type
        print()
        if arc4random_uniform(UInt32(2)) == 1 && evenNum < 3 {
            evenMosquitos[i*2][0]=1
            evenNum+=1
        } else if oddNum < 2 {
            oddMosquitos[i*2][0]=1
            oddNum+=1
        } else {
            evenMosquitos[i*2][0]=1
            evenNum += 1
        }
    }
case 2 : // if there is one player playing...
    playerMax = 2 //set player max to 2
    players[1][5] = 1 //initialize player positions
    players[8][5] = 2
    for i in 0...4 {//create mosquitos at respective positions, randomize mosquito type
        if arc4random_uniform(UInt32(2)) == 1 && evenNum < 3 {
            evenMosquitos[i*2][0]=1
            evenNum+=1
        } else if oddNum < 2 {
            oddMosquitos[i*2][0]=1
            oddNum+=1
        } else {
            evenMosquitos[i*2][0]=1
            evenNum += 1
        }
    }
case 3 : // if there is one player playing...
    playerMax = 3 //set player max to 2
    players[1][5] = 1 //initialize player positions
    players[3][5] = 3
    players[8][5] = 2
    for i in 0...8 {
        if i != 3 && i != 5 {//create mosquitos at respective positions, randomize mosquito type
            if arc4random_uniform(UInt32(2))  == 1 && evenNum < 3 {
                evenMosquitos[i][0]=1
                evenNum+=1
            } else if oddNum < 4 {
                oddMosquitos[i][0]=1
                oddNum+=1
            } else {
                evenMosquitos[i][0]=1
                evenNum += 1
            }
        }
    }
case 4 : // if there is one player playing...
    playerMax = 4 //set player max to 2
    players[1][5] = 1 //initialize player positions
    players[3][5] = 3
    players[6][5] = 4
    players[8][5] = 2
    for i in 0...9 {//create mosquitos at respective positions, randomize mosquito type
        if arc4random_uniform(UInt32(2))  == 1 && evenNum < 5 {
            evenMosquitos[i][0]=1
            evenNum+=1
        } else if oddNum < 5 {
            oddMosquitos[i][0]=1
            oddNum+=1
        } else {
            evenMosquitos[i][0]=1
            evenNum += 1
        }
    }
default :
    break
}

var exitGame = false; //exit game clause
var currentPlayer = 0; //current player turn variable
var moveTurns = 0; //initialize and set player speed
var mosquitosEaten: [Int] = [0,0,0,0,0] //initialize mosquotos eaten array
var speedAdjust = 0; //initialize speed adjustment from eating mosquitos
var cx = 0; //initialize current player x
var cy = 0; //initialize current player y

while exitGame == false { //while the game has not ended
    
    moveTurns = 3;//reset movement speed
    
    if currentPlayer < playerMax { //cycle to next player turn
        currentPlayer += 1
    } else {
        currentPlayer = 1
    }
    
    for j in 0...9 {//look for current player and store position
        for i in 0...9{
            if players[i][j] == currentPlayer {
                cx = i
                cy = j
            }
        }
    }
    
    if mosquitosEaten[currentPlayer] == 2 || mosquitosEaten[currentPlayer] == 3 {//adjust player speed based on the number of mosquitos they have eaten
        speedAdjust = -1;
    } else if mosquitosEaten[currentPlayer] == 4 {
        speedAdjust = -2;
    } else if mosquitosEaten[currentPlayer] > 4 {
        speedAdjust = -3;
    }
    
    moveTurns += speedAdjust; //adjust speed
    
    //dice roll input goes here
    let dice = arc4random_uniform(UInt32(6))+1  //random 1-6
    for j in stride(from: 8, to: -1, by: -1 ) {//count from bottom to top, left to right
        for i in 0...9{
            if dice%2 == 0 {//if the dice roll was odd move all odd mosquitos down
                if evenMosquitos[i][j] > 0 {
                    evenMosquitos[i][j+1] += evenMosquitos[i][j]
                    evenMosquitos[i][j] = 0
                    if players[i][j+1] > 0{
                        mosquitosEaten[currentPlayer] += evenMosquitos[i][j+1]
                        evenMosquitos[i][j+1] = 0
                    }
                }
            } else {//if the dice roll was even move all even mosquitos down
                if oddMosquitos[i][j] > 0 {
                    oddMosquitos[i][j+1] += oddMosquitos[i][j]
                    oddMosquitos[i][j] = 0
                    if players[i][j+1] > 0{
                        mosquitosEaten[currentPlayer] += oddMosquitos[i][j+1]
                        oddMosquitos[i][j+1] = 0
                    }
                }
            }
        }
    }
    
    boardDisplay()
    
    while moveTurns > 0 { //for each player speed
        moveTurns -= 1//reduce turn number
        var moved = false//set has moved clause
        
        while !moved {//while the player has not made an appropriate move
            let moveInput = (readLine())! //read input
            if moveInput == "7" && players[cx-1][cy-1] == 0 {//if corrseponding direction is free, move to that location and set move clause to true
                players[cx][cy] = 0
                players[cx-1][cy-1] = currentPlayer
                cx = cx-1; cy = cy-1;
                moved = true
            } else if moveInput == "8" && players[cx][cy-1] == 0 {
                players[cx][cy] = 0
                players[cx][cy-1] = currentPlayer
                cy = cy-1;
                moved = true
            } else if moveInput == "9" && players[cx+1][cy-1] == 0 {
                players[cx][cy] = 0
                players[cx+1][cy-1] = currentPlayer
                cx = cx+1; cy = cy-1;
                moved = true
            } else if moveInput == "6" && players[cx+1][cy] == 0 {
                players[cx][cy] = 0
                players[cx+1][cy] = currentPlayer
                cx = cx+1;
                moved = true
            } else if moveInput == "3" && players[cx+1][cy+1] == 0 {
                players[cx][cy] = 0
                players[cx+1][cy+1] = currentPlayer
                cx = cx+1; cy = cy+1;
                moved = true
            } else if moveInput == "2" && players[cx][cy+1] == 0 {
                players[cx][cy] = 0
                players[cx][cy+1] = currentPlayer
                cy = cy+1;
                moved = true
            } else if moveInput == "1" && players[cx-1][cy+1] == 0 {
                players[cx][cy] = 0
                players[cx-1][cy+1] = currentPlayer
                cx = cx-1; cy = cy+1;
                moved = true
            } else if moveInput == "4" && players[cx-1][cy] == 0 {
                players[cx][cy] = 0
                players[cx-1][cy] = currentPlayer
                cx = cx-1;
                moved = true
            } else if moveInput == "5"{//stay in place
                moved = true
            }
            
            if evenMosquitos[cx][cy] > 0{ //if there are even mosquitos at the players position
                mosquitosEaten[currentPlayer] += evenMosquitos[cx][cy] //eat them
                evenMosquitos[cx][cy] = 0
            } else if oddMosquitos[cx][cy] > 0 { //if there are odd mosquitos at the players position
                mosquitosEaten[currentPlayer] += oddMosquitos[cx][cy] //eat them
                oddMosquitos[cx][cy] = 0
            }
            
        }
        boardDisplay()
    }
    
    
    print((windList[windCycle]).directionX," ",(windList[windCycle]).directionY," ",(windList[windCycle]).strength)//print wind, used for testing REMOVE LATER
    
    let wDH = (windList[windCycle]).directionX//wind direction in the horizontal
    let wDV = (windList[windCycle]).directionY//wind direction in the vertical
    let wM = (windList[windCycle]).strength//wind magnitude
    if windCycle == 12 {//if the wind 'deck' has been fully drawn
        windCycle = 2//start from beginning
    } else {windCycle+=1}//else next card
    var tempMosquitosXEven : [Int] = Array(repeating: 0, count: 10)//initialize temporary even mosquito x
    var tempMosquitosYEven : [Int] = Array(repeating: 0, count: 10)//initialize temporary even mosquito y
    var tempMosquitosMagnitudeEven : [Int] = Array(repeating: 0, count: 10)//initialize temporary even mosquito magnitude
    var tempCounterEven = 0//initialize even temporary counter
    
    var tempMosquitosXOdd : [Int] = Array(repeating: 0, count: 10)//initialize temporary even mosquito x
    var tempMosquitosYOdd : [Int] = Array(repeating: 0, count: 10)//initialize temporary even mosquito y
    var tempMosquitosMagnitudeOdd : [Int] = Array(repeating: 0, count: 10)//initialize temporary even mosquito magnitude
    var tempCounterOdd = 0//initialize odd temporary counter
    
    for j in 0...9 {///find all mosquitos and store position, magnitude
        for i in 0...9{
            if evenMosquitos[i][j] > 0 {
                tempMosquitosXEven[tempCounterEven] = i
                tempMosquitosYEven[tempCounterEven] = j
                tempMosquitosMagnitudeEven[tempCounterEven] = evenMosquitos[i][j]
                tempCounterEven += 1
            }
            if oddMosquitos[i][j] > 0 {
                tempMosquitosXOdd[tempCounterOdd] = i
                tempMosquitosYOdd[tempCounterOdd] = j
                tempMosquitosMagnitudeOdd[tempCounterOdd] = oddMosquitos[i][j]
                tempCounterOdd += 1
            }
        }
    }
    
    for k in 0...tempCounterEven {//for each found even mosquito
        if ( ((tempMosquitosXEven[k]+wM*wDH)<=9) && ((tempMosquitosXEven[k]+wM*wDH)>=0) && ((tempMosquitosYEven[k]+wM*wDV)<=9) ) {//if space is free
            evenMosquitos[tempMosquitosXEven[k]][tempMosquitosYEven[k]] = 0//move there
            evenMosquitos[tempMosquitosXEven[k]+wM*wDH][tempMosquitosYEven[k]+wM*wDV] = tempMosquitosMagnitudeEven[k]
        } else if ( wM == 2 && ((tempMosquitosXEven[k]+1*wDH)<=9) && ((tempMosquitosXEven[k]+1*wDH)>=0) && ((tempMosquitosYEven[k]+1*wDV)<=9) ) {//else if on a diagnol and can move one space
            evenMosquitos[tempMosquitosXEven[k]][tempMosquitosYEven[k]] = 0//move only one space
            evenMosquitos[tempMosquitosXEven[k]+1*wDH][tempMosquitosYEven[k]+1*wDV] += tempMosquitosMagnitudeEven[k]
        }
    }
    for k in 0...tempCounterOdd {//for each found odd mosquito
        if ( ((tempMosquitosXOdd[k]+wM*wDH)<=9) && ((tempMosquitosXOdd[k]+wM*wDH)>=0) && ((tempMosquitosYOdd[k]+wM*wDV)<=9) ) {//if space is free
            oddMosquitos[tempMosquitosXOdd[k]][tempMosquitosYOdd[k]] = 0//move there
            oddMosquitos[tempMosquitosXOdd[k]+wM*wDH][tempMosquitosYOdd[k]+wM*wDV] = tempMosquitosMagnitudeOdd[k]
        } else if (wM == 2 && ((tempMosquitosXOdd[k]+1*wDH)<=9) && ((tempMosquitosXOdd[k]+1*wDH)>=0) && ((tempMosquitosYOdd[k]+1*wDV)<=9) ) {//else if on a diagnol and can move one space
            oddMosquitos[tempMosquitosXOdd[k]][tempMosquitosYOdd[k]] = 0//move only one space
            oddMosquitos[tempMosquitosXOdd[k]+1*wDH][tempMosquitosYOdd[k]+1*wDV] += tempMosquitosMagnitudeOdd[k]
        }
    }
    
    boardDisplay()
    
    var mosquitoFound = false//set temporary clause for found mosquitos
    for j in 0...8 {
        for i in 0...9{
            if evenMosquitos[i][j] > 0 || oddMosquitos[i][j] > 0 {//search each position, if ANY mosquitos are found on the board, mosquito found clause is set to true
                mosquitoFound = true
            }
        }
    }
    
    if mosquitoFound == false {//if mosquitos were not found
        exitGame = true//end game
    }
}

print("Game end!")//end game message, DELETE THIS LATER
