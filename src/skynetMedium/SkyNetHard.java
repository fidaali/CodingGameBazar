/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skynetMedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jahan
 */
public class SkyNetHard {
    
    public static class Input {

        public static class Node {

            final int id;

            boolean isGateWay = false;

            public Node(int id) {
                this.id = id;
                
                
            }

            @Override
            public String toString() {
                return "N{" + "" + id + ", " + isGateWay + '}';
            }

        }

        public static class Link {

            final Node A;
            final Node B;
            boolean cut=false;

            public Link(Node A, Node B) {
                this.A = A;
                this.B = B;
                
                
            }

            @Override
            public String toString() {
                return "{" + "" + A + ", " + B +""+ '}';
            }

            public Node other(Node x) {
                if (A.id == x.id) {
                    return B;
                }
                return A;
            }

        }

        public static class PathToGate {

            List<Link> it = new ArrayList<>(500);

            public PathToGate() {
            }

            public PathToGate(List<Link> it) {
                this.it.addAll(it);
            }

            @Override
            public String toString() {
                return "\nPathToGate{" + "it=" + it + '}';
            }

            
        }

        public static class GameInput {

            private List<Link> recShortPath(Node c, HashSet<Node> used) {
                if (c.isGateWay) {
                    return new ArrayList<>();
                }
                used.add(c);                

                List<Link> freeEdge = new ArrayList<>(20);
                Link toSh = null;
                
                //System.err.println(""+c+" edged "+edge.get(c));
                for (Link l : edge.get(c)) {
                    if(l.cut) continue;
                    if (!used.contains(l.other(c))) {
                        freeEdge.add(l);
                    }
                    //System.err.println(""+used);
                }
                List<Link> shortl = null;
                for (Link l : freeEdge) {

                    List<Link> curr = recShortPath(l.other(c), used);
                    if (!(curr==null) && (shortl == null || shortl.size() > curr.size())) {
                            shortl = curr;
                            toSh = l;
                    }
                }
                if (shortl != null) {
                    shortl.add(0,toSh);
                }
                //System.err.println(""+shortl);
                return shortl;
            }

            public List<PathToGate> pathToGates() {
                HashSet<Node> used = new HashSet<>();
                List<PathToGate> res = new ArrayList<>(500);

                    List<Link> s = recShortPath(agentPos, used);
                    PathToGate p = new PathToGate(s);
                    res.add(p);

                return res;
            }

            final int N;
            final int L;
            final int E;

            final HashMap<Node, List<Link>> edge;
            final HashMap<Integer, Node> allNode;

            Node agentPos = null;

            public GameInput(int N, int L, int E) {
                this.N = N;
                this.L = L;
                this.E = E;

                edge = new HashMap<>(N);
                allNode = new HashMap<>(N);
            }

            public void addLinkDescr(int N1, int N2) {
                if (!allNode.containsKey(N1)) {
                    allNode.put(N1, new Node(N1));
                    edge.put(allNode.get(N1), new ArrayList<>(10));
                }
                if (!allNode.containsKey(N2)) {
                    allNode.put(N2, new Node(N2));
                    edge.put(allNode.get(N2), new ArrayList<>(10));
                }

                Link ll = new Link(allNode.get(N1), allNode.get(N2));
                edge.get(allNode.get(N1)).add(ll);
                edge.get(allNode.get(N2)).add(ll);

            }

            public void addGateWay(int N) {
                allNode.get(N).isGateWay = true;
            }

            public void setAgent(int N) {
                agentPos = allNode.get(N);
            }

        }

    }
    
    public static void  main(String args[]){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        
        Input.GameInput ing=new Input.GameInput(N, L, E);
        
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            System.err.println("Link "+N1+" "+N2);
            ing.addLinkDescr(N1, N2);
        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            ing.addGateWay(EI);
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            ing.setAgent(SI);

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            
            List<Input.PathToGate> path=ing.pathToGates();

            Input.Link last=path.get(path.size()-1).it.get(path.get(path.size()-1).it.size()-1);
            System.err.println(""+path);
            last.cut=true;
            System.out.println(""+last.A.id+" "+last.B.id); // Example: 0 1 are the indices of the nodes you wish to sever the link between
        }        
        
        
    }
}
