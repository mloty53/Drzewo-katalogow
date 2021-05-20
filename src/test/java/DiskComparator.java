import java.util.Comparator;

public class DiskComparator implements Comparator<DiskElement> {
    //@Override
    public int compare(DiskElement o1, DiskElement o2) {
        int value =0;
        if(o1.lastModified.compareTo(o2.lastModified)==1)return 1;
        if (value == 0) value = o1.fileName.compareToIgnoreCase(o2.fileName);
        return -1;
    }
}
