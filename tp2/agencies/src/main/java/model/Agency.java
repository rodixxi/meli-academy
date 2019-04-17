package model;

public class Agency implements Comparable<Agency>{

    private Address address = null;
    private String agency_code;
    private String correspondent_id;
    private String description;
    private String disabled;
    private String distance;
    private String id;
    private String payment_method_id;
    private String phone;
    private String site_id;
    private String terminal;

    public enum OrderBy {
        ADDRESS_LINE,
        AGENCY_CODE,
        DISTANCE;
    }

    public static OrderBy orderBy = OrderBy.DISTANCE;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAgency_code() {
        return agency_code;
    }

    public void setAgency_code(String agency_code) {
        this.agency_code = agency_code;
    }

    public String getCorrespondent_id() {
        return correspondent_id;
    }

    public void setCorrespondent_id(String correspondent_id) {
        this.correspondent_id = correspondent_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisable() {
        return disabled;
    }

    public void setDisable(String disable) {
        this.disabled = disable;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    @Override
    public int compareTo(Agency o) {
        switch (orderBy) {
            case DISTANCE: return this.distance.compareTo(o.getDistance());
            case AGENCY_CODE: return Integer.valueOf(this.agency_code).compareTo(Integer.valueOf(o.getAgency_code()));
            case ADDRESS_LINE: return this.address.getAddress_line().compareTo(o.getAddress().getAddress_line());
        }
        return 0;
    }
}
