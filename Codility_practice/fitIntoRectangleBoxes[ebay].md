 # fitIntoRectangleBoxes

 You are given operations, an array containing the following two types of operations:

[0, a, b] - Create and save a rectangle of size a × b;
[1, a, b] - Answer the question: "Could every one of the saved rectangles fit in a box of size a × b". It is possible to rotate rectangles by 90 degrees; ie: a rectangle of dimensions a × b can be rotated so that its dimensions are b × a. Note: We're trying to fit each rectangle within the box separately (not all at the same time).
Your task is to return an array of booleans, representing the answers to the second type of operation, in the order they appear.

Example

For operations = [[1, 1, 1]], the output should be rectangleBoxes(operations) = [true].

There are no rectangles, so they all can be fit in any box.

For operations = [[0, 1, 3], [0, 4, 2], [1, 3, 4], [1, 3, 2]], the output should be
rectangleBoxes(operations) = [true, false].
```
[0, 1, 3]  *
		   *
		   *

[0, 4, 2] * * * *
		  * * * *

[1, 3, 4]  _ _ _ 
		  |	    |
		  |	    |
		  |	    |
		  |	    |
		   - - - 
[1, 3, 2] _ _ _
    	 |	   |
		 |	   |
		  - - - 
```
example

A 1 × 3 rectangle is added;
A 4 × 2 rectangle is added;
We need to check if it's possible to store each of the rectangles from operations 1 and 2 into a 3 × 4 area.
The rectangle from the 1st operation can be stored as-is.
The rectangle from the 2nd operation can be rotated to become 2 × 4 and after that it will fit.
Both rectangles will fit, so add a true to the result.
We need to check if it's possible to store each of the rectangles from operations 1 and 2 into a 3 × 2 area.
The rectangle from the 1st operation can be rotated to become 3 × 1 and after that it will fit.
The rectangle from the 2nd operation will not fit, even if it's rotated.
Not all of the rectangles could be stored, so add a false to the result.
So the final answer is [true, false].

Input/Output

[execution time limit] 4 seconds (php)

[input] array.array.integer operations

An array of operations in the format described above.

Guaranteed constraints:
1 ≤ operations.length ≤ 105,
operations[i].length = 3,
operations[i][0] is either 0 or 1,
1 ≤ operations[i][1] ≤ 105,
1 ≤ operations[i][2] ≤ 105.

[output] array.boolean

An array of booleans, where true means that for the request [1, a, b] it is possible to store all the rectangles, and false means the opposite.