package leson3;

/**
 * Created by Viktoriya.D on 7/5/2017.
 */
public class CatGamer {
    protected String name;
    protected double age;
    protected int fight_counter = 10;
    protected int playWithMice = 0;
    protected String peeInShoes;
    protected int weowVolume;
    protected String friendshipWithCats;
    protected String likeMilk;


    @Override
    public String toString() {
        return "I'm a gamer :\n"+ "My name is " + name + ",\nMy age " + age  ;
    }

}


