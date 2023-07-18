package graphics;

import entities.PapaSmurf;
import entities.Smurf;

import java.util.ArrayList;

public class Village
{
    private ArrayList<Smurf> smurfzens;
    private String name;
    private int smurfLimit;


    public Village(String name)
    {
        this.name = name;
        smurfzens = new ArrayList<>();
        smurfLimit = 30;

    }


    /**
     * Function for initializing the citizens in the village so that there is
     * a number of smurfs which live at the beginning in the village
     *
     * Initially 10 smurfs:
     * 1 PapaSmurf
     * 1 Smurfette
     * 1 SmurfSmith
     * 2 Warriors
     * 5 SmurfFarmers
     *
     * @return
     */
//    private ArrayList<Smurf> fillVillageWithSmurfs()
//    {
//        ArrayList<Smurf> smurfs = new ArrayList<>();
//
//    }




}
