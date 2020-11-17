package pers.demo.asa.feign.no.eureka.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import pers.demo.asa.feign.no.eureka.bean.Foo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class HiServiceTest {
    private final static String BASE_URI = "localhost:8090/";

    @Test
    public void givenConsumingXml_whenWritingTheFoo_thenCorrect() {
        String URI = BASE_URI + "foos/{id}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(getMessageConverters());

        Foo resource = new Foo(4, "jason");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType((MediaType.APPLICATION_XML));
        HttpEntity<Foo> entity = new HttpEntity<Foo>(resource, headers);

        ResponseEntity<Foo> response = restTemplate.exchange(
                URI, HttpMethod.PUT, entity, Foo.class, resource.getId());
        Foo fooResponse = response.getBody();

        Assert.assertEquals(resource.getId(), fooResponse.getId());
    }

    private List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> converters =
                new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());
        return converters;
    }
}