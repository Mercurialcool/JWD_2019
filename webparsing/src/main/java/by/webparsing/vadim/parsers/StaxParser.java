package by.webparsing.vadim.parsers;

import by.webparsing.vadim.builder.CandyBuilder;
import by.webparsing.vadim.entity.Candy;
import by.webparsing.vadim.entity.CaramelCandy;
import by.webparsing.vadim.entity.NotStuffedChocolateCandy;
import by.webparsing.vadim.entity.StuffedChocolateCandy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.events.Attribute;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaxParser extends CandyBuilder implements Parser {

    private final Logger logger = LogManager.getLogger();

    private List<Candy> candies = new ArrayList<>();
    private StringBuilder currentString = null;
    private boolean isString = false;
    private boolean hasChocolate = false;
    private String candyType;


    @Override
    public List<Candy> parse(InputStream inputStream) {
        logger.info("Parsing xml file with StAX parser");
        try{
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(inputStream);
            while(eventReader.hasNext()){
                XMLEvent event = eventReader.nextEvent();

                switch(event.getEventType()){
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        switch (qName){
                            case"candy":
                                Iterator<Attribute> attributes = startElement.getAttributes();
                                candyType = attributes.next().getValue().toString();
                                buildSweet();
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

                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if(isString){
                            currentString.append(characters.getData());
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        String endElementName = endElement.getName().getLocalPart();
                        switch (endElementName){
                            case "candy":
                                candies.add(getCandy());
                                break;
                            case "name":
                                buildName();
                                isString = false;
                                currentString = null;
                                break;
                            case "energy":
                                buildEnergy();
                                isString = false;
                                currentString = null;
                                break;
                            case "water":
                                buildWaterAmount();
                                isString = false;
                                currentString = null;
                                break;
                            case "sugar":
                                buildSugarAmount();
                                isString = false;
                                currentString = null;
                                break;
                            case "fructose":
                                buildFructoseAmount();
                                isString = false;
                                currentString = null;
                                break;
                            case "vanillin":
                                buildVanillinAmount();
                                isString = false;
                                currentString = null;
                                break;
                            case "production":
                                buildProduction();
                                isString = false;
                                currentString = null;
                                break;
                            case "chocolate":
                                buildChocolateType();
                                isString = false;
                                currentString = null;
                                break;
                            case "proteins":
                                buildProteins();
                                isString = false;
                                currentString = null;
                                break;
                            case "fats":
                                buildFats();
                                isString = false;
                                currentString = null;
                                break;
                            case "carbohydrates":
                                buildCarbohydrates();
                                isString = false;
                                currentString = null;
                                break;
                        }
                        break;
                }
            }
        } catch (XMLStreamException e){
            logger.error(e.toString());
        }
        return candies;
    }

    @Override
    public void buildName() {
        candy.setName(currentString.toString());
    }

    @Override
    public void buildEnergy() {
        candy.setEnergy(Integer.parseInt(currentString.toString()));
    }

    @Override
    public void buildWaterAmount() {
        candy.setWaterAmount(Double.parseDouble(currentString.toString()));
    }

    @Override
    public void buildSugarAmount() {
        candy.setSugarAmount(Double.parseDouble(currentString.toString()));
    }

    @Override
    public void buildFructoseAmount() {
        candy.setFructoseAmount(Double.parseDouble(currentString.toString()));
    }

    @Override
    public void buildVanillinAmount() {
        candy.setVanillinAmount(Double.parseDouble(currentString.toString()));
    }

    @Override
    public void buildProduction() {
        candy.setProduction(currentString.toString());
    }

    @Override
    public void buildChocolateType() {
        if(hasChocolate){
            candy.setChocolateType(currentString.toString());
        }
    }

    @Override
    public void buildProteins() {
        candy.setProteins(Double.parseDouble(currentString.toString()));
    }

    @Override
    public void buildFats() {
        candy.setFats(Double.parseDouble(currentString.toString()));
    }

    @Override
    public void buildCarbohydrates() {
        candy.setCarbohydrates(Double.parseDouble(currentString.toString()));
    }

    @Override
    public void buildSweet() {
        switch (candyType){
            case "карамельная":
                candy = new CaramelCandy();
                hasChocolate = false;
                break;
            case "шоколадная с начинкой":
                candy = new StuffedChocolateCandy();
                hasChocolate = true;
                break;
            case "шоколадная без начинки":
                candy = new NotStuffedChocolateCandy();
                hasChocolate = true;
                break;
        }
    }
}
