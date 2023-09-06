
import java.util.*;

public class Main {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                String T = scanner.nextLine();

                int[] answer = new int[Integer.parseInt(T)];

                for (int i = 0; i < Integer.parseInt(T); i++) {
                        String NK = scanner.nextLine();
                        String[] NKs = NK.split(" ");
                        int buildingCount = Integer.parseInt(NKs[0]);
                        int ruleCount = Integer.parseInt(NKs[1]);

                        String seconds = scanner.nextLine();
                        String[] secondsArr = seconds.split(" ");
                        int[] buildings = new int[secondsArr.length];
                        for (int k = 0; k < buildings.length; k++) {
                                buildings[k] = Integer.parseInt(secondsArr[k]);
                        }       

                        Integer[][] rules = new Integer[ruleCount][2];
                        for (int k = 0; k < ruleCount; k++) {
                                String[] rule = scanner.nextLine().split(" ");
                                rules[k][0] = Integer.parseInt(rule[0]);
                                rules[k][1] = Integer.parseInt(rule[1]);
                        }

                        int findingBuildingNumber = Integer.parseInt(scanner.nextLine());

                        answer[i] = solution(buildingCount, ruleCount, buildings, rules, findingBuildingNumber);
                }

                for (int num : answer) {
                        System.out.println(num);
                }
        }

        private static int solution(int buildingCount, int ruleCount, int[] buildings, Integer[][] rules, int findingBuildingCount) {
//                System.out.println(buildingCount + " " + ruleCount + " " + Arrays.toString(buildings) + Arrays.deepToString(rules) + " " + findingBuildingCount);

                List<Building> buildingList = new ArrayList<>();

                for (int i = 0; i < buildings.length; i++) {
                        buildingList.add(new Building(i + 1, buildings[i]));
                }

                for (Integer[] rule : rules) {
                        Building building = buildingList.get(rule[1] - 1);
                        building.addBuilding(buildingList.get(rule[0] - 1));
                }

                return buildingList.get(findingBuildingCount - 1).findEndTime();
        }

        private static class Building {
                private int id;
                private boolean dirtyCheck = false;
                private int time;
                private int endTime;
                private List<Building> buildings = new ArrayList<>();

                public Building(int id, int time) {
                        this.id = id;
                        this.time = time;
                }

                public void addBuilding(Building building) {
                        buildings.add(building);
                }

                public int findEndTime() {
                        if (dirtyCheck) {
                                return endTime;
                        }

                        if (buildings.isEmpty()) {
                                dirtyCheck = true;
                                endTime = time;
                                return time;
                        }

                        int max = 0;
                        for (Building building : buildings) {
                                max = Math.max(max, building.findEndTime());
                        }

                        dirtyCheck = true;
                        endTime = max + time;
                        return endTime;
                }
        }
}