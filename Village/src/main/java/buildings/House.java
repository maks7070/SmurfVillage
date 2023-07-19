package buildings;

import tile.DataTile;

public class House
{
    private DataTile location;
    private String name;
    private String resourceType;

    private int resources;
    private int limit;


    public House(DataTile location, String name, String resourceType)
    {
        this.location = location;
        this.name = name;
        this.resourceType = resourceType;
        resources = 0;
    }

    public House(DataTile location){
        this.location = location;
    }




    public DataTile getLocation() {
        return location;
    }

    public void setLocation(DataTile location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }







}
