import java.io.File;
public class Main {
    public static void main(String[] args){
        String path = (new File("C:\\Users\\macie\\OneDrive\\Desktop\\Studia\\Semestr III")).getAbsolutePath();
        String sorting = "size";
        DiskDirectory directory = new DiskDirectory(path);
        if(sorting.equalsIgnoreCase("date")) directory.ChildrenChangeSort(new DiskComparator());
        else if(!sorting.equals("size"))System.exit(1);
        directory.print();
    }
}
