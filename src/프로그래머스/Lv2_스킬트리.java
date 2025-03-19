package 프로그래머스;

public class Lv2_스킬트리 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            Game game = new Game(skill, skill_trees);
            game.start();

            return game.getCount();
        }
    }
}
class Game {
    private final String firstSkill; //선행스킬
    private final String[] users;
    private int count = 0;

    public Game (String skill, String[] skill_trees) {
        this.firstSkill = skill;
        this.users = skill_trees;
    }

    public void start() {
        for(String user : this.users) {
            checkSkill(removeHill(user));
        }
    }

    private void checkSkill(String user) {
        if(this.firstSkill.contains(user)) {
            success();
        }
    }

    private void success() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }

    private String removeHill(String userSkill) {
        return userSkill.replaceAll("[^" + this.firstSkill + "]", "");
    }
}
