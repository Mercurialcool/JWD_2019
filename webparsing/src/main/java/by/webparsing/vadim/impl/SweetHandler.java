package by.webparsing.vadim.impl;

import by.webparsing.vadim.entity.Candy;
import by.webparsing.vadim.entity.CaramelCandy;
import by.webparsing.vadim.entity.NotStuffedChocolateCandy;
import by.webparsing.vadim.entity.StuffedChocolateCandy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class SweetHandler extends DefaultHandler {

    private List<Candy> candies = new ArrayList<>();
    private Candy currentCandy = null;
    private StringBuilder currentString = null;
    private boolean isString = false;

    List<Candy> getCandies() {
        return candies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName){
            case "candy":
                String candyType = attributes.getValue("type");
                switch (candyType){
                    case "карамельная":
                        currentCandy = new CaramelCandy();
                        break;
                    case "шоколадная с начинкой":
                        currentCandy = new StuffedChocolateCandy();
                        break;
                    case "шоколадная без начинки":
                        currentCandy = new NotStuffedChocolateCandy();
                        break;
                }
                break;
            case "name":
            case "energy":
            case "water":
            case "sugar":
            case "fructose":
            case "vanillin":
            case "production":
            case "chocolate":
            case "proteins":
            case "fats":
            case "carbohydrates":
                currentString = new StringBuilder();
                isString = true;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        switch (qName){
            case "candy":
                candies.add(currentCandy);
                currentCandy = null;
                break;
            case "name":
                currentCandy.setName(currentString.toString());
                isString = false;
                currentString = null;
                break;
            case "energy":
                currentCandy.setEnergy(Integer.parseInt(currentString.toString()));
                isString = false;
                currentString = null;
                break;
            case "water":
                currentCandy.setWaterAmount(Double.parseDouble(currentString.toString()));
                isString = false;
                currentString = null;
                break;
            case "sugar":
                currentCandy.setSugarAmount(Double.parseDouble(currentString.toString()));
                isString = false;
                currentString = null;
                break;
            case "fructose":
                currentCandy.setFructoseAmount(Double.parseDouble(currentString.toString()));
                isString = false;
                currentString = null;
                break;
            case "vanillin":
                currentCandy.setVanillinAmount(Double.parseDouble(currentString.toString()));
                isString = false;
                currentString = null;
                break;
            case "production":
                currentCandy.setProduction(currentString.toString());
                isString = false;
                currentString = null;
                break;
            case "chocolate":
                currentCandy.setChocolateType(currentString.toString());
                isString = false;
                currentString = null;
                break;
            case "proteins":
                currentCandy.setProteins(Double.parseDouble(currentString.toString()));
                isString = false;
                currentString = null;
                break;
            case "fats":
                currentCandy.setFats(Double.parseDouble(currentString.toString()));
                isString = false;
                currentString = null;
                break;
            case "carbohydrates":
                currentCandy.setCarbohydrates(Double.parseDouble(currentString.toString()));
                isString = false;
                currentString = null;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length){
        if(isString) {
            currentString.append(ch, start, length);
        }
    }
}