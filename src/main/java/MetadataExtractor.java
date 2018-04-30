import java.io.File;

/**
 * Created by ibrahim on 4/30/18.
 */
public class MetadataExtractor {

    private void extract(){

    }

    private void traverse(File node){
        System.out.println(node.getAbsoluteFile());

        if(node.isDirectory()){
            String [] subNodes = node.list();
            for (String name : subNodes){
                traverse(new File(node, name));
            }
        }
    }

    public static void main(String args[]){
        MetadataExtractor metadataExtractor = new MetadataExtractor();
        metadataExtractor.traverse(new File("/media/ibrahim/Ib_Files/pics"));
    }
}
