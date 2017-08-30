#Fuga dev assignment

Oh no, it's the SPACE INVADERS! But this time, you only see them on a very noisy radar image. Your mission is to write a program that detects space invaders in this image.

The program must take a radar image as input, like the example below, and detect any of the known list of space invaders.

##Requirements:

* Advance image detection techniques are not required, brute force match is fine
* Do not focus on algorithm design, but on code structure, proper design principles, tests, readability etc.
* Production-like code is expected

##Tips:

* The noise in the radar image can be either false positives or false negatives
* Think of edge cases ... pun intended ;)


Assuming that space invaders cannot overlap

##TODO, if I would have more time (top 3 with priority descending)
1) Improve the searchForSpaceInvader algo
The first optimization that comes to mind is a substraction of the space invader from the rolling window.
Then walk through all the elements of the matrix.
For a perfect match I should end up with a matrix with only 0 values for the elements. 
Anything else would count towards allowedErrors. 
2) Use a factory pattern to generate the invaders.
3) Refactor the SpaceInvaderDetector and it's test. This is the latest component that I wrote and I didn't pay much attention to writing it.