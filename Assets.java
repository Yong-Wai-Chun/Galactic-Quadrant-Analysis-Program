import java.util.*;
import java.lang.Math;
import java.text.DecimalFormat;
import java.io.*;

/* Assets class
** Most of the backend process is located in this file
** 3 class, Assets, Planet and Edge
** Association concept is applied here 
*/
public class Assets {

    private String[] p_names = {"Planet_A", "Planet_B", "Planet_C", "Planet_D", "Planet_E", "Planet_F", "Planet_G", "Planet_H", "Planet_I", "Planet_J"};  // Planet's name
    private int x,y,z; // planet coordinates
    private int weight,profit; // planet weight and profit

    private ArrayList<Planet> nPlanets  = new ArrayList<Planet>();
    private ArrayList<Planet> planets  = new ArrayList<Planet>(); // arraylist of planets
    private ArrayList<String> sortedPlanets  = new ArrayList<>(); // sorted planet
    private ArrayList<Edge> edges; // list of edges
    private ArrayList<String> sortedEdges = new ArrayList<>(); // sroted edges

    private ArrayList<LinkedList<Edge>> adjacentList = new ArrayList<LinkedList<Edge>>(10); // adjacency list
    private ArrayList<String> adjListDisplay = new ArrayList<>(); // display adjacency list

    private List<List<Integer>> matrix = new ArrayList<List<Integer>>();  // 0/1 knapsack matrix
    private ArrayList<Planet> chosenPlanets = new ArrayList<>(); // chosen planets
    private ArrayList<String> chosenDisplay = new ArrayList<>(); // display chosen planets

    private int totalWeight = 0; // total weight
    private int totalProfit = 0; // total profit
    
    private int graph[][];
    private ArrayList<String> shortestDisplay = new ArrayList<>(); // shortest path display
    private ArrayList<String> path = new ArrayList<>(); // path 
    private ArrayList<String> pathDisplay = new ArrayList<>(); // path dispay
    private final int V = 10;

    public Assets(int opt) {
        
        // set all the planets' details
        for (int i=0; i<10; i++) {
            x = getRandomNumber(1, 200); 
            y = getRandomNumber(1, 200);
            z = getRandomNumber(1, 200);

            weight = getRandomNumber(1*(i+1), 5*(i+1));
            profit = getRandomNumber(10, 100);

            planets.add(new Planet(p_names[i], x, y, z, weight, profit));
            nPlanets.add(new Planet(p_names[i], x, y, z, weight, profit));
        }
        switch(opt) {
            // calculate distance depending on which quadrant user chose
            case 0:
                edges = findDistance1(planets); 
                break;
            case 1:
                edges = findDistance2(planets);
                break;
            case 2:
                edges = findDistance3(planets);
                break;
            case 3:
                edges = findDistance4(planets);
                break;
            default:
                // code block
                break;
        }
        // compute knpasack dynamic programming
        try {
            knapsack(planets, 10 , 80);
        } catch (IOException e) {
            System.out.println(e);
        }
        
    } // end of constructor
    
    // find minimum path for Shortest path
    public int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // Dijkstra function to find the shortest path
    // algorithm for a graph represented using adjacency matrix representation
    // Adapted from geeksforgeeks, credit to https://www.geeksforgeeks.org
    public void dijkstra() {
        graph = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // default matrix
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
        shortestDisplay.clear();
        // set the matrix with new distance
        DecimalFormat f = new DecimalFormat("##.00");  
        for (int i=0; i < adjacentList.size(); i++) {
            for (int j=0; j< adjacentList.get(i).size(); j++) {
                if (adjacentList.get(i).get(j).getPlanet1().getP_name().compareTo(planets.get(i).getP_name()) != 0 ) {  
                    if (adjacentList.get(i).get(j).getPlanet1().getP_name().compareTo("Planet_A") == 0) {
                        graph[i][0] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet1().getP_name().compareTo("Planet_B") == 0) {
                        graph[i][1] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet1().getP_name().compareTo("Planet_C") == 0) {
                        graph[i][2] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet1().getP_name().compareTo("Planet_D") == 0) {
                        graph[i][3] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet1().getP_name().compareTo("Planet_E") == 0) {
                        graph[i][4] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet1().getP_name().compareTo("Planet_F") == 0) {
                        graph[i][5] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet1().getP_name().compareTo("Planet_G") == 0) {
                        graph[i][6] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet1().getP_name().compareTo("Planet_H") == 0) {
                        graph[i][7] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet1().getP_name().compareTo("Planet_I") == 0) {
                        graph[i][8] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet1().getP_name().compareTo("Planet_J") == 0) {
                        graph[i][9] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    }
                } else {
                    if (adjacentList.get(i).get(j).getPlanet2().getP_name().compareTo("Planet_A") == 0) {
                        graph[i][0] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet2().getP_name().compareTo("Planet_B") == 0) {
                        graph[i][1] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet2().getP_name().compareTo("Planet_C") == 0) {
                        graph[i][2] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet2().getP_name().compareTo("Planet_D") == 0) {
                        graph[i][3] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet2().getP_name().compareTo("Planet_E") == 0) {
                        graph[i][4] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet2().getP_name().compareTo("Planet_F") == 0) {
                        graph[i][5] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet2().getP_name().compareTo("Planet_G") == 0) {
                        graph[i][6] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet2().getP_name().compareTo("Planet_H") == 0) {
                        graph[i][7] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet2().getP_name().compareTo("Planet_I") == 0) {
                        graph[i][8] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    } else if (adjacentList.get(i).get(j).getPlanet2().getP_name().compareTo("Planet_J") == 0) {
                        graph[i][9] = (int)Math.round(adjacentList.get(i).get(j).getDistance());
                    }
                }
            }
        }

        int src = 0; // source planet
        int dist[] = new int[V]; // The output array. dist[i] will hold
        // the shortest distance from src to i
 
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];
 
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        planets.get(0).setPre(-1);
        dist[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
 
            // Mark the picked vertex as processed
            sptSet[u] = true;
 
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)
 
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    planets.get(v).setD(dist[v]);
                    planets.get(v).setPre(u);
                }
        }
        // for displaying distance and predecessor
        StringBuilder sb = new StringBuilder(""); 
        for (int i=0; i<V; i++) {
            sb.append(i);
            sb.append(":");
            sb.append(planets.get(i).getP_name());
            sb.append(" (");
            sb.append(planets.get(i).getCoorX());
            sb.append(",");
            sb.append(planets.get(i).getCoorY());
            sb.append(",");
            sb.append(planets.get(i).getCoorZ());
            sb.append(") Distance=");
            sb.append(planets.get(i).getD());
            sb.append(" Predecessor=");
            sb.append(planets.get(i).getPre());
            shortestDisplay.add(sb.toString());
            sb.setLength(0);
        }
        
        // display every planet shortest path from planet A
        pathDisplay.clear();
        for (int i=0; i<V; i++) {
            if (i < V-1) {
                path.add(planets.get(i+1).getP_name());
                int ii = planets.get(i+1).getPre();
                while (true) {
                    if (ii == -1) {
                        break;
                    }
                    path.add(0, planets.get(ii).getP_name());
                    ii = planets.get(ii).getPre();
                }
                for (int j=0; j<path.size(); j++) {
                    sb.append(path.get(j));
                    if (j < path.size()-1) {
                        sb.append(" -> ");
                    }
                }
                pathDisplay.add(sb.toString());
                sb.setLength(0);
                path.clear();
            }
        }

    }
    // get path display
    public ArrayList<String> getPathDisp() {
        return pathDisplay;
    }
    // get shortest  path display
    public ArrayList<String> getShortDisp() {
        return shortestDisplay;
    }
    // 0/1 knapsack algorithm (dynamic programming)
    public void knapsack(ArrayList<Planet> p, int pcount, int maxCap) throws IOException{

        StringBuilder sb = new StringBuilder(""); 

        // 0/1 knapsack dynamic programming
        for (int i=0; i<maxCap+1; i++) {
            matrix.add(new ArrayList<Integer>());
            matrix.get(0).add(0);
        }
        for (int item = 1; item < pcount; item++) {
            matrix.get(item).add(0);
            for (int bagsize=1; bagsize < maxCap+1; bagsize++) {
                if (p.get(item).getWeight() > bagsize) {
                    matrix.get(item).add(matrix.get(item-1).get(bagsize));
                } else {
                    matrix.get(item).add(Math.max(matrix.get(item-1).get(bagsize), matrix.get(item-1).get(bagsize - p.get(item).getWeight()) + p.get(item).getProfit()) );
                }
            }
        }
        
        
        PrintWriter writer = new PrintWriter("matrix.csv");
        writer.print("");
        writer.close();
        // read the matrix from matrix.csv file
        File file;
		FileWriter wr;
        file = new File("matrix.csv");
        if (!file.exists()) {
            wr = new FileWriter("matrix.csv");
        }

        BufferedWriter buffWrite; 

        // write the matrix on a csv file
        buffWrite = new BufferedWriter(new FileWriter("matrix.csv", true));

        for (int i=0; i<pcount; i++) {
            buffWrite.write(p.get(i).getP_name() + ",");
            for (int j=0; j<maxCap+1; j++) {
                buffWrite.write(matrix.get(i).get(j) + ",");
            }
            buffWrite.write("\n");
        }

        buffWrite.close();
        
        int res = matrix.get(pcount-1).get(maxCap);
         
        // find chosen planets
        int w = maxCap;
        for (int i = pcount-1; i > 0 && res > 0; i--) {
    
            if (res == matrix.get(i - 1).get(w)) {
                continue;   
            } else {
                // This item is included.
                chosenPlanets.add(p.get(i));
                
                // Since this weight is included its
                // value is deducted
                res = res - p.get(i).getProfit();
                w = w - p.get(i).getWeight();
            }
        }
    
        // display chosen planets
        for (int i=0; i < chosenPlanets.size(); i++) {
            sb.append(chosenPlanets.get(i).getP_name());
            sb.append(" selected: weight = "); 
            sb.append(chosenPlanets.get(i).getWeight());
            sb.append(", profit =  ");
            sb.append(chosenPlanets.get(i).getProfit()); 
            chosenDisplay.add(sb.toString());
            sb.setLength(0);
        }
    
        // get total weight    
        for (int i=0; i < chosenPlanets.size(); i++) {
            totalWeight = totalWeight + chosenPlanets.get(i).getWeight(); 
        }
        // get total profit
        for (int i=0; i < chosenPlanets.size(); i++) {
            totalProfit = totalProfit + chosenPlanets.get(i).getProfit();
        }

    }
    public ArrayList<String> getChosenDisp() { // display chosen planets 
        return chosenDisplay;
    }
    public int getTotalWeight() { // get total weight
        return totalWeight;
    }
    public int getTotalProfit() { // get total profit
        return totalProfit;
    }
    public ArrayList<LinkedList<Edge>> getRealAdjList() { // get adjacency list
        return adjacentList;
    }
    public ArrayList<String> getAdjList() { // display adjacency list
        return adjListDisplay;
    }
    public void setAdjacencyList() { // set and instantiate adjacency list
        adjacentList.clear();
        DecimalFormat f = new DecimalFormat("##.00");        
        StringBuilder sb = new StringBuilder(""); 

        // compute adjacency list, using double for loop
        for (int i=0;i<10;i++) {
            int temp_size = planets.get(i).getEdgesPlanet().size() - 1;
            for (int j=0;j<planets.get(i).getEdgesPlanet().size();j++) {
                adjacentList.add(new LinkedList<>());
                adjacentList.get(i).addFirst(planets.get(i).getEdgesPlanet().get(temp_size-j));
            }  
        }

        // for displaying adjacency list
        for (int i=0; i<10; i++) {
            sb.append(planets.get(i).getP_name());  
            sb.append(" : ");
            for (int j=0; j<adjacentList.get(i).size(); j++) {        
                if (planets.get(i).getP_name().compareTo(adjacentList.get(i).get(j).getPlanet1().getP_name()) == 0) {
                    sb.append(adjacentList.get(i).get(j).getPlanet2().getP_name());
                } else {
                    sb.append(adjacentList.get(i).get(j).getPlanet1().getP_name());
                }
                sb.append(" (");
                sb.append(f.format(planets.get(i).getEdgesPlanet().get(j).getDistance()));
                sb.append(")");
                if (j < adjacentList.get(i).size() - 1) {
                    sb.append(" -> ");
                }
                
            }
            adjListDisplay.add(sb.toString());
            sb.setLength(0);
        }
    }

    public Planet getPlanets(int i) { // get planets
        return planets.get(i);
    }
    public int getRandomNumber(int min, int max) { // randomizing intervals
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void initSort() { // inistialize sorting using merge sort
        sortedEdges.clear();
        sortedPlanets.clear();
        DecimalFormat f = new DecimalFormat("##.00"); 
        StringBuilder sb = new StringBuilder(""); 
        sort(edges, 0, edges.size()-1);
        for (int i=0; i<edges.size(); i++) {
            sb.append(edges.get(i).getE_name());
            sb.append(" (");
            sb.append(f.format(edges.get(i).getDistance()));
            sb.append(")");

            sortedEdges.add(sb.toString());
            sb.setLength(0);
        }

        sortDesc(nPlanets, 0, nPlanets.size()-1);
        for (int i=0; i<nPlanets.size(); i++) {
            sb.append(nPlanets.get(i).getP_name());
            sb.append(" (");
            sb.append(nPlanets.get(i).getCoorX());
            sb.append(",");
            sb.append(nPlanets.get(i).getCoorY());
            sb.append(",");
            sb.append(nPlanets.get(i).getCoorZ());
            sb.append(") Weight = ");
            sb.append(nPlanets.get(i).getWeight());
            sb.append(" Profit = ");
            sb.append(nPlanets.get(i).getProfit());

            sortedPlanets.add(sb.toString());
            sb.setLength(0);
        }
    }

    public ArrayList<String> getSortedEdges() { // get sorted edges
        return sortedEdges;
    }
    
    public ArrayList<String> getSortedPlanets() { // get sorted planets
        return sortedPlanets;
    }

    public ArrayList<Edge> findDistance1(ArrayList<Planet> planets) { // find distance for alpha quadrant
        double distance;
        ArrayList<Edge> edges = new ArrayList<Edge>();
        // A=0,B=1,C=2,D=3,E=4,F=5,G=6,H=7,I=8,J=9
        
        // 0. A and B
        distance=Math.sqrt( Math.pow(planets.get(0).getCoorX() - planets.get(1).getCoorX(),2) + Math.pow(planets.get(0).getCoorY() -planets.get(1).getCoorY(),2) + Math.pow(planets.get(0).getCoorZ() -planets.get(1).getCoorZ(),2) );
        edges.add(new Edge("A-B",planets.get(0),planets.get(1),distance));

        // 1. A and C
        distance=Math.sqrt( Math.pow(planets.get(0).getCoorX() - planets.get(2).getCoorX(),2) + Math.pow(planets.get(0).getCoorY() -planets.get(2).getCoorY(),2) + Math.pow(planets.get(0).getCoorZ() -planets.get(2).getCoorZ(),2) );
        edges.add(new Edge("A-C",planets.get(0),planets.get(2),distance));

        // 2. C and D
        distance=Math.sqrt( Math.pow(planets.get(2).getCoorX() - planets.get(3).getCoorX(),2) + Math.pow(planets.get(2).getCoorY() -planets.get(3).getCoorY(),2) + Math.pow(planets.get(2).getCoorZ() -planets.get(3).getCoorZ(),2) );
        edges.add(new Edge("C-D",planets.get(2),planets.get(3),distance));

        // 3. C and E
        distance=Math.sqrt( Math.pow(planets.get(2).getCoorX() - planets.get(4).getCoorX(),2) + Math.pow(planets.get(2).getCoorY() -planets.get(4).getCoorY(),2) + Math.pow(planets.get(2).getCoorZ() -planets.get(4).getCoorZ(),2) );
        edges.add(new Edge("C-E",planets.get(2),planets.get(4),distance));

        // 4. B and F
        distance=Math.sqrt( Math.pow(planets.get(1).getCoorX() - planets.get(5).getCoorX(),2) + Math.pow(planets.get(1).getCoorY() -planets.get(5).getCoorY(),2) + Math.pow(planets.get(1).getCoorZ() -planets.get(5).getCoorZ(),2) );
        edges.add(new Edge("B-F",planets.get(1),planets.get(5),distance));

        // 5. B and G
        distance=Math.sqrt( Math.pow(planets.get(1).getCoorX() - planets.get(6).getCoorX(),2) + Math.pow(planets.get(1).getCoorY() -planets.get(6).getCoorY(),2) + Math.pow(planets.get(1).getCoorZ() -planets.get(6).getCoorZ(),2) );
        edges.add(new Edge("B-G",planets.get(1),planets.get(6),distance));

        // 6. D and H
        distance=Math.sqrt( Math.pow(planets.get(3).getCoorX() - planets.get(7).getCoorX(),2) + Math.pow(planets.get(3).getCoorY() -planets.get(7).getCoorY(),2) + Math.pow(planets.get(3).getCoorZ() -planets.get(7).getCoorZ(),2) );
        edges.add(new Edge("D-H",planets.get(3),planets.get(7),distance));

        // 7. D and I
        distance=Math.sqrt( Math.pow(planets.get(3).getCoorX() - planets.get(8).getCoorX(),2) + Math.pow(planets.get(3).getCoorY() -planets.get(8).getCoorY(),2) + Math.pow(planets.get(3).getCoorZ() -planets.get(8).getCoorZ(),2) );
        edges.add(new Edge("D-I",planets.get(3),planets.get(8),distance));

        // 8. G and J
        distance=Math.sqrt( Math.pow(planets.get(6).getCoorX() - planets.get(9).getCoorX(),2) + Math.pow(planets.get(6).getCoorY() -planets.get(9).getCoorY(),2) + Math.pow(planets.get(6).getCoorZ() -planets.get(9).getCoorZ(),2) );
        edges.add(new Edge("G-J",planets.get(6),planets.get(9),distance));
        
        // 9. G and I
        distance=Math.sqrt( Math.pow(planets.get(6).getCoorX() - planets.get(8).getCoorX(),2) + Math.pow(planets.get(6).getCoorY() -planets.get(8).getCoorY(),2) + Math.pow(planets.get(6).getCoorZ() -planets.get(8).getCoorZ(),2) );
        edges.add(new Edge("G-I",planets.get(6),planets.get(8),distance));
        
        // 10. I and H
        distance=Math.sqrt( Math.pow(planets.get(8).getCoorX() - planets.get(7).getCoorX(),2) + Math.pow(planets.get(8).getCoorY() -planets.get(7).getCoorY(),2) + Math.pow(planets.get(8).getCoorZ() -planets.get(7).getCoorZ(),2) );
        edges.add(new Edge("I-H",planets.get(8),planets.get(7),distance));

        // 11. I and J
        distance=Math.sqrt( Math.pow(planets.get(8).getCoorX() - planets.get(9).getCoorX(),2) + Math.pow(planets.get(8).getCoorY() -planets.get(9).getCoorY(),2) + Math.pow(planets.get(8).getCoorZ() -planets.get(9).getCoorZ(),2) );
        edges.add(new Edge("I-J",planets.get(8),planets.get(9),distance));
        
        // 12. H and E
        distance=Math.sqrt( Math.pow(planets.get(7).getCoorX() - planets.get(4).getCoorX(),2) + Math.pow(planets.get(7).getCoorY() -planets.get(4).getCoorY(),2) + Math.pow(planets.get(7).getCoorZ() -planets.get(4).getCoorZ(),2) );
        edges.add(new Edge("H-E",planets.get(7),planets.get(4),distance));

        // 13. J and F
        distance=Math.sqrt( Math.pow(planets.get(9).getCoorX() - planets.get(5).getCoorX(),2) + Math.pow(planets.get(9).getCoorY() -planets.get(5).getCoorY(),2) + Math.pow(planets.get(9).getCoorZ() -planets.get(5).getCoorZ(),2) );
        edges.add(new Edge("J-F",planets.get(9),planets.get(5),distance));

        // 14. E and F
        distance=Math.sqrt( Math.pow(planets.get(4).getCoorX() - planets.get(5).getCoorX(),2) + Math.pow(planets.get(4).getCoorY() -planets.get(5).getCoorY(),2) + Math.pow(planets.get(4).getCoorZ() -planets.get(5).getCoorZ(),2) );
        edges.add(new Edge("E-F",planets.get(4),planets.get(5),distance));
        
        
        // A
        planets.get(0).pushEdges(edges.get(0));
        planets.get(0).pushEdges(edges.get(1));
        // B
        planets.get(1).pushEdges(edges.get(0));
        planets.get(1).pushEdges(edges.get(4));
        planets.get(1).pushEdges(edges.get(5));
        // C
        planets.get(2).pushEdges(edges.get(1));
        planets.get(2).pushEdges(edges.get(2));
        planets.get(2).pushEdges(edges.get(3));
        // D
        planets.get(3).pushEdges(edges.get(2));
        planets.get(3).pushEdges(edges.get(6));
        planets.get(3).pushEdges(edges.get(7));
        // E
        planets.get(4).pushEdges(edges.get(3));
        planets.get(4).pushEdges(edges.get(14));
        planets.get(4).pushEdges(edges.get(12));
        // F
        planets.get(5).pushEdges(edges.get(4));
        planets.get(5).pushEdges(edges.get(14));
        planets.get(5).pushEdges(edges.get(13));
        // G
        planets.get(6).pushEdges(edges.get(5));
        planets.get(6).pushEdges(edges.get(9));
        planets.get(6).pushEdges(edges.get(8));
        // H
        planets.get(7).pushEdges(edges.get(6));
        planets.get(7).pushEdges(edges.get(12));
        planets.get(7).pushEdges(edges.get(10));
        // I
        planets.get(8).pushEdges(edges.get(7));
        planets.get(8).pushEdges(edges.get(9));
        planets.get(8).pushEdges(edges.get(10));
        planets.get(8).pushEdges(edges.get(11));
        // J
        planets.get(9).pushEdges(edges.get(13));
        planets.get(9).pushEdges(edges.get(8));
        planets.get(9).pushEdges(edges.get(11));

        return edges;
    }

    public ArrayList<Edge> findDistance2(ArrayList<Planet> planets) { // find distance for beta quadrant
        
        double distance;
        ArrayList<Edge> edges = new ArrayList<Edge>();
        // A=0,B=1,C=2,D=3,E=4,F=5,G=6,H=7,I=8,J=9
        
        // A and F
        distance=Math.sqrt( Math.pow(planets.get(0).getCoorX() - planets.get(5).getCoorX(),2) + Math.pow(planets.get(0).getCoorY() -planets.get(5).getCoorY(),2) + Math.pow(planets.get(0).getCoorZ() -planets.get(5).getCoorZ(),2) );
        edges.add(new Edge("A-F",planets.get(0),planets.get(5),distance));
        
        // A and G
        distance=Math.sqrt( Math.pow(planets.get(0).getCoorX() - planets.get(6).getCoorX(),2) + Math.pow(planets.get(0).getCoorY() -planets.get(6).getCoorY(),2) + Math.pow(planets.get(0).getCoorZ() -planets.get(6).getCoorZ(),2) );
        edges.add(new Edge("A-G",planets.get(0),planets.get(6),distance));

        // A and J
        distance=Math.sqrt( Math.pow(planets.get(0).getCoorX() - planets.get(9).getCoorX(),2) + Math.pow(planets.get(0).getCoorY() -planets.get(9).getCoorY(),2) + Math.pow(planets.get(0).getCoorZ() -planets.get(9).getCoorZ(),2) );
        edges.add(new Edge("A-J",planets.get(0),planets.get(9),distance));
    
        // F and C
        distance=Math.sqrt( Math.pow(planets.get(5).getCoorX() - planets.get(2).getCoorX(),2) + Math.pow(planets.get(5).getCoorY() -planets.get(2).getCoorY(),2) + Math.pow(planets.get(5).getCoorZ() -planets.get(2).getCoorZ(),2) );
        edges.add(new Edge("F-C",planets.get(5),planets.get(2),distance));

        // F and H
        distance=Math.sqrt( Math.pow(planets.get(5).getCoorX() - planets.get(7).getCoorX(),2) + Math.pow(planets.get(5).getCoorY() -planets.get(7).getCoorY(),2) + Math.pow(planets.get(5).getCoorZ() -planets.get(7).getCoorZ(),2) );
        edges.add(new Edge("F-H",planets.get(5),planets.get(7),distance));
    
        // G and C
        distance=Math.sqrt( Math.pow(planets.get(6).getCoorX() - planets.get(2).getCoorX(),2) + Math.pow(planets.get(6).getCoorY() -planets.get(2).getCoorY(),2) + Math.pow(planets.get(6).getCoorZ() -planets.get(2).getCoorZ(),2) );
        edges.add(new Edge("G-C",planets.get(6),planets.get(2),distance));
        
        // G and H
        distance=Math.sqrt( Math.pow(planets.get(6).getCoorX() - planets.get(7).getCoorX(),2) + Math.pow(planets.get(6).getCoorY() -planets.get(7).getCoorY(),2) + Math.pow(planets.get(6).getCoorZ() -planets.get(7).getCoorZ(),2) );
        edges.add(new Edge("G-H",planets.get(6),planets.get(7),distance));
        
        // G and E
        distance=Math.sqrt( Math.pow(planets.get(6).getCoorX() - planets.get(4).getCoorX(),2) + Math.pow(planets.get(6).getCoorY() -planets.get(4).getCoorY(),2) + Math.pow(planets.get(6).getCoorZ() -planets.get(4).getCoorZ(),2) );
        edges.add(new Edge("G-E",planets.get(6),planets.get(4),distance));
    
        // J and H
        distance=Math.sqrt( Math.pow(planets.get(9).getCoorX() - planets.get(7).getCoorX(),2) + Math.pow(planets.get(9).getCoorY() -planets.get(7).getCoorY(),2) + Math.pow(planets.get(9).getCoorZ() -planets.get(7).getCoorZ(),2) );
        edges.add(new Edge("J-H",planets.get(9),planets.get(7),distance));

        // J and E
        distance=Math.sqrt( Math.pow(planets.get(9).getCoorX() - planets.get(4).getCoorX(),2) + Math.pow(planets.get(9).getCoorY() -planets.get(4).getCoorY(),2) + Math.pow(planets.get(9).getCoorZ() -planets.get(4).getCoorZ(),2) );
        edges.add(new Edge("J-E",planets.get(9),planets.get(4),distance));
    
        // C and I
        distance=Math.sqrt( Math.pow(planets.get(2).getCoorX() - planets.get(8).getCoorX(),2) + Math.pow(planets.get(2).getCoorY() -planets.get(8).getCoorY(),2) + Math.pow(planets.get(2).getCoorZ() -planets.get(8).getCoorZ(),2) );
        edges.add(new Edge("C-I",planets.get(2),planets.get(8),distance));
    
        // H and I
        distance=Math.sqrt( Math.pow(planets.get(7).getCoorX() - planets.get(8).getCoorX(),2) + Math.pow(planets.get(7).getCoorY() -planets.get(8).getCoorY(),2) + Math.pow(planets.get(7).getCoorZ() -planets.get(8).getCoorZ(),2) );
        edges.add(new Edge("H-I",planets.get(7),planets.get(8),distance));

        // H and B    
        distance=Math.sqrt( Math.pow(planets.get(7).getCoorX() - planets.get(1).getCoorX(),2) + Math.pow(planets.get(7).getCoorY() -planets.get(1).getCoorY(),2) + Math.pow(planets.get(7).getCoorZ() -planets.get(1).getCoorZ(),2) );
        edges.add(new Edge("H-B",planets.get(7),planets.get(1),distance));
    
        // E and B
        distance=Math.sqrt( Math.pow(planets.get(4).getCoorX() - planets.get(1).getCoorX(),2) + Math.pow(planets.get(4).getCoorY() -planets.get(1).getCoorY(),2) + Math.pow(planets.get(4).getCoorZ() -planets.get(1).getCoorZ(),2) );
        edges.add(new Edge("E-B",planets.get(4),planets.get(1),distance));
    
        // I and D
        distance=Math.sqrt( Math.pow(planets.get(8).getCoorX() - planets.get(3).getCoorX(),2) + Math.pow(planets.get(8).getCoorY() -planets.get(3).getCoorY(),2) + Math.pow(planets.get(8).getCoorZ() -planets.get(3).getCoorZ(),2) );
        edges.add(new Edge("I-D",planets.get(8),planets.get(3),distance));
    
        // B and D
        distance=Math.sqrt( Math.pow(planets.get(1).getCoorX() - planets.get(3).getCoorX(),2) + Math.pow(planets.get(1).getCoorY() -planets.get(3).getCoorY(),2) + Math.pow(planets.get(1).getCoorZ() -planets.get(3).getCoorZ(),2) );
        edges.add(new Edge("B-D",planets.get(1),planets.get(3),distance));
        
        // A
        planets.get(0).pushEdges(edges.get(0));
        planets.get(0).pushEdges(edges.get(1));
        planets.get(0).pushEdges(edges.get(2));
        // B
        planets.get(1).pushEdges(edges.get(15));
        planets.get(1).pushEdges(edges.get(13));
        planets.get(1).pushEdges(edges.get(12));
        // C
        planets.get(2).pushEdges(edges.get(3));
        planets.get(2).pushEdges(edges.get(5));
        planets.get(2).pushEdges(edges.get(10));
        // D
        planets.get(3).pushEdges(edges.get(15));
        planets.get(3).pushEdges(edges.get(14));
        // E
        planets.get(4).pushEdges(edges.get(13));
        planets.get(4).pushEdges(edges.get(7));
        planets.get(4).pushEdges(edges.get(9));
        // F
        planets.get(5).pushEdges(edges.get(0));
        planets.get(5).pushEdges(edges.get(3));
        planets.get(5).pushEdges(edges.get(4));
        // G
        planets.get(6).pushEdges(edges.get(1));
        planets.get(6).pushEdges(edges.get(5));
        planets.get(6).pushEdges(edges.get(7));
        planets.get(6).pushEdges(edges.get(6));
        // H
        planets.get(7).pushEdges(edges.get(12));
        planets.get(7).pushEdges(edges.get(4));
        planets.get(7).pushEdges(edges.get(6));
        planets.get(7).pushEdges(edges.get(11));
        planets.get(7).pushEdges(edges.get(8));
        // I
        planets.get(8).pushEdges(edges.get(10));
        planets.get(8).pushEdges(edges.get(14));
        planets.get(8).pushEdges(edges.get(11));
        // J
        planets.get(9).pushEdges(edges.get(1));
        planets.get(9).pushEdges(edges.get(9));
        planets.get(9).pushEdges(edges.get(8));

        return edges;
    }

    public ArrayList<Edge> findDistance3(ArrayList<Planet> planets) { // find distance for gamma quadrant
        
        double distance;
        ArrayList<Edge> edges = new ArrayList<Edge>();
        // A=0,B=1,C=2,D=3,E=4,F=5,G=6,H=7,I=8,J=9
        
        // 0. A and B
        distance=Math.sqrt( Math.pow(planets.get(0).getCoorX() - planets.get(1).getCoorX(),2) + Math.pow(planets.get(0).getCoorY() -planets.get(1).getCoorY(),2) + Math.pow(planets.get(0).getCoorZ() -planets.get(1).getCoorZ(),2) );
        edges.add(new Edge("A-B",planets.get(0),planets.get(1),distance));

        // 1. A and C
        distance=Math.sqrt( Math.pow(planets.get(0).getCoorX() - planets.get(2).getCoorX(),2) + Math.pow(planets.get(0).getCoorY() -planets.get(2).getCoorY(),2) + Math.pow(planets.get(0).getCoorZ() -planets.get(2).getCoorZ(),2) );
        edges.add(new Edge("A-C",planets.get(0),planets.get(2),distance));

        // 2. A and E
        distance=Math.sqrt( Math.pow(planets.get(0).getCoorX() - planets.get(4).getCoorX(),2) + Math.pow(planets.get(0).getCoorY() -planets.get(4).getCoorY(),2) + Math.pow(planets.get(0).getCoorZ() -planets.get(4).getCoorZ(),2) );
        edges.add(new Edge("A-E",planets.get(0),planets.get(4),distance));
    
        // 3. B and E
        distance=Math.sqrt( Math.pow(planets.get(1).getCoorX() - planets.get(4).getCoorX(),2) + Math.pow(planets.get(1).getCoorY() -planets.get(4).getCoorY(),2) + Math.pow(planets.get(1).getCoorZ() -planets.get(4).getCoorZ(),2) );
        edges.add(new Edge("B-E",planets.get(1),planets.get(4),distance));

        // 4. C and E
        distance=Math.sqrt( Math.pow(planets.get(2).getCoorX() - planets.get(4).getCoorX(),2) + Math.pow(planets.get(2).getCoorY() -planets.get(4).getCoorY(),2) + Math.pow(planets.get(2).getCoorZ() -planets.get(4).getCoorZ(),2) );
        edges.add(new Edge("C-E",planets.get(2),planets.get(4),distance));
    
        // 5. E and F
        distance=Math.sqrt( Math.pow(planets.get(4).getCoorX() - planets.get(5).getCoorX(),2) + Math.pow(planets.get(4).getCoorY() -planets.get(5).getCoorY(),2) + Math.pow(planets.get(4).getCoorZ() -planets.get(5).getCoorZ(),2) );
        edges.add(new Edge("E-F",planets.get(4),planets.get(5),distance));
        
        // 6. E and D
        distance=Math.sqrt( Math.pow(planets.get(4).getCoorX() - planets.get(3).getCoorX(),2) + Math.pow(planets.get(4).getCoorY() -planets.get(3).getCoorY(),2) + Math.pow(planets.get(4).getCoorZ() -planets.get(3).getCoorZ(),2) );
        edges.add(new Edge("E-D",planets.get(4),planets.get(3),distance));
        
        // 7. D and F
        distance=Math.sqrt( Math.pow(planets.get(3).getCoorX() - planets.get(5).getCoorX(),2) + Math.pow(planets.get(3).getCoorY() -planets.get(5).getCoorY(),2) + Math.pow(planets.get(3).getCoorZ() -planets.get(5).getCoorZ(),2) );
        edges.add(new Edge("D-F",planets.get(3),planets.get(5),distance));
    
        // 8. D and J
        distance=Math.sqrt( Math.pow(planets.get(3).getCoorX() - planets.get(9).getCoorX(),2) + Math.pow(planets.get(3).getCoorY() -planets.get(9).getCoorY(),2) + Math.pow(planets.get(3).getCoorZ() -planets.get(9).getCoorZ(),2) );
        edges.add(new Edge("D-J",planets.get(3),planets.get(9),distance));

        // 9. F and J
        distance=Math.sqrt( Math.pow(planets.get(5).getCoorX() - planets.get(9).getCoorX(),2) + Math.pow(planets.get(5).getCoorY() -planets.get(9).getCoorY(),2) + Math.pow(planets.get(5).getCoorZ() -planets.get(9).getCoorZ(),2) );
        edges.add(new Edge("F-J",planets.get(5),planets.get(9),distance));
    
        // 10. J and G
        distance=Math.sqrt( Math.pow(planets.get(9).getCoorX() - planets.get(6).getCoorX(),2) + Math.pow(planets.get(9).getCoorY() -planets.get(6).getCoorY(),2) + Math.pow(planets.get(9).getCoorZ() -planets.get(6).getCoorZ(),2) );
        edges.add(new Edge("J-G",planets.get(9),planets.get(6),distance));
    
        // 11. J and H
        distance=Math.sqrt( Math.pow(planets.get(9).getCoorX() - planets.get(7).getCoorX(),2) + Math.pow(planets.get(9).getCoorY() -planets.get(7).getCoorY(),2) + Math.pow(planets.get(9).getCoorZ() -planets.get(7).getCoorZ(),2) );
        edges.add(new Edge("J-H",planets.get(9),planets.get(7),distance));

        // 12. J and I
        distance=Math.sqrt( Math.pow(planets.get(9).getCoorX() - planets.get(8).getCoorX(),2) + Math.pow(planets.get(9).getCoorY() -planets.get(8).getCoorY(),2) + Math.pow(planets.get(9).getCoorZ() -planets.get(8).getCoorZ(),2) );
        edges.add(new Edge("J-I",planets.get(9),planets.get(8),distance));
    
        // 13. I and G
        distance=Math.sqrt( Math.pow(planets.get(8).getCoorX() - planets.get(6).getCoorX(),2) + Math.pow(planets.get(8).getCoorY() -planets.get(6).getCoorY(),2) + Math.pow(planets.get(8).getCoorZ() -planets.get(6).getCoorZ(),2) );
        edges.add(new Edge("I-G",planets.get(8),planets.get(6),distance));
    
        // 14. I and H
        distance=Math.sqrt( Math.pow(planets.get(8).getCoorX() - planets.get(7).getCoorX(),2) + Math.pow(planets.get(8).getCoorY() -planets.get(7).getCoorY(),2) + Math.pow(planets.get(8).getCoorZ() -planets.get(7).getCoorZ(),2) );
        edges.add(new Edge("I-H",planets.get(8),planets.get(7),distance));
        
        // A
        planets.get(0).pushEdges(edges.get(0));
        planets.get(0).pushEdges(edges.get(1));
        planets.get(0).pushEdges(edges.get(2));
        // B
        planets.get(1).pushEdges(edges.get(0));
        planets.get(1).pushEdges(edges.get(3));
        // C
        planets.get(2).pushEdges(edges.get(2));
        planets.get(2).pushEdges(edges.get(4));
        // D
        planets.get(3).pushEdges(edges.get(6));
        planets.get(3).pushEdges(edges.get(7));
        planets.get(3).pushEdges(edges.get(8));
        // E
        planets.get(4).pushEdges(edges.get(2));
        planets.get(4).pushEdges(edges.get(3));
        planets.get(4).pushEdges(edges.get(4));
        planets.get(4).pushEdges(edges.get(6));
        planets.get(4).pushEdges(edges.get(5));
        // F
        planets.get(5).pushEdges(edges.get(7));
        planets.get(5).pushEdges(edges.get(5));
        planets.get(5).pushEdges(edges.get(9));
        // G
        planets.get(6).pushEdges(edges.get(13));
        planets.get(6).pushEdges(edges.get(10));
        // H
        planets.get(7).pushEdges(edges.get(14));
        planets.get(7).pushEdges(edges.get(11));
        // I
        planets.get(8).pushEdges(edges.get(13));
        planets.get(8).pushEdges(edges.get(14));
        planets.get(8).pushEdges(edges.get(12));
        // J
        planets.get(9).pushEdges(edges.get(8));
        planets.get(9).pushEdges(edges.get(9));
        planets.get(9).pushEdges(edges.get(10));
        planets.get(9).pushEdges(edges.get(11));
        planets.get(9).pushEdges(edges.get(12));

        return edges;
    }

    public ArrayList<Edge> findDistance4(ArrayList<Planet> planets) { // find distance for delta quadrant
        
        double distance;
        ArrayList<Edge> edges = new ArrayList<Edge>();
        // A=0,B=1,C=2,D=3,E=4,F=5,G=6,H=7,I=8,J=9
        
        // 0. A and B
        distance=Math.sqrt( Math.pow(planets.get(0).getCoorX() - planets.get(1).getCoorX(),2) + Math.pow(planets.get(0).getCoorY() -planets.get(1).getCoorY(),2) + Math.pow(planets.get(0).getCoorZ() -planets.get(1).getCoorZ(),2) );
        edges.add(new Edge("A-B",planets.get(0),planets.get(1),distance));

        // 1. A and C
        distance=Math.sqrt( Math.pow(planets.get(0).getCoorX() - planets.get(2).getCoorX(),2) + Math.pow(planets.get(0).getCoorY() -planets.get(2).getCoorY(),2) + Math.pow(planets.get(0).getCoorZ() -planets.get(2).getCoorZ(),2) );
        edges.add(new Edge("A-C",planets.get(0),planets.get(2),distance));

        // 2. A and D
        distance=Math.sqrt( Math.pow(planets.get(0).getCoorX() - planets.get(3).getCoorX(),2) + Math.pow(planets.get(0).getCoorY() -planets.get(3).getCoorY(),2) + Math.pow(planets.get(0).getCoorZ() -planets.get(3).getCoorZ(),2) );
        edges.add(new Edge("A-D",planets.get(0),planets.get(3),distance));
    
        // 3. B and E
        distance=Math.sqrt( Math.pow(planets.get(1).getCoorX() - planets.get(4).getCoorX(),2) + Math.pow(planets.get(1).getCoorY() -planets.get(4).getCoorY(),2) + Math.pow(planets.get(1).getCoorZ() -planets.get(4).getCoorZ(),2) );
        edges.add(new Edge("B-E",planets.get(1),planets.get(4),distance));

        // 4. B and F
        distance=Math.sqrt( Math.pow(planets.get(1).getCoorX() - planets.get(5).getCoorX(),2) + Math.pow(planets.get(1).getCoorY() -planets.get(5).getCoorY(),2) + Math.pow(planets.get(1).getCoorZ() -planets.get(5).getCoorZ(),2) );
        edges.add(new Edge("B-F",planets.get(1),planets.get(5),distance));
    
        // 5. B and G
        distance=Math.sqrt( Math.pow(planets.get(1).getCoorX() - planets.get(6).getCoorX(),2) + Math.pow(planets.get(1).getCoorY() -planets.get(6).getCoorY(),2) + Math.pow(planets.get(1).getCoorZ() -planets.get(6).getCoorZ(),2) );
        edges.add(new Edge("B-G",planets.get(1),planets.get(6),distance));
        
        // 6. B and J
        distance=Math.sqrt( Math.pow(planets.get(1).getCoorX() - planets.get(9).getCoorX(),2) + Math.pow(planets.get(1).getCoorY() -planets.get(9).getCoorY(),2) + Math.pow(planets.get(1).getCoorZ() -planets.get(9).getCoorZ(),2) );
        edges.add(new Edge("B-J",planets.get(1),planets.get(9),distance));
        
        // 7. C and F
        distance=Math.sqrt( Math.pow(planets.get(2).getCoorX() - planets.get(5).getCoorX(),2) + Math.pow(planets.get(2).getCoorY() -planets.get(5).getCoorY(),2) + Math.pow(planets.get(2).getCoorZ() -planets.get(5).getCoorZ(),2) );
        edges.add(new Edge("C-F",planets.get(2),planets.get(5),distance));
    
        // 8. C and G
        distance=Math.sqrt( Math.pow(planets.get(2).getCoorX() - planets.get(6).getCoorX(),2) + Math.pow(planets.get(2).getCoorY() -planets.get(6).getCoorY(),2) + Math.pow(planets.get(2).getCoorZ() -planets.get(6).getCoorZ(),2) );
        edges.add(new Edge("C-G",planets.get(2),planets.get(6),distance));

        // 9. C and H
        distance=Math.sqrt( Math.pow(planets.get(2).getCoorX() - planets.get(7).getCoorX(),2) + Math.pow(planets.get(2).getCoorY() -planets.get(7).getCoorY(),2) + Math.pow(planets.get(2).getCoorZ() -planets.get(7).getCoorZ(),2) );
        edges.add(new Edge("C-H",planets.get(2),planets.get(7),distance));
    
        // 10. C and I
        distance=Math.sqrt( Math.pow(planets.get(2).getCoorX() - planets.get(8).getCoorX(),2) + Math.pow(planets.get(2).getCoorY() -planets.get(8).getCoorY(),2) + Math.pow(planets.get(2).getCoorZ() -planets.get(8).getCoorZ(),2) );
        edges.add(new Edge("C-I",planets.get(2),planets.get(8),distance));
    
        // 11. D and E
        distance=Math.sqrt( Math.pow(planets.get(3).getCoorX() - planets.get(4).getCoorX(),2) + Math.pow(planets.get(3).getCoorY() -planets.get(4).getCoorY(),2) + Math.pow(planets.get(3).getCoorZ() -planets.get(4).getCoorZ(),2) );
        edges.add(new Edge("D-E",planets.get(3),planets.get(4),distance));

        // 12. D and H    
        distance=Math.sqrt( Math.pow(planets.get(3).getCoorX() - planets.get(7).getCoorX(),2) + Math.pow(planets.get(3).getCoorY() -planets.get(7).getCoorY(),2) + Math.pow(planets.get(3).getCoorZ() -planets.get(7).getCoorZ(),2) );
        edges.add(new Edge("D-H",planets.get(3),planets.get(7),distance));
    
        // 13. D and I
        distance=Math.sqrt( Math.pow(planets.get(3).getCoorX() - planets.get(8).getCoorX(),2) + Math.pow(planets.get(3).getCoorY() -planets.get(8).getCoorY(),2) + Math.pow(planets.get(3).getCoorZ() -planets.get(8).getCoorZ(),2) );
        edges.add(new Edge("D-I",planets.get(3),planets.get(8),distance));
    
        // 14. D and J
        distance=Math.sqrt( Math.pow(planets.get(3).getCoorX() - planets.get(9).getCoorX(),2) + Math.pow(planets.get(3).getCoorY() -planets.get(9).getCoorY(),2) + Math.pow(planets.get(3).getCoorZ() -planets.get(9).getCoorZ(),2) );
        edges.add(new Edge("D-J",planets.get(3),planets.get(9),distance));
        
        // A
        planets.get(0).pushEdges(edges.get(0));
        planets.get(0).pushEdges(edges.get(1));
        planets.get(0).pushEdges(edges.get(2));
        // B
        planets.get(1).pushEdges(edges.get(0));
        planets.get(1).pushEdges(edges.get(3));
        planets.get(1).pushEdges(edges.get(4));
        planets.get(1).pushEdges(edges.get(5));
        planets.get(1).pushEdges(edges.get(6));
        // C
        planets.get(2).pushEdges(edges.get(1));
        planets.get(2).pushEdges(edges.get(7));
        planets.get(2).pushEdges(edges.get(8));
        planets.get(2).pushEdges(edges.get(9));
        planets.get(2).pushEdges(edges.get(10));
        // D
        planets.get(3).pushEdges(edges.get(2));
        planets.get(3).pushEdges(edges.get(11));
        planets.get(3).pushEdges(edges.get(12));
        planets.get(3).pushEdges(edges.get(13));
        planets.get(3).pushEdges(edges.get(14));
        // E
        planets.get(4).pushEdges(edges.get(3));
        planets.get(4).pushEdges(edges.get(11));
        // F
        planets.get(5).pushEdges(edges.get(4));
        planets.get(5).pushEdges(edges.get(7));
        // G
        planets.get(6).pushEdges(edges.get(5));
        planets.get(6).pushEdges(edges.get(8));
        // H
        planets.get(7).pushEdges(edges.get(9));
        planets.get(7).pushEdges(edges.get(12));
        // I
        planets.get(8).pushEdges(edges.get(10));
        planets.get(8).pushEdges(edges.get(13));
        // J
        planets.get(9).pushEdges(edges.get(6));
        planets.get(9).pushEdges(edges.get(14));

        return edges;
    }
    // merging function
    public void merge(ArrayList<Edge> arr, int l, int m, int r) { 
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        Edge L[] = new Edge[n1];
        Edge R[] = new Edge[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr.get(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = arr.get(m + 1 + j);
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getDistance() <= R[j].getDistance()) {
                arr.set(k,L[i]);
                i++;
            }
            else {
                arr.set(k,R[j]);
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr.set(k,L[i]);
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr.set(k,R[j]);
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using merge()
    public void sort(ArrayList<Edge> arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // merging descending
    public void mergeDesc(ArrayList<Planet> arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        Planet L[] = new Planet[n1];
        Planet R[] = new Planet[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr.get(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = arr.get(m + 1 + j);
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getProfit() > R[j].getProfit()) {
                arr.set(k,L[i]);
                i++;
            }
            else {
                arr.set(k,R[j]);
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr.set(k,L[i]);
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr.set(k,R[j]);
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using merge() in descending
    public void sortDesc(ArrayList<Planet> arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            sortDesc(arr, l, m);
            sortDesc(arr, m + 1, r);
  
            // Merge the sorted halves
            mergeDesc(arr, l, m, r);
        }
    }
}

// planet class
class Planet {
    private String p_name; // planet name
    private int x,y,z;  // coordinates
    private int weight,profit; // planet weight and profit
    private ArrayList<Edge> edgesPlanets = new ArrayList<Edge>(); // edges connected to this planet
    private int d; // total distance for shortest path
    private int predecessor; // predecessor planet for shortest path. (upper level planet)

    public Planet(String p_name, int x, int y, int z, int weight, int profit) {
        this.p_name = p_name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.weight = weight;
        this.profit = profit;
    }

    public void pushEdges(Edge e) {
        edgesPlanets.add(e);
    }
    // Accessor methods
    public String getP_name() {
        return p_name;
    }
    public int getCoorX() {
        return x;
    }
    public int getCoorY() {
        return y;
    }
    public int getCoorZ() {
        return z;
    }
    public int getWeight() {
        return weight;
    }
    public int getProfit() {
        return profit;
    }
    public int getD() {
        return d;
    }
    public int getPre() {
        return predecessor;
    }
    public ArrayList<Edge> getEdgesPlanet() {
        return edgesPlanets;
    }
    // Mutator methods
    public void setD(int d) {
        this.d = d;
    }
    public void setPre(int pre) {
        predecessor = pre;
    }
};

// edge class
class Edge {

    private String e_name; // edge name 
    private Planet planet1; // pointed planet 1
    private Planet planet2; // pointed planet 2
    private double distance; // distance

    public Edge(String e_name, Planet planet1, Planet planet2, double distance) {
        this.e_name = e_name;
        this.planet1 = planet1;
        this.planet2 = planet2;
        this.distance = distance;
    }
    public String getE_name() {
        return e_name;
    }
    public Planet getPlanet1() {
        return planet1;
    }
    public Planet getPlanet2() {
        return planet2;
    }
    public double getDistance() {
        return distance;
    }
};
