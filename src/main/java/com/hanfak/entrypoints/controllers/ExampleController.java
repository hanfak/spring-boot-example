package com.hanfak.entrypoints.controllers;

import com.hanfak.entrypoints.controllers.dto.ObjectDto;
import com.hanfak.entrypoints.controllers.dto.XmlDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ExampleController {
    @RequestMapping(value = "/", method = GET)
    public String index() {
        return "You have reached the blog controller";
    }

    @GetMapping(value="/hello")
    public String helloIndex() {
        return "You have reached the blog controller, hello endpoint";
    }

    @RequestMapping(value = "/ex/foos/{id}", method = GET)
    public String getFoosBySimplePathWithPathVariable(
            @PathVariable("id") long id) {
        return "Get a specific Foo with id=" + id;
    }

    @RequestMapping(value = "/ex/foos/{id}/{name}", method = GET)
    public String getMorePathVar(@PathVariable("id") long id, @PathVariable("name") String name) {
        return "Get a specific Foo with id=" + id + " and name: " + name;
    }

    @RequestMapping(value = "/ex/bars/{numericId:[\\d]+}", method = GET)
    public String getBarsBySimplePathWithPathVariable(@PathVariable long numericId) {
        return "Get a specific Bar with id=" + numericId;
    }

    @RequestMapping(value = "/ex/bars", method = GET)
    public String getBarBySimplePathWithRequestParam(@RequestParam("id") long id) {
        return "Get a specific Bar with id=" + id;
    }

    @RequestMapping(
            value = "/ex/bars",
            params = { "id", "second" },
            method = GET)
    public String multipleParams(@RequestParam("id") long id, @RequestParam("second") String second) {
        return "Narrow Get a specific Bar with id=" + id + " and second is: " + second;
    }

    @GetMapping(value = "/ex/dto/{id}", produces = "application/xml")
    public ObjectDto doSomethingReturnDTO(@PathVariable("id") int id) {
        if (id % 2 == 0) { // This is some logic, this should be in a usecase ??
            return new ObjectDto(false, true, "someString");
        }
        return new ObjectDto(false, false, "some other string");
    }

    @GetMapping(value = "/ex/xmldto/{id}", produces = { MediaType.APPLICATION_XML_VALUE })
    public XmlDto doSomethingReturnXmlDTO(@PathVariable("id") int id) {
        XmlDto xmlDto = new XmlDto();
        xmlDto.setId(id);
        return xmlDto;
    }
}