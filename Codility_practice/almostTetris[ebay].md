almostTetris[ebay]

You have a sheet of n × m grid paper and you'd like to draw a cool design on it. You've decided on a block motif similar to tetris pieces. Specifically, your picture will include the following five types of figures:

Image of Figures

1. *

2. * * *

3. * *
   * *

4. *
   * *
   *

5.   *
   * * *
The array figures contains a list of integers representing the types of figures you'd like to include in your design. Your task is to create a matrix of integers representing the grid paper, and draw the figures on it according to the following rules:

Start with a matrix of all 0s, and use the 1-based index of each figure to represent it on the grid. For example, if figures[0] = 5 then the shape added to the grid will look like this:
[[0, 1, 0],
[1, 1, 1]]
Place the figures on the grid in the order they appear in figures. The figures must not overlap any other figures that have already been placed, and they may not be rotated.
Of all the available locations, choose the one with the lowest row index.
If there are multiple possible locations with the lowest row index, choose the one among them with the lowest column index.
It's guaranteed that all figures will fit on the grid.
Return a matrix of integers representing the grid paper after all the figures have been drawn.

Example

For n = 4, m = 4, and figures = [4, 2, 1, 3], the output should be

almostTetris(n, m, figures) =
[[1, 2, 2, 2],
[1, 1, 3, 0],
[1, 4, 4, 0],
[0, 4, 4, 0]]
example

Input/Output

[execution time limit] 4 seconds (php)

[input] integer n

An integer representing the height of the grid.

Guaranteed constraints:
2 ≤ n ≤ 50.

[input] integer m

An integer representing the width of the grid.

Guaranteed constraints:
2 ≤ m ≤ 50.

[input] array.integer figures

An array of integers representing figures to be drawn on the paper.

Guaranteed constraints:
1 ≤ figures.length ≤ 500,
1 ≤ figures[i] ≤ 5.

[output] array.array.integer

Return the resulting paper, after drawing all figures on it.