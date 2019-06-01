package main.server.logic.products.websitetypes;

import main.server.controllers.data.AdvancedSearch;
import main.server.controllers.data.product.Product;
import main.server.controllers.data.product.ProductCategory;
import main.server.logic.products.AbstractProductFactory;
import main.server.logic.products.ProductConverter;
import main.server.logic.products.producttypes.VehicleProductFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GratkaProductConverter implements ProductConverter {

    private AdvancedSearch advancedSearch;

    private AbstractProductFactory productFactory;

    public GratkaProductConverter(AdvancedSearch advancedSearch){
        this.advancedSearch = advancedSearch;
        this.productFactory = advancedSearch.getProductCategory().getProductFactory();
    }

    @Override
    public List<Product> getProductsFromSite() {
        ProductCategory category = advancedSearch.getProductCategory();
        List<Product> resultsList = new ArrayList<>();
        try {
            switch(category) {
                case VEHICLE:
                    resultsList.addAll(getVehicleProductsFromGratka());
                    break;

                case CLOTHING:
                    resultsList.addAll(getClothingProductsFromGratka());
                    break;

                default:

            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return resultsList;
    }
    private List<Product> getVehicleProductsFromGratka() throws IOException {
        //Parameters needed:
        //name;
        //sourceWebsite
        //offerLink
        //image
        //price;
        //used;
        //year;
        //mileage;
        String seachTerm = advancedSearch.getSearchString();
        AbstractProductFactory productFactory = new VehicleProductFactory();

        List<Product> resultsList = new ArrayList<>();
        Map<String, String> attributes = new HashMap<>();
        Document doc = Jsoup.connect("https://gratka.pl/oferty/q/"+seachTerm).get();
        Elements offers = doc
                .select("article.teaser ");
        for(Element offer : offers) {
            //<--- name --->
            String title = offer.select("a.teaser__anchor").attr("title");
            attributes.put("name", title.substring("Przejdź do ogłoszenia: ".length()));
            //<--- sourceWebsite --->
            attributes.put("sourceWebsite", "GRATKA");
            //<--- image --->
            String imageHTML = offer.select("div.teaser__foto").html();
            String imageSRC = imageHTML.substring(imageHTML.indexOf("https://"),imageHTML.indexOf("\" alt="));
            attributes.put("image", imageSRC);
            if(attributes.get("image").equals(""))
                attributes.put("image", "https://static.thenounproject.com/png/1427-200.png");
            //<--- price --->
            attributes.put("price", offer.select("p.teaser__price").text());
            //<--- offerLink --->
            String offerLink = offer.select("a.teaser__anchor").attr("href");
            attributes.put("link", offerLink);
            Document oneVehicleDoc = Jsoup.connect(offerLink).get();
            //<--- used --->
            Elements specs = oneVehicleDoc.select(".parameters__container");
            if(specs.select("li:contains(Stan pojazdu)").select("b.parameters__value").html().equals("nowy"))
                attributes.put("used", "no");
            else {
                attributes.put("used", "yes");
            }
            //<--- year --->
            attributes.put("year", specs.select("li:contains(Rok produkcji)").select("b.parameters__value").html());
            //<--- mileage --->
            attributes.put("mileage", specs.select("li:contains(Przebieg)").select("b.parameters__value").html());

            resultsList.add(productFactory.createProduct(attributes));
        }
        return resultsList;
    }

    private List<Product> getClothingProductsFromGratka() {
        return new ArrayList<>();
    }
}
