package main.server.beans.services;

import main.server.controllers.data.AdvancedSearch;
import main.server.controllers.data.product.Product;
import main.server.controllers.products.ProductController;
import main.server.logic.products.ProductConverter;
import main.server.logic.products.WebsiteType;
import main.server.logic.products.websitetypes.AllegroProductConverter;
import main.server.logic.products.websitetypes.OLXProductConverter;
import main.server.logic.products.websitetypes.GratkaProductConverter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ShopWebsiteServiceBean implements ShopWebsiteService {
    @Override
    public List<ProductController.ProductResultList> getProducts(String searchCriteria) throws IOException {
        Document doc = Jsoup.connect("https://www.olx.pl/oferty/q-"+searchCriteria).get();
        Elements table = doc.select("tr.wrap");
        List<ProductController.ProductResultList> resultsList = new LinkedList<>();
        for(Element el : table){
            ProductController.ProductResultList result = new ProductController.ProductResultList();
            result.setName(el.select("a.marginright5").select("strong").html());
            result.setUrl(el.select("a.marginright5").select("strong").first().parent().attributes().get("href"));
            try{
                result.setImage(ImageIO.read(new URL("https://static.thenounproject.com/png/1427-200.png")));
                result.setImage(ImageIO.read(new URL(el.select("img.fleft").attr("src"))));
            }
            catch (java.net.MalformedURLException exc){
                System.out.println("Incorrect image");
            }
            catch(IOException ex) {
                System.out.println("Incorrect image");
                ex.printStackTrace();
            }
            resultsList.add(result);
        }
        return resultsList;
    }

    @Override
    public Product getProductDetails(String url) throws IOException {
        return WebsiteType.getProductDetails(url);
    }

    @Override
    public List<Product> getAdvancedProductList(AdvancedSearch advancedSearch){

        List<Product> resultsList = new ArrayList<>();
        Set<WebsiteType> websitesTypesList = advancedSearch.getWebsitesToSearchIn();

        for(WebsiteType web : websitesTypesList){
            switch(web) {
                case ALLEGRO:
                    ProductConverter converterAllegro = new AllegroProductConverter(advancedSearch);
                    resultsList.addAll(converterAllegro.getProductsFromSite());
                    break;

                case OLX :
                    ProductConverter converterOlx = new OLXProductConverter(advancedSearch);
                    resultsList.addAll(converterOlx.getProductsFromSite());
                    break;

                case GRATKA:
                    ProductConverter converterGratka = new GratkaProductConverter(advancedSearch);
                    resultsList.addAll(converterGratka.getProductsFromSite());
                    break;
            }
        }
        Collections.shuffle(resultsList);
        return resultsList;
    }
}
