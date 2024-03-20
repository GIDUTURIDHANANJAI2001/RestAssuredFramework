package Stepdef;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import postinputpojo1.postInputPojo;

public class nt_thai_seeting_01 extends nt_thai_testdata {

    static postInputPojo creditLimit;
    static String json;

    public void setPriceAndDescription(double price, String description) {
        // Initialize the creditLimit object if it's null
        if (creditLimit == null) {
            creditLimit = new postInputPojo();
        }

        // Set the price and description
        creditLimit.setPrice(price);
        creditLimit.setDescription(description);

        // Generate request payload

    }

    public static postInputPojo requestPayLoad() {
        // Initialize the creditLimit object if it's null
        if (creditLimit == null) {
            creditLimit = new postInputPojo();
        }

        creditLimit.setTitle(title1);
        creditLimit.setImage(image1);
        creditLimit.setCatgorey(category);

        // Convert POJO to JSON string
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(creditLimit);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // Print the JSON string
        System.out.println("Request payload is " + json);

        return creditLimit;
    }
}
