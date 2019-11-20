import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecordMain {
    private static final String RECORDSTORE_XML = "./recordstore-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException, SQLException {
        JAXBContext context = JAXBContext.newInstance(RecordStore.class);
        Unmarshaller um = context.createUnmarshaller();

        URL xmlUrl = readXmlFromGoogleDriveUrl("https://drive.google.com/file/d/16zWYQXfSwbfjAt0Xue8MAw8a5L7VTIsG/edit");

        RecordStore recordStore1 = (RecordStore) um.unmarshal(xmlUrl);

        List<Record> list = recordStore1.getRecordList();
        for (Record record : list) {
            System.out.println(record.getName() + " from " + record.getCity() + " with " + record.getEmail() + " and the phone is " + record.getPhone());
            RecordDAO.insertRecord(record);
        }
    }

    private static URL readXmlFromGoogleDriveUrl(String string) throws IOException {
        String urlString = generateDownloadUrl(string);
        URL url = new URL(urlString);
        URL finalUrl = getFinalURL(url);

        return finalUrl;
    }

    private static String generateDownloadUrl(String urlString) {
        String pattern = "(.+)\\/+(.+)\\/(.+)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(urlString);

        if (m.find()){
            urlString = m.group(2);
        }

        urlString = "https://drive.google.com/uc?id=" + urlString + "&export=download";
        return urlString;
    }

    public static URL getFinalURL(URL url) {
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setInstanceFollowRedirects(false);
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
            con.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
            con.addRequestProperty("Referer", "https://www.google.com/");
            con.connect();
            //con.getInputStream();
            int resCode = con.getResponseCode();
            if (resCode == HttpURLConnection.HTTP_SEE_OTHER
                    || resCode == HttpURLConnection.HTTP_MOVED_PERM
                    || resCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                String Location = con.getHeaderField("Location");
                if (Location.startsWith("/")) {
                    Location = url.getProtocol() + "://" + url.getHost() + Location;
                }
                return getFinalURL(new URL(Location));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return url;
    }
}
