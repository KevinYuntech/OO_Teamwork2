/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuntech.oose.state_diagram_editor.flyweight;

import java.util.HashMap;

/**
 * @author user
 */
public class FlyweightFactory {
    private static final FlyweightFactory flyweightFactory = new FlyweightFactory();
    public static int count = 0;
    private HashMap<Integer, ColorFlyweight> map = new HashMap<>();

    private FlyweightFactory() {
    }

    public static FlyweightFactory getFlyweightFactory() {
        return flyweightFactory;
    }

    public static int getCount() {
        return count;
    }

    public ColorFlyweight getColorFlyweight(int key) {
        if (!map.containsKey(key)) {
            map.put(key, new ConcreteColorFlyweight(key));
            //System.out.println("new color!!");
            count++;
        }
        return map.get(key);
    }
}
