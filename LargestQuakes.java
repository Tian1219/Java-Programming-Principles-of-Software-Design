import java.util.ArrayList;
import java.util.WeakHashMap;

public class LargestQuakes {


    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("Read " + list.size() + "quakes");

        for (QuakeEntry quake : list) {
            System.out.println(quake);
        }
    }

    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        double magMax = 0;
        int index = -1;
        for (QuakeEntry qe : data) {
            double mag = qe.getMagnitude();
            if (mag > magMax) {
                magMax = mag;
                index = data.indexOf(qe);
            }
        }
        return index;
    }


    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> data, int howMany) {
        ArrayList<QuakeEntry> dataRemovale = data;
        ArrayList<QuakeEntry> largest = new ArrayList<QuakeEntry>();

        while ((largest.size() < howMany) || dataRemovale.size() > 0) {

            int index = indexOfLargest(dataRemovale);
            largest.add(dataRemovale.get(index));
            dataRemovale.remove(index);

        }

        return largest;


    }

}
