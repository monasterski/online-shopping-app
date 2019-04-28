package main.server.database;

public abstract class AbstractData {

    public abstract Long getId();
    public abstract void setId(Long id);

    protected AbstractData(){
        setId(AbstractRepository.getId());
    }
}
