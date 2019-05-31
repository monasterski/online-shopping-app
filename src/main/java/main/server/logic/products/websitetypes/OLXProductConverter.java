package main.server.logic.products.websitetypes;

import main.server.controllers.data.AdvancedSearch;
import main.server.controllers.data.product.CarProduct;
import main.server.controllers.data.product.Product;
import main.server.controllers.data.product.ProductCategory;
import main.server.controllers.products.ProductController;
import main.server.logic.products.AbstractProductFactory;
import main.server.logic.products.ProductConverter;
import main.server.logic.products.WebsiteType;
import main.server.logic.products.producttypes.CarProductFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class OLXProductConverter implements ProductConverter {

    private AdvancedSearch advancedSearch;

    private AbstractProductFactory productFactory;

    public OLXProductConverter(AdvancedSearch advancedSearch){
        this.advancedSearch = advancedSearch;
        this.productFactory = advancedSearch.getProductCategory().getProductFactory();
    }

    @Override
    public List<Product> getProductsFromSite() {
        ProductCategory category = advancedSearch.getProductCategory();
        List<Product> resultsList = new ArrayList<>();
        try {
            switch(category) {
                case CAR:
                    resultsList.addAll(getCarProductsFromSite());
                    break;

                case BIKE:
                    resultsList.addAll(getBikeProductsFromSite());
                    break;

                default:

            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return resultsList;
    }

    private List<Product> getCarProductsFromSite() throws IOException {
        List<Product> carResultList = new ArrayList<>();
        String seachTerm = advancedSearch.getSearchString();
        AbstractProductFactory productFactory = new CarProductFactory();

        Document doc = Jsoup.connect("https://www.olx.pl/oferty/q-"+seachTerm).get();
        Elements table = doc.select("tr.wrap");
        List<Product> resultsList = new LinkedList<>();
        for(Element el : table){
            Map<String, String> attributes = new HashMap<>();
            String name = el.html();
            attributes.put("name", el.select("a.marginright5").select("strong").html());
            attributes.put("sourceWebsite", "OLX");
            attributes.put("image", el.select("img.fleft").attr("src"));
            if(attributes.get("image").equals(""))
                attributes.put("image", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/300px-No_image_available.svg.png");
            Document oneCarDoc = Jsoup.connect(el.select("a.marginright5").attr("href")).get();
            String host = new URL(oneCarDoc.location()).getHost();
            switch (host) {
                case "www.otomoto.pl":
                    Elements elemOtomoto = oneCarDoc
                            .select("#parameters")
                            .select("li.offer-params__item:has(span.offer-params__label:contains(Rok produkcji))")
                            .select("div.offer-params__value");
                    if(elemOtomoto.text().equals(""))
                        continue;
                    attributes.put("year", elemOtomoto.text());
                    break;
                case "www.olx.pl":
                    try {
                        Elements elemOlx = oneCarDoc
                                .select(".details td.col")
                                .select("tr:matches(Rok produkcji)").first()
                                .select("td.value").select("strong");
                        if(elemOlx.text().equals(""))
                            continue;
                        attributes.put("year", elemOlx.text());
                    }
                    catch (NullPointerException ex) {
                        //Product found is not a car
                        continue;
                    }

                    break;
                default:
                    break;
            }

//            add("name");
//            add("price");
//            add("used");
//            add("contactNumber");
//            add("active");
//            add("vin");
//            add("year");
//            add("mileage");

            resultsList.add(productFactory.createProduct(attributes));
        }
        return resultsList;


    }

    private List<Product> getBikeProductsFromSite() {
        return new ArrayList<>();
    }
}
