package com.example.URLShortner.Controller;
import com.example.URLShortner.Entity.RequestDTO;
import com.example.URLShortner.Entity.RequestEntity;
import com.example.URLShortner.Repo.Repo;
import com.example.URLShortner.ServiceLayer.URLShortenerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.SQLOutput;

@RestController
public class RedirectController {
    @Autowired
    private Repo repo;

    @GetMapping("/{id}")
    ResponseEntity<?> handleRedirect(@PathVariable String id) throws MalformedURLException {

        String hash_str= URLShortenerUtils.generateShortUrlKey(id);
        if (repo.existsByRequestKey(hash_str)) {
            RequestEntity requestEntity = repo.findByRequestKey(hash_str);
            if (requestEntity != null) {
                String url = requestEntity.getURL();
                HttpHeaders httpHeaders = new HttpHeaders();
                System.out.println(url);
                httpHeaders.setLocation(URI.create(url));
                return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
            }
        }


//        URL url = new URL("http://www.google.com");


        return new ResponseEntity<>("nahi hain yh shortened URL",HttpStatus.BAD_REQUEST);
    }
//    @PostMapping("/")
//    public void createRequestEntity(@RequestBody RequestDTO requestDTO) {
//
//        System.out.println(requestDTO.getRequestkey());
//        System.out.println(requestDTO.getURL());
//    }
    @PostMapping("/")
    ResponseEntity<String> MakeRedirects(@RequestBody RequestDTO requestDTO) {
        String hash_str= URLShortenerUtils.generateShortUrlKey(requestDTO.getRequestkey());
        if (repo.existsByRequestKey(hash_str)) {
            // Instead of throwing a NullPointerException, return a conflict response

            System.out.println(repo.existsByRequestKey(requestDTO.getRequestkey()));
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Change key, already exists");
        } else {
            // Save the new entity
            System.out.println("entity " + hash_str);
            RequestEntity requestEntity = new RequestEntity(hash_str, requestDTO.getURL());
           repo.save(requestEntity);

            return new ResponseEntity<>(HttpStatus.CREATED); // Return 201 Created
        }
    }
}
