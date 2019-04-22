public class Edge {
    private Node u;
    private Node v;
    private String ID;
    double weight;
    Edge(String id, Node u, Node v){
        this.u = u;
        this.v = v;
        this.ID = id;
        weight = weight(u,v);
    }
 public Node getU() {
  return u;
 }
 public void setU(Node u) {
  this.u = u;
 }
 public Node getV() {
  return v;
 }
 public void setV(Node v) {
  this.v = v;
 }
 public String getID() {
  return ID;
 }
 public void setID(String iD) {
  ID = iD;
 }
 public double getWeight() {
  return weight;
 }
 public void setWeight(double weight) {
  this.weight = weight;
 }
 double weight(Node u, Node v) {
  double Latitude1 = u.getLatitude();
  double Latitude2 = v.getLatitude();
  double Longitude1 = u.getLongitude();
  double Longitude2 = v.getLongitude();
     double longitudeDistance = Math.toRadians(Longitude2 - Longitude1);
        double dLat = Math.toRadians(Latitude2 - Latitude1);
        Longitude1 = Math.toRadians(Longitude1);
        Longitude2 = Math.toRadians(Longitude2);
        Latitude1 = Math.toRadians(Latitude1);
        Latitude2 = Math.toRadians(Latitude2);       
     double R = 3959; //???
     double a = Math.pow(Math.sin(dLat/2),2) + Math.pow(Math.sin(longitudeDistance/2), 2) 
     * Math.cos(Latitude1) * Math.cos(Latitude2);
     double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
       return R * c * 0.621371;  
    }
}