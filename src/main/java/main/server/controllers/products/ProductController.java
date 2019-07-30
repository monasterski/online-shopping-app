package main.server.controllers.products;


import main.server.beans.services.ShopWebsiteService;
import main.server.controllers.AbstractController;
import main.server.controllers.data.AdvancedSearch;
import main.server.controllers.data.Search;
import main.server.controllers.data.Sort;
import main.server.logic.products.abstractions.Product;
import main.server.logic.products.enums.ProductCategory;
import main.server.logic.products.enums.WebsiteType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Controller
public class ProductController extends AbstractController {

    @Autowired
    private ShopWebsiteService shopService;

    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public String product(
            @RequestParam("productUrl") String productUrl,
            Model model
    ) throws IOException {
        model.addAttribute("product",shopService.getProductDetails(productUrl));
        model.addAttribute("productLink",productUrl);
        return "product";
    }



    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Search search, Model model){


        ProductCategory productCategory = ProductCategory.CLOTHING;
        Set<WebsiteType > websitesToSearchIn = new HashSet<>();
        websitesToSearchIn.add(WebsiteType.OLX);
        websitesToSearchIn.add(WebsiteType.GRATKA);

        AdvancedSearch advancedSearch = new AdvancedSearch(search.getSearchString(), productCategory,websitesToSearchIn);

        List<Product> productResultList = shopService.getAdvancedProductList(advancedSearch);
        model.addAttribute("productResultList", productResultList);
        return "results";
    }

    public static class ProductResultList {

        private String name;
        private String url;
        private BufferedImage image;

        public BufferedImage getImage() {
            return image;
        }

        public void setImage(BufferedImage image) {
            this.image = image;
        }

        public String getImage64() {
            try{
                BufferedImage bImage = this.image;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write( bImage, "jpg", baos );
                baos.flush();
                byte[] imageInByteArray = baos.toByteArray();
                baos.close();
                return javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public String getName() { return name; }

        public void setName(String name) { this.name = name; }

        public String getUrl() { return url; }

        public void setUrl(String url) { this.url = url; }
    }
}
