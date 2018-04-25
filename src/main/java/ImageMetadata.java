import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ibrahim on 4/24/18.
 */
public class ImageMetadata {

    private void getMetadata(String filename) throws TikaException, SAXException, IOException {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        InputStream inputStream = this.getClass().getResourceAsStream(filename);
        ParseContext context = new ParseContext();

        parser.parse(inputStream, handler, metadata, context);
        System.out.println(handler.toString());

        String[] metadataNames = metadata.names();

        for(String name : metadataNames){
            System.out.println(name + ": " + metadata.get(name));
        }
    }

    public static void main(String[] args) throws IOException, TikaException, SAXException {
        ImageMetadata imageMetadata = new ImageMetadata();
        String filename = "clarks.jpg";
        imageMetadata.getMetadata(filename);
    }

}
