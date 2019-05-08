package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Site {

    public String id;
    public String name;
    public String countryId;
    public String saleFeesMode;
    public Integer mercadopagoVersion;
    public String defaultCurrencyId;
    public String immediatePayment;
    public List<String> paymentMethodIds = null;
    public Settings settings;
    public List<Currency> currencies = null;
    public List<Category> categories = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Site() {
        this.id = "MLC";
        this.name = "Chile";
        this.countryId = "CL";
        this.saleFeesMode = "not_free";
        this.mercadopagoVersion = 3;
        this.defaultCurrencyId = "CLP";
        this.immediatePayment = "optional";
        this.paymentMethodIds = null;
        this.settings = null;
        this.currencies = null;
        List<Category> categories = new ArrayList<Category>();
        categories.add(new Category("MLC1747", "Accesorios para Vehículos"));
        categories.add(new Category("MLC1403", "Alimentos y Bebidas"));
        categories.add(new Category("MLC1071", "Animales y Mascotas"));
        categories.add(new Category("MLC1367", "Arte y Antigüedades"));
        this.categories = categories;
    }

    /**
     *
     * @param countryId
     * @param id
     * @param currencies
     * @param immediatePayment
     * @param paymentMethodIds
     * @param settings
     * @param saleFeesMode
     * @param name
     * @param categories
     * @param defaultCurrencyId
     * @param mercadopagoVersion
     */
    public Site(String id, String name, String countryId, String saleFeesMode, Integer mercadopagoVersion, String defaultCurrencyId, String immediatePayment, List<String> paymentMethodIds, Settings settings, List<Currency> currencies, List<Category> categories) {
        super();
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.saleFeesMode = saleFeesMode;
        this.mercadopagoVersion = mercadopagoVersion;
        this.defaultCurrencyId = defaultCurrencyId;
        this.immediatePayment = immediatePayment;
        this.paymentMethodIds = paymentMethodIds;
        this.settings = settings;
        this.currencies = currencies;
        this.categories = categories;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

class Category {

    public String id;
    public String name;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Category() {
    }

    /**
     *
     * @param id
     * @param name
     */
    public Category(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

class Currency {

    public String id;
    public String symbol;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Currency() {
    }

    /**
     *
     * @param id
     * @param symbol
     */
    public Currency(String id, String symbol) {
        super();
        this.id = id;
        this.symbol = symbol;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

class Settings {

    public List<String> identificationTypes = null;
    public List<Object> taxpayerTypes = null;
    public Object identificationTypesRules;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Settings() {
    }

    /**
     *
     * @param taxpayerTypes
     * @param identificationTypes
     * @param identificationTypesRules
     */
    public Settings(List<String> identificationTypes, List<Object> taxpayerTypes, Object identificationTypesRules) {
        super();
        this.identificationTypes = identificationTypes;
        this.taxpayerTypes = taxpayerTypes;
        this.identificationTypesRules = identificationTypesRules;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
