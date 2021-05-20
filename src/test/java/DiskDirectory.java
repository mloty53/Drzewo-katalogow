import java.io.File;
import java.util.Comparator;
import java.util.TreeSet;

public class DiskDirectory extends DiskElement{
    TreeSet<DiskElement> children;

    public DiskDirectory(File file){
        super(file);
        File[] childrenFiles = file.listFiles();
        children = new TreeSet<DiskElement>();
        if(childrenFiles != null && childrenFiles.length > 0) {
            for(File child : childrenFiles){
                DiskElement newChild;
                if(child.isDirectory()) {
                    newChild = new DiskDirectory(child);
                    this.size+=newChild.size;
                }
                else {
                    newChild = new DiskFile(child);
                    size+=child.length();
                }
                children.add(newChild);

            }
        }
    }

    public DiskDirectory(String path){
        this(new File(path));
    }

    protected void print(int depth){
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < depth; i++) output.append('-');
        output.append(this.toString());
        System.out.println(output.toString());
        for(DiskElement child : children) child.print(depth + 1);
    }

    public void ChildrenChangeSort(Comparator<DiskElement> comparator){
        TreeSet<DiskElement> newChildren = new TreeSet<DiskElement>(comparator);
        newChildren.addAll(children);
        children = newChildren;
    }

    @Override
    public String toString(){
        return fileName + " " + this.size +" " + formattedLastModified;
    }
}
