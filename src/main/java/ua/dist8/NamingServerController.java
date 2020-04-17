package ua.dist8;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

/**
 *  takes a http request of format /fileRequest?filename="name"
 *  calculates the hash value of filename
 *  uses the hash to extract the file location from the hashmap
 *  returns the ip address of the node that contains the file
 */
@RestController
public class NamingServerController {
    @GetMapping("/fileRequest")
    public FileLocation fileLocation(@RequestParam(value = "filename") String filename){
        InetAddress ip = null;
        Hashing hash = new Hashing();
        Integer fileHash = hash.createHash(filename);
        // networktreemap nwt = mew networktreemap()
        // nwt.findadress(fileHash)
        //        // do hashtable lookup
        // temporary value
        try {
            ip = InetAddress.getLocalHost(); // = findIpadress(fileHash)

        }catch(Exception e){System.out.println(e);}
        return new FileLocation(filename,ip);
    }

}
