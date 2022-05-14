# Galactic Quadrant Analysis Program

## Introduction and Problem Statement

<p align="justify">
  Greetings, this project is an extension from one of my Algorithm Subject's assignment. The original assignment is mainly about implementing and applying graph related algorithms on solving various problems. In that case, I was given a few tasks to solve.
</p>

  - The tasks are:
    - to create an adjacency list and matrix
    - to display edges and planets sorted using merge sort algorithm
    - to implement dynamic programming via 0/1 knapsack algorithm
    - to apply Dijkstra's algorithm to find the shortest path

<p align="justify">
  In the original assignment, I was given a scenario to assist the captain of a spaceship who collects items/products from a number of planets in a galactic quadrant. There are 3 maps, but I only had to do one map. My task is to do some analysis on the quadrant map. I had to create an association among the planets with respect to the quadrant map given by creating the adjacency list and matrix for visualization. In addition, I had to list out the sorted edges and planets using a sorting algorithm which I have chosen to apply the merge sort algorithm. Next, I had to find the shortest path from home planet to each planet by aplying the Dijkstra's algorithm. Finally, I have to identify the optimum set of planets to visit in order to collect their materials/minerals before returning home through dynamic programming via 0/1 knapsack algorithm. The original assignment is built using C++.
  
  So for this project, I have done a massive modification and refinement. I decided to convert the program from C++ to Java language and add GUI to the program by using Java Swing library where users can have a more friendly environment to use this program. The original assignment only need to do 1 map but I have done all the 3 maps and I also added one more map so it fulfills the meaning of galactic quadrant where each map represents a quadrant in the galaxy where I am residing in. 
  
  Furthermore, I also add a more coherent story to the program. Assuming a scenario where the users / us are in a civilization living on a planet located on the center of a galaxy known as Epsilon. In Epsilon, it is divided into 4 quadrants, which are Alpha, Beta, Gamma and Delta quadrants. In every quadrant, there are 10 planets, which are Planet A to Planet J. Every Planet A in every quadrant is also considered as a home planent. Planet A is also where our headquarters are located at. So our main task is to choose a quadrant to scout and explore the area, study and analysis the planets. To do this task with ease, we can use this program to learn the details and information of planet on every quadrant. The main function of this program is to give users the information on every planet and quadrant details like distance, route, mineral weight and profit before scouting the quadrants.
</p>

<p align="center">
  <img width="35%" src="https://github.com/Yong-Wai-Chun/Vacation-Planner/blob/main/Components/cmd1.png?raw=true">
  <br> Figure 1: VS code CMD
</p>

## Instructions and Explanation

!!! PLEASE MAKE SURE ALL THE FILES AND FOLDERS INCLUDING THE COMPONENTS FOLDER ARE INCLUDED IN THE SAME DIRECTORY !!!
1. Run only the Main.java file.
2. Please make sure all the other java files and the 'components' folder are in the same directory.
3. The first page has 3 buttons which are start, help and exit. 
    
    a. Start will bring user to the next page.
    
    b. Help will give user instructions.
    
    c. Exit will quit the whole program.

4. After pressing the start button, it will bring user to the next page where user can see some instruction on what to do. Then press next.
5. After that, the next page is where user choose one quadrant out of 4. (Alpha,Beta,Gamma and Delta)
6. After choosing a quadrant, the next page user can see the details of the planets, the quadrant map and the home planet's(Planet A) appearance. In addition, user will have 4 options:

    a. Randomize - randomize a new set of planets details.
    
    b. Quadrant Map's Detail - Adjacency list & matrix and the sorted edges and planets.
    
    c. Planet's Materials Mining - 0/1 Knapsack Problem (Dynamic Programming).
    
    d. Shortest Route Distance - Shortest Path from every planet to Planet A.
    
7. Every page, there is a home and back button. User can press home button to go back to the first page, back button to the previous page.

## Sample Outputs

<p align="center">
  <img width="35%" src="https://github.com/Yong-Wai-Chun/Vacation-Planner/blob/main/Components/cmd1.png?raw=true">
  <br> Figure 1: VS code CMD
</p>

## Motivation and Contribution

<p align="justify">
  The main motivation of this project is to learn and apply different kinds of algorithms. Besides, I wanted to learn and practise more on Java Swing library which is a fun GUI library to use. However Swing has a lot of restriction when it comes to design part, there isnt much freedom to configure the design that I intended to.
</p>

## Backend (Algorithm) Discussion

<p align="justify">
  In this project, there are 3 sub-programs and some algorithms worth mentioning and discussing. First and foremost, for the quadrant map's detail program, adjacency list and adjacency matrix are displayed. Adjacency list is a form of visualization on a graph / map. For example, if Planet A is connected to Planet B and Planet C, it will look like this, Planet A: Planet B(distance) -> Planet C(distance). As for adjacency matrix, it is similar to adjacency list, it is only another form of visualization. The overall concepts are the same. Next in the same program, the display of edges and planets are sorted using merge sort algorithm. Merge sort is a sorting algorithm based on the divide-and-conquer method. It is a stable and not-in-place algorithm. Stable algorithm preserves the order of records with equal keys after processing. Not-in-place algorithm requires an additional temporary data structure to store the temporary result, then use the temporary result to obtain the final result and store the final result back to the original data structure.
  
  In the next program which is planet's materials mining. In this program, it will choose the optimum planets to visit and collect the materials and minerals. The maximum capacity/weight is 80 tons. Assume that if the ship cannot return to the home planet in the midst visiting other planets. This program utilizes dynamic programming via 0/1 knapsack algorithm. In the end, a matrix is created onto a csv file called matrix.csv and total weight and total and profit is calculated.
</p>
