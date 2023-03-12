import java.util.Random;

public class Hero {
    private String name;
    private int hitPoints;

    public Hero(){

    }

    public Hero(String name){
        this.name = name;
        hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void attack(Hero opponent){
        Random random = new Random();
        double number = random.nextDouble();

        if(number < 0.5){
            opponent.setHitPoints(opponent.getHitPoints() - 10);
        }
        else{
            this.setHitPoints(this.hitPoints - 10);;
        }
    }

    public void senzuBean(){
        this.setHitPoints(100);
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        while(true){
            this.attack(opponent);
            if(this.getHitPoints() <= 0 || opponent.getHitPoints() <= 0){
                break;
            }
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        this.senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);

        return this.getName() + ": " + this.getHitPoints() + "     " + opponent.getName() + ": " + opponent.getHitPoints();
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] scores = new int[2];
        if(n > 0){
            while(true){
                this.attack(opponent);
                if(this.getHitPoints() <= 0){
                    scores[1] ++;
                    this.senzuBean();
                    opponent.senzuBean();
                    break;
                }
                else if(opponent.getHitPoints() <= 0){
                    scores[0] ++;
                    this.senzuBean();
                    opponent.senzuBean();
                    break;
                }
            }
        }

        return scores;
    }

    public String nFightsToTheDeath(Hero opponent, int n){
        int heroScore = nFightsToTheDeathHelper(opponent, n)[0];
        int opponentScore = nFightsToTheDeathHelper(opponent, n)[1];

        if(heroScore == opponentScore){
            return this.getName() + ": " + heroScore + "wins" + opponent.getName() + ": " + opponentScore + "\nOMG! It was actually a draw!";
        }
        else if(heroScore > opponentScore){
            return this.getName() + ": " + heroScore + "wins" + opponent.getName() + ": " + opponentScore + "\n" + this.getName() + " wins!";
        }
        else if(heroScore < opponentScore){
            return this.getName() + ": " + heroScore + "wins" + opponent.getName() + ": " + opponentScore + "\n" + opponent.getName() + " wins!";
        }

        return null;
    }

    public void dramaticFightToTheDeath(Hero opponent){
        while(true){
            this.attack(opponent);
            System.out.println(this.getName() + ": " + this.getHitPoints() + "      " + opponent.getName() + ": " + opponent.getHitPoints());
            if(this.getHitPoints() <= 0){
                System.out.println(opponent.getName() + " wins!");
            }
            else if(opponent.getHitPoints() <= 0){
                System.out.println(this.getName() + " wins!");
            }
        }
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }
}
