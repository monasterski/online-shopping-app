package main.server.controllers.products;

import main.server.controllers.AbstractController;
import main.server.database.dao.ProductRepository;
import main.server.database.dto.ProductData;
import main.server.logic.products.abstractions.Product;
import main.server.logic.products.producttypes.VehicleProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/user")
public class BasketController extends AbstractController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/basket",method = RequestMethod.GET)
    public String basket(Model model){
        List<ProductData> productList = getApplicationContext().getBasket().getProducts();
        model.addAttribute("products",productList);
        model.addAttribute("vehicleString", "VEHICLE");
        model.addAttribute("clothingString", "CLOTHING");
        return "basket";
    }

    @RequestMapping(value ="/basket/add")
    public String basketAdd(
            @RequestParam("base64") String base64String,
            @RequestParam("additional1") String additional1,
            @RequestParam("additional2") String additional2

    ) throws IOException, ClassNotFoundException {
        final byte[] objToBytes = Base64.getUrlDecoder().decode(base64String);
        ByteArrayInputStream bais = new ByteArrayInputStream(objToBytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();
        String productType = (product instanceof VehicleProduct) ? "VEHICLE" : "CLOTHING";
        getApplicationContext().getBasket().addProduct(productRepository.createItem(
                getApplicationContext().getUser().getId(),
                product.getProductName(),
                product.getImage(),
                product.getPrice(),
                product.getUsed(),
                product.getLinkToOffer(),
                product.getSourceWebsite(),
                productType,
                additional1,
                additional2));
        return redirect("/user/basket");
    }

    @RequestMapping(value ="/basket/delete")
    public String basketDelete(
            @RequestParam("base64String") String base64String

    ) throws IOException, ClassNotFoundException {
        final byte[] objToBytes = Base64.getUrlDecoder().decode(base64String);
        ByteArrayInputStream bais = new ByteArrayInputStream(objToBytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        ProductData product = (ProductData) ois.readObject();
        productRepository.deleteItem(product);
        getApplicationContext().getBasket().removeProduct(product);
        return redirect("/user/basket");
    }
}
