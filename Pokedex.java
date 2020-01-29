import java.util.ArrayList;
/**
 * Library for storing all pokemon objects found in file. Also stores 
 * groupings of pokemon by type (i.e. water, forest, etc).
 * This program requires future editing to condense libraries but allows
 * for specific altering and changing of pokemon as creator sees fit.
 * 
 * Note: All images accessed in this project came from free online resources. 
 * I do not take credit for all graphics used. Images are altered by 
 * Photoscape X to alter background colors to opaque and fro resizing 
 * before being called in program.
 * 
 * @Jonathan Ke
 * @8/13/2019
 */

public class Pokedex
{
    
    //list of all pokemon in pokedex
    private ArrayList<Pokemon> a = new ArrayList<Pokemon>();
    
    //lists for specific pokemon groupings. Each grouping is assigned a spawn 
    //area and characteristics on map.
    private ArrayList<Pokemon> dirtPokemon1 = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> grassPokemon1 = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> waterPokemon1 = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> waterPokemonH2O = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> forestPokemon1 = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> wheatPokemon1 = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> whitePokemon1 = new ArrayList<Pokemon>();
    
    private ArrayList<Pokemon> dirtPokemon2 = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> grassPokemon2 = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> waterPokemon2 = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> forestPokemon2 = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> wheatPokemon2 = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> whitePokemon2 = new ArrayList<Pokemon>();
    
    private ArrayList<Pokemon> unknown = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> legendary = new ArrayList<Pokemon>();
    
    
    public Pokedex(){
        //full pokedex
        //large cutouts from online sprite art resources 
        a.add(new Pokemon("slowpoke","other",false,0,0));
        a.add(new Pokemon("magnemite","other",false,1,0));
        a.add(new Pokemon("farfetch'd","other",false,2,0));
        a.add(new Pokemon("doduo","other",false,3,0));
        a.add(new Pokemon("slowbro","other",false,0,1));
        a.add(new Pokemon("magneton","other",false,1,1));
        a.add(new Pokemon("lickitung","other",false,2,1));
        a.add(new Pokemon("dodrio","other",false,3,1));
        
        a.add(new Pokemon("seel","other2",false,0,0));
        a.add(new Pokemon("grimer","other2",false,1,0));
        a.add(new Pokemon("shellder","other2",false,2,0));
        a.add(new Pokemon("voltorb","other2",false,3,0));
        a.add(new Pokemon("dewgong","other2",false,0,1));
        a.add(new Pokemon("muk","other2",false,1,1));
        a.add(new Pokemon("cloyster","other2",false,2,1));
        a.add(new Pokemon("electrode","other2",false,3,1));
        
        a.add(new Pokemon("spinarak","other3",false,0,0));
        a.add(new Pokemon("ariados","other3",false,1,0));
        a.add(new Pokemon("crobat","other3",false,2,0));
        a.add(new Pokemon("chinchou","other3",false,3,0));
        a.add(new Pokemon("lanturn","other3",false,0,1));
        a.add(new Pokemon("pichu","other3",false,1,1));
        a.add(new Pokemon("pichu2","other3",false,2,1));
        a.add(new Pokemon("cleffa","other3",false,3,1));
        
        a.add(new Pokemon("bellossom","other4",false,0,0));
        a.add(new Pokemon("marill","other4",false,1,0));
        a.add(new Pokemon("azumarill","other4",false,2,0));
        a.add(new Pokemon("sudowoodo","other4",false,3,0));
        a.add(new Pokemon("politoed","other4",false,0,1));
        a.add(new Pokemon("hopip","other4",false,1,1));
        a.add(new Pokemon("skiploom","other4",false,2,1));
        a.add(new Pokemon("jumpluff","other4",false,3,1));
        
        a.add(new Pokemon("clefairy","other5",false,0,0));
        a.add(new Pokemon("togepi","other5",false,1,0));
        a.add(new Pokemon("togetic","other5",false,2,0));
        a.add(new Pokemon("natu","other5",false,3,0));
        a.add(new Pokemon("xatu","other5",false,0,1));
        a.add(new Pokemon("mareep","other5",false,1,1));
        a.add(new Pokemon("flaafy","other5",false,2,1));
        a.add(new Pokemon("ampharos","other5",false,3,1));
        
        a.add(new Pokemon("croconaw","other6",false,0,0));
        a.add(new Pokemon("feraligatr","other6",false,1,0));
        a.add(new Pokemon("sentret","other6",false,2,0));
        a.add(new Pokemon("furret","other6",false,3,0));
        a.add(new Pokemon("hoothoot","other6",false,0,1));
        a.add(new Pokemon("noctowl","other6",false,1,1));
        a.add(new Pokemon("ledyba","other6",false,2,1));
        a.add(new Pokemon("ledian","other6",false,3,1));
        
        a.add(new Pokemon("aipom","other7",false,0,0));
        a.add(new Pokemon("sunkern","other7",false,1,0));
        a.add(new Pokemon("sunflora","other7",false,2,0));
        a.add(new Pokemon("yanma","other7",false,3,0));
        a.add(new Pokemon("wooper","other7",false,0,1));
        a.add(new Pokemon("quagsire","other7",false,1,1));
        a.add(new Pokemon("espeon","other7",false,2,1));
        a.add(new Pokemon("umbreon","other7",false,3,1));
        
        a.add(new Pokemon("chikorita","other8",false,0,0));
        a.add(new Pokemon("bayleef","other8",false,1,0));
        a.add(new Pokemon("meganium","other8",false,2,0));
        a.add(new Pokemon("cyndaquil","other8",false,0,1));
        a.add(new Pokemon("quilava","other8",false,1,1));
        a.add(new Pokemon("typhlosion","other8",false,2,1));
        a.add(new Pokemon("totodile","other8",false,3,1));
        
        a.add(new Pokemon("murkrow","other9",false,0,0));
        a.add(new Pokemon("slowking","other9",false,1,0));
        a.add(new Pokemon("misdreavus","other9",false,2,0));
        a.add(new Pokemon("unknown1","other9",false,3,0));
        a.add(new Pokemon("unknown2","other9",false,0,1));
        a.add(new Pokemon("unknown3","other9",false,1,1));
        a.add(new Pokemon("unknown4","other9",false,2,1));
        a.add(new Pokemon("unknown5","other9",false,3,1));
        
        //separately downloaded sprite sheets from Google Images 
        a.add(new Pokemon("pikachu","pikachu",true,0,0));
        a.add(new Pokemon("kyogre","kyogre",true,0,0));
        a.add(new Pokemon("diglett","diglett",true,0,0));        
        a.add(new Pokemon("meowth","meowth",true,0,0));
        a.add(new Pokemon("raticate","raticate",true,0,0));
        a.add(new Pokemon("vulpix","vulpix",true,0,0));
        a.add(new Pokemon("zygarde","zygarde",true,0,0));
        p("weedle");
        p("sandshrew");
        p("sandslash");
        p("rattata");
        p("persian");
        p("ninetails");
        p("mewtwo1");
        a.add(new Pokemon("mimikyu","mimkyu",true,0,0));
        p("froakie");
        p("fennekin");
        p("exeggutor");
        p("espurr");
        p("chespin");
        p("chesnaught");
        p("marowak");
        
        
        
        /*
         * heart/gold pack allows future creators to costumize 
         * their own game world with another set of pokemon.         
         * None of the pokemon in heart/gold pack are used in game.
         * The heart/gold addition to the pokedex has been commented out 
         * temporarily due to long loading time for game.
         * 
         */
         
        //heart/gold row 1
        a.add(new Pokemon("bulbasaur","hg",0,0));
        a.add(new Pokemon("ivysaur","hg",1,0));
        a.add(new Pokemon("venusaur","hg",2,0));
        a.add(new Pokemon("charmander","hg",4,0));
        a.add(new Pokemon("charmeleon","hg",5,0));
        a.add(new Pokemon("charizard","hg",6,0));
        a.add(new Pokemon("squirtle","hg",7,0));
        a.add(new Pokemon("wartortle","hg",8,0));
        a.add(new Pokemon("blastoise","hg",9,0));
        a.add(new Pokemon("caterpie","hg",10,0));
        a.add(new Pokemon("metapod","hg",11,0));
        a.add(new Pokemon("butterfree","hg",12,0));
        a.add(new Pokemon("weedle","hg",13,0));
        a.add(new Pokemon("kakuna","hg",14,0));
        
        //row 2
        a.add(new Pokemon("beedril","hg",0,1));
        a.add(new Pokemon("pidgey","hg",1,1));
        a.add(new Pokemon("pidgeot","hg",2,1));
        a.add(new Pokemon("pidgeotto","hg",3,1));
        a.add(new Pokemon("spearow","hg",6,1));
        a.add(new Pokemon("fearow","hg",7,1));
        a.add(new Pokemon("ekans","hg",8,1));
        a.add(new Pokemon("arbok","hg",9,1));
        a.add(new Pokemon("raichu","hg",12,1));
        
        
        //row 3
        int y = 2;
        a.add(new Pokemon("nidoranF","hg",0,y));
        a.add(new Pokemon("nidorina","hg",1,y));

        a.add(new Pokemon("nidoranM","hg",3,y));
        a.add(new Pokemon("nidorino","hg",4,y));
        a.add(new Pokemon("nidoking","hg",5,y));
        a.add(new Pokemon("clefairy","hg",6,y));
        a.add(new Pokemon("clefable","hg",7,y));

        
        a.add(new Pokemon("jigglypuff","hg",10,y));
        a.add(new Pokemon("wigglytuff","hg",11,y));

        
        a.add(new Pokemon("oddish","hg",14,y));
        
        //row 4
        y = 3;
        a.add(new Pokemon("gloom","hg",0,y));
        a.add(new Pokemon("vileplume","hg",1,y));
        a.add(new Pokemon("paras","hg",2,y));
        a.add(new Pokemon("parasect","hg",3,y));
        a.add(new Pokemon("venonat","hg",4,y));
        a.add(new Pokemon("venomoth","hg",5,y));

        a.add(new Pokemon("dugtrio","hg",7,y));

        
        a.add(new Pokemon("psyduck","hg",10,y));
        a.add(new Pokemon("golduck","hg",11,y));
        a.add(new Pokemon("mankey","hg",12,y));
        a.add(new Pokemon("primate","hg",13,y));        
        a.add(new Pokemon("growlithe","hg",14,y));
        
        //row 5
        y = 4;
        a.add(new Pokemon("arcanine","hg",0,y));
        a.add(new Pokemon("poliwag","hg",1,y));
        a.add(new Pokemon("poliwhirl","hg",2,y));
        a.add(new Pokemon("poliwrath","hg",3,y));
        a.add(new Pokemon("abra","hg",4,y));
        a.add(new Pokemon("kadrabra","hg",5,y));
        a.add(new Pokemon("alakazam","hg",6,y));
        
        a.add(new Pokemon("machamp","hg",8,y));
        a.add(new Pokemon("bellsprout","hg",10,y));
        a.add(new Pokemon("weepinbell","hg",11,y));
        a.add(new Pokemon("victreebell","hg",12,y));
        a.add(new Pokemon("tentacool","hg",13,y));        
        a.add(new Pokemon("tentacruel","hg",14,y));
        
        //row 6
        y = 5;
        
        a.add(new Pokemon("golem","hg",2,y));
        
        //row 7
        y = 6;

        
        
        a.add(new Pokemon("ghastly","hg",3,y));
        a.add(new Pokemon("haunter","hg",4,y));
        a.add(new Pokemon("gengar","hg",5,y));
        a.add(new Pokemon("steelix","hg",6,y));
        a.add(new Pokemon("drowzee","hg",7,y));
        a.add(new Pokemon("hypno","hg",8,y));
        a.add(new Pokemon("krabby","hg",9,y));

        
        a.add(new Pokemon("exeggcute","hg",13,y));  
        
        //row 8
        y = 7;

        a.add(new Pokemon("koffing","hg",5,y));
        a.add(new Pokemon("weezing","hg",6,y));
        a.add(new Pokemon("rhyhorn","hg",7,y));
        a.add(new Pokemon("rhydon","hg",8,y));
        a.add(new Pokemon("chansey","hg",9,y));
        a.add(new Pokemon("tangela","hg",10,y));
        a.add(new Pokemon("kangaskhan","hg",11,y));
        a.add(new Pokemon("horsea","hg",12,y));
        a.add(new Pokemon("seadra","hg",13,y)); 
        
        a.add(new Pokemon("goldeen","hg",14,7));
        
        
        
        /*
         * The following lines of code allow user to add pokemon to 
         * designated areas on map. A 1 indicates the pokemon are of normal rarity.
         * A 2 indicates pokemon are of higher rarity.
         */
        //pokemon1 in dirt area
        dirtPokemon1.add(getPokemon("sunkern"));
        dirtPokemon1.add(getPokemon("sunflora"));
        dirtPokemon1.add(getPokemon("ledyba"));        
        dirtPokemon1.add(getPokemon("yanma"));
        dirtPokemon1.add(getPokemon("diglett")); 
        dirtPokemon1.add(getPokemon("weedle")); 
        dirtPokemon1.add(getPokemon("sandshrew")); 
        getPokemon("diglett").setSpawnTime(500);
        
        //pokemon1 in grass area
        grassPokemon1.add(getPokemon("farfetch'd"));         
        grassPokemon1.add(getPokemon("doduo"));
        grassPokemon1.add(getPokemon("grimer"));
        grassPokemon1.add(getPokemon("cleffa"));
        grassPokemon1.add(getPokemon("bellossom"));
        grassPokemon1.add(getPokemon("hopip"));
        grassPokemon1.add(getPokemon("skiploom"));
        grassPokemon1.add(getPokemon("jumpluff"));
        grassPokemon1.add(getPokemon("mareep"));
        grassPokemon1.add(getPokemon("chikorita"));
        grassPokemon1.add(getPokemon("raticate"));
        grassPokemon1.add(getPokemon("rattata"));
        
        getPokemon("chikorita").setSpawnTime(500);
        getPokemon("marill").setSpawnTime(500);
        
        //pokemon1 in water area
        waterPokemon1.add(getPokemon("slowpoke"));
        waterPokemon1.add(getPokemon("slowbro"));
        waterPokemon1.add(getPokemon("muk"));       
        waterPokemon1.add(getPokemon("marill"));
        waterPokemon1.add(getPokemon("totodile"));
        waterPokemon1.add(getPokemon("wooper"));
        waterPokemon1.add(getPokemon("quagsire"));
        waterPokemon1.add(getPokemon("croconaw"));
        waterPokemon1.add(getPokemon("froakie"));
        
        getPokemon("croconaw").setSpawnTime(500);
        getPokemon("totodile").setSpawnTime(500);
        
        waterPokemonH2O.add(getPokemon("shellder"));
        waterPokemonH2O.add(getPokemon("seel"));
        waterPokemonH2O.add(getPokemon("lanturn"));
        waterPokemonH2O.add(getPokemon("chinchou"));
        
        forestPokemon1.add(getPokemon("muk"));
        forestPokemon1.add(getPokemon("spinarak"));        
        forestPokemon1.add(getPokemon("sudowoodo"));
        forestPokemon1.add(getPokemon("natu"));
        forestPokemon1.add(getPokemon("xatu"));
        forestPokemon1.add(getPokemon("sentret"));
        forestPokemon1.add(getPokemon("furret"));
        forestPokemon1.add(getPokemon("hoothoot"));
        forestPokemon1.add(getPokemon("umbreon"));
        getPokemon("umbreon").setSpawnTime(250);
        forestPokemon1.add(getPokemon("murkrow"));
        forestPokemon1.add(getPokemon("chikorita"));
        forestPokemon1.add(getPokemon("chespin"));
        
        wheatPokemon1.add(getPokemon("farfetch'd"));
        wheatPokemon1.add(getPokemon("lickitung"));
        wheatPokemon1.add(getPokemon("hopip"));
        wheatPokemon1.add(getPokemon("flaafy"));
        wheatPokemon1.add(getPokemon("mareep"));
        wheatPokemon1.add(getPokemon("togepi"));
        getPokemon("togepi").setSpawnTime(200);
        wheatPokemon1.add(getPokemon("raticate"));
        wheatPokemon1.add(getPokemon("rattata"));
        
        whitePokemon1.add(getPokemon("magnemite"));  
        whitePokemon1.add(getPokemon("magneton")); 
        whitePokemon1.add(getPokemon("pichu"));
        getPokemon("pichu").setSpawnTime(100);
        whitePokemon1.add(getPokemon("clefairy")); 
        getPokemon("cleffa").setSpawnTime(100);
        getPokemon("clefairy").setSpawnTime(100);
        whitePokemon1.add(getPokemon("cleffa"));  
        whitePokemon1.add(getPokemon("cyndaquil")); 
        getPokemon("cyndaquil").setSpawnTime(300);
        whitePokemon1.add(getPokemon("togepi")); 
        whitePokemon1.add(getPokemon("voltorb")); 
        whitePokemon1.add(getPokemon("electrode")); 
        whitePokemon1.add(getPokemon("vulpix"));
        whitePokemon1.add(getPokemon("fennekin"));
        whitePokemon1.add(getPokemon("espurr"));
        
        //creating libraries for higher rarity pokemon
        String[] a = {"bayleef","ledian","zygarde","sandslash","marowak"};
        for (String s : a){
            dirtPokemon2.add(getPokemon(s));
            getPokemon(s).setSpawnTime(700);
        }
        
        a = new String[]{"dodrio","ampharos","umbreon","espeon","meganium",
            "bayleef","exeggutor"};
        
        for (String s : a){
            grassPokemon2.add(getPokemon(s));
            getPokemon(s).setSpawnTime(700);
        }
        
        a = new String[]{"slowking","feraligatr","azumarill","croconaw","cloyster",
            "dewgong","politoed"};
        for (String s : a){
            waterPokemon2.add(getPokemon(s));
            getPokemon(s).setSpawnTime(700);
        }
        
        a = new String[]{"togetic","dodrio","espeon","umbreon","ampharos","meowth",
            "persian"};
        for (String s : a){
            wheatPokemon2.add(getPokemon(s));
            getPokemon(s).setSpawnTime(700);
        }
        
        a = new String[]{"crobat","noctowl","aipom","ariados","persian","chesnaught"};
        for (String s : a){
            forestPokemon2.add(getPokemon(s));
            getPokemon(s).setSpawnTime(700);
        }
        
        a = new String[]{"typhlosion","quilava","togetic","pikachu","aipom","ninetails","mimikyu"};
        for (String s : a){
            whitePokemon2.add(getPokemon(s));
            getPokemon(s).setSpawnTime(700);
        }
        
        //libraries for special pokemon like unknowns and legendaries
        //unknown        
        for (int i = 1; i <= 5; i++){
            unknown.add(getPokemon("unknown"+i));
        }
        
        //legendaries        
        a = new String[]{"kyogre","mewtwo1"};
        for (String s : a){
            legendary.add(getPokemon(s));
            getPokemon(s).setSpawnTime(300);
        }       
    }

    //accesor methods
    public Pokemon getPokemon(String name){
        for (Pokemon p : a){
            if (p.getName().equalsIgnoreCase(name)){
                return p;
            }
        }
        System.out.println("POKEMON NOT FOUND-> "+name);
        return null;     
    }
    
    public ArrayList<Pokemon> getDirtPokemon1(){
        return dirtPokemon1;
    }
    
    public ArrayList<Pokemon> getGrassPokemon1(){
        return grassPokemon1;
    }
    
    public ArrayList<Pokemon> getWaterPokemon1(){
        return waterPokemon1;
    }
    
    public ArrayList<Pokemon> getH2OPokemon(){
        return waterPokemonH2O;
    }
    
    public ArrayList<Pokemon> getForestPokemon1(){
        return forestPokemon1;
    }
    
    public ArrayList<Pokemon> getWheatPokemon1(){
        return wheatPokemon1;
    }

    public ArrayList<Pokemon> getWhitePokemon1(){
        return whitePokemon1;
    }
    
    public ArrayList<Pokemon> getDirtPokemon2(){
        return dirtPokemon2;
    }
    
    public ArrayList<Pokemon> getGrassPokemon2(){
        return grassPokemon2;
    }
    
    public ArrayList<Pokemon> getWaterPokemon2(){
        return waterPokemon2;
    }
    
    public ArrayList<Pokemon> getForestPokemon2(){
        return forestPokemon2;
    }
    
    public ArrayList<Pokemon> getWheatPokemon2(){
        return wheatPokemon2;
    }

    public ArrayList<Pokemon> getWhitePokemon2(){
        return whitePokemon2;
    }
    
    public ArrayList<Pokemon> getUnkown(){
        return unknown;
    }
    
    public ArrayList<Pokemon> getLegendary(){
        return legendary;
    }
    
    public ArrayList<Pokemon> getPokedex(){
        return a;
    }
    
    //shorthand for adding extra pokemon sprites 
    //from separately dowloaded images
    private void p(String s){
        a.add( new Pokemon(s,s,true,0,0));
    }
}
