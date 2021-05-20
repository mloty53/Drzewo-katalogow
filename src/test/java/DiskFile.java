import java.io.File;

public class DiskFile extends DiskElement {

    public DiskFile(File file){
        super(file);
        this.size=file.length();
    }

    protected void print(int depth){
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < depth; i++){
            output.append('-');
        }
        output.append(this.toString());
        System.out.println(output.toString());
    }

    @Override
    public String toString(){
        return fileName + " " + this.size + " " + formattedLastModified;
    }
}
