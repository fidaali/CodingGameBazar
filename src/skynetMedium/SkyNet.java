/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skynetMedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jahan
 */
public class SkyNet {

    public static class Input {

        Node agentPos = null;

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

        }

        public static class GameInitInput {

            final int N;
            final int L;
            final int E;

            final HashMap<Node, List<Link>> edge;
            final HashMap<Integer, Node> allNode;

            public GameInitInput(int N, int L, int E) {
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

        }

    }

}
