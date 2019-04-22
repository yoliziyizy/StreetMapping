import java.util.LinkedList;
public class Node {
 private String ID;
    private Double Latitude;
    private Double Longitude;
    private Double Distance;
    private Node Previous;
    private Boolean Visited;
    private Boolean isPath;
//    Boolean isStart;
//    Boolean isEnd;
    LinkedList<Node> Adjacency;
 public String getID() {
  return ID;
 }
 public void setID(String iD) {
  ID = iD;
 }
 public Double getLatitude() {
  return Latitude;
 }
 public void setLatitude(Double latitude) {
  Latitude = latitude;
 }
 public Double getLongitude() {
  return Longitude;
 }

 public void setLongitude(Double longitude) {
  Longitude = longitude;
 }
 public Double getDistance() {
  return Distance;
 }
 public void setDistance(Double distance) {
  Distance = distance;
 }
 public Node getPrevious() {
  return Previous;
 }
 public void setPrevious(Node previous) {
  Previous = previous;
 }
 public Boolean getVisited() {
  return Visited;
 }
 public void setVisited(Boolean visited) {
  Visited = visited;
 }
 public Boolean getIsPath() {
  return isPath;
 }

 /**
  * @param isPath the isPath to set
  */
 public void setIsPath(Boolean isPath) {
  this.isPath = isPath;
 }

 /**
  * @return the adjacency
  */
 public LinkedList<Node> getAdjacency() {
  return Adjacency;
 }

 /**
  * @param adjacency the adjacency to set
  */
 public void setAdjacency(LinkedList<Node> adjacency) {
  Adjacency = adjacency;
 }

 Node(String ID, double latitude, double longitude){
        this.ID = ID;
        this.Latitude = latitude;
        this.Longitude = longitude;
        this.Visited = false;
        this.Distance = Double.MAX_VALUE;
        this.Adjacency = new LinkedList<>();
        this.isPath = false;
//        this.isEnd = false;
//        this.isStart = false;
    }
}
