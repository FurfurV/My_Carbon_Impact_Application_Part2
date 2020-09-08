import java.io.*;
import java.util.ArrayList;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Mar 2020
 */
public class Serialize {
    ArrayList<Activity> actList=new ArrayList <>();

    public void serialize(ArrayList<Activity> actList){

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Serialization▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        try{
            FileOutputStream fileOut= new FileOutputStream("src/activity.ser");
            ObjectOutputStream out=new ObjectOutputStream(fileOut);
            out.writeObject(actList);

            out.close();
            fileOut.close();
            System.out.println("Serialized stuff saved in /activity.ser");

        }catch (IOException i){
            i.printStackTrace();
        }
    }


    public ArrayList<Activity> deserialize(){
        ArrayList<Activity> actList=new ArrayList<>();
        //Activity act=null;
        try{
            FileInputStream fileIn= new FileInputStream("src/activity.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
             actList = (ArrayList<Activity>) in.readObject();
            //ArrayList<Activity> actListFromFile = (ArrayList<Activity>) in.readObject();
            //actList .add(act);
            //actList = actListFromFile;
            //act=(Activity) in.readObject();
            //actList.add(act);
            in.close();
            fileIn.close();
        }catch(FileNotFoundException f){
            f.printStackTrace();
        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        catch(IOException i){
            i.printStackTrace();
        }
        return actList;
    }
}
