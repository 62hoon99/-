

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String T = scanner.nextLine();

        List<String[]> strings = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(T); i++) {
            String str = scanner.nextLine();
            String[] input = new String[2];
            input[0] = str.split(" ")[0];
            input[1] = str.split(" ")[1];
            strings.add(input);
        }

        List<Double[]> inputs = new ArrayList<>();
        for (String[] string : strings) {
            Double[] doubles = new Double[2];
            doubles[0] = Double.parseDouble(string[0]);
            doubles[1] = Double.parseDouble(string[1]);
            inputs.add(doubles);
        }

        System.out.println(Math.round(solution(inputs) * 100) / 100.0);
    }

    private static double solution(List<Double[]> inputs) {
        List<Star> stars = new ArrayList<>();

        for (int i = 0; i < inputs.size(); i++) {
            Double[] doubles = inputs.get(i);
            stars.add(new Star(i + 1, doubles[0], doubles[1]));
        }

        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < stars.size() - 1; i++) {
            for (int k = i + 1; k < stars.size(); k++) {
                vertices.add(new Vertex(stars.get(i), stars.get(k)));
            }
        }
        Collections.sort(vertices);

//        System.out.println(vertices);

        List<Vertex> choices = new ArrayList<>();
        for (Vertex vertex : vertices) {
            if (choices.size() > stars.size() - 2) {
                break;
            }

            if (vertex.canChoice()) {
                vertex.mergeParentStar();
                choices.add(vertex);
            }
        }

//        System.out.println(choices);

        double answer = 0;
        for (Vertex choice : choices) {
            answer += choice.distance;
        }
        return answer;
    }

    private static class Vertex implements Comparable<Vertex> {
        private final Star star1;
        private final Star star2;
        private final double distance;

        public Vertex(Star star1, Star star2) {
            if (star1.getId() < star2.getId()) {
                this.star1 = star1;
                this.star2 = star2;
            } else {
                this.star1 = star2;
                this.star2 = star1;
            }

            this.distance = calcDistance(star1.x, star1.y, star2.x, star2.y);
        }

        public boolean canChoice() {
            return !star1.findRootStar().equals(star2.findRootStar());
        }

        public void mergeParentStar() {
            if (star1.parentStar == null && star2.parentStar == null) {
                star2.setParentStar(star1);
            } else if (star1.parentStar == null) {
                star1.setParentStar(star2);
            } else if (star2.parentStar == null) {
                star2.setParentStar(star1);
            } else {
                star2.findRootStar().setParentStar(star1);
            }
        }

        @Override
        public String toString() {
            return "distance: " + distance + " star1: " + star1.id + " star2: " + star2.id;
        }

        @Override
        public int compareTo(Vertex o) {
            return Double.compare(distance, o.distance);
        }
    }

    private static class Star {
        private final int id;
        private Star parentStar;
        private final double x;
        private final double y;

        public Star(int id, double x, double y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public void setParentStar(Star o) {
            this.parentStar = o;
        }

        public Star findRootStar() {
            if (parentStar == null) {
                return this;
            }
            return parentStar.findRootStar();
        }

        public int getId() {
            return id;
        }
    }

    private static double calcDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}