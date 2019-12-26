package by.webparsing.vadim.impl;

import by.webparsing.vadim.creator.CandyCreator;
import by.webparsing.vadim.entity.Candy;

import by.webparsing.vadim.entity.CaramelCandy;
import by.webparsing.vadim.entity.NotStuffedChocolateCandy;
import by.webparsing.vadim.entity.StuffedChocolateCandy;
import by.webparsing.vadim.parser.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DomParser extends CandyCreator implements Parser {

    private final static Logger logger = LogManager.getLogger();

    private List<Candy> candies = new ArrayList<>();
    private Element eElement;
    private boolean hasChocolate;

    @Override
    public List<Candy> parse(InputStream inputStream) {
        logger.info("Parsing xml file with DOM parser");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("candy");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    eElement = (Element) nNode;
                    buildSweet();
                    candies.add(getCandy());
                }
            }
        } catch (Exception e){
           logger.error(e);
        }
        return candies;
    }

    @Override
    public void buildName() {
        candy.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
    }

    @Override
    public void buildEnergy() {
        candy.setEnergy(Integer.parseInt(eElement.getElementsByTagName("energy").item(0).getTextContent()));
    }

    @Override
    public void buildWaterAmount() {
        candy.setWaterAmount(Double.parseDouble(eElement.getElementsByTagName("water").item(0).getTextContent()));
    }

    @Override
    public void buildSugarAmount() {
        candy.setSugarAmount(Double.parseDouble(eElement.getElementsByTagName("sugar").item(0).getTextContent()));
    }

    @Override
    public void buildFructoseAmount() {
        candy.setFructoseAmount(Double.parseDouble(eElement.getElementsByTagName("fructose").item(0).getTextContent()));
    }

    @Override
    public void buildVanillinAmount() {
        candy.setVanillinAmount(Double.parseDouble(eElement.getElementsByTagName("vanillin").item(0).getTextContent()));
    }

    @Override
    public void buildProduction() {
        candy.setProduction(eElement.getElementsByTagName("production").item(0).getTextContent());
    }

    @Override
    public void buildChocolateType() {
        if(hasChocolate){
            candy.setChocolateType(eElement.getElementsByTagName("chocolate").item(0).getTextContent());
        }
    }

    @Override
    public void buildProteins() {
        candy.setProteins(Double.parseDouble(eElement.getElementsByTagName("proteins").item(0).getTextContent()));
    }

    @Override
    public void buildFats() {
        candy.setFats(Double.parseDouble(eElement.getElementsByTagName("fats").item(0).getTextContent()));
    }

    @Override
    public void buildCarbohydrates() {
        candy.setCarbohydrates(Double.parseDouble(eElement.getElementsByTagName("carbohydrates").item(0).getTextContent()));
    }

    @Override
    public void buildSweet() {
        String attribute = eElement.getAttribute("type");
        switch (attribute){
            case "карамельная":
                hasChocolate = false;
                candy = new CaramelCandy();
                break;
            case "шоколадная без начинки":
                hasChocolate = true;
                candy = new NotStuffedChocolateCandy();
                break;
            case "шоколадная с начинкой":
                hasChocolate = true;
                candy = new StuffedChocolateCandy();
                break;
        }
        buildName();
        buildEnergy();
        buildProduction();
        buildSugarAmount();
        buildVanillinAmount();
        buildWaterAmount();
        buildFructoseAmount();
        buildChocolateType();
        buildProteins();
        buildFats();
        buildCarbohydrates();
    }


}
