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

/**
 *
 * @author Jahan
 */
public class SkyNet {

    public static class Input {

        public static class Node {

            final int id;

            boolean isGateWay = false;

            public Node(int id) {
                this.id = id;
            }

        }

        public static class Link {

            final Node A;
            final Node B;

            public Link(Node A, Node B) {
                this.A = A;
                this.B = B;
            }

            public Node other(Node x) {
                if (A == x) {
                    return B;
                }
                return A;
            }

        }

        public static class PathToGate {

            List<Link> it = new ArrayList<>(500);
        }

        public static class GameInput {

            private List<Link> recShortPath(Node c, HashSet<Link> used) {
                for (Link l : edge.get(c)) {
                    List<Link> short
                    =null;
                    if (!used.contains(l)) {
                        List<Link> curr = recShortPath(c, used);

                    }
                    used.add(l);

                }
            }

            List<PathToGate> pathToGates() {
                HashSet<Link> used = new HashSet<>();
                List<PathToGate> res = new ArrayList<>(500);

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

}
