package main.server.database;

import java.util.HashMap;

public abstract class AbstractData {

    private static HashMap<Class<?>,Long> map = new HashMap<>();

    public abstract Long getId();
    public abstract void setId(Long id);

    protected AbstractData(){
        if(!map.containsKey(this.getClass()))
            map.put(this.getClass(),0L);
        Long id = map.get(this.getClass());
        map.put(this.getClass(),id + 1);
        setId(id);
    }
}
