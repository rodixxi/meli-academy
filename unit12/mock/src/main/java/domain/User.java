package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    public Integer id;
    public String nickname;
    public String registrationDate;
    public String countryId;
    public Address address;
    public String userType;
    public List<String> tags = null;
    public Object logo;
    public Integer points;
    public String siteId;
    public String permalink;
    public SellerReputation sellerReputation;
    public BuyerReputation buyerReputation;
    public Status status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
        this.id = 1;
        this.nickname = "NICTRAFFICGENER1";
        this.registrationDate = "2011-09-05T12:00:00.000-04:00";
        this.countryId = "CL";
        this.address = null;
        this.userType = "normal";
        this.tags = null;
        this.logo = null;
        this.points = 0;
        this.siteId = "MLC";
        this.permalink = "http://perfil.mercadolibre.cl/NICTRAFFICGENER1";
        this.sellerReputation = null;
        this.buyerReputation = null;
        this.status = null;
    }

    /**
     *
     * @param countryId
     * @param tags
     * @param sellerReputation
     * @param logo
     * @param status
     * @param nickname
     * @param buyerReputation
     * @param userType
     * @param id
     * @param registrationDate
     * @param siteId
     * @param permalink
     * @param address
     * @param points
     */
    public User(Integer id, String nickname, String registrationDate, String countryId, Address address, String userType, List<String> tags, Object logo, Integer points, String siteId, String permalink, SellerReputation sellerReputation, BuyerReputation buyerReputation, Status status) {
        super();
        this.id = id;
        this.nickname = nickname;
        this.registrationDate = registrationDate;
        this.countryId = countryId;
        this.address = address;
        this.userType = userType;
        this.tags = tags;
        this.logo = logo;
        this.points = points;
        this.siteId = siteId;
        this.permalink = permalink;
        this.sellerReputation = sellerReputation;
        this.buyerReputation = buyerReputation;
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

class Address {

    public Object city;
    public Object state;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Address() {
    }

    /**
     *
     * @param state
     * @param city
     */
    public Address(Object city, Object state) {
        super();
        this.city = city;
        this.state = state;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

class BuyerReputation {

    public List<Object> tags = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public BuyerReputation() {
    }

    /**
     *
     * @param tags
     */
    public BuyerReputation(List<Object> tags) {
        super();
        this.tags = tags;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

class Ratings {

    public Integer negative;
    public Integer neutral;
    public Integer positive;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Ratings() {
    }

    /**
     *
     * @param negative
     * @param positive
     * @param neutral
     */
    public Ratings(Integer negative, Integer neutral, Integer positive) {
        super();
        this.negative = negative;
        this.neutral = neutral;
        this.positive = positive;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

class SellerReputation {

    public Object levelId;
    public Object powerSellerStatus;
    public Transactions transactions;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public SellerReputation() {
    }

    /**
     *
     * @param powerSellerStatus
     * @param transactions
     * @param levelId
     */
    public SellerReputation(Object levelId, Object powerSellerStatus, Transactions transactions) {
        super();
        this.levelId = levelId;
        this.powerSellerStatus = powerSellerStatus;
        this.transactions = transactions;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

class Status {

    public String siteStatus;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Status() {
    }

    /**
     *
     * @param siteStatus
     */
    public Status(String siteStatus) {
        super();
        this.siteStatus = siteStatus;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

class Transactions {

    public Integer canceled;
    public Integer completed;
    public String period;
    public Ratings ratings;
    public Integer total;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Transactions() {
    }

    /**
     *
     * @param total
     * @param canceled
     * @param period
     * @param ratings
     * @param completed
     */
    public Transactions(Integer canceled, Integer completed, String period, Ratings ratings, Integer total) {
        super();
        this.canceled = canceled;
        this.completed = completed;
        this.period = period;
        this.ratings = ratings;
        this.total = total;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}