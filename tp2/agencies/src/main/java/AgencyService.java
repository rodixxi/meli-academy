import model.Agency;

import java.util.Collection;

public interface AgencyService {

    public Collection<Agency> getAgencies(String site_id, String payment_method_id, String optionalQueryParams) throws AgencyServiceExpetion;

    public Collection<Agency> getAgencies(String site_id, String payment_method_id, String optionalQueryParams, String orderBy) throws AgencyServiceExpetion;
}
