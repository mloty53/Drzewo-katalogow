import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class DiskElement implements Comparable<DiskElement>{
    protected File file;
    protected Date lastModified;
    protected String formattedLastModified;
    protected String fileName;
    protected long size=0;

    public DiskElement(File file){
        lastModified = new Date(file.lastModified());
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:MM:ss");
        formattedLastModified = dateFormat.format(lastModified);
        fileName = file.getName();
    }

    @Override
    public boolean equals(Object other){
        if(this == other) return true;
        else if(other == null || getClass() != other.getClass()) return false;
        else {
            DiskElement otherDiskElement = (DiskElement)other;
            return Objects.equals(file, otherDiskElement.file) && Objects.equals(lastModified, otherDiskElement.lastModified)
                    && Objects.equals(formattedLastModified, otherDiskElement.formattedLastModified)
                    && Objects.equals(fileName, otherDiskElement.fileName);
        }
    }

    @Override
    public int hashCode(){
        return 353 * Objects.hash(file, lastModified, formattedLastModified, this.size);
    }

    //@Override
    public int compareTo(DiskElement other){
        int value = 0;
        if(this.size>other.size)return 1;
        if(value == 0) value = lastModified.compareTo(other.lastModified);
        return -1;
    }

    protected abstract void print(int depth);
    public void print() { print(0); }
}