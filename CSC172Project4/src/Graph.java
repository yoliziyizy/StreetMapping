import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph {

	static HashMap<String, Node> adj = new HashMap<String, Node> ();
	HashMap<String, Edge> edgerelation = new HashMap<String, Edge>();
	PriorityQueue<Node> q = new PriorityQueue<Node>();
	double minLattitude = 0, maxLattitude = 0, minLongitude = 0, maxLongitude = 0;
	
	public Graph(String Filename){
		try {
		 BufferedReader rd = new BufferedReader(new FileReader(new File(Filename)));
	        String str;
	        while ((str = rd.readLine()) != null) {
	            String[] line = str.split("\\t");

	            if (line[0].equals("i")) {
	            	adj.put(line[1], new Node(line[1], Double.parseDouble(line[2]), Double.parseDouble(line[3])));
	            }else if(line[0].equals("r")){
	            	//System.out.println(line[0]);
	            	addEdge(line[1],adj.get(line[2]),adj.get(line[3]));
	            }
	        }
	        
		}catch (IOException e){
	        e.printStackTrace();
	    }
	}
	
	public void addEdge(String edgeid, Node n1, Node n2) {
		n1.Adjacency.add(n2);
		n2.Adjacency.add(n1);
		
		edgerelation.put(String.valueOf(n1.getID() + n2.getID()),  new Edge(edgeid, n1,n2));
		edgerelation.put(String.valueOf(n2.getID() + n1.getID()),  new Edge(edgeid, n2,n1));
	}
	
	private class NodeComparator implements Comparator<Node>{
		@Override
		public int compare(Node n1, Node n2) {
			return Double.compare(n1.getDistance(), n2.getDistance());
		}
	}
	
	public LinkedList<Node> dijkstra(Node n1, Node n2) {
		NodeComparator nc = new NodeComparator();
		q = new PriorityQueue<Node>(adj.size(),nc);
		LinkedList<Node> path = new LinkedList<Node> ();
		//PriorityQueue<Node> q = new PriorityQueue();
        for (String h : adj.keySet()) {
        		q.offer(adj.get(h));
			adj.get(h).setDistance(Double.POSITIVE_INFINITY);
			adj.get(h).setVisited(false);
			adj.get(h).setPrevious(null);
		}		
        System.out.println(q.remove(n1));
        n1.setDistance(0.0);
        n1.setVisited(true);
        q.add(n1);
		//q.offer(n1);
		
		Node nn;
	
		while(!q.isEmpty()) {
			

			
			nn = q.poll();
			nn.setVisited(true);
			//if(nn.getVisited()==false) {
				for(Node j: nn.Adjacency) {
//				j = adj.get(j.getID());
				
//				System.out.println(j.isVi);
				
//				if(!(q.contains(j)&&j.getVisited()==false)) {
					//q.add(j);
//				}
				
//				for(String s: edgerelation.keySet() ) {
//					System.out.println(s); //edgerelation.get(s).getID()
//				}
//				
//				System.out.println(String.valueOf("Test: " + nn.getId()+ j.getId()));
				
				//System.out.println(edgerelation.get(String.valueOf(nn.getId()+ j.getId())));
				if(nn.getDistance() + edgerelation.get(nn.getID()+ j.getID()).getWeight() < j.getDistance() ) {
					j.setDistance(nn.getDistance() + edgerelation.get(nn.getID()+ j.getID()).getWeight()) ;
					j.setPrevious(nn);
					q.remove(j);
					q.offer(j);
					
				}
//				adj.remove(j);
//				adj.put(j.getID(), j);
				
				
			}
			//}
			
		
			
		}
		while(n2.getPrevious() !=null) {
			path.add(n2);
			n2 = n2.getPrevious();
		}
		path.add(n1);
		Collections.reverse(path);
		
		return path;
		
	}
	
	
	public static void main(String[]args) {
		
			Graph g = new Graph("ur.txt");
			LinkedList<Node> l = 
			g.dijkstra(adj.get("SIMON"), adj.get("SPURRIER"));
			for(int i = 0; i < l.size(); i++) {
				System.out.println(l.get(i).getID());
			}
		
	}
	
}
